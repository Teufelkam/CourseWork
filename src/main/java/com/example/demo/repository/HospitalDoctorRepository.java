package com.example.demo.repository;

import com.example.demo.model.HospitalDoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface HospitalDoctorRepository extends JpaRepository<HospitalDoctor,Integer> {
}
