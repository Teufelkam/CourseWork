package com.example.demo.model;

import com.example.demo.enums.TypeOfDepartment;
import com.fasterxml.jackson.annotation.JsonIgnore;
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

    @Enumerated(EnumType.STRING)
    TypeOfDepartment type;

    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "corps_id",insertable = false,updatable = false)
    Corp corps;

    @Column(name = "corps_id")
    Integer corpsId;

    @OneToMany(mappedBy="department")
    List<Ward> wards;

    public void setWards(List<Ward> wards) {
        this.wards = wards;
    }

    public List<Ward> getWards() {

        return wards;
    }

    public Department(TypeOfDepartment type, Corp corps, Integer corpsId, List<Ward> wards) {

        this.type = type;
        this.corps = corps;
        this.corpsId = corpsId;
        this.wards = wards;
    }

    public void setCorpsId(Integer corpsId) {
        this.corpsId = corpsId;
    }

    public Integer getCorpsId() {

        return corpsId;
    }

    public Department(TypeOfDepartment type, Integer corpsId) {
        this.type = type;
        this.corpsId = corpsId;
    }

    public Department(TypeOfDepartment type, Corp corps, Integer corpsId) {
        this.type = type;
        this.corps = corps;
        this.corpsId = corpsId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setType(TypeOfDepartment type) {
        this.type = type;
    }

    public void setCorps(Corp corps) {
        this.corps = corps;
    }

    public Integer getId() {

        return id;
    }

    public TypeOfDepartment getType() {
        return type;
    }

    public Corp getCorps() {
        return corps;
    }

    public Department() {}

}
