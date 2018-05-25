package com.example.demo.controller;

import com.example.demo.model.Laboratory;
import com.example.demo.repository.LaboratoryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/laboratories")
public class LaboratoryController {
//    @Autowired
//    ILaboratoryService laboratoryService;
//
//    @RequestMapping("/laboratories")
//    public List<Laboratory> showLaboratories() {
//        return laboratoryService.getAll();
//    }
@Autowired
LaboratoryRepository laboratoryRepository;

    @RequestMapping("/get")
    public List<Laboratory> getLaboratories() throws SQLException {
        return laboratoryRepository.findAll(); }
    @PostMapping("/insert")
    public Laboratory insertLaboratory( @RequestBody Laboratory laboratory){
        //return buildingService.insertBuilding(building);
        return laboratoryRepository.save(laboratory);
    }
    @RequestMapping("/update")
    public Laboratory updateLaboratory(@RequestBody Laboratory laboratory,@RequestParam("id")int id)  {
        laboratory.setId(id);
        System.out.println("fdssdf");
        return laboratoryRepository.save(laboratory);
        //return buildingService.updateBuilding(building);
    }

    @RequestMapping("/delete")
    public void deleteLaboratory(@RequestParam("id")int id)  {
        laboratoryRepository.delete(id);
    }
}
