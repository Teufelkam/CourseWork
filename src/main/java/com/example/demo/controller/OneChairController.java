//package com.example.demo.controller;
//
//import com.example.demo.model.Chair;
//import com.example.demo.service.chair.ChairService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.*;
//
//import java.sql.SQLException;
//
//@RestController
//@RequestMapping("/api")
//public class  OneChairController {
//    @Autowired
//    ChairService chairService;
//
//
//    @RequestMapping("/chair/del")
//    public Chair delOneChair(@RequestParam("id") int id) throws SQLException {
//        return chairService.deleteChair(id);
//    }
//
//    @PostMapping("/chair/insert")
//    public Chair insertOneChair(@RequestBody Chair chair) {
//        return chairService.insertChair(chair);
//    }
//
//    @PostMapping("/chair/update")
//    public Chair updateOneChair(@RequestBody Chair chair) {
//        return chairService.updateChair(chair);
//    }
//}
