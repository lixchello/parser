package com.lxc;

/**
 * Created By lxc
 * Date: 2017/11/27
 */
// TODO: 2017/12/12 枚举写法
public enum RuleTypeEnum {

    ROW(1, "行"),
    COLUMN(2, "列"),;

    public final int key;
    public final String value;

    RuleTypeEnum(int key, String value) {
        this.key = key;
        this.value = value;
    }



}
