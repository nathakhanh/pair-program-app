package com.thd.pairprogram.dto;

public class PivotalCredential {
    private String id;
    private String initial;

    public PivotalCredential(String id, String initial) {
        this.id = id;
        this.initial = initial;

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInitial() {
        return initial;
    }

    public void setInitial(String initial) {
        this.initial = initial;
    }
}
