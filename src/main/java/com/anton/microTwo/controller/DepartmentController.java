package com.anton.microTwo.controller;

import com.anton.microTwo.model.Department;
import com.anton.microTwo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/microTwo")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    //Add Department
    @PostMapping(path="/addDepartment")
    public ResponseEntity<Department> createDepartment(@RequestBody Department department){
        Department newDepartment = departmentService.createDepartment(department);
        return ResponseEntity.status(HttpStatus.CREATED).body(newDepartment);
    }

    //Get Department
    @GetMapping (path = "/getDepartment")
    public ResponseEntity<List<Department>> getDepartment(){
        List<Department> getDepartment = departmentService.getDepartment();
        if(getDepartment != null){
            return ResponseEntity.ok(getDepartment);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping (path = "/getDepartment/{id}")
    public ResponseEntity<Department> getDepartmentByID(@PathVariable Long id){
        Department getDepartment = departmentService.getDepartmentByID(id);
        if(getDepartment != null){
            return ResponseEntity.ok(getDepartment);
        }
        else{
            return ResponseEntity.notFound().build();
        }
    }

    //Update Department
    @PutMapping (path = "/putDepartment/{id}")
    public ResponseEntity<?>updateEmployee (@RequestBody Department department, @PathVariable long id){
        Optional<Department> findDepartment = Optional.ofNullable(departmentService.getDepartmentById(id));
        if(findDepartment.isPresent()){
            Department updateDepartment = findDepartment.get();
            updateDepartment.setDeptName(department.getDeptName());
            return new ResponseEntity<>(departmentService.updateDepartment(updateDepartment), HttpStatus.OK);
        }else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
    //Delete Department
    @DeleteMapping(path = "/deleteDepartment/{id}")
    public ResponseEntity<Void> deleteDepartment(@PathVariable long id){
        boolean deleted = departmentService.deleteDepartment(id);
        if (deleted) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
