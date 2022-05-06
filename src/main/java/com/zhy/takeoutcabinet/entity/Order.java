package com.zhy.takeoutcabinet.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import java.io.Serializable;
import java.util.Date;

public class Order implements Serializable {

    private int orderId;
    private String orderNo;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
    private Date orderTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
    private Date orderPickTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
    private Date actualPickTime;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
    private Date orderFinishTime;
    private int orderCurrentTemperature;
    private int orderCabinetNumber;
    private String orderCode;
    private int orderStatus;
    private Integer orderPayMode;
    private int autoConfirmDay;
    private User user;
    private Cabinet cabinet;
    private Mode mode;

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    public String getOrderNo() {
        return orderNo;
    }

    public void setOrderNo(String orderNo) {
        this.orderNo = orderNo;
    }

    public Date getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Date orderTime) {
        this.orderTime = orderTime;
    }

    public Date getOrderPickTime() {
        return orderPickTime;
    }

    public void setOrderPickTime(Date orderPickTime) {
        this.orderPickTime = orderPickTime;
    }

    public int getOrderCurrentTemperature() {
        return orderCurrentTemperature;
    }

    public void setOrderCurrentTemperature(int orderCurrentTemperature) {
        this.orderCurrentTemperature = orderCurrentTemperature;
    }

    public int getOrderCabinetNumber() {
        return orderCabinetNumber;
    }

    public void setOrderCabinetNumber(int orderCabinetNumber) {
        this.orderCabinetNumber = orderCabinetNumber;
    }

    public String getOrderCode() {
        return orderCode;
    }

    public void setOrderCode(String orderCode) {
        this.orderCode = orderCode;
    }

    public int getOrderStatus() {
        return orderStatus;
    }

    public void setOrderStatus(int orderStatus) {
        this.orderStatus = orderStatus;
    }

    public int getOrderPayMode() {
        return orderPayMode;
    }

    public void setOrderPayMode(int orderPayMode) {
        this.orderPayMode = orderPayMode;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Cabinet getCabinet() {
        return cabinet;
    }

    public void setCabinet(Cabinet cabinet) {
        this.cabinet = cabinet;
    }

    public Date getActualPickTime() {
        return actualPickTime;
    }

    public void setActualPickTime(Date actualPickTime) {
        this.actualPickTime = actualPickTime;
    }

    public Date getOrderFinishTime() {
        return orderFinishTime;
    }

    public void setOrderFinishTime(Date orderFinishTime) {
        this.orderFinishTime = orderFinishTime;
    }

    public int getAutoConfirmDay() {
        return autoConfirmDay;
    }

    public void setAutoConfirmDay(int autoConfirmDay) {
        this.autoConfirmDay = autoConfirmDay;
    }

    @Override
    public String toString() {
        return "Order{" +
                "orderId=" + orderId +
                ", orderNo='" + orderNo + '\'' +
                ", orderTime=" + orderTime +
                ", orderPickTime=" + orderPickTime +
                ", actualPickTime=" + actualPickTime +
                ", orderFinishTime=" + orderFinishTime +
                ", orderCurrentTemperature=" + orderCurrentTemperature +
                ", orderCabinetNumber=" + orderCabinetNumber +
                ", orderCode='" + orderCode + '\'' +
                ", orderStatus=" + orderStatus +
                ", orderPayMode=" + orderPayMode +
                ", autoConfirmDay=" + autoConfirmDay +
                ", user=" + user +
                ", cabinet=" + cabinet +
                ", mode=" + mode +
                '}';
    }
}
