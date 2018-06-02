package com.example.demo.model;

import com.example.demo.enums.TypeOfSurvey;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "laboratory_surveys")
@EntityListeners(AuditingEntityListener.class)
public class LaboratorySurvey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "laboratory_id",insertable = false,updatable = false)
    Laboratory laboratory;

    @ManyToOne
    @JoinColumn(name = "hospital_id",insertable = false,updatable = false)
    Hospital hospital;

    @Column(name = "date")
    String date;
    @Column(name = "description")
    String description;
    @Column(name = "hospital_id")
    Integer hospitalId;
    @Column(name = "laboratory_id")
    Integer laboratoryId;
    @Enumerated(EnumType.STRING)
    TypeOfSurvey type;

    public void setType(TypeOfSurvey type) {
        this.type = type;
    }

    public TypeOfSurvey getType() {

        return type;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public void setLaboratoryId(Integer laboratoryId) {
        this.laboratoryId = laboratoryId;
    }

    public Integer getHospitalId() {

        return hospitalId;
    }

    public Integer getLaboratoryId() {
        return laboratoryId;
    }

    public LaboratorySurvey(String date, String description, Integer hospitalId, Integer laboratoryId) {

        this.date = date;
        this.description = description;
        this.hospitalId = hospitalId;
        this.laboratoryId = laboratoryId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setLaboratory(Laboratory laboratory) {
        this.laboratory = laboratory;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {

        return id;
    }

    public Laboratory getLaboratory() {
        return laboratory;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public LaboratorySurvey () {}
    public LaboratorySurvey(Integer id, Laboratory laboratory, Hospital hospital, String date, String description) {

        this.id = id;
        this.laboratory = laboratory;
        this.hospital = hospital;
        this.date = date;
        this.description = description;
    }
}
