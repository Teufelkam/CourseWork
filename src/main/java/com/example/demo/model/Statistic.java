package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;

@Entity
@Table(name = "statistics")
@EntityListeners(AuditingEntityListener.class)
public class Statistic {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;


    @ManyToOne
    @JoinColumn(name = "doctor_id",insertable = false,updatable = false)
    Doctor doctor;

    @Column(name = "operation_amount")
    Integer operationAmount;

    @Column(name = "failed_operation_amount")
    Integer failedOperationAmount;

    @Column(name = "doctor_id")
    Integer doctorId;

    public void setDoctorId(Integer doctorId) {
        this.doctorId = doctorId;
    }

    public Integer getDoctorId() {

        return doctorId;
    }

    public Statistic() {
    }

    public Statistic(Integer id, Doctor doctor, Integer operationAmount, Integer faliedOperationAmount) {
        this.id = id;
        this.doctor = doctor;
        this.operationAmount = operationAmount;
        this.failedOperationAmount = faliedOperationAmount;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setOperationAmount(Integer operationAmount) {
        this.operationAmount = operationAmount;
    }

    public void setFailedOperationAmount(Integer failedOperationAmount) {
        this.failedOperationAmount = failedOperationAmount;
    }

    public Doctor getDoctor() {

        return doctor;
    }

    public Integer getOperationAmount() {
        return operationAmount;
    }

    public Integer getFailedOperationAmount() {
        return failedOperationAmount;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {

        return id;
    }
}
