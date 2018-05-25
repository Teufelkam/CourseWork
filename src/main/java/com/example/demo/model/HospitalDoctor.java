package com.example.demo.model;

import org.springframework.data.jpa.domain.support.AuditingEntityListener;

import javax.persistence.*;
import javax.print.Doc;

@Entity
@Table(name = "doctors_and_hospitals")
@EntityListeners(AuditingEntityListener.class)
public class HospitalDoctor {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "id")
    Integer id;

    @ManyToOne
    @JoinColumn(name = "doctor_id",insertable = false,updatable = false)
    Doctor doctor;

    @ManyToOne
    @JoinColumn(name = "department_id",insertable = false,updatable = false)
    Department department;
    @Column(name = "salary")
    Integer salary;
    @Column(name = "vacation")
    Integer vacation;
    @Column(name = "doctor_id")
    Integer doctorId;
    @Column(name = "department_id")
    Integer departmentId;

    public HospitalDoctor(Integer salary, Integer vacation, Integer doctorId, Integer departmentId) {
        this.salary = salary;
        this.vacation = vacation;
        this.doctorId = doctorId;
        this.departmentId = departmentId;
    }

    public void setDoctorId(Integer doctorId) {

        this.doctorId = doctorId;
    }

    public void setDepartmentId(Integer departmentId) {
        this.departmentId = departmentId;
    }

    public Integer getDoctorId() {

        return doctorId;
    }

    public Integer getDepartmentId() {
        return departmentId;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setDoctor(Doctor doctor) {
        this.doctor = doctor;
    }

    public void setDepartment(Department department) {
        this.department = department;
    }

    public void setSalary(Integer salary) {
        this.salary = salary;
    }

    public void setVacation(Integer vacation) {
        this.vacation = vacation;
    }

    public Integer getId() {

        return id;
    }

    public Doctor getDoctor() {
        return doctor;
    }

    public Department getDepartment() {
        return department;
    }

    public Integer getSalary() {
        return salary;
    }

    public Integer getVacation() {
        return vacation;
    }
    public HospitalDoctor () {}
    public HospitalDoctor(Integer id, Doctor doctor, Department department, Integer salary, Integer vacation) {

        this.id = id;
        this.doctor = doctor;
        this.department = department;
        this.salary = salary;
        this.vacation = vacation;
    }
}
