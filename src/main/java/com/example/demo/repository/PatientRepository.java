package com.example.demo.repository;

import com.example.demo.enums.SpecializationOfWorker;
import com.example.demo.model.Patient;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PatientRepository extends JpaRepository<Patient,Integer> {
    @Query("SELECT pat FROM Patient pat WHERE pat.cot.ward.department.corps.hospitalId =:hospital_id")
    List<Patient> getPatientByHospital(@Param("hospital_id")int hospital_id);

    @Query("SELECT pat FROM Patient pat WHERE pat.cotId =:cotId")
    List<Patient> getPatientByCot(@Param("cotId")int cotId);

    @Query("SELECT pat FROM Patient pat WHERE pat.clinicDoctorId =:doctorId")
    List<Patient> getPatientByClinicDoctor(@Param("doctorId")int doctorId);
}
