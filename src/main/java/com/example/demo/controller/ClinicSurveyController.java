package com.example.demo.controller;

import com.example.demo.model.ClinicSurvey;
import com.example.demo.repository.ClinicSurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/clinicSurveys")
public class ClinicSurveyController {
//    @Autowired
//    IClinicSurveyService clinicSurveyService;
//
//    @RequestMapping("/clinicSurveys")
//    public List<ClinicSurvey> showClinicSurveys() {
//        return clinicSurveyService.getAll();
//    }
@Autowired
ClinicSurveyRepository clinicSurveyRepository;

    @RequestMapping("/get")
    public List<ClinicSurvey> getClinicSurveys() throws SQLException {
        return clinicSurveyRepository.findAll(); }
    @PostMapping("/insert")
    public ClinicSurvey insertClinicSurvey( @RequestBody ClinicSurvey clinicSurvey){
        //return buildingService.insertBuilding(building);
        return clinicSurveyRepository.save(clinicSurvey);
    }
    @RequestMapping("/update")
    public ClinicSurvey updateClinicSurvey(@RequestBody ClinicSurvey clinicSurvey,@RequestParam("id")int id)  {
        clinicSurvey.setId(id);
        return clinicSurveyRepository.save(clinicSurvey);
        //return buildingService.updateBuilding(building);
    }

    @RequestMapping("/delete")
    public void deleteClinicSurvey(@RequestParam("id")int id)  {
        clinicSurveyRepository.delete(id);
    }
}
