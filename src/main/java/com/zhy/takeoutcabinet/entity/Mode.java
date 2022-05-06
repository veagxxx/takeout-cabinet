package com.zhy.takeoutcabinet.entity;

import java.io.Serializable;

public class Mode implements Serializable {

    private Integer modeId;
    private String modeName;
    private String modeDescription;
    private Integer modeStatus;

    public Integer getModeId() {
        return modeId;
    }

    public void setModeId(Integer modeId) {
        this.modeId = modeId;
    }

    public String getModeName() {
        return modeName;
    }

    public void setModeName(String modeName) {
        this.modeName = modeName;
    }

    public String getModeDescription() {
        return modeDescription;
    }

    public void setModeDescription(String modeDescription) {
        this.modeDescription = modeDescription;
    }

    public Integer getModeStatus() {
        return modeStatus;
    }

    public void setModeStatus(Integer modeStatus) {
        this.modeStatus = modeStatus;
    }

    @Override
    public String toString() {
        return "CabinetMode{" +
                "modeId=" + modeId +
                ", modeName='" + modeName + '\'' +
                ", modeDescription='" + modeDescription + '\'' +
                ", modeStatus=" + modeStatus +
                '}';
    }
}
