//package com.example.demo.controller;
//
//import com.example.demo.model.Chair;
//import com.example.demo.model.Student;
//import com.example.demo.service.chair.ChairService;
//import com.example.demo.service.student.interfaces.IStudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RequestParam;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class ChairController {
//    @Autowired
//    ChairService chairService;
//
//    @Autowired
//    IStudentService studentService;
//
//    @RequestMapping("/chairs")
//    public List<Chair> showChairs() {
//        return chairService.getAll();
//    }
//
//    @GetMapping("/byChair")
//    public List<Student> showStudentsByChair(@RequestParam String chair) {
//        Chair chairByName = chairService.getChairByName(chair);
//        return studentService.getStudentByChair(chairByName);
//    }
//}
