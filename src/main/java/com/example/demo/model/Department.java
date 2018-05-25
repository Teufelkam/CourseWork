package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "department")
@EntityListeners(AuditingEntityListener.class)
public class Department {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @Column(name = "type")
    String type;


    @ManyToOne
    @JoinColumn(name = "corps_id",insertable = false,updatable = false)
    Corp corps;

    @Column(name = "corps_id")
    Integer corpsId;

    public void setCorpsId(Integer corpsId) {
        this.corpsId = corpsId;
    }

    public Integer getCorpsId() {

        return corpsId;
    }

    public Department(String type, Integer corpsId) {
        this.type = type;
        this.corpsId = corpsId;
    }

    public Department(String type, Corp corps, Integer corpsId) {
        this.type = type;
        this.corps = corps;
        this.corpsId = corpsId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setType(String type) {
        this.type = type;
    }

    public void setCorps(Corp corps) {
        this.corps = corps;
    }

    public Integer getId() {

        return id;
    }

    public String getType() {
        return type;
    }

    public Corp getCorps() {
        return corps;
    }

    public Department() {}

}
