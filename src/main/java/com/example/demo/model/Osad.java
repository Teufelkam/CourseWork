package com.example.demo.model;

import com.example.demo.enums.SpecializationOfDoctor;

public class Osad {
    long amount;
    SpecializationOfDoctor specializationOfDoctor;

    public Osad() {
    }

    public Osad(long amount, SpecializationOfDoctor specializationOfDoctor) {

        this.amount = amount;
        this.specializationOfDoctor = specializationOfDoctor;
    }

    public void setAmount(long amount) {
        this.amount = amount;
    }

    public void setSpecializationOfDoctor(SpecializationOfDoctor specializationOfDoctor) {
        this.specializationOfDoctor = specializationOfDoctor;
    }

    public long getAmount() {

        return amount;
    }

    public SpecializationOfDoctor getSpecializationOfDoctor() {
        return specializationOfDoctor;
    }
}
