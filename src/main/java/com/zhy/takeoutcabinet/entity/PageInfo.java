package com.zhy.takeoutcabinet.entity;

import java.util.List;

public class PageInfo {
    private int total;
    private List<?> list;

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public List<?> getList() {
        return list;
    }

    public void setList(List<?> list) {
        this.list = list;
    }

    @Override
    public String toString() {
        return "QueryInfo{" +
                "total=" + total +
                ", list=" + list +
                '}';
    }
}
