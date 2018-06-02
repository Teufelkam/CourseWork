package com.example.demo.repository;

import com.example.demo.enums.ScienceRank;
import com.example.demo.enums.SpecializationOfDoctor;
import com.example.demo.model.Doctor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface DoctorRepository extends JpaRepository<Doctor,Integer> {
    @Query("SELECT dc FROM Doctor dc WHERE dc.type =:type")
    List<Doctor> getDoctorBySpecialization(@Param("type")SpecializationOfDoctor type);

    @Query("SELECT doc FROM HospitalDoctor hdoc JOIN hdoc.doctor doc WHERE hdoc.department.corps.hospitalId = :hospital_id AND doc.type = :type")
    List<Doctor> getDoctorBySpecializationAndHospital(@Param("type")SpecializationOfDoctor type, @Param("hospital_id")int hospital_id);

    @Query("SELECT doc from ClinicDoctor cdoc join cdoc.doctor doc where cdoc.cabinet.clinic_id = :clinic_id and doc.type =:type ")
    List<Doctor> getDoctorBySpecializationAndClinic(@Param("type")SpecializationOfDoctor type, @Param("clinic_id")int clinic_id);

    @Query("SELECT doc, stat.operationAmount from Statistic stat join stat.doctor doc where stat.operationAmount > :operationAmount")
    List<Doctor> getDoctorByOperationAmount(@Param("operationAmount") int operationAmount);

    @Query("SELECT dc FROM Doctor dc WHERE dc.scienceRank =:scienceRank")
    List<Doctor> getDoctorByScienceRank(@Param("scienceRank")ScienceRank scienceRank);

    @Query("SELECT doc FROM HospitalDoctor hdoc JOIN hdoc.doctor doc WHERE hdoc.department.corps.hospitalId = :hospital_id AND doc.scienceRank = :scienceRank")
    List<Doctor> getDoctorByScienceRankAndHospital(@Param("scienceRank")ScienceRank scienceRank, @Param("hospital_id")int hospital_id);

    @Query("SELECT doc from ClinicDoctor cdoc join cdoc.doctor doc where cdoc.cabinet.clinic_id = :clinic_id and doc.scienceRank =:scienceRank ")
    List<Doctor> getDoctorByScienceRankAndClinic(@Param("scienceRank")ScienceRank scienceRank, @Param("clinic_id")int clinic_id);

    @Query("SELECT COUNT(dc.id) FROM Doctor dc GROUP BY dc.type ORDER BY COUNT(dc.id)")
    List<Long> getDoctorByGroup1();

    @Query("SELECT distinct dc.type FROM Doctor dc ORDER BY dc.type")
    List<SpecializationOfDoctor> getDoctorByGroup2();
}
