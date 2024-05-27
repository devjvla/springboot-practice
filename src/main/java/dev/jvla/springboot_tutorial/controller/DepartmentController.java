package dev.jvla.springboot_tutorial.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import dev.jvla.springboot_tutorial.entity.Department;
import dev.jvla.springboot_tutorial.service.DepartmentService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RestController
@RequestMapping("api/v1/departments")
public class DepartmentController {
    @Autowired
    private DepartmentService departmentService;

    // Get all Department records
    @GetMapping("/")
    public List<Department> getDepartments(
        @RequestParam(value = "name", required = false) String departmentName,
        @RequestParam(value = "code", required = false) String departmentCode
    ) {
        return departmentService.fetchDepartmentList(departmentName, departmentCode);
    }

    // Get single Department record by ID
    @GetMapping("/{id}")
    public Optional<Department> getDepartment(@PathVariable("id") Long departmentId) {
        return departmentService.fetchDepartmentById(departmentId);
    }

    // Create a new Department record
    @PostMapping("/")
    public Department saveDepartment(@RequestBody Department department) {
        return departmentService.saveDepartment(department);
    }

    // Update Department record
    @PutMapping("/{id}")
    public String updateDepartment(@PathVariable Long id, @RequestBody Department department) {
        return departmentService.updateDepartment(id, department);
    }

    // Delete Department record by ID
    @DeleteMapping("/{id}")
    public String deleteDepartment(@PathVariable("id") Long departmentId) {
        return departmentService.deleteDepartment(departmentId);
    }
}
