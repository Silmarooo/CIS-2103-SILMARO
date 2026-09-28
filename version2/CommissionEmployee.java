package version2;

public class CommissionEmployee {
    private int empID;
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;
    private double totalSale;

    public CommissionEmployee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, Name empName) {
        this.empID = empID;
        this.empName = empName != null ? empName : new Name();
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
        this.totalSale = 0.0;
    }

    public CommissionEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, double totalSale) {
        this.empID = empID;
        this.empName = empName != null ? empName : new Name();
        this.birthDate = birthDate != null ? birthDate : new MyDate();
        this.dateHired = dateHired != null ? dateHired : new MyDate();
        setTotalSale(totalSale);
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public void setEmpName(Name empName) {
        this.empName = empName;
    }

    public MyDate getBirthDate() {
        return birthDate;
    }

    public void setBirthDate(MyDate birthDate) {
        this.birthDate = birthDate;
    }

    public MyDate getDateHired() {
        return dateHired;
    }

    public void setDateHired(MyDate dateHired) {
        this.dateHired = dateHired;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = (totalSale >= 0) ? totalSale : 0.0;
    }

    protected double getCommissionRate() {
        if (totalSale < 50000) {
            return 0.05;
        } else if (totalSale < 100000) {
            return 0.10;
        } else if (totalSale < 500000) {
            return 0.15;
        } else {
            return 0.20;
        }
    }

    // Overloaded no-arg method (Computes basic earnings without incentive)
    public double computeSalary() {
        return totalSale * getCommissionRate();
    }

    // Worker method with birthday incentive logic (+₱5,000.00)
    public double computeSalary(int currentMonth) {
        double salary = computeSalary();
        if (birthDate != null && birthDate.getMonth() == currentMonth) {
            salary += 5000.00;
        }
        return salary;
    }

    public void displayCommissionEmployee() {
        System.out.printf("ID: %d | Name: %s | DOB: %s | Hired: %s | Total Sales: ₱%.2f%n", 
                empID, empName, birthDate, dateHired, totalSale);
    }

    @Override
    public String toString() {
        return String.format("CommissionEmployee [ID: %d, Name: %s, DOB: %s, Hired: %s, Sales: ₱%.2f, Commission Rate: %.0f%%, Total Salary: ₱%,.2f]", 
                empID, empName, birthDate, dateHired, totalSale, getCommissionRate() * 100, computeSalary());
    }
}
