package com.example.demo.controller;

import com.example.demo.model.Hospital;
import com.example.demo.repository.HospitalRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/hospitals")
public class HospitalController {
//    @Autowired
//    IHospitalService hospitalService;
//
//    @RequestMapping("/hospitals")
//    public List<Hospital> showHospitals() {
//        return hospitalService.getAll();
//    }
    @Autowired
    HospitalRepository hospitalRepository;

    @RequestMapping("/get")
    public List<Hospital> getHospitals() throws SQLException {
        return hospitalRepository.findAll(); }
    @PostMapping("/insert")
    public Hospital insertHospital( @RequestBody Hospital hospital){
        //return buildingService.insertBuilding(building);
        return hospitalRepository.save(hospital);
    }
    @RequestMapping("/update")
    public Hospital updateHospital(@RequestBody Hospital hospital,@RequestParam("id")int id)  {
        hospital.setId(id);
        return hospitalRepository.save(hospital);
        //return buildingService.updateBuilding(building);
    }

    @RequestMapping("/delete")
    public void deleteHospital(@RequestParam("id")int id)  {
        hospitalRepository.delete(id);
    }
}
