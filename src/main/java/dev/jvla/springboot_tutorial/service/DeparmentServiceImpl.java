package dev.jvla.springboot_tutorial.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import dev.jvla.springboot_tutorial.entity.Department;
import dev.jvla.springboot_tutorial.repository.DepartmentRepository;

@Service
public class DeparmentServiceImpl implements DepartmentService{
    @Autowired
    private DepartmentRepository departmentRepository;

    // Get all Department records
    @Override
    public List<Department> fetchDepartmentList(String departmentName, String departmentCode) {
        String wildcardDepartmentName = "%" + departmentName + "%";
        String wildcardDepartmentCode = "%" + departmentCode + "%";

        if(departmentName != null && departmentCode == null) {
            return departmentRepository.findAllByDepartmentNameLikeIgnoreCase(wildcardDepartmentName);
        }
        else if(departmentCode != null && departmentName == null) {
            return departmentRepository.findAllByDepartmentCodeLikeIgnoreCase(wildcardDepartmentCode);
        }
        else if(departmentName != null && departmentName != null) {
            return departmentRepository.findAllByDepartmentNameLikeIgnoreCaseAndDepartmentCodeLikeIgnoreCase(wildcardDepartmentName, wildcardDepartmentCode);
        }

        return departmentRepository.findAll();
    }

    // Get single Department record by ID
    @Override
    public Optional<Department> fetchDepartmentById(Long departmentId) {
        return departmentRepository.findById(departmentId);
    }

    // Create new Department record
    @Override
    public Department saveDepartment(Department department) {
        return departmentRepository.save(department);
    }

    // Update Department record
    @Override
    public String updateDepartment(Long id, Department department) {
        String result = "An error occurred while updating record.";

        // Check if department exists
        Optional<Department> getDepartment = departmentRepository.findById(id);

        if(getDepartment.isPresent()) {
            Department updateDepartment = getDepartment.get();

            if(department.getDepartmentName() != null && !department.getDepartmentName().isBlank()) {
                updateDepartment.setDepartmentName(department.getDepartmentName());
            }

            if(department.getDepartmentAddress() != null && !department.getDepartmentAddress().isBlank()) {
                updateDepartment.setDepartmentAddress(department.getDepartmentAddress());
            }

            if(department.getDepartmentCode() != null && !department.getDepartmentCode().isBlank()) {
                updateDepartment.setDepartmentCode(department.getDepartmentCode());
            }

            departmentRepository.save(updateDepartment);
            result = "Department has been updated";
        }

        return result;
    }

    @Override
    public String deleteDepartment(Long departmentId) {
        String result = "Can't delete Department because it does not exist.";

        boolean departmentExists = departmentRepository.existsById(departmentId);

        if (departmentExists) {
            departmentRepository.deleteById(departmentId);
            result = "Department has been deleted.";
        }

        return result;
    }
}
