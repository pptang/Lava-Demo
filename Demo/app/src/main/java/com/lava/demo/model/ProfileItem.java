package com.lava.demo.model;


public class ProfileItem {
    private String title;
    private String value;
    private int icon;

    public ProfileItem(String title, String value, int icon) {
        this.title = title;
        this.value = value;
        this.icon = icon;
    }

    public String getTitle() {
        return title;
    }

    public String getValue() {
        return value;
    }

    public int getIcon() {
        return icon;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public void setIcon(int icon) {
        this.icon = icon;
    }
}
