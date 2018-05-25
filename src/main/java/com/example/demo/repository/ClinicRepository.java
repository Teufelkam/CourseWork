package com.example.demo.repository;

import com.example.demo.model.Clinic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ClinicRepository extends JpaRepository<Clinic,Integer> {
}
