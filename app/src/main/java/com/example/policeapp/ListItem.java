package com.example.policeapp;

public class ListItem {

    private String name;
    private  String timeshift;
    private String mobile;
    private  String location;
    private  String assign;

    public ListItem(String name, String mobile, String location, String timeshift, String assign) {
        this.name = name;
        this.timeshift = timeshift;
        this.mobile = mobile;
        this.location = location;
        this.assign = assign;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTimeshift() {
        return timeshift;
    }

    public void setTimeshift(String timeshift) {
        this.timeshift = timeshift;
    }

    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getAssign() {
        return assign;
    }

    public void setAssign(String assign) {
        this.assign = assign;
    }
}
