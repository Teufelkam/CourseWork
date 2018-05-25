package com.example.demo.model;


public class Student {
    private int id;
    private String firstName;
    private String secondName;
    private Chair chair;
    public Student() {
    }

    public Student(int id, String firstName, String secondName, Chair chair) {

        this.id = id;
        this.firstName = firstName;
        this.secondName = secondName;
        this.chair = chair;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getSecondName() {
        return secondName;
    }

    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }

    public Chair getChair() {
        return chair;
    }

    public void setChair(Chair chair) {
        this.chair = chair;
    }
}
