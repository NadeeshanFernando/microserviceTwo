package com.anton.microTwo.service;

import com.anton.microTwo.dto.DepartmentDto;
import com.anton.microTwo.dto.Response;
import com.anton.microTwo.model.Department;
import com.anton.microTwo.repo.DepartmentRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * @author by nadeeshan_fdz
 */

@Service
@Slf4j
public class DepartmentService {

    @Autowired
    DepartmentRepository departmentRepository;


    public Response<Department> saveDepartment(DepartmentDto departmentDto) {
        log.info("Saving Department");
        Response<Department> response = new Response<>();

        if(!departmentRepository.existsByDeptName(departmentDto.getDeptName())){
            Department department = new Department();
            department.setDeptName(departmentDto.getDeptName());
            departmentRepository.save(department);

            response.setData(department);
            response.setStatus(HttpStatus.OK.value());
            response.setMsg("New Department Saved");
            log.info("New Department Saved");
        }
        else{
            response.setData(null);
            response.setStatus(HttpStatus.CONFLICT.value());
            response.setMsg("Department Already Exist");
            log.info("Department Already Exist");
        }
        return response;
    }

    public Response<List<Department>> getDepartment() {
        log.info("Get Department");
        Response<List<Department>> response = new Response<>();

        List<Department> departmentList = departmentRepository.findAll();
        if(departmentList.isEmpty()){
            response.setData(null);
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setMsg("Empty Department List");
            log.info("Empty Department List");
        }
        else{
            response.setData(departmentList);
            response.setStatus(HttpStatus.OK.value());
            response.setMsg("Retrieved Department List");
            log.info("Retrieved Department List");
        }
        return response;
    }

    public Response<Department> getDepartmentById(Long id) {
        log.info("Get Department By Id");
        Response<Department> response = new Response<>();

        Optional<Department> departmentOptional = departmentRepository.findById(id);
        if(departmentOptional.isEmpty()){
            response.setData(null);
            response.setStatus(HttpStatus.NOT_FOUND.value());
            response.setMsg("Department Not Exist");
            log.info("Department Not Exist");
        }
        else{
            response.setData(departmentOptional);
            response.setStatus(HttpStatus.OK.value());
            response.setMsg("Retrieved Department");
            log.info("Retrieved Department");
        }
        return response;
    }

    public Response<Department> updateDepartment(DepartmentDto departmentDto, Long id) {
        log.info("Update Department");
        Response<Department> response = new Response<>();

        Optional<Department> departmentOptional = departmentRepository.findById(id);

        if(departmentOptional.isPresent()){
            Department currentDepartment = departmentOptional.get();

//            check if the updated department name is unique (excluding the current department)
            boolean unique = !departmentRepository.existsByDeptNameAndDeptIdNot(departmentDto.getDeptName(),currentDepartment.getDeptId());

            if(unique){
                currentDepartment.setDeptName(departmentDto.getDeptName());
                departmentRepository.save(currentDepartment);

                response.setData(currentDepartment);
                response.setStatus(HttpStatus.OK.value());
                response.setMsg("Department Updated");
                log.info("Department Updated");
            }
            else{
                response.setData(null);
                response.setStatus(HttpStatus.CONFLICT.value());
                response.setMsg("Department Name Already Exist");
                log.info("Department Name Already Exist");
            }
        }
        else{
            response.setData(null);
            response.setStatus(HttpStatus.CONFLICT.value());
            response.setMsg("Department Id Not Exist");
            log.info("Department Id Not Exist");
        }
        return response;
    }
}
