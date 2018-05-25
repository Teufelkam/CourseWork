package com.example.demo.controller;

import com.example.demo.model.ClinicHistory;
import com.example.demo.repository.ClinicHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/clinicHistories")
public class ClinicHistoryController {
//    @Autowired
//    IClinicHistoryService clinicHistoryService;
//
//    @RequestMapping("/clinicHistories")
//    public List<ClinicHistory> showCabinets() {
//        return clinicHistoryService.getAll();
//    }
@Autowired
ClinicHistoryRepository clinicHistoryRepository;

    @RequestMapping("/get")
    public List<ClinicHistory> getClinicHistories() throws SQLException {
        return clinicHistoryRepository.findAll(); }

    @PostMapping("/insert")
    public ClinicHistory insertClinicHistory( @RequestBody ClinicHistory clinicHistory){
        //return buildingService.insertBuilding(building);
        return clinicHistoryRepository.save(clinicHistory);
    }
    @RequestMapping("/update")
    public ClinicHistory updateClinicHistory(@RequestBody ClinicHistory clinicHistory,@RequestParam("id")int id)  {
        clinicHistory.setId(id);
        return clinicHistoryRepository.save(clinicHistory);
        //return buildingService.updateBuilding(building);
    }

    @RequestMapping("/delete")
    public void deleteClinicHistory(@RequestParam("id")int id)  {
        clinicHistoryRepository.delete(id);
    }
}
