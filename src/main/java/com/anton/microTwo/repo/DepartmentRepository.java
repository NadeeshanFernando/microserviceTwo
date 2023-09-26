package com.anton.microTwo.repo;

import com.anton.microTwo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * @author by nadeeshan_fdz
 */

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

    boolean existsByDeptName(String deptName);

    boolean existsByDeptNameAndDeptIdNot(String deptName, long deptId);
}
