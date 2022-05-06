package com.zhy.takeoutcabinet.entity;

public class SettingInfo {

    private Integer id;
    private String headerBgc;
    private String headerFontColor;
    private String sideBgc;
    private String sideFontColor;
    private Integer loginAnimation;
    private String loginBgImage;
    private Integer isUse;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getHeaderBgc() {
        return headerBgc;
    }

    public void setHeaderBgc(String headerBgc) {
        this.headerBgc = headerBgc;
    }

    public String getSideBgc() {
        return sideBgc;
    }

    public void setSideBgc(String sideBgc) {
        this.sideBgc = sideBgc;
    }

    public Integer getLoginAnimation() {
        return loginAnimation;
    }

    public void setLoginAnimation(Integer loginAnimation) {
        this.loginAnimation = loginAnimation;
    }

    public String getLoginBgImage() {
        return loginBgImage;
    }

    public void setLoginBgImage(String loginBgImage) {
        this.loginBgImage = loginBgImage;
    }

    public Integer getIsUse() {
        return isUse;
    }

    public void setIsUse(Integer isUse) {
        this.isUse = isUse;
    }

    public String getHeaderFontColor() {
        return headerFontColor;
    }

    public void setHeaderFontColor(String headerFontColor) {
        this.headerFontColor = headerFontColor;
    }

    public String getSideFontColor() {
        return sideFontColor;
    }

    public void setSideFontColor(String sideFontColor) {
        this.sideFontColor = sideFontColor;
    }

    @Override
    public String toString() {
        return "SettingInfo{" +
                "id=" + id +
                ", headerBgc='" + headerBgc + '\'' +
                ", headerFontColor='" + headerFontColor + '\'' +
                ", sideBgc='" + sideBgc + '\'' +
                ", sideFontColor='" + sideFontColor + '\'' +
                ", loginAnimation=" + loginAnimation +
                ", loginBgImage='" + loginBgImage + '\'' +
                ", isUse=" + isUse +
                '}';
    }
}
