package com.example.demo.repository;

import com.example.demo.model.Corp;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CorpRepository extends JpaRepository<Corp,Integer> {
}
