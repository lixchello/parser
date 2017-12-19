package com.lxc;

import java.io.Serializable;
import java.util.Date;

public class ChannelTransRecord implements Serializable {
    private static final long serialVersionUID = -301127602804405086L;

    private String merOrderId = "";
    private String paycenterOrderId = "";
    private String channelMerId = "";
    private String channelTerminalId = "";
    private String channelTransId = "";
    private String channelTransactionCode = "";
    private Long channelAccountId = 0L;
    private Integer transAmount = 0;
    private Integer transPoundage = 0;
    private Integer transRecordedFee = 0;
    private String transStatus = "";
    private String transType = "";
    private Date transTime;
    private Date settleDate;
    public String getMerOrderId() {
        return merOrderId;
    }

    public void setMerOrderId(String merOrderId) {
        this.merOrderId = merOrderId;
    }

    public String getPaycenterOrderId() {
        return paycenterOrderId;
    }

    public void setPaycenterOrderId(String paycenterOrderId) {
        this.paycenterOrderId = paycenterOrderId;
    }

    public String getChannelMerId() {
        return channelMerId;
    }

    public void setChannelMerId(String channelMerId) {
        this.channelMerId = channelMerId;
    }

    public String getChannelTerminalId() {
        return channelTerminalId;
    }

    public void setChannelTerminalId(String channelTerminalId) {
        this.channelTerminalId = channelTerminalId;
    }

    public String getChannelTransId() {
        return channelTransId;
    }

    public void setChannelTransId(String channelTransId) {
        this.channelTransId = channelTransId;
    }

    public String getChannelTransactionCode() {
        return channelTransactionCode;
    }

    public void setChannelTransactionCode(String channelTransactionCode) {
        this.channelTransactionCode = channelTransactionCode;
    }

    public Long getChannelAccountId() {
        return channelAccountId;
    }

    public void setChannelAccountId(Long channelAccountId) {
        this.channelAccountId = channelAccountId;
    }

    public Integer getTransAmount() {
        return transAmount;
    }

    public void setTransAmount(Integer transAmount) {
        this.transAmount = transAmount;
    }

    public Integer getTransPoundage() {
        return transPoundage;
    }

    public void setTransPoundage(Integer transPoundage) {
        this.transPoundage = transPoundage;
    }

    public Integer getTransRecordedFee() {
        return transRecordedFee;
    }

    public void setTransRecordedFee(Integer transRecordedFee) {
        this.transRecordedFee = transRecordedFee;
    }

    public String getTransStatus() {
        return transStatus;
    }

    public void setTransStatus(String transStatus) {
        this.transStatus = transStatus;
    }

    public String getTransType() {
        return transType;
    }

    public void setTransType(String transType) {
        this.transType = transType;
    }

    public Date getTransTime() {
        return transTime;
    }

    public void setTransTime(Date transTime) {
        this.transTime = transTime;
    }

    public Date getSettleDate() {
        return settleDate;
    }

    public void setSettleDate(Date settleDate) {
        this.settleDate = settleDate;
    }

    @Override
    public String toString() {
        return "ChannelTransRecord{" +
                "merOrderId='" + merOrderId + '\'' +
                ", paycenterOrderId='" + paycenterOrderId + '\'' +
                ", channelMerId='" + channelMerId + '\'' +
                ", channelTerminalId='" + channelTerminalId + '\'' +
                ", channelTransId='" + channelTransId + '\'' +
                ", channelTransactionCode='" + channelTransactionCode + '\'' +
                ", channelAccountId=" + channelAccountId +
                ", transAmount=" + transAmount +
                ", transPoundage=" + transPoundage +
                ", transRecordedFee=" + transRecordedFee +
                ", transStatus='" + transStatus + '\'' +
                ", transType='" + transType + '\'' +
                ", transTime=" + transTime +
                ", settleDate=" + settleDate +
                '}';
    }
}