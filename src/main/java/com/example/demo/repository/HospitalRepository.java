package com.example.demo.repository;

import com.example.demo.model.Hospital;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

public interface HospitalRepository  extends JpaRepository<Hospital,Integer> {
    @Query("SELECT hsp FROM Hospital hsp WHERE hsp.id =:hospitalId")
    Hospital getInfoAboutHospital(@Param("hospitalId")int hospitalId);
}
