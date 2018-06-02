package com.example.demo.model;

import com.example.demo.enums.ScienceRank;
import com.example.demo.enums.SpecializationOfDoctor;
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

    @Enumerated(EnumType.STRING)
    SpecializationOfDoctor type;

    @Column(name = "experience")
    String careerStartYear;

    @Enumerated(EnumType.STRING)
    ScienceRank scienceRank;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setType(SpecializationOfDoctor type) {
        this.type = type;
    }

    public void setCareerStartYear(String careerStartYear) {
        this.careerStartYear = careerStartYear;
    }

    public void setScienceRank(ScienceRank scienceRank) {
        this.scienceRank = scienceRank;
    }

    public SpecializationOfDoctor getType() {
        return type;
    }

    public ScienceRank getScienceRank() {
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

    public Doctor(Integer id, String name, String surname, SpecializationOfDoctor type, String careerStartYear, ScienceRank scienceRank) {

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.type = type;
        this.careerStartYear = careerStartYear;
        this.scienceRank = scienceRank;
    }
}
