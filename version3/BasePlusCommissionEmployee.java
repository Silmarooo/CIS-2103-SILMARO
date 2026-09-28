package version3;

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

    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = (baseSalary >= 0) ? baseSalary : 0.0;
    }

    // FIX 1: Override no-arg method to add base salary to commission earnings
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
        return String.format("BasePlusCommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Base Salary: ₱%,.2f, Sales: ₱%,.2f, Commission Rate: %.0f%%, Total Salary: ₱%,.2f]", 
                getEmpID(), getEmpName(), getBirthDate(), getDateHired(), baseSalary, getTotalSale(), getCommissionRate() * 100, computeSalary());
    }
}
