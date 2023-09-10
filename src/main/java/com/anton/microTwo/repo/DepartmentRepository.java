package com.anton.microTwo.repo;

import com.anton.microTwo.model.Department;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DepartmentRepository extends JpaRepository<Department, Long> {

//    @Query("SELECT e from Employee e left join e.employee e where e.id=?1")
//    List<Employee> findByParentEntityId(Long id);
}
