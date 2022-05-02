package com.springboot.department.controller;

import com.springboot.department.entity.Department;
import com.springboot.department.service.DepartmentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/departments")
@Slf4j
@RequiredArgsConstructor
public class DepartmentController {

    @Autowired
    private DepartmentService departmentService;

    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        log.info("DepartmentController>saveDepartment");
        return departmentService.saveDepartment(department);
    }

    @PostMapping("/all")
    public List<Department> saveEmployees(@RequestBody List<Department> departmentList){
        return departmentService.saveDepartments(departmentList);
    }

    @GetMapping("/{id}")
    public Department getDepartmentById(@PathVariable Long id) {
        log.info("DepartmentController>getDepartmentById");
        return departmentService.getDepartmentById(id);
    }



}
