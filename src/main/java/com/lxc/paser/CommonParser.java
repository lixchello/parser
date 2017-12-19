package com.lxc.paser;

import com.lxc.ChannelTransRecord;
import com.lxc.RuleMap;
import org.apache.commons.lang3.StringUtils;

import java.util.List;

import static com.lxc.Constant.EXCEL_XLSX_SUFFIX;
import static com.lxc.Constant.EXCEL_XLS_SUFFIX;

/**
 * Created By lxc
 * Date: 2017/12/19
 */
public class CommonParser {

    private List<RuleMap> ruleMapList;
    private String filePath;
    private String encode;

    public List<ChannelTransRecord> process() {
        if (ruleMapList == null || ruleMapList.isEmpty()) {
            throw new RuntimeException("规则集合不能为空");
        }
        if (StringUtils.isBlank(filePath)) {
            throw new RuntimeException("文件路径不能为空");
        }
        AbstractParser abstractParser;
        if (StringUtils.containsAny(filePath, EXCEL_XLSX_SUFFIX) || StringUtils.containsAny(filePath, EXCEL_XLS_SUFFIX)) {
            abstractParser = new ExcelParser(ruleMapList, filePath, encode);
            return abstractParser.parse();
        }
        abstractParser = new ReadLineParser(ruleMapList, filePath, encode);
        return abstractParser.parse();
    }

    public CommonParser(List<RuleMap> ruleMapList, String filePath, String encode) {
        this.ruleMapList = ruleMapList;
        this.filePath = filePath;
        this.encode = StringUtils.isBlank(encode) ? "UTF-8" : encode;
    }
}
