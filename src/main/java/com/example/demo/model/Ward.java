package com.example.demo.model;

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
    @ManyToOne
    @JoinColumn(name = "department_id",insertable = false,updatable = false)
    Department department;

    @Column(name = "department_id")
    Integer departmentId;

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
