package com.zhy.takeoutcabinet.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.List;

public class Cabinet implements Serializable {

    private int cabinetId;
    private String cabinetPosition;
    private String cabinetNo;
    private int cabinetSize;
    private Date useDate;
    private int cabinetStatus;

    private List<Order> orders;

    public int getCabinetId() {
        return cabinetId;
    }

    public void setCabinetId(int cabinetId) {
        this.cabinetId = cabinetId;
    }

    public String getCabinetPosition() {
        return cabinetPosition;
    }

    public void setCabinetPosition(String cabinetPosition) {
        this.cabinetPosition = cabinetPosition;
    }

    public String getCabinetNo() {
        return cabinetNo;
    }

    public void setCabinetNo(String cabinetNo) {
        this.cabinetNo = cabinetNo;
    }

    public int getCabinetSize() {
        return cabinetSize;
    }

    public void setCabinetSize(int cabinetSize) {
        this.cabinetSize = cabinetSize;
    }

    public Date getUseDate() {
        return useDate;
    }

    public void setUseDate(Date useDate) {
        this.useDate = useDate;
    }

    public int getCabinetStatus() {
        return cabinetStatus;
    }

    public void setCabinetStatus(int cabinetStatus) {
        this.cabinetStatus = cabinetStatus;
    }

    public List<Order> getOrders() {
        return orders;
    }

    public void setOrders(List<Order> orders) {
        this.orders = orders;
    }

    @Override
    public String toString() {
        return "Cabinet{" +
                "cabinetId=" + cabinetId +
                ", cabinetPosition='" + cabinetPosition + '\'' +
                ", cabinetNo='" + cabinetNo + '\'' +
                ", cabinetSize=" + cabinetSize +
                ", useDate=" + useDate +
                ", cabinetStatus=" + cabinetStatus +
                ", orders=" + orders +
                '}';
    }
}
