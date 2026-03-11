package com.example.JPAProject.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.JPAProject.entity.Employee;
import com.example.JPAProject.repository.EmployeeRepository;

import java.util.List;

@Service
public class EmployeeService {

    @Autowired
    EmployeeRepository repo;

    public Employee save(Employee e){
        return repo.save(e);
    }

    public List<String> names(){ return repo.getAllNames(); }

    public long total(){ return repo.totalEmployees(); }

    public List<String> departments(){ return repo.getDepartments(); }

    public List<Object[]> empPerDept(){ return repo.employeesPerDept(); }

    public Employee highest(){ return repo.findTopByOrderBySalaryDesc(); }

    public Employee lowest(){ return repo.findTopByOrderBySalaryAsc(); }

    public List<Employee> salaryAbove(){ return repo.findBySalaryGreaterThan(20000.0); }

    public Double avgSalary(){ return repo.avgSalary(); }

    public List<Employee> top5(){ return repo.findTop5ByOrderBySalaryDesc(); }

    public List<Employee> marketing(){ return repo.findByDepartment("Marketing"); }

    public List<Employee> salaryBetween(){ return repo.findBySalaryBetween(15000.0,25000.0); }

    public List<Employee> salaryNull(){ return repo.findBySalaryIsNull(); }

    public List<Employee> nameStartJ(){ return repo.findByFirstNameStartingWith("J"); }

    public List<Employee> salaryDesc(){ return repo.findAllByOrderBySalaryDesc(); }

    public Double totalSalary(){ return repo.totalSalary(); }

    public List<Object[]> sameNames(){ return repo.sameFirstName(); }

    public List<Employee> pune(){ return repo.findByLocation("Pune"); }

    public Double avgDev(){ return repo.avgDevSalary(); }

    public List<Employee> aboveAvg(){ return repo.salaryAboveAverage(); }

    public List<Employee> lowestTest(){ return repo.lowestSalaryTest(); }

    public long hired2023(){ return repo.hiredIn2023(); }

    public List<Employee> emp2023(){ return repo.employees2023(); }

    public Double devSupportSalary(){ return repo.totalDevSupportSalary(); }

    public List<Employee> greaterDevAvg(){ return repo.greaterThanDevAvg(); }

    public Double puneSalary(){ return repo.totalSalaryPune(); }

}
