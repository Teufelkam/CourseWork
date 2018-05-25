package com.example.demo.controller;

import com.example.demo.model.HospitalDoctor;
import com.example.demo.repository.HospitalDoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/hospitalDoctors")
public class HospitalDoctorController {
//    @Autowired
//    IHospitalDoctorService hospitalDoctorService;
//
//    @RequestMapping("/hospitalDoctors")
//    public List<HospitalDoctor> showHospitalDoctors() {
//        return hospitalDoctorService.getAll();
//    }
@Autowired
HospitalDoctorRepository hospitalDoctorRepository;

    @RequestMapping("/get")
    public List<HospitalDoctor> getHospitalDoctors() throws SQLException {
        return hospitalDoctorRepository.findAll(); }
    @PostMapping("/insert")
    public HospitalDoctor insertHospitalDoctor( @RequestBody HospitalDoctor hospitalDoctor){
        //return buildingService.insertBuilding(building);
        return hospitalDoctorRepository.save(hospitalDoctor);
    }
    @RequestMapping("/update")
    public HospitalDoctor updateHospitalDoctor(@RequestBody HospitalDoctor hospitalDoctor,@RequestParam("id")int id)  {
        hospitalDoctor.setId(id);
        return hospitalDoctorRepository.save(hospitalDoctor);
        //return buildingService.updateBuilding(building);
    }

    @RequestMapping("/delete")
    public void deleteHospitalDoctor(@RequestParam("id")int id)  {
        hospitalDoctorRepository.delete(id);
    }
}
