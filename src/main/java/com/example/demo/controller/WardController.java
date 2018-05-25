package com.example.demo.controller;

import com.example.demo.model.Ward;
import com.example.demo.repository.WardRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/wards")
public class WardController {
//    @Autowired
//    IWardService wardService;
//
//    @RequestMapping("/wards")
//    public List<Ward> showWards() {
//        return wardService.getAll();
//    }
@Autowired
    WardRepository wardRepository;

    @RequestMapping("/get")
    public List<Ward> getWards() throws SQLException {
        return wardRepository.findAll(); }
    @PostMapping("/insert")
    public Ward insertWard( @RequestBody Ward ward){
        //return buildingService.insertBuilding(building);
        return wardRepository.save(ward);
    }
    @RequestMapping("/update")
    public Ward updateWard(@RequestBody Ward ward,@RequestParam("id")int id)  {
        ward.setId(id);
        return wardRepository.save(ward);
        //return buildingService.updateBuilding(building);
    }

    @RequestMapping("/delete")
    public void deleteWard(@RequestParam("id")int id)  {
        wardRepository.delete(id);
    }
}
