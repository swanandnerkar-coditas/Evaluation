package com.week6.EmployeeManagementSystem.controller;

import com.week6.EmployeeManagementSystem.model.Employee;
import com.week6.EmployeeManagementSystem.service.EmployeeService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
@RequestMapping("/api/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @GetMapping
    public ResponseEntity<List<Employee>> getAllEmployee(){
        return new ResponseEntity<>(employeeService.getAllEmployee(), HttpStatus.OK);
    }

    @GetMapping("/department/{department}")
    public ResponseEntity<Employee> getEmployeeByDepartment(@PathVariable String department){
        Employee staff = employeeService.getEmployeeByDepartment(department);
        if(staff != null) return new ResponseEntity<>(staff, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @PostMapping
    public ResponseEntity<String> createEmployee(@RequestBody Employee employee){
        employeeService.createEmployee(employee);
        return new ResponseEntity<>("Record Inserted Successfully", HttpStatus.OK);
    }

    @GetMapping("/salary/{salary}")
    public ResponseEntity<List<Employee>> getEmployeeSalaryGreaterThan(@PathVariable Double salary){
        List<Employee> staff = employeeService.findBySalaryGreaterThan(salary);
        if(!staff.isEmpty()) return new ResponseEntity<>(staff, HttpStatus.OK);
        return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    }

    @DeleteMapping("/{uuid}")
    public ResponseEntity<String> deleteEmployeeById(@PathVariable UUID uuid){
        if(employeeService.deleteEmployeeById(uuid)){
            return ResponseEntity.ok("Record Deleted Successfully");
        }
        return new ResponseEntity<>("Employee Id not present", HttpStatus.NOT_FOUND);
    }

}
