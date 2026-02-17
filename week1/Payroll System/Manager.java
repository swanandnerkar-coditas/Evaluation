package week3.CompanyPayrollSystem;

public class Manager extends Employee{

//    private static final double baseSalary = 1_00_000;
    private int teamSize;

    public Manager(double baseSalary, int teamSize, int attendedDays, int rating){
        super(baseSalary, attendedDays, rating);
        this.teamSize = teamSize;

        // auto-call
        grossSalaryCalculation();
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getGrossSalary(){
        return grossSalary;
    }

    @Override
    public void grossSalaryCalculation(){
        grossSalary = baseSalary + (teamSize * 500);
    }

    //    Step 3 : Performance Bonus Calculation
    public double getPerformanceBonus(){
        return bonus;
    }
}
