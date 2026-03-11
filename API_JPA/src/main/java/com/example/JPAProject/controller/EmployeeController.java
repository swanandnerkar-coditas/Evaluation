package com.example.JPAProject.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.JPAProject.entity.Employee;
import com.example.JPAProject.service.EmployeeService;

import java.util.List;

@RestController
@RequestMapping("/employee")
public class EmployeeController {

    EmployeeService service;

    public EmployeeController(EmployeeService service) {
        this.service = service;
    }

    @PostMapping("/add")
    public Employee add(@RequestBody Employee e){
        return service.save(e);
    }

    @GetMapping("/names") public List<String> names(){
        return service.names();
    }

    @GetMapping("/count") public long total(){
        return service.total();
    }

    @GetMapping("/departments") public List<String> departments(){
        return service.departments();
    }

    @GetMapping("/emp-per-dept") public List<Object[]> empDept(){
        return service.empPerDept();
    }

    @GetMapping("/highest") public Employee highest(){
        return service.highest();
    }

    @GetMapping("/lowest") public Employee lowest(){
        return service.lowest();
    }

    @GetMapping("/salary-above-20000") public List<Employee> salaryAbove(){
        return service.salaryAbove();
    }

    @GetMapping("/avg-salary")
    public Double avg() {
        return service.avgSalary();
    }

    @GetMapping("/top5")
    public List<Employee> top5() {
        return service.top5();
    }

    @GetMapping("/marketing")
    public List<Employee> marketing() {
        return service.marketing();
    }

    @GetMapping("/salary-between")
    public List<Employee> salaryBetween() {
        return service.salaryBetween();
    }

    @GetMapping("/salary-null")
    public List<Employee> salaryNull() {
        return service.salaryNull();
    }

    @GetMapping("/name-start-j")
    public List<Employee> startJ() {
        return service.nameStartJ();
    }

    @GetMapping("/salary-desc")
    public List<Employee> salaryDesc() {
        return service.salaryDesc();
    }

    @GetMapping("/total-salary")
    public Double totalSalary() {
        return service.totalSalary();
    }

    @GetMapping("/same-names")
    public List<Object[]> sameNames() {
        return service.sameNames();
    }

    @GetMapping("/pune")
    public List<Employee> pune() {
        return service.pune();
    }

    @GetMapping("/avg-dev")
    public Double avgDev() {
        return service.avgDev();
    }

    @GetMapping("/above-avg")
    public List<Employee> aboveAvg() {
        return service.aboveAvg();
    }

    @GetMapping("/lowest-test")
    public List<Employee> lowestTest() {
        return service.lowestTest();
    }

    @GetMapping("/hired-2023-count")
    public long hired2023() {
        return service.hired2023();
    }

    @GetMapping("/hired-2023")
    public List<Employee> emp2023() {
        return service.emp2023();
    }

    @GetMapping("/dev-support-salary")
    public Double devSupport() {
        return service.devSupportSalary();
    }

    @GetMapping("/greater-dev-avg")
    public List<Employee> greaterDevAvg() {
        return service.greaterDevAvg();
    }

    @GetMapping("/pune-total-salary")
    public Double puneSalary() {
        return service.puneSalary();
    }

}