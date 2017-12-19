package com.lxc;

import com.lxc.paser.CommonParser;

import java.util.List;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        // ruleMapCode是对应数据库表格的规则吗
        String ruleMapCode;
        // 根据规则吗查询出一整套规则
        List<RuleMap> ruleMapList = null;
        // 文件的完整路径例如：
        String filePath = "/Users/lxc/Desktop/20171205.xls";
        // 解析文件编码
        String encode = null;
        CommonParser commonParser = new CommonParser(ruleMapList, filePath, encode);
        // 暂时没有考虑数据量很大情况，欢迎老铁们给优化一下
        List<ChannelTransRecord> list = commonParser.process();

    }
}
