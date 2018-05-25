package com.example.demo.repository;

import com.example.demo.model.LaboratorySurvey;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface LaboratorySurveyRepository extends JpaRepository<LaboratorySurvey,Integer> {
}
