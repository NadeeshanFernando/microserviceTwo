package com.anton.microTwo.controller;

import com.anton.microTwo.dto.DepartmentDto;
import com.anton.microTwo.dto.Response;
import com.anton.microTwo.model.Department;
import com.anton.microTwo.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author by nadeeshan_fdz
 */

@RestController
@RequestMapping("/microTwo/department")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @PostMapping
    public ResponseEntity<Response<Department>> saveDepartment(@RequestBody DepartmentDto departmentDto){
        Response<Department> response = departmentService.saveDepartment(departmentDto);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping
    public ResponseEntity<Response<List<Department>>> getDepartment(){
        Response<List<Department>> response = departmentService.getDepartment();
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Response<Department>> getDepartmentById(@PathVariable Long id){
        Response<Department> response = departmentService.getDepartmentById(id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Response<Department>> updateDepartment(@RequestBody DepartmentDto departmentDto, @PathVariable Long id){
        Response<Department> response = departmentService.updateDepartment(departmentDto,id);
        return ResponseEntity.status(response.getStatus()).body(response);
    }
}
