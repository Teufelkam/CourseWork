package com.example.demo.controller;
import com.example.demo.enums.ScienceRank;
import com.example.demo.enums.SpecializationOfDoctor;
import com.example.demo.enums.SpecializationOfWorker;
import com.example.demo.model.*;
import com.example.demo.service.RequestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RequestsController {
    @Autowired
    RequestService service;


    @RequestMapping("/request1_1")
    List<Doctor> getDoctorBySpecialization(@RequestParam SpecializationOfDoctor type){
        return service.getDoctorBySpecialization(type);
    }

    @RequestMapping("/request1_2")
    List<Doctor> getDoctorBySpecializationAndClinic(@RequestParam SpecializationOfDoctor type, @RequestParam int clinic_id){
        return service.getDoctorBySpecializationAndClinic(type, clinic_id);
    }

    @RequestMapping("/request1_3")
    List<Doctor> getDoctorBySpecializationAndHospital(@RequestParam SpecializationOfDoctor type, @RequestParam int hospital_id){
        return service.getDoctorBySpecializationAndHospital(type, hospital_id);
    }

    @RequestMapping("/request2_1")
    List<Worker> getWorkerBySpecialization(@RequestParam SpecializationOfWorker type){
        return service.getWorkerBySpecialization(type);
    }

    @RequestMapping("/request2_2")
    List<Worker> getWorkerBySpecializationAndHospital(@RequestParam SpecializationOfWorker type, @RequestParam int hospital_id){
        return service.getWorkerBySpecializationAndHospital(type, hospital_id);
    }

    @RequestMapping("/request2_3")
    List<Worker> getWorkerBySpecializationAndClinic(@RequestParam SpecializationOfWorker type, @RequestParam int clinic_id){
        return service.getWorkerBySpecializationAndClinic(type, clinic_id);
    }

    @RequestMapping("/request3_1")
    List<Doctor> getDoctorByOperationAmount(@RequestParam int operationAmount){
        return service.getDoctorByOperationAmount(operationAmount);
    }

    @RequestMapping("/request4_1")
    List<Doctor> getDoctorByScienceRank(@RequestParam ScienceRank scienceRank){
        return service.getDoctorByScienceRank(scienceRank);
    }
    @RequestMapping("/request4_2")
    List<Doctor> getDoctorByScienceRankAndHospital(@RequestParam ScienceRank scienceRank, @RequestParam int hospital_id){
        return service.getDoctorByScienceRankAndHospital(scienceRank, hospital_id);
    }
    @RequestMapping("/request4_3")
    List<Doctor> getDoctorByScienceRankAndClinic(@RequestParam ScienceRank scienceRank,@RequestParam int clinic_id){
        return service.getDoctorByScienceRankAndClinic(scienceRank, clinic_id);
    }

    @RequestMapping("/request5_1")
    List<Patient> getPatientByHospital(@RequestParam int hospital_id){
        return service.getPatientByHospital(hospital_id);
    }

    @RequestMapping("/request5_2")
    List<Patient> getPatientByCot(@RequestParam int cot_id){
        return service.getPatientByCot(cot_id);
    }

    @RequestMapping("/request5_3")
    List<Patient> getPatientByClinicDoctor(@RequestParam int doctorId){
        return service.getPatientByClinicDoctor(doctorId);
    }

    @RequestMapping("/request6")
    Hospital getInfoAboutHospital(@RequestParam int hospitalId){
        return service.getInfoAboutHospital(hospitalId);
    }

    @RequestMapping("/requestOSAD")
    List<Osad> getGroup(){
        return service.getGroupBy();
    }
}
