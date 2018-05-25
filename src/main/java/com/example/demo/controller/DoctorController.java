package com.example.demo.controller;

import com.example.demo.model.Doctor;
import com.example.demo.repository.DoctorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/doctors")
public class DoctorController {
//    @Autowired
//    IDoctorService doctorService;
//
//    @RequestMapping("/doctors")
//    public List<Doctor> showDoctors() {
//        return doctorService.getAll();
//    }
@Autowired
DoctorRepository doctorRepository;

    @RequestMapping("/get")
    public List<Doctor> getDoctors() {
        return doctorRepository.findAll(); }
    @PostMapping("/insert")
    public Doctor insertDoctor( @RequestBody Doctor doctor){
        //return buildingService.insertBuilding(building);
        return doctorRepository.save(doctor);
    }
    @RequestMapping("/update")
    public Doctor updateDoctor(@RequestBody Doctor doctor,@RequestParam("id")int id)  {
        doctor.setId(id);
        return doctorRepository.save(doctor);
        //return buildingService.updateBuilding(building);
    }

    @RequestMapping("/delete")
    public void deleteDoctor(@RequestParam("id")int id)  {
        doctorRepository.delete(id);
    }
}
