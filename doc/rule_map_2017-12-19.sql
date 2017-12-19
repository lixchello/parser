DROP TABLE IF EXISTS `rule_map`;

CREATE TABLE `rule_map` (
  `id` int(11) unsigned NOT NULL AUTO_INCREMENT COMMENT '自增主键|李学朝|2017-12-07',
  `rule_type` tinyint(4) unsigned NOT NULL DEFAULT '2' COMMENT '规则类型：1、行规则，2、列规则|李学朝|2017-12-07',
  `rule_code` varchar(64) NOT NULL DEFAULT '' COMMENT '规则码：后期扩展用|李学朝|2017-12-07',
  `map_code` varchar(64) NOT NULL DEFAULT '' COMMENT '映射码：对应文件的的映射编码|李学朝|2017-12-07',
  `map_value1` varchar(64) NOT NULL DEFAULT '' COMMENT '映射值1：映射字段值|李学朝|2017-12-07',
  `map_value2` varchar(64) NOT NULL DEFAULT '' COMMENT '映射值2：映射文件列|李学朝|2017-12-07',
  `field_type` tinyint(4) NOT NULL DEFAULT '1' COMMENT '字段类型：1、string类型,2、integer类型,3、long类型,4、date类型,5、特殊的string类型1|李学朝|2017-12-07',
  `field_value` varchar(64) NOT NULL DEFAULT '0' COMMENT '字段单位(包含一些特殊格式)|李学朝|2017-12-07',
  `remark` varchar(64) NOT NULL DEFAULT '' COMMENT '备注|李学朝|2017-12-07',
  `create_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP COMMENT '创建时间|李学朝|2017-12-07',
  `update_time` datetime NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新时间|李学朝|2017-12-07',
  `reserve_char_1` varchar(64) NOT NULL DEFAULT '' COMMENT '保留字串类型1|李学朝|2017-12-07',
  `reserve_char_2` varchar(64) NOT NULL DEFAULT '' COMMENT '保留字串类型2|李学朝|2017-12-07',
  PRIMARY KEY (`id`),
  KEY `idx_rule_code` (`rule_code`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COMMENT='解析文件表|李学朝|2017-12-07';

INSERT INTO `rule_map` (`id`, `rule_type`, `rule_code`, `map_code`, `map_value1`, `map_value2`, `field_type`, `field_value`, `remark`, `create_time`, `update_time`, `reserve_char_1`, `reserve_char_2`)
VALUES
	(10051,1,'0000','111','','3',1,'0','','2017-12-07 11:39:06','2017-12-18 17:41:57','',''),
	(10052,2,'0000','111','paycenterOrderId','2',1,'0','','2017-12-07 11:39:06','2017-12-11 19:11:14','',''),
	(10054,2,'0000','111','channelTransId','1',1,'0','','2017-12-07 11:39:06','2017-12-11 19:11:14','',''),
	(10055,2,'0000','111','transAmount','6',2,'100','','2017-12-07 11:39:06','2017-12-19 15:59:29','',''),
	(10057,2,'0000','111','transStatus','9',5,'交易结束_SUCCESS','','2017-12-07 11:39:06','2017-12-19 16:00:21','',''),
	(10058,2,'0000','111','transTime','7',4,'yyyy-MM-dd HH:mm:ss','','2017-12-07 11:39:06','2017-12-19 16:38:58','','');