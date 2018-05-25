package com.example.demo.controller;

import com.example.demo.model.ClinicDoctor;
import com.example.demo.repository.ClinicDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/clinicDoctors")
public class ClinicDoctorController {
//    @Autowired
//    IClinicDoctorService clinicDoctorService;
//
//    @RequestMapping("/clinicDoctors")
//    public List<ClinicDoctor> showCabinets() {
//        return clinicDoctorService.getAll();
//    }
@Autowired
ClinicDoctorRepository clinicDoctorRepository;

    @RequestMapping("/get")
    public List<ClinicDoctor> getClinicDoctors()   {
        return clinicDoctorRepository.findAll(); }

    @PostMapping("/insert")
    public ClinicDoctor insertClinicDoctor( @RequestBody ClinicDoctor clinicDoctor){
        //return buildingService.insertBuilding(building);
        System.out.println(clinicDoctor.getCabinetId());
        return clinicDoctorRepository.save(clinicDoctor);
    }
    @RequestMapping("/update")
    public ClinicDoctor updateClinicDoctor(@RequestBody ClinicDoctor clinicDoctor,@RequestParam("id")int id)  {
        clinicDoctor.setId(id);
        return clinicDoctorRepository.save(clinicDoctor);
        //return buildingService.updateBuilding(building);
    }

    @RequestMapping("/delete")
    public void ClinicDoctor(@RequestParam("id")int id)  {
        clinicDoctorRepository.delete(id);
    }
}
