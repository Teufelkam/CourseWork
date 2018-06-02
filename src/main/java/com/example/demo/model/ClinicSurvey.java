package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Date;

@Entity
@Table(name = "survey_in_clinics")
@EntityListeners(AuditingEntityListener.class)
public class ClinicSurvey {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "clinics_history_id",insertable = false,updatable = false)
    ClinicHistory clinicHistory;
    @ManyToOne
    @JoinColumn(name = "doctor_id",insertable = false,updatable = false)
    Doctor doctor;
    @Column(name = "type")
    String type;
    @Column(name = "date")
    LocalDate date;
    @Column(name = "description")
    String description;
    @Column(name = "clinics_history_id")
    Integer clinicHistoryId;
    @Column(name = "doctor_id")
    Integer doctorId;

    public void setClinicHistoryId(Integer clinicHistoryId) {
        this.clinicHistoryId = clinicHistoryId;
    }

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getClinicHistoryId() {

        return clinicHistoryId;
    }

    public Integer getDoctorId() {
        return doctorId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setClinicHistory(ClinicHistory clinicHistory) {
        this.clinicHistory = clinicHistory;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setDate(LocalDate date) {
        this.date = date;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Integer getId() {

        return id;
    }

    public ClinicHistory getClinicHistory() {
        return clinicHistory;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public String getType() {
        return type;
    }

    public LocalDate getDate() {
        return date;
    }

    public String getDescription() {
        return description;
    }

    public ClinicSurvey () {}
    public ClinicSurvey(Integer id, ClinicHistory clinicHistory, Doctor doctor, String type, LocalDate date, String description) {

        this.id = id;
        this.clinicHistory = clinicHistory;
        this.doctor = doctor;
        this.type = type;
        this.date = date;
        this.description = description;
    }
}
