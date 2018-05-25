package com.example.demo.repository;

import com.example.demo.model.Statistic;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface StatisticRepository extends JpaRepository<Statistic,Integer> {
}
