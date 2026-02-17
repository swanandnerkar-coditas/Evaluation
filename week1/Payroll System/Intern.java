package week3.CompanyPayrollSystem;

public class Intern extends Employee{

//    private static final double baseSalary = 10_000;
    private int attendanceDays;

    public Intern(double baseSalary, int attendedDays, int rating){
        super(baseSalary, attendedDays, rating);

        // auto-call
        grossSalaryCalculation();
    }

    public double getBaseSalary() {
        return baseSalary;
    }

    public double getGrossSalary(){
        return grossSalary;
    }


    // Gross Salary depends on attendance percentage
    @Override
    public void grossSalaryCalculation(){
        float attendancePercent = (attendanceDays / 30.f) * 100;
        if(attendancePercent < 70)
            grossSalary = baseSalary - (baseSalary * 0.20);
        else
            grossSalary = baseSalary;
    }

//    @Override
//    public void attendanceDeduction(int attendedDays) {
//
//        // in intern case if attendance % is already < 70 then we have cut 20%
//        // then should continue or not?
//        double dailySalary = baseSalary / 30.f;
//        int absentDays = 30 - attendedDays;
//        attendanceDeduction = absentDays * dailySalary;
//    }

    //    Step 3 : Performance Bonus Calculation
    public double getPerformanceBonus(){
        return bonus;
    }
}
