package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "patient")
@EntityListeners(AuditingEntityListener.class)
public class Patient {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @Column(name = "name")
    String name;
    @Column(name = "surname")
    String surname;

    @ManyToOne
    @JoinColumn(name = "clinic_doctor_id",insertable = false,updatable = false)
    Doctor clinicDoctor;

    @ManyToOne
    @JoinColumn(name = "hospital_doctor_id",insertable = false,updatable = false)
    Doctor hospitalDoctor;

    @ManyToOne
    @JoinColumn(name = "cot_id",insertable = false,updatable = false)
    Cot cot;

    @Column(name = "clinic_doctor_id")
    Integer clinicDoctorId;

    @Column(name = "hospital_doctor_id")
    Integer hospitalDoctorId;

    @Column(name = "cot_id")
    Integer cotId;

    @Column(name = "address")
    String address;

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {

        return address;
    }

    public void setCotId(Integer cotId) {
        this.cotId = cotId;
    }

    public Integer getCotId() {

        return cotId;
    }

    public void setClinicDoctorId(Integer clinicDoctorId) {
        this.clinicDoctorId = clinicDoctorId;
    }

    public void setHospitalDoctorId(Integer hospitalDoctorId) {
        this.hospitalDoctorId = hospitalDoctorId;
    }

    public Integer getClinicDoctorId() {

        return clinicDoctorId;
    }

    public Integer getHospitalDoctorId() {
        return hospitalDoctorId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public void setClinicDoctor(Doctor clinicDoctor) {
        this.clinicDoctor = clinicDoctor;
    }

    public void setHospitalDoctor(Doctor hospitalDoctor) {
        this.hospitalDoctor = hospitalDoctor;
    }

    public void setCot(Cot cot) {
        this.cot = cot;
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

    public Doctor getClinicDoctor() {
        return clinicDoctor;
    }

    public Doctor getHospitalDoctor() {
        return hospitalDoctor;
    }

    public Cot getCot() {
        return cot;
    }

    public Patient() {
    }

    public Patient(Integer id, String name, String surname, Doctor clinicDoctor, Doctor hospitalDoctor, Cot cot) {

        this.id = id;
        this.name = name;
        this.surname = surname;
        this.clinicDoctor = clinicDoctor;
        this.hospitalDoctor = hospitalDoctor;
        this.cot = cot;
    }
}
