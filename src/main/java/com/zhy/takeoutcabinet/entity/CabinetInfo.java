package com.zhy.takeoutcabinet.entity;

import java.util.List;

public class CabinetInfo {

    private List<?> cabinets;
    private List<?> modes;
    private Integer cabinetTotal;

    public Integer getCabinetTotal() {
        return cabinetTotal;
    }

    public void setCabinetTotal(Integer cabinetTotal) {
        this.cabinetTotal = cabinetTotal;
    }

    public List<?> getCabinets() {
        return cabinets;
    }

    public void setCabinets(List<?> cabinets) {
        this.cabinets = cabinets;
    }

    public List<?> getModes() {
        return modes;
    }

    public void setModes(List<?> modes) {
        this.modes = modes;
    }

    @Override
    public String toString() {
        return "CabinetInfo{" +
                "cabinets=" + cabinets +
                ", modes=" + modes +
                ", cabinetTotal=" + cabinetTotal +
                '}';
    }
}
