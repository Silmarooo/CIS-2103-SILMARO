package version6;

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
    public void setTotalHoursWorked(float hours) {
        if (hours < 0) throw new IllegalArgumentException("Total hours worked cannot be negative.");
        this.totalHoursWorked = hours;
    }

    public double getRatePerHour() { return ratePerHour; }
    public void setRatePerHour(double rate) {
        if (rate < 0) throw new IllegalArgumentException("Rate per hour cannot be negative.");
        this.ratePerHour = rate;
    }

    @Override
    public double computeSalary() {
        if (totalHoursWorked <= 40) {
            return totalHoursWorked * ratePerHour;
        } else {
            return (40 * ratePerHour) + ((totalHoursWorked - 40) * ratePerHour * 1.5);
        }
    }

    @Override
    public double computeSalary(int currentMonth) {
        return computeSalary() + getBirthdayBonus(currentMonth);
    }

    @Override
    public void displayEmployee() {
        System.out.printf("[Hourly] ID: %d | Name: %s | Payout: ₱%,.2f%n", 
                getEmpID(), getEmpName(), computeSalary());
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
}
