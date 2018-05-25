package com.example.demo.repository;

import com.example.demo.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

public interface WorkerRepository extends JpaRepository<Worker,Integer> {
}
