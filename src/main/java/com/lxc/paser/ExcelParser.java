package com.lxc.paser;

import com.lxc.ChannelTransRecord;
import com.lxc.RuleMap;

import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;


import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.InputStream;
import java.util.List;

import static com.lxc.Constant.EXCEL_XLSX_SUFFIX;
import static com.lxc.Constant.EXCEL_XLS_SUFFIX;


/**
 * Created By lxc
 * Date: 2017/12/19
 */
public class ExcelParser extends AbstractParser {

    public ExcelParser(List<RuleMap> ruleMapList, String filePath, String encode) {
        super(ruleMapList, filePath, encode);
    }

    @Override
    public List<ChannelTransRecord> parse() {
        long startTime = System.currentTimeMillis();
        int lineRows = 0;
        try {
            InputStream is = new FileInputStream(filePath);
            Workbook wb;
            if (StringUtils.containsAny(filePath, EXCEL_XLS_SUFFIX)) {
                wb = new HSSFWorkbook(is);
            } else if (StringUtils.containsAny(filePath, EXCEL_XLSX_SUFFIX)) {
                wb = new XSSFWorkbook(is);
            } else {
                wb = null;
            }
            for (int numSheet = 0; numSheet < wb.getNumberOfSheets(); numSheet++) {
                Sheet sheet = wb.getSheetAt(numSheet);
                if (sheet == null) {
                    continue;
                }
                lineRows = skipRows;
                for (int rowNum = skipRows; rowNum <= sheet.getLastRowNum(); rowNum++) {
                    lineRows++;
                    Row row = sheet.getRow(rowNum);
                    if (row != null) {
                        ChannelTransRecord tmp = new ChannelTransRecord();
                        setFields(tmp, row, ruleMapList, specialRules);
                        list.add(tmp);
                    }
                }
            }
        } catch (FileNotFoundException fe) {
            throw new RuntimeException("文件不存在");
        } catch (Exception e) {
            throw new RuntimeException("解析文件报错");
        } finally {
        }
        return list;
    }
}
