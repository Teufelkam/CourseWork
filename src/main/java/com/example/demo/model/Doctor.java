package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "doctor")
@EntityListeners(AuditingEntityListener.class)
public class Doctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @Column(name = "name")
    String name;

    @Column(name = "surname")
    String surname;

    @Column(name = "type")
    String type;

    @Column(name = "experience")
    String careerStartYear;

    @Column(name = "science_rank")
    String scienceRank;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCareerStartYear(String careerStartYear) {
        this.careerStartYear = careerStartYear;
    }

    public void setScienceRank(String scienceRank) {
        this.scienceRank = scienceRank;
    }

    public String getType() {
        return type;
    }

    public String getScienceRank() {
        return scienceRank;
    }

    public Integer getId() {


        return id;
    }

    public String getName() {
        return name;
    }

    public String getSurname() {
        return surname;
    }

    public String getCareerStartYear() {
        return careerStartYear;
    }

    public Doctor () {}

    public Doctor(Integer id, String name, String surname, String type, String careerStartYear, String scienceRank) {

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.type = type;
        this.careerStartYear = careerStartYear;
        this.scienceRank = scienceRank;
    }
}
