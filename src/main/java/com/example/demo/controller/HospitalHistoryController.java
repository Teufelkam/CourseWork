package com.example.demo.controller;

import com.example.demo.model.HospitalHistory;
import com.example.demo.repository.HospitalHistoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/hospitalHistories")
public class HospitalHistoryController {
//    @Autowired
//    IHospitalHistoryService hospitalHistoryService;
//
//    @RequestMapping("/hospitalHistories")
//    public List<HospitalHistory> showHospitalHistories() {
//        return hospitalHistoryService.getAll();
//    }
@Autowired
HospitalHistoryRepository hospitalHistoryRepository;

    @RequestMapping("/get")
    public List<HospitalHistory> getHospitalHistories() throws SQLException {
        return hospitalHistoryRepository.findAll(); }
    @PostMapping("/insert")
    public HospitalHistory insertHospitalHistory( @RequestBody HospitalHistory hospitalHistory){
        //return buildingService.insertBuilding(building);
        return hospitalHistoryRepository.save(hospitalHistory);
    }
    @RequestMapping("/update")
    public HospitalHistory updateHospitalHistory(@RequestBody HospitalHistory hospitalHistory,@RequestParam("id")int id)  {
        hospitalHistory.setId(id);
        return hospitalHistoryRepository.save(hospitalHistory);
        //return buildingService.updateBuilding(building);
    }

    @RequestMapping("/delete")
    public void deleteHospitalHistory(@RequestParam("id")int id)  {
        hospitalHistoryRepository.delete(id);
    }
}
