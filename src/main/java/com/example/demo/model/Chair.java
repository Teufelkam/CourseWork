package com.example.demo.model;

public class Chair {
    private int id;
    private String name;
    private String abr;

    public Chair() {
    }

    public Chair(int id, String name, String abr) {
        this.id = id;
        this.name = name;
        this.abr = abr;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAbr() {
        return abr;
    }

    public void setAbr(String abr) {
        this.abr = abr;
    }
}
