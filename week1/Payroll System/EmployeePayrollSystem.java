package week3.CompanyPayrollSystem;

public class EmployeePayrollSystem {
    public static void main(String[] args) {

        Employee emp1 = new Developer(40_000, 1, 26, 5);
        emp1.startSalaryCalculation();
        emp1.getNetSalary();
        emp1.getSalaryDistribution();
        Employee emp2 = new Manager(1_00_000, 10, 20, 3);
        emp2.startSalaryCalculation();
        emp2.getNetSalary();
        emp2.getSalaryDistribution();
        Employee emp3 = new Intern(10_000, 30, 5);
        emp3.startSalaryCalculation();
        emp3.getNetSalary();
        emp3.getSalaryDistribution();

    }
}
