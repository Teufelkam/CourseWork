package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
//
@Entity
@Table(name = "clinics_history")
@EntityListeners(AuditingEntityListener.class)
public class ClinicHistory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "patient_id",insertable = false,updatable = false)
    Patient patient;

    @ManyToOne
    @JoinColumn(name = "clinic_id",insertable = false,updatable = false)
    Clinic clinic;

    @Column(name = "patient_id")
    Integer patientId;

    @Column(name = "clinic_id")
    Integer clinicId;

    public ClinicHistory(Integer patientId, Integer clinicId) {
        this.patientId = patientId;
        this.clinicId = clinicId;
    }

    public ClinicHistory() {}

    public ClinicHistory(Patient patient, Clinic clinic, Integer patientId, Integer clinicId) {
        this.patient = patient;
        this.clinic = clinic;
        this.patientId = patientId;
        this.clinicId = clinicId;
    }

    public void setPatientId(Integer patientId) {
        this.patientId = patientId;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }

    public Integer getPatientId() {

        return patientId;
    }

    public Integer getClinicId() {
        return clinicId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setPatient(Patient patient) {
        this.patient = patient;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public Integer getId() {

        return id;
    }

    public Patient getPatient() {
        return patient;
    }

    public Clinic getClinic() {
        return clinic;
    }
}
