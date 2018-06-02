package com.example.demo.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "ward")
@EntityListeners(AuditingEntityListener.class)
public class Ward {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;


    @Column(name = "number")
    Integer number;
    @JsonIgnore
    @ManyToOne
    @JoinColumn(name = "department_id",insertable = false,updatable = false)
    Department department;

    @Column(name = "department_id")
    Integer departmentId;

    @OneToMany(mappedBy="ward")
    List<Cot> cots;

    public List<Cot> getCots() {
        return cots;
    }

    public void setCots(List<Cot> cots) {
        this.cots = cots;
    }

    public Ward(Integer number, Department department, Integer departmentId, List<Cot> cots) {

        this.number = number;
        this.department = department;
        this.departmentId = departmentId;
        this.cots = cots;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public Ward() {
    }

    public Ward(Integer id, Integer number, Department department) {
        this.id = id;
        this.number = number;
        this.department = department;
    }

    public Integer getId() {
        return id;
    }

    public Integer getNumber() {
        return number;
    }

    public Department getDepartment() {
        return department;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setNumber(Integer number) {
        this.number = number;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }
}
