package com.example.demo.controller;

import com.example.demo.model.Corp;
import com.example.demo.repository.CorpRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/corps")
public class CorpController {
//    @Autowired
//    ICorpService corpService;
//
//    @RequestMapping("/corps")
//    public List<Corp> showCorps() {
//        return corpService.getAll();
//    }
@Autowired
CorpRepository corpRepository;

    @RequestMapping("/get")
    public List<Corp> getCorps() throws SQLException {
        return corpRepository.findAll(); }

    @PostMapping("/insert")
    public Corp insertCorp( @RequestBody Corp corp){
        //return buildingService.insertBuilding(building);
        return corpRepository.save(corp);
    }
    @RequestMapping("/update")
    public Corp updateCorp(@RequestBody Corp corp,@RequestParam("id")int id)  {
        corp.setId(id);
        return corpRepository.save(corp);
        //return buildingService.updateBuilding(building);
    }

    @RequestMapping("/delete")
    public void deleteCorp(@RequestParam("id")int id)  {
        corpRepository.delete(id);
    }
}
