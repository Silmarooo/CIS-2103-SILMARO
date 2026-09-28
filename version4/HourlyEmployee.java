package version4;

import java.util.Objects;

public class HourlyEmployee extends Employee {
    private float totalHoursWorked;
    private double ratePerHour;

    public HourlyEmployee() {
        super();
        this.totalHoursWorked = 0.0f;
        this.ratePerHour = 0.0;
    }

    public HourlyEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, float totalHoursWorked, double ratePerHour) {
        super(empID, empName, birthDate, dateHired);
        setTotalHoursWorked(totalHoursWorked);
        setRatePerHour(ratePerHour);
    }

    public float getTotalHoursWorked() { return totalHoursWorked; }
    public void setTotalHoursWorked(float hours) { this.totalHoursWorked = hours >= 0 ? hours : 0.0f; }

    public double getRatePerHour() { return ratePerHour; }
    public void setRatePerHour(double rate) { this.ratePerHour = rate >= 0 ? rate : 0.0; }

    public double computeSalary() {
        if (totalHoursWorked <= 40) {
            return totalHoursWorked * ratePerHour;
        } else {
            return (40 * ratePerHour) + ((totalHoursWorked - 40) * ratePerHour * 1.5);
        }
    }

    public double computeSalary(int currentMonth) {
        double salary = computeSalary();
        if (getBirthDate() != null && getBirthDate().getMonth() == currentMonth) {
            salary += 5000.00;
        }
        return salary;
    }

    public void displayHourlyEmployee() {
        super.displayEmployee();
        System.out.printf("   Hours Worked: %.2f | Rate: ₱%.2f/hr%n", totalHoursWorked, ratePerHour);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        HourlyEmployee other = (HourlyEmployee) obj;
        return Float.compare(totalHoursWorked, other.totalHoursWorked) == 0 &&
               Double.compare(ratePerHour, other.ratePerHour) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalHoursWorked, ratePerHour);
    }

    @Override
    public String toString() {
        return String.format("HourlyEmployee [%s, Hours: %.2f, Rate: ₱%.2f, Total Salary: ₱%,.2f]", 
                super.toString(), totalHoursWorked, ratePerHour, computeSalary());
    }
}
