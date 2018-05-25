package com.example.demo.controller;

import com.example.demo.model.Cot;
import com.example.demo.repository.CotRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/cots")
public class CotController {
//    @Autowired
//    ICotService cotService;
//
//    @RequestMapping("/cots")
//    public List<Cot> showCots() {
//        return cotService.getAll();
//    }
@Autowired
CotRepository cotRepository;

    @RequestMapping("/get")
    public List<Cot> getCots() throws SQLException {
        return cotRepository.findAll(); }
    @PostMapping("/insert")
    public Cot insertCot( @RequestBody Cot cot){
        //return buildingService.insertBuilding(building);
        return cotRepository.save(cot);
    }
    @RequestMapping("/update")
    public Cot updateCot(@RequestBody Cot cot,@RequestParam("id")int id)  {
        cot.setId(id);
        return cotRepository.save(cot);
        //return buildingService.updateBuilding(building);
    }

    @RequestMapping("/delete")
    public void deleteCot(@RequestParam("id")int id)  {
        cotRepository.delete(id);
    }
}
