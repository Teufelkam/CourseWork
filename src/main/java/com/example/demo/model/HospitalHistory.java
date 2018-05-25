package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;
//
@Entity
@Table(name = "hospitals_history")
@EntityListeners(AuditingEntityListener.class)
public class HospitalHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;


    @ManyToOne
    @JoinColumn(name = "patient_id",insertable = false,updatable = false)
    Patient patient;

    @ManyToOne
    @JoinColumn(name = "hospital_id",insertable = false,updatable = false)
    Hospital hospital;

    @Column(name = "patient_id")
    Integer patientId;

    @Column(name = "hospital_id")
    Integer hospitalId;

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getPatientId() {

        return patientId;
    }

    public Integer getHospitalId() {
        return hospitalId;
    }

    public HospitalHistory(Integer patientId, Integer hospitalId) {

        this.patientId = patientId;
        this.hospitalId = hospitalId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public Integer getId() {

        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Hospital getHospital() {
        return hospital;
    }
    public HospitalHistory () {}
    public HospitalHistory(Integer id, Patient patient, Hospital hospital) {

        this.id = id;
        this.patient = patient;
        this.hospital = hospital;
    }
}
