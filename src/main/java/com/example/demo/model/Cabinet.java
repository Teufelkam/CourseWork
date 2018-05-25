package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "cabinet")
@EntityListeners(AuditingEntityListener.class)
public class Cabinet {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @Column(name = "number")
    Integer number;

    @ManyToOne
    @JoinColumn(name = "clinic_id",insertable = false,updatable = false)
    Clinic clinic;

    @Column(name = "clinic_id")
    private int clinic_id;

    @ManyToMany(cascade = CascadeType.ALL)
    @JoinTable(name = "doctors_and_clinics",
            joinColumns = @JoinColumn(name = "cabinet_id", referencedColumnName = "id"),
            inverseJoinColumns = @JoinColumn(name = "doctor_id", referencedColumnName = "id"))
    List<Doctor> doctors;

    public Cabinet(Integer number, Clinic clinic, int clinic_id) {
        this.number = number;
        this.clinic = clinic;
        this.clinic_id = clinic_id;
    }

    public void setClinic(Clinic clinic) {
        this.clinic = clinic;
    }

    public Clinic getClinic() {

        return clinic;
    }

    public void setDoctors(List<Doctor> doctors) {
        this.doctors = doctors;
    }

    public List<Doctor> getDoctors() {

        return doctors;
    }

    public Cabinet(Integer number, Clinic clinic, int clinic_id, List<Doctor> doctors) {

        this.number = number;
        this.clinic = clinic;
        this.clinic_id = clinic_id;
        this.doctors = doctors;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setClinic_id(int clinic_id) {
        this.clinic_id = clinic_id;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public int getClinic_id() {
        return clinic_id;
    }

    public Cabinet(Integer number, int clinic_id) {
        this.number = number;
        this.clinic_id = clinic_id;
    }

    public Cabinet () {}


}
