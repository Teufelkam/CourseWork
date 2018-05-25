package com.example.demo.repository;

import com.example.demo.model.HospitalSurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface HospitalSurveyRepository extends JpaRepository<HospitalSurvey,Integer> {
}
