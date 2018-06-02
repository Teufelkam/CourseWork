package com.example.demo.model;

import com.example.demo.enums.SpecializationOfWorker;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "worker")
@EntityListeners(AuditingEntityListener.class)
public class Worker {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;
    @Column(name = "name")
    String name;
    @Column(name = "surname")
    String surname;
    @Enumerated(EnumType.STRING)
    SpecializationOfWorker type;
    @ManyToOne
    @JoinColumn(name = "hospital_id",insertable = false,updatable = false)
    Hospital hospital;
    @ManyToOne
    @JoinColumn(name = "clinic_id",insertable = false,updatable = false)
    Clinic clinic;

    @Column(name = "clinic_id")
    Integer clinicId;
    @Column(name = "hospital_id")
    Integer hospitalId;

    public void setType(SpecializationOfWorker type) {
        this.type = type;
    }

    public SpecializationOfWorker getType() {

        return type;
    }

    public void setClinicId(Integer clinicId) {
        this.clinicId = clinicId;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getClinicId() {

        return clinicId;
    }

    public Integer getHospitalId() {
        return hospitalId;
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

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
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

    public Hospital getHospital() {
        return hospital;
    }

    public Clinic getClinic() {
        return clinic;
    }

    public Worker() {
    }

    public Worker(String name, String surname, Hospital hospital, Clinic clinic, SpecializationOfWorker type) {
        this.name = name;
        this.surname = surname;
        this.hospital = hospital;
        this.clinic = clinic;
        this.type = type;
    }
}
