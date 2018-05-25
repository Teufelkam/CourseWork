package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;
//
@Entity
@Table(name = "laboratory")
@EntityListeners(AuditingEntityListener.class)
public class Laboratory {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @Column(name = "type")
    String type;

    @Column(name = "address")
    String address;

    public void setAddress(String address) {
        this.address = address;
    }

    public String getAddress() {

        return address;
    }

    public Laboratory(String type, String address) {

        this.type = type;
        this.address = address;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public Integer getId() {

        return id;
    }

    public String getType() {
        return type;
    }

    public Laboratory () {}

    public Laboratory(Integer id, String type) {

        this.id = id;
        this.type = type;
    }
}
