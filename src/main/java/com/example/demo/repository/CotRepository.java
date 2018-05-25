package com.example.demo.repository;

import com.example.demo.model.Cot;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface CotRepository extends JpaRepository<Cot,Integer> {
}
