package com.example.demo.controller;

import com.example.demo.model.Cabinet;
import com.example.demo.model.Clinic;
import com.example.demo.repository.CabinetRepository;
import com.example.demo.repository.ClinicDoctorRepository;
import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.criterion.Restrictions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/cabinets")
public class CabinetController {

    @Autowired
    CabinetRepository cabinetRepository;

    @Autowired
    ClinicDoctorRepository clinicDoctorRepository;

    @RequestMapping("/get")
    public List<Cabinet> getClinics() throws SQLException {
        return cabinetRepository.findAll(); }

    @PostMapping("/insert")
    public Cabinet insertCabinet( @RequestBody Cabinet cabinet){
        //return buildingService.insertBuilding(building);
//
//        Criteria criteria = session.createCriteria(Clinic.class);
//        Clinic clinic = criteria.add(Restrictions.eq("name", yourFieldValue))
//                .uniqueResult();
        return cabinetRepository.save(cabinet);
    }
    @RequestMapping("/update")
    public Cabinet updateCabinet(@RequestBody Cabinet cabinet,@RequestParam("id")int id)  {
        cabinet.setId(id);
        return cabinetRepository.save(cabinet);
        //return buildingService.updateBuilding(building);
    }

    @RequestMapping("/delete")
    public void deleteCabinet(@RequestParam("id")int id)  {
            cabinetRepository.delete(id);
    }
}
