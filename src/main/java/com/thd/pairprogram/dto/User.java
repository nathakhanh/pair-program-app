package com.thd.pairprogram.dto;

public class User {
    private String name;
    private String id;
    private String location;
    private String tab;

    public User() {}

    public User(String name, String location, String tab) {
        this.name = name;
        this.location = location;
        this.tab = tab;
    }

    public User(String name, String location, String id, String tab) {
        this.name = name;
        this.location = location;
        this.id = id;
        this.tab = tab;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getTab() {
        return tab;
    }

    public void setTab(String tab) {
        this.tab = tab;
    }
}
