package com.example.demo.repository;

import com.example.demo.model.ClinicDoctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ClinicDoctorRepository extends JpaRepository<ClinicDoctor,Integer> {
}
