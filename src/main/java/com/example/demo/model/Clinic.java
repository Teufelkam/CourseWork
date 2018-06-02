package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "clinic")
@EntityListeners(AuditingEntityListener.class)
public class Clinic {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "hospital_id",insertable = false,updatable = false)
    Hospital hospital;

    @Column(name = "hospital_id")
    Integer hospitalId;

    @Column(name = "name")
    String name;

    @Column(name = "address")
    String address;

    @OneToMany(mappedBy="clinic")
    List<Cabinet> cabinets;

    public Clinic(Hospital hospital, Integer hospitalId, String name, String address, List<Cabinet> cabinets) {
        this.hospital = hospital;
        this.hospitalId = hospitalId;
        this.name = name;
        this.address = address;
        this.cabinets = cabinets;
    }

    public void setCabinets(List<Cabinet> cabinets) {
        this.cabinets = cabinets;
    }

    public List<Cabinet> getCabinets() {

        return cabinets;
    }

    public Clinic () {}

    public void setHospitalId(Integer hospitalId) {
        this.hospitalId = hospitalId;
    }

    public Integer getHospitalId() {

        return hospitalId;
    }
//
//    public Clinic(Integer hospitalId, String name, String address) {
//        this.hospitalId = hospitalId;
//        this.name = name;
//        this.address = address;
//    }
//
//    public Clinic(Hospital hospital, Integer hospitalId, String name, String address) {
//        this.hospital = hospital;
//        this.hospitalId = hospitalId;
//        this.name = name;
//        this.address = address;
//    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {
        return address;
    }

    public Integer getId() {
        return id;
    }

    public Hospital getHospital() {
        return hospital;
    }

    public String getName() {
        return name;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setHospital(Hospital hospital) {
        this.hospital = hospital;
    }

    public void setName(String name) {
        this.name = name;
    }
}
