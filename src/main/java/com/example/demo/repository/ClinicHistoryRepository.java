package com.example.demo.repository;

import com.example.demo.model.ClinicHistory;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface ClinicHistoryRepository extends JpaRepository<ClinicHistory,Integer> {
}
