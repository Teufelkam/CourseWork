package com.example.demo.repository;

import com.example.demo.enums.SpecializationOfWorker;
import com.example.demo.model.Worker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface WorkerRepository extends JpaRepository<Worker,Integer> {
    @Query("SELECT wk FROM Worker wk WHERE wk.type =:type")
    List<Worker> getWorkerBySpecialization(@Param("type")SpecializationOfWorker type);

    @Query("SELECT wk FROM Worker wk WHERE wk.type =:type AND wk.hospitalId = :hospital_id")
    List<Worker> getWorkerBySpecializationAndHospital(@Param("type")SpecializationOfWorker type, @Param("hospital_id") int hospital_id);

    @Query("SELECT wk FROM Worker wk WHERE wk.type =:type AND wk.clinicId = :clinic_id")
    List<Worker> getWorkerBySpecializationAndClinic(@Param("type")SpecializationOfWorker type, @Param("clinic_id") int clinic_id);

}
