package dev.jvla.springboot_tutorial.service;

import java.util.List;
import java.util.Optional;

import dev.jvla.springboot_tutorial.entity.Department;

public interface DepartmentService {
    public List<Department> fetchDepartmentList(String departmentName, String departmentCode);
    public Optional<Department> fetchDepartmentById(Long departmentId);
    public Department saveDepartment(Department department);
    public String updateDepartment(Long id, Department department);
    public String deleteDepartment(Long departmentId);
}
