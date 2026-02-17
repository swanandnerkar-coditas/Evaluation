package week3.CompanyPayrollSystem;

public class Developer extends Employee{

//    private static final double baseSalary = 80_000;
    private float overTimeHours;

    public Developer(double baseSalary, float overTimeHours, int attendedDays, int rating){
        super(baseSalary, attendedDays, rating);
        this.overTimeHours = overTimeHours;

        // auto-call
        grossSalaryCalculation();
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getGrossSalary(){
        return grossSalary;
    }

//    Step 1 : Gross Salary calculation
    @Override
    public void grossSalaryCalculation(){
        grossSalary = baseSalary + (overTimeHours * 500);
    }

//    Step 3 : Performance Bonus Calculation
    public double getPerformanceBonus(){
        return bonus;
    }

}
