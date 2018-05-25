package com.example.demo.controller;

import com.example.demo.model.Clinic;
import com.example.demo.repository.ClinicRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/clinics")
public class ClinicController {
//    @Autowired
//    IClinicService clinicService;
//
//    @RequestMapping("/clinics")
//    public List<Clinic> showClinics() {
//        return clinicService.getAll();
//    }
@Autowired
ClinicRepository clinicRepository;

    @RequestMapping("/get")
    public List<Clinic> getClinics() throws SQLException {
        return clinicRepository.findAll(); }
    @PostMapping("/insert")
    public Clinic insertClinic( @RequestBody Clinic clinic){
        //return buildingService.insertBuilding(building);
        return clinicRepository.save(clinic);
    }
    @RequestMapping("/update")
    public Clinic updateClinic(@RequestBody Clinic clinic,@RequestParam("id")int id)  {
        clinic.setId(id);
        return clinicRepository.save(clinic);
        //return buildingService.updateBuilding(building);
    }

    @RequestMapping("/delete")
    public void deleteCabinet(@RequestParam("id")int id)  {
        clinicRepository.delete(id);
    }
}
