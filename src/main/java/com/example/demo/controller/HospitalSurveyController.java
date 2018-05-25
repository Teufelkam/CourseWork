package com.example.demo.controller;

import com.example.demo.model.ClinicSurvey;
import com.example.demo.model.HospitalSurvey;
import com.example.demo.repository.ClinicSurveyRepository;
import com.example.demo.repository.HospitalSurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/hospitalSurveys")
public class HospitalSurveyController {
//    @Autowired
//    IHospitalSurveyService hospitalSurveyService;
//
//    @RequestMapping("/hospitalSurveys")
//    public List<HospitalSurvey> showHospitalSurvey() {
//        return hospitalSurveyService.getAll();
//    }
@Autowired
HospitalSurveyRepository hospitalSurveyRepository;

    @RequestMapping("/get")
    public List<HospitalSurvey> getHospitalSurveys() throws SQLException {
        return hospitalSurveyRepository.findAll(); }
    @PostMapping("/insert")
    public HospitalSurvey insertHospitalSurvey( @RequestBody HospitalSurvey hospitalSurvey){
        return hospitalSurveyRepository.save(hospitalSurvey);
    }
    @RequestMapping("/update")
    public HospitalSurvey updateHospitalSurvey(@RequestBody HospitalSurvey hospitalSurvey,@RequestParam("id")int id)  {
        hospitalSurvey.setId(id);
        return hospitalSurveyRepository.save(hospitalSurvey);
        //return buildingService.updateBuilding(building);
    }

    @RequestMapping("/delete")
    public void deleteHospitalSurvey(@RequestParam("id")int id)  {
        hospitalSurveyRepository.delete(id);
    }
}
