package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;



@Entity
@Table(name = "hospital")
@EntityListeners(AuditingEntityListener.class)
public class Hospital {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name= "address")
    private String address;

    @OneToMany(mappedBy="hospital")
    List<Corp> corps;

    public void setCorps(List<Corp> corps) {
        this.corps = corps;
    }

    public List<Corp> getCorps() {
        return corps;
    }

    public Hospital(String name, String address, List<Corp> corps) {
        this.name = name;
        this.address = address;
        this.corps = corps;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public Hospital() {

    }

    public Hospital(Integer id, String name, String adress) {
        this.id = id;
        this.name = name;
        this.address = adress;
    }


}
