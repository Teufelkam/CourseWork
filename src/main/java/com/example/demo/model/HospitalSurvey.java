package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.Date;
//
@Entity
@Table(name = "survey_in_hospitals")
@EntityListeners(AuditingEntityListener.class)
public class HospitalSurvey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;


    @ManyToOne
    @JoinColumn(name = "hospitals_history_id",insertable = false,updatable = false)
    HospitalHistory hospitalHistory;

    @ManyToOne
    @JoinColumn(name = "doctor_id",insertable = false,updatable = false)
    Doctor doctor;

    @Column(name = "type")
    String type;
    @Column(name = "date")
    String date;
    @Column(name = "description")
    String description;
    @Column(name = "hospitals_history_id")
    Integer hospitalHistoryId;
    @Column(name = "doctor_id")
    Integer doctorId;

    public void setHospitalHistoryId(Integer hospitalHistoryId) {
        this.hospitalHistoryId = hospitalHistoryId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getHospitalHistoryId() {

        return hospitalHistoryId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public Integer getId() {
        return id;
    }

    public HospitalHistory getHospitalHistory() {
        return hospitalHistory;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getType() {
        return type;
    }

    public String getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public void setId(Integer id) {

        this.id = id;
    }

    public void setHospitalHistory(HospitalHistory hospitalHistory) {
        this.hospitalHistory = hospitalHistory;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public HospitalSurvey () {}
    public HospitalSurvey(Integer id, HospitalHistory hospitalHistory, Doctor doctor, String type, String date, String description) {

        this.id = id;
        this.hospitalHistory = hospitalHistory;
        this.doctor = doctor;
        this.type = type;
        this.date = date;
        this.description = description;
    }
}
