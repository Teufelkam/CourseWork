package com.example.demo.controller;

import com.example.demo.model.Worker;
import com.example.demo.repository.WorkerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/workers")
public class WorkerController {
//    @Autowired
//    IWorkerService workerService;
//
//    @RequestMapping("/workers")
//    public List<Worker> showWorkers() {
//        return workerService.getAll();
//    }
@Autowired
    WorkerRepository workerRepository;

    @RequestMapping("/get")
    public List<Worker> getWorkers() throws SQLException {
        return workerRepository.findAll(); }
    @PostMapping("/insert")
    public Worker insertWorker( @RequestBody Worker worker){
        //return buildingService.insertBuilding(building);
        return workerRepository.save(worker);
    }
    @RequestMapping("/update")
    public Worker updateWorker(@RequestBody Worker worker,@RequestParam("id")int id)  {
        worker.setId(id);
        return workerRepository.save(worker);
        //return buildingService.updateBuilding(building);
    }

    @RequestMapping("/delete")
    public void deleteWorker(@RequestParam("id")int id)  {
        workerRepository.delete(id);
    }
}
