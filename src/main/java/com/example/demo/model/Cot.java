package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
//
@Entity
@Table(name = "cot")
@EntityListeners(AuditingEntityListener.class)
public class Cot {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @Column(name = "number")
    Integer number;


    @ManyToOne
    @JoinColumn(name = "ward_id")
    Ward ward;

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setWard(Ward ward) {
        this.ward = ward;
    }

    public Integer getId() {

        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public Ward getWard() {
        return ward;
    }
    public Cot () {}
    public Cot(Integer id, Integer number, Ward ward) {

        this.id = id;
        this.number = number;
        this.ward = ward;
    }

    public Cot(Integer number, Ward ward) {
        this.number = number;
        this.ward = ward;
    }
}
