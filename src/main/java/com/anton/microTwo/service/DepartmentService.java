package com.anton.microTwo.service;

import com.anton.microTwo.model.Department;
import com.anton.microTwo.repo.DepartmentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;

    //Create Department
    public Department createDepartment(Department department) {
        System.out.println(department);
        return departmentRepository.save(department);
    }

    //Read Department
    public List<Department> getDepartment(){
        return departmentRepository.findAll();
    }

    //Update Department
    public Department updateDepartment(Department department){
        return departmentRepository.save(department);
    }

    public boolean deleteDepartment(Long itemId) {
        if (departmentRepository.existsById(itemId)) {
            departmentRepository.deleteById(itemId);
            return true;
        } else {
            return false;
        }
    }

    public Department getDepartmentById(long id) {
        return departmentRepository.findById(id).get();
    }

    public Department getDepartmentByID(Long id) {
        return departmentRepository.findById(id).orElse(null);
    }

}
