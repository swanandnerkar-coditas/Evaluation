package com.week6.EmployeeManagementSystem.repository;

import com.week6.EmployeeManagementSystem.enums.Roles;
import com.week6.EmployeeManagementSystem.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.UUID;

@Repository
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

    Employee findByDepartment(String department);

    List<Employee> findBySalaryGreaterThan(Double salary);

//    @Query("select e.role from employee e where e.email = username")
    String findRoleByEmail(String username);

    Employee findByEmail(String email);
}
