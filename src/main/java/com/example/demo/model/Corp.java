package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "corps")
@EntityListeners(AuditingEntityListener.class)
public class Corp {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @Column(name = "number")
    Integer number;

    @ManyToOne
    @JoinColumn(name = "hospital_id",insertable = false,updatable = false)
    Hospital hospital;

    @Column(name = "hospital_id")
    Integer hospitalId;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getHospitalId() {

        return hospitalId;
    }

    public Corp(Integer number, Hospital hospital, Integer hospitalId) {

        this.number = number;
        this.hospital = hospital;
        this.hospitalId = hospitalId;
    }

    public Integer getId() {

        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public Corp () {}

    public Corp(Integer number, Integer hospitalId) {
        this.number = number;
        this.hospitalId = hospitalId;
    }


}
