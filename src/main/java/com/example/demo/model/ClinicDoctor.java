package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
//
@Entity
@Table(name = "doctors_and_clinics")
@EntityListeners(AuditingEntityListener.class)
public class ClinicDoctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "doctor_id",insertable = false,updatable = false)
    Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "cabinet_id",insertable = false,updatable = false)
    Cabinet cabinet;

    @Column(name = "salary")
    Integer salary;

    @Column(name = "vacation")
    Integer vacation;

    @Column(name = "doctor_id")
    Integer doctorId;

    @Column(name = "cabinet_id")
    Integer cabinetId;

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public void setCabinetId(Integer cabinetId) {
        System.out.println(cabinetId);
        this.cabinetId = cabinetId;
    }

    public Integer getDoctorId() {

        return doctorId;
    }

    public Integer getCabinetId() {
        return cabinetId;
    }

    public ClinicDoctor(Integer salary, Integer vacation, Integer doctorId, Integer cabinetId) {

        this.salary = salary;
        this.vacation = vacation;
        this.doctorId = doctorId;
        this.cabinetId = cabinetId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setCabinet(Cabinet cabinet) {
        this.cabinet = cabinet;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setVacation(Integer vacation) {
        this.vacation = vacation;
    }

    public Integer getId() {

        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Cabinet getCabinet() {
        return cabinet;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getVacation() {
        return vacation;
    }

    public ClinicDoctor () {}
    public ClinicDoctor(Integer id, Doctor doctor, Cabinet cabinet, Integer salary, Integer vacation) {

        this.id = id;
        this.doctor = doctor;
        this.cabinet = cabinet;
        this.salary = salary;
        this.vacation = vacation;
    }
}
