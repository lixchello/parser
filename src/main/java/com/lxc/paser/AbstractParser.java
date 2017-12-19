package com.lxc.paser;

import com.google.common.collect.Lists;
import com.google.common.collect.Maps;
import com.lxc.*;
import org.apache.commons.lang3.StringUtils;
import org.apache.poi.hssf.usermodel.HSSFDateUtil;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;

import java.lang.reflect.Field;
import java.math.BigDecimal;
import java.text.ParseException;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/**
 * Created By lxc
 * Date: 2017/12/19
 */
public abstract class AbstractParser {

    public static final int BATCH_NUM = 1000;


    protected List<ChannelTransRecord> list = Lists.newArrayListWithCapacity(2 * BATCH_NUM);
    protected List<RuleMap> ruleMapList;
    protected String filePath;
    protected String encode;
    protected int skipRows;
    protected Map<String, String> specialRules = Maps.newHashMap();

    public AbstractParser(List<RuleMap> ruleMapList, String filePath, String encode) {
        this.ruleMapList = ruleMapList;
        this.filePath = filePath;
        RuleMap rowRuleMap = getRuleMap(ruleMapList, RuleTypeEnum.ROW);
        skipRows = rowRuleMap == null ? 0 : Integer.parseInt(rowRuleMap.getMapValue2());
        this.encode = encode;
    }

    public static RuleMap getRuleMap(List<RuleMap> ruleMapList, RuleTypeEnum ruleTypeEnum) {
        RuleMap rowRuleMap = null;
        Iterator<RuleMap> ruleMapIterator = ruleMapList.iterator();
        while (ruleMapIterator.hasNext()) {
            RuleMap tempRow = ruleMapIterator.next();
            if (tempRow.getRuleType().compareTo(ruleTypeEnum.key) == 0) {
                rowRuleMap = tempRow;
                ruleMapIterator.remove();
                break;
            }
        }
        return rowRuleMap;
    }

    public static ChannelTransRecord setFields(ChannelTransRecord tmp, String line, List<RuleMap> ruleMapList, Map<String, String> specialRules)
            throws NoSuchFieldException, IllegalAccessException, ParseException {
        String[] strings = line.split(",");
        for (RuleMap ruleMap : ruleMapList) {
            Field filed = tmp.getClass().getDeclaredField(ruleMap.getMapValue1());
            filed.setAccessible(true);
            int column = Integer.parseInt(ruleMap.getMapValue2()) - 1;
            String value = strings[column];
            String fieldValue = ruleMap.getFieldValue().trim();
            FieldTypeEnum fieldTypeEnum = FieldTypeEnum.getFieldTypeEnum(ruleMap.getFieldType());
            switch (fieldTypeEnum) {
                case STRING_VALUE:
                    filed.set(tmp, value);
                    break;
                case INTEGER_VALUE:
                    BigDecimal amount = new BigDecimal(value);
                    amount = amount.multiply(new BigDecimal(fieldValue)).setScale(0, BigDecimal.ROUND_HALF_UP);
                    filed.set(tmp, amount.intValue());
                    break;
                case LONG_VALUE:
                    filed.set(tmp, Long.parseLong(value));
                    break;
                case DATE_VALUE:
                    filed.set(tmp, TimeHelper.getFmtDate(value, fieldValue));
                    break;
                case SPECIAL_STRING_VALUE1:
                    value = transformRule(value, fieldValue, specialRules);
                    filed.set(tmp, value);
                    break;
                default:
                    filed.set(tmp, value);
                    break;
            }
        }
        return tmp;
    }

    public static ChannelTransRecord setFields(ChannelTransRecord tmp, Row row, List<RuleMap> ruleMapList, Map<String, String> specialRules)
            throws NoSuchFieldException, IllegalAccessException, ParseException {
        for (RuleMap ruleMap : ruleMapList) {
            Field filed = tmp.getClass().getDeclaredField(ruleMap.getMapValue1());
            filed.setAccessible(true);
            int column = Integer.parseInt(ruleMap.getMapValue2()) - 1;
            Cell cell = row.getCell(column);
            String fieldValue = ruleMap.getFieldValue().trim();
            FieldTypeEnum fieldTypeEnum = FieldTypeEnum.getFieldTypeEnum(ruleMap.getFieldType());
            switch (fieldTypeEnum) {
                case STRING_VALUE:
                    filed.set(tmp, getCellValueByCell(cell));
                    break;
                case INTEGER_VALUE:
                    BigDecimal integerAmount = new BigDecimal(getCellValueByCell(cell));
                    integerAmount = integerAmount.multiply(new BigDecimal(fieldValue)).setScale(0, BigDecimal.ROUND_HALF_UP);
                    filed.set(tmp, integerAmount.intValue());
                    break;
                case LONG_VALUE:
                    BigDecimal longAmount = new BigDecimal(getCellValueByCell(cell));
                    longAmount = longAmount.setScale(0, BigDecimal.ROUND_HALF_UP);
                    filed.set(tmp, longAmount.longValue());
                    break;
                case DATE_VALUE:
                    filed.set(tmp, TimeHelper.getFmtDate(getCellValueByCell(cell, fieldValue), fieldValue));
                    break;
                case SPECIAL_STRING_VALUE1:
                    String tmpValue = transformRule(getCellValueByCell(cell), fieldValue, specialRules);
                    filed.set(tmp, tmpValue);
                    break;
                default:
                    filed.set(tmp, getCellValueByCell(cell));
                    break;
            }
        }
        return tmp;
    }

    public static String transformRule(String value, String fieldValue, Map<String, String> specialRuleMap) {
        if (!specialRuleMap.isEmpty()) {
            return specialRuleMap.get(value);
        }
        String[] specialRules = StringUtils.split(fieldValue, ",");
        for (String specialRule : specialRules) {
            String[] mapRules = StringUtils.split(specialRule, "_");
            specialRuleMap.put(mapRules[0], mapRules[1]);
        }
        return specialRuleMap.get(value);
    }

    private static String getCellValueByCell(Cell cell, String... args) {
        if (cell == null || cell.toString().trim().equals("")) {
            return "";
        }
        String cellValue;
        CellType cellType = cell.getCellTypeEnum();
        switch (cellType) {
            case NUMERIC:
                if (HSSFDateUtil.isCellDateFormatted(cell)) {
                    cellValue = TimeHelper.getTimeStr(cell.getDateCellValue(), args[0]);
                    break;
                }
                cellValue = cell.getNumericCellValue() + "";
                break;
            case STRING:
                cellValue = cell.getStringCellValue();
                break;
            case BOOLEAN:
                cellValue = String.valueOf(cell.getBooleanCellValue());
                break;
            default:
                cellValue = cell.getStringCellValue().trim();
                cellValue = StringUtils.isEmpty(cellValue) ? "" : cellValue;
                break;
        }
        return cellValue;
    }

    public abstract List<ChannelTransRecord> parse();

}
