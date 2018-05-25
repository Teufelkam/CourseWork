package com.example.demo.controller;

import com.example.demo.model.Department;
import com.example.demo.repository.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLException;
import java.util.List;

@RestController
@RequestMapping("/departments")
public class DepartmentController {
//    @Autowired
//    IDepartmentService departmentService;
//
//    @RequestMapping("/departments")
//    public List<Department> showDepartments() {
//        return departmentService.getAll();
//    }
@Autowired
DepartmentRepository departmentRepository;

    @RequestMapping("/get")
    public List<Department> getDepartment() throws SQLException {
        return departmentRepository.findAll(); }

    @PostMapping("/insert")
    public Department insertDepartment( @RequestBody Department department){
        //return buildingService.insertBuilding(building);
        return departmentRepository.save(department);
    }
    @RequestMapping("/update")
    public Department updateDepartment(@RequestBody Department department,@RequestParam("id")int id)  {
        department.setId(id);
        System.out.println(department.getType());
        System.out.println("fdsfsd");
        return departmentRepository.save(department);
        //return buildingService.updateBuilding(building);
    }

    @RequestMapping("/delete")
    public void deleteDepartments(@RequestParam("id")int id)  {
        departmentRepository.delete(id);
    }
}
