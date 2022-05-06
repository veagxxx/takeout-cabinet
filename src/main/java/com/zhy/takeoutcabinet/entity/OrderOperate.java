package com.zhy.takeoutcabinet.entity;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.Entity;
import java.util.Date;

public class OrderOperate {

    private int operateId;
    private String operateMan;
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern="yyyy-MM-dd HH:mm")
    private Date operateTime;
    private int beforeStatus;
    private int afterStatus;
    private String note;

    private Order order;

    public int getOperateId() {
        return operateId;
    }

    public void setOperateId(int operateId) {
        this.operateId = operateId;
    }

    public String getOperateMan() {
        return operateMan;
    }

    public void setOperateMan(String operateMan) {
        this.operateMan = operateMan;
    }

    public Date getOperateTime() {
        return operateTime;
    }

    public void setOperateTime(Date operateTime) {
        this.operateTime = operateTime;
    }

    public int getBeforeStatus() {
        return beforeStatus;
    }

    public void setBeforeStatus(int beforeStatus) {
        this.beforeStatus = beforeStatus;
    }

    public int getAfterStatus() {
        return afterStatus;
    }

    public void setAfterStatus(int afterStatus) {
        this.afterStatus = afterStatus;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    @Override
    public String toString() {
        return "OrderOperate{" +
                "operateId=" + operateId +
                ", operateMan='" + operateMan + '\'' +
                ", operateTime=" + operateTime +
                ", beforeStatus=" + beforeStatus +
                ", afterStatus=" + afterStatus +
                ", note='" + note + '\'' +
                ", order=" + order +
                '}';
    }
}
