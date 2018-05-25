package com.example.demo.controller;

import com.example.demo.model.Patient;
import com.example.demo.repository.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/patients")
public class PatientController {
//    @Autowired
//    IPatientService patientService;
//
//    @RequestMapping("/patients")
//    public List<Patient> showPatients() {
//        return patientService.getAll();
//    }
@Autowired
PatientRepository patientRepository;

    @RequestMapping("/get")
    public List<Patient> getPatients() throws SQLException {
        return patientRepository.findAll(); }
    @PostMapping("/insert")
    public Patient insertPatient( @RequestBody Patient patient){
        //return buildingService.insertBuilding(building);
        return patientRepository.save(patient);
    }
    @RequestMapping("/update")
    public Patient updatePatient(@RequestBody Patient patient,@RequestParam("id")int id)  {
        patient.setId(id);
        System.out.println(patient.getCotId());
        return patientRepository.save(patient);
        //return buildingService.updateBuilding(building);
    }

    @RequestMapping("/delete")
    public void deletePatient(@RequestParam("id")int id)  {
        patientRepository.delete(id);
    }
}
