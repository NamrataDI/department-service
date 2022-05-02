package com.springboot.department.service;

import com.springboot.department.entity.Department;
import com.springboot.department.repository.DepartmentRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@Slf4j
@RequiredArgsConstructor
public class DepartmentService {

    @Autowired
    private DepartmentRepository departmentRepository;

    public Department saveDepartment(Department department) {
        log.info("DepartmentController>saveDepartment");
        return departmentRepository.save(department);
    }

    public Department getDepartmentById(Long id) {
        log.info("DepartmentController>getDepartmentById");
        return departmentRepository.findById(id)
                .orElseGet(() -> new Department(0L, "Default", "Default"));
    }

    public List<Department> saveDepartments(List<Department> departmentList) {
        return departmentRepository.saveAll(departmentList);
    }
}
