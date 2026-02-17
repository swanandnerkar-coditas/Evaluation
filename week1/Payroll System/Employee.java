package week3.CompanyPayrollSystem;

abstract class Employee{
    double grossSalary;
    double baseSalary;
    int attendedDays;
    double attendanceDeduction;
    int rating;
    public static final float pfPercentage = 0.12f;
    double pf;
    double tax;
    double netSalary;
    double bonus;

    // constructor
    public Employee(double baseSalary, int attendedDays, int rating){

        // check for valid values / input
        // instead of using try-catch, preferred conditions

        this.baseSalary = baseSalary;
        this.attendedDays = attendedDays;
        this.rating = rating;

        if(!(baseSalary > 0 && attendedDays > 0 && rating > 0)){
            System.out.println("Invalid inputs, values");
            System.exit(0);
        }
    }

    // Polymorphism
    public abstract void grossSalaryCalculation();

    // because of base salary is in child class then have to do it there
    public void attendanceDeduction(int attendedDays){
        double dailySalary = baseSalary / 30.f;
        int absentDays = 30 - attendedDays;
        attendanceDeduction = absentDays * dailySalary;
    }

    public void performanceBonusCalculation(int rating){
        int bonusPercent = 0;
        switch (rating){
            case 1 :
                bonusPercent = 0;
                break;
            case 2 :
                bonusPercent = 5;
                break;
            case 3 :
                bonusPercent = 10;
                break;
            case 4 :
                bonusPercent = 15;
                break;
            case 5 :
                bonusPercent = 20;
                break;
            default:
                System.out.println("Invalid rating, should be in range of [1-5]");
        }
        bonus =  (grossSalary * bonusPercent);
    }

    public void pfDeduction(){
        pf = baseSalary * pfPercentage;
    }

    public void taxCalculation(){
        double taxableIncome = grossSalary + bonus;
        float taxRate = 0;
        if(taxableIncome <= 50_000) taxRate = 5;
        else if(taxableIncome <= 1_00_000) taxRate = 10;
        else if(taxableIncome <= 1_50_000) taxRate = 15;
        else taxRate = 20;

        tax = taxableIncome * (taxRate / 100);
    }

    public void netSalaryCalculation(){
        netSalary = grossSalary + bonus - tax - pf - attendanceDeduction;
    }

    public void startSalaryCalculation(){
        grossSalaryCalculation();
        attendanceDeduction(attendedDays);
        performanceBonusCalculation(rating);
        pfDeduction();
        taxCalculation();
        netSalaryCalculation();
    }

    public void getNetSalary(){
        System.out.println("Net Salary after Company defined payroll rules : "+ netSalary);
    }

    public void getSalaryDistribution(){
        System.out.println("Base Salary : "+baseSalary);
        System.out.println("Gross Salary : "+grossSalary);
        System.out.println("Attended Days : "+attendedDays+" so Attendance Deduction = "+ attendanceDeduction);
        System.out.println("Performance Bonus : "+ bonus+ " for rating : "+rating);
        System.out.println("PF deduction : "+pf);
        System.out.println("Tax based on slab : "+ tax);
        System.out.println("Net Salary : "+ netSalary);
    }
}
