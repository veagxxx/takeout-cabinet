package com.zhy.takeoutcabinet.entity;

public class Submenu {

    private Integer submenuId;
    private String name;
    private String path;

    public Integer getSubmenuId() {
        return submenuId;
    }

    public void setSubmenuId(Integer submenuId) {
        this.submenuId = submenuId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    @Override
    public String toString() {
        return "Submenu{" +
                "submenuId=" + submenuId +
                ", name='" + name + '\'' +
                ", path='" + path + '\'' +
                '}';
    }
}
