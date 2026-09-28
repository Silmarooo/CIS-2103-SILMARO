package version5;

import java.util.Objects;

public class BasePlusCommissionEmployee extends CommissionEmployee {
    private double baseSalary;

    public BasePlusCommissionEmployee() {
        super();
        this.baseSalary = 0.0;
    }

    public BasePlusCommissionEmployee(int empID, Name empName) {
        super(empID, empName);
        this.baseSalary = 0.0;
    }


    public BasePlusCommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale, double baseSalary) {
        super(empID, empName, birthDate, dateHired, totalSale);
        setBaseSalary(baseSalary);
    }

    public double getBaseSalary() { return baseSalary; }
    public void setBaseSalary(double baseSalary) { this.baseSalary = baseSalary >= 0 ? baseSalary : 0.0; }

    @Override
    public double computeSalary() {
        return baseSalary + (getTotalSale() * getCommissionRate());
    }

    @Override
    public double computeSalary(int currentMonth) {
        double total = this.computeSalary(); 
        if (getBirthDate() != null && getBirthDate().getMonth() == currentMonth) {
            total += 5000.00;
        }
        return total;
    }

    public void displayBasePlusCommissionEmployee() {
        super.displayCommissionEmployee();
        System.out.printf("   Base Salary: ₱%.2f%n", baseSalary);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        BasePlusCommissionEmployee other = (BasePlusCommissionEmployee) obj;
        return Double.compare(baseSalary, other.baseSalary) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), baseSalary);
    }

    @Override
    public String toString() {
        return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, Total Salary: ₱%,.2f]", 
                getEmpID(), getEmpName(), computeSalary());
    }
}
