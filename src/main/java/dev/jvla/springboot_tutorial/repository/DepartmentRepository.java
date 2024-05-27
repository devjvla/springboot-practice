package dev.jvla.springboot_tutorial.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import dev.jvla.springboot_tutorial.entity.Department;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {
    public List<Department> findAllByDepartmentNameLikeIgnoreCase(String departmentName);
    public List<Department> findAllByDepartmentCodeLikeIgnoreCase(String departmentCode);
    public List<Department> findAllByDepartmentNameLikeIgnoreCaseAndDepartmentCodeLikeIgnoreCase(String departmentName, String departmentCode);
}
