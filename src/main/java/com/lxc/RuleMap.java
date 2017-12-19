package com.lxc;

import java.io.Serializable;
import java.util.Date;

public class RuleMap implements Serializable {
    private Integer id;

    private Integer ruleType;

    private String ruleCode;

    private String mapCode;

    private String mapValue1;

    private String mapValue2;

    private Integer fieldType;

    private String fieldValue;

    private String remark;

    private Date createTime;

    private Date updateTime;

    private String reserveChar1;

    private String reserveChar2;

    private static final long serialVersionUID = 1L;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getRuleType() {
        return ruleType;
    }

    public void setRuleType(Integer ruleType) {
        this.ruleType = ruleType;
    }

    public String getRuleCode() {
        return ruleCode;
    }

    public void setRuleCode(String ruleCode) {
        this.ruleCode = ruleCode;
    }

    public String getMapCode() {
        return mapCode;
    }

    public void setMapCode(String mapCode) {
        this.mapCode = mapCode;
    }

    public String getMapValue1() {
        return mapValue1;
    }

    public void setMapValue1(String mapValue1) {
        this.mapValue1 = mapValue1;
    }

    public String getMapValue2() {
        return mapValue2;
    }

    public void setMapValue2(String mapValue2) {
        this.mapValue2 = mapValue2;
    }

    public Integer getFieldType() {
        return fieldType;
    }

    public void setFieldType(Integer fieldType) {
        this.fieldType = fieldType;
    }

    public String getFieldValue() {
        return fieldValue;
    }

    public void setFieldValue(String fieldValue) {
        this.fieldValue = fieldValue;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public Date getUpdateTime() {
        return updateTime;
    }

    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    public String getReserveChar1() {
        return reserveChar1;
    }

    public void setReserveChar1(String reserveChar1) {
        this.reserveChar1 = reserveChar1;
    }

    public String getReserveChar2() {
        return reserveChar2;
    }

    public void setReserveChar2(String reserveChar2) {
        this.reserveChar2 = reserveChar2;
    }
}