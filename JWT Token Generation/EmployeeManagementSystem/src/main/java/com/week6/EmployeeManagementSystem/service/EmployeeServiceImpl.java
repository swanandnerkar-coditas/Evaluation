package com.week6.EmployeeManagementSystem.service;

import com.week6.EmployeeManagementSystem.exception.NegativeSalaryException;
import com.week6.EmployeeManagementSystem.model.Employee;
import com.week6.EmployeeManagementSystem.repository.EmployeeRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class EmployeeServiceImpl implements EmployeeService{

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public List<Employee> getAllEmployee() {
        return employeeRepository.findAll();
    }

    @Override
    public void createEmployee(Employee employee) {
        double salary = employee.getSalary();
        if(salary < 0) throw new NegativeSalaryException("Salary Can't be Negative");
        employeeRepository.save(employee);
    }

    @Override
    public Employee getEmployeeByDepartment(String department) {
        return employeeRepository.findByDepartment(department);
    }

    @Override
    public List<Employee> findBySalaryGreaterThan(Double salary) {
        return employeeRepository.findBySalaryGreaterThan(salary);
    }

    @Override
    public boolean deleteEmployeeById(UUID uuid) {
        Optional<Employee> optionalEmployee = employeeRepository.findById(uuid);
        if(optionalEmployee.isPresent()){
            Employee emp = optionalEmployee.get();
            employeeRepository.delete(emp);
            return true;
        }
        // can provide exception as well here
        return false;
    }
}
