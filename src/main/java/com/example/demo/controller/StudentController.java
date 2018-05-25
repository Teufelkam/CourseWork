//package com.example.demo.controller;
//
//import com.example.demo.model.Chair;
//import com.example.demo.model.Student;
//import com.example.demo.service.student.interfaces.IStudentService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.web.bind.annotation.GetMapping;
//import org.springframework.web.bind.annotation.RequestMapping;
//import org.springframework.web.bind.annotation.RestController;
//
//import java.util.List;
//
//@RestController
//@RequestMapping("/api")
//public class StudentController {
//    @Autowired
//    IStudentService studentService;
//
//    @RequestMapping("/students")
//    public List<Student> showStudents() {
//        return studentService.getAll();
//    }
//    @GetMapping("/bestchair")
//    public Chair bestChair(){
//         return studentService.bestChair();
//    }
//
//}