package com.example.JPAProject.repository;

import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import com.example.JPAProject.entity.Employee;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Integer> {

    //1 names
    @Query("SELECT e.firstName FROM Employee e")
    List<String> getAllNames();

    //2 total employees
    @Query("SELECT COUNT(e) FROM Employee e")
    long totalEmployees();

    //3 departments
    @Query("SELECT DISTINCT e.department FROM Employee e")
    List<String> getDepartments();

    //4 employee count by department
    @Query("SELECT e.department, COUNT(e) FROM Employee e GROUP BY e.department")
    List<Object[]> employeesPerDept();

    //5 highest paid
    Employee findTopByOrderBySalaryDesc();

    //6 lowest paid
    Employee findTopByOrderBySalaryAsc();

    //7 salary > 20000
    List<Employee> findBySalaryGreaterThan(Double salary);

    //8 average salary
    @Query("SELECT AVG(e.salary) FROM Employee e")
    Double avgSalary();

    //9 top 5 salaries
    List<Employee> findTop5ByOrderBySalaryDesc();

    //10 marketing dept
    List<Employee> findByDepartment(String department);

    //11 salary between
    List<Employee> findBySalaryBetween(Double s1, Double s2);

    //12 salary null
    List<Employee> findBySalaryIsNull();

    //13 first name starts with J
    List<Employee> findByFirstNameStartingWith(String name);

    //14 salaries desc
    List<Employee> findAllByOrderBySalaryDesc();

    //15 total salary
    @Query("SELECT SUM(e.salary) FROM Employee e")
    Double totalSalary();

    //16 same first name
    @Query("SELECT e.firstName, COUNT(e) FROM Employee e GROUP BY e.firstName HAVING COUNT(e)>1")
    List<Object[]> sameFirstName();

    //17 pune employees
    List<Employee> findByLocation(String location);

    //18 avg salary dev
    @Query("SELECT AVG(e.salary) FROM Employee e WHERE e.department='Dev'")
    Double avgDevSalary();

    //19 salary above average
    @Query("SELECT e FROM Employee e WHERE e.salary > (SELECT AVG(e.salary) FROM Employee e)")
    List<Employee> salaryAboveAverage();

    //20 lowest salary in test dept
    @Query("SELECT e FROM Employee e WHERE e.department='Test' AND e.salary = (SELECT MIN(e.salary) FROM Employee e WHERE e.department='Test')")
    List<Employee> lowestSalaryTest();

    //21 hired in 2023 count
    @Query("SELECT COUNT(e) FROM Employee e WHERE YEAR(e.hireDate)=2023")
    long hiredIn2023();

    //22 employees hired in 2023
    @Query("SELECT e FROM Employee e WHERE YEAR(e.hireDate)=2023")
    List<Employee> employees2023();

    //23 salary dev + support
    @Query("SELECT SUM(e.salary) FROM Employee e WHERE e.department IN ('Dev','Support')")
    Double totalDevSupportSalary();

    //24 salary greater than avg dev
    @Query("SELECT e FROM Employee e WHERE e.salary > (SELECT AVG(e.salary) FROM Employee e WHERE e.department='Dev')")
    List<Employee> greaterThanDevAvg();

    //25 salary in pune
    @Query("SELECT SUM(e.salary) FROM Employee e WHERE e.location='Pune'")
    Double totalSalaryPune();
}