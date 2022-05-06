package com.zhy.takeoutcabinet.entity;

public class OrderSetting {
    private int settingId;
    private int codeDestroyHour;
    private int distancePickMin;
    private int emailRemindInterval;
    private int autoFiveStarsDay;
    private int remindPick;
    private int finishRemind;

    public int getSettingId() {
        return settingId;
    }

    public void setSettingId(int settingId) {
        this.settingId = settingId;
    }

    public int getCodeDestroyHour() {
        return codeDestroyHour;
    }

    public void setCodeDestroyHour(int codeDestroyHour) {
        this.codeDestroyHour = codeDestroyHour;
    }

    public int getDistancePickMin() {
        return distancePickMin;
    }

    public void setDistancePickMin(int distancePickMin) {
        this.distancePickMin = distancePickMin;
    }

    public int getEmailRemindInterval() {
        return emailRemindInterval;
    }

    public void setEmailRemindInterval(int emailRemindInterval) {
        this.emailRemindInterval = emailRemindInterval;
    }

    public int getAutoFiveStarsDay() {
        return autoFiveStarsDay;
    }

    public void setAutoFiveStarsDay(int autoFiveStarsDay) {
        this.autoFiveStarsDay = autoFiveStarsDay;
    }

    public int getRemindPick() {
        return remindPick;
    }

    public void setRemindPick(int remindPick) {
        this.remindPick = remindPick;
    }

    public int getFinishRemind() {
        return finishRemind;
    }

    public void setFinishRemind(int finishRemind) {
        this.finishRemind = finishRemind;
    }

    @Override
    public String toString() {
        return "OrderSetting{" +
                "settingId=" + settingId +
                ", codeDestroyHour=" + codeDestroyHour +
                ", distancePickMin=" + distancePickMin +
                ", emailRemindInterval=" + emailRemindInterval +
                ", autoFiveStarsDay=" + autoFiveStarsDay +
                ", remindPick=" + remindPick +
                ", finishRemind=" + finishRemind +
                '}';
    }
}
