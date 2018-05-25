package com.example.demo.controller;

import com.example.demo.model.LaboratorySurvey;
import com.example.demo.repository.LaboratorySurveyRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/laboratorySurveys")
public class LaboratorySurveyController {
//    @Autowired
//    ILaboratorySurveyService laboratorySurveyService;
//
//    @RequestMapping("/laboratorySurveys")
//    public List<LaboratorySurvey> showLaboratorySurveys() {
//        return laboratorySurveyService.getAll();
//    }
@Autowired
LaboratorySurveyRepository laboratorySurveyRepository;
    @RequestMapping("/get")
    public List<LaboratorySurvey> getLaboratoryServeys() throws SQLException {
        return laboratorySurveyRepository.findAll(); }
    @PostMapping("/insert")
    public LaboratorySurvey insertLaboratorySurvey( @RequestBody LaboratorySurvey laboratorySurvey){
        //return buildingService.insertBuilding(building);
        return laboratorySurveyRepository.save(laboratorySurvey);
    }
    @RequestMapping("/update")
    public LaboratorySurvey updateLaboratorySurvey(@RequestBody LaboratorySurvey laboratorySurvey,@RequestParam("id")int id)  {
        laboratorySurvey.setId(id);
        return laboratorySurveyRepository.save(laboratorySurvey);
        //return buildingService.updateBuilding(building);
    }

    @RequestMapping("/delete")
    public void deleteLaboratorySurvey(@RequestParam("id")int id)  {
        laboratorySurveyRepository.delete(id);
    }
}
