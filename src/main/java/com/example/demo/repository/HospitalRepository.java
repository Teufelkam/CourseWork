package com.example.demo.repository;

import com.example.demo.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface HospitalRepository  extends JpaRepository<Hospital,Integer> {
}
