package com.lxc;


/**
 * Created By lxc
 * Date: 2017/11/27
 */
public enum FieldTypeEnum {

    STRING_VALUE(1, "String类型"),
    INTEGER_VALUE(2, "Integer类型"),
    LONG_VALUE(3, "Long类型"),
    DATE_VALUE(4, "Date类型"),
    SPECIAL_STRING_VALUE1(5, "特殊需要转换的String类型1"),;

    public final int key;
    public final String value;

    FieldTypeEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }

    public static FieldTypeEnum getFieldTypeEnum(Integer fieldType) {
        if (fieldType == null) {
            return null;
        }
        for (FieldTypeEnum fieldTypeEnum : FieldTypeEnum.values()) {
            if (fieldTypeEnum.key == fieldType.intValue()) {
                return fieldTypeEnum;
            }
        }
        return null;
    }


}
