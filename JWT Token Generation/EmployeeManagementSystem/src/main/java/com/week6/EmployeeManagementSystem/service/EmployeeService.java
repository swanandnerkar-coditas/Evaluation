package com.week6.EmployeeManagementSystem.service;

import com.week6.EmployeeManagementSystem.model.Employee;

import java.util.List;
import java.util.UUID;

public interface EmployeeService {
    List<Employee> getAllEmployee();

    void createEmployee(Employee employee);

    Employee getEmployeeByDepartment(String department);

    List<Employee> findBySalaryGreaterThan(Double salary);

    boolean deleteEmployeeById(UUID uuid);
}
