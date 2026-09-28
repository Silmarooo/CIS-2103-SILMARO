package version5;

import java.util.Objects;

public class CommissionEmployee extends Employee {
    private double totalSale;

    public CommissionEmployee() {
        super();
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, Name empName) {
        super(empID, empName, new MyDate(), new MyDate());
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale) {
        super(empID, empName, birthDate, dateHired);
        setTotalSale(totalSale);
    }


    public double getTotalSale() { return totalSale; }
    public void setTotalSale(double sale) { this.totalSale = sale >= 0 ? sale : 0.0; }

    protected double getCommissionRate() {
        if (totalSale < 50000) return 0.05;
        else if (totalSale < 100000) return 0.10;
        else if (totalSale < 500000) return 0.15;
        else return 0.20;
    }

    @Override
    public double computeSalary() {
        return totalSale * getCommissionRate();
    }

    @Override
    public double computeSalary(int currentMonth) {
        double salary = computeSalary();
        if (getBirthDate() != null && getBirthDate().getMonth() == currentMonth) {
            salary += 5000.00;
        }
        return salary;
    }

    public void displayCommissionEmployee() {
        super.displayEmployee();
        System.out.printf("   Total Sales: ₱%.2f | Commission Rate: %.0f%%%n", totalSale, getCommissionRate() * 100);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        CommissionEmployee other = (CommissionEmployee) obj;
        return Double.compare(totalSale, other.totalSale) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalSale);
    }

    @Override
    public String toString() {
        return String.format("CommissionEmployee [ID: %d, Name: %s, Total Salary: ₱%,.2f]", 
                getEmpID(), getEmpName(), computeSalary());
    }
}
