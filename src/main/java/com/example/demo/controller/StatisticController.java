package com.example.demo.controller;

import com.example.demo.model.Statistic;
import com.example.demo.repository.StatisticRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/statistics")
public class StatisticController {
//    @Autowired
//    IStatisticService statisticService;
//
//    @RequestMapping("/statistics")
//    public List<Statistic> showStatistics() {
//        return statisticService.getAll();
//    }
@Autowired
StatisticRepository statisticRepository;

    @RequestMapping("/get")
    public List<Statistic> getStatictics() throws SQLException {
        return statisticRepository.findAll(); }
    @PostMapping("/insert")
    public Statistic insertStatistic( @RequestBody Statistic statistic){
        //return buildingService.insertBuilding(building);
        return statisticRepository.save(statistic);
    }
    @RequestMapping("/update")
    public Statistic updateStatistic(@RequestBody Statistic statistic,@RequestParam("id")int id)  {
        statistic.setId(id);
        return statisticRepository.save(statistic);
        //return buildingService.updateBuilding(building);
    }

    @RequestMapping("/delete")
    public void deleteStatistic(@RequestParam("id")int id)  {
        statisticRepository.delete(id);
    }
}
