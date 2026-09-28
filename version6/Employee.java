package version6;

import java.util.Objects;

public abstract class Employee implements Cloneable {
    private final int empID; // Permanently sealed invariant identifier
    private Name empName;
    private MyDate birthDate;
    private MyDate dateHired;

    public Employee() {
        this.empID = 0;
        this.empName = new Name();
        this.birthDate = new MyDate();
        this.dateHired = new MyDate();
    }

    public Employee(int empID, Name empName, MyDate birthDate, MyDate dateHired) {
        if (empName == null) throw new NullPointerException("Employee name cannot be null");
        if (birthDate == null) throw new NullPointerException("Birth date cannot be null");
        if (dateHired == null) throw new NullPointerException("Date hired cannot be null");
        
        this.empID = empID;
        // Defensive copying within constructor maps
        this.empName = empName.clone();
        this.birthDate = birthDate.clone();
        this.dateHired = dateHired.clone();
    }

    // Sealed accessor variants to protect identifier identity consistency
    public final int getEmpID() { return empID; }

    // Accessors returning defensive duplicates to neutralize memory aliasing
    public Name getEmpName() { return this.empName.clone(); }
    public void setEmpName(Name empName) {
        if (empName == null) throw new NullPointerException("Employee name cannot be null");
        this.empName = empName.clone();
    }

    public MyDate getBirthDate() { return this.birthDate.clone(); }
    public void setBirthDate(MyDate birthDate) {
        if (birthDate == null) throw new NullPointerException("Birth date cannot be null");
        this.birthDate = birthDate.clone();
    }

    public MyDate getDateHired() { return this.dateHired.clone(); }
    public void setDateHired(MyDate dateHired) {
        if (dateHired == null) throw new NullPointerException("Date hired cannot be null");
        this.dateHired = dateHired.clone();
    }

    // Sealed business calculation logic invariant
    public final double getBirthdayBonus(int currentMonth) {
        return (birthDate.getMonth() == currentMonth) ? 5000.00 : 0.0;
    }

    // Pure abstract methods enforcing specific dynamic subclass calculations
    public abstract double computeSalary(int currentMonth);
    public abstract double computeSalary();
    public abstract void displayEmployee();

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Employee other = (Employee) obj;
        return empID == other.empID &&
               Objects.equals(empName, other.empName) &&
               Objects.equals(birthDate, other.birthDate) &&
               Objects.equals(dateHired, other.dateHired);
    }

    @Override
    public int hashCode() {
        return Objects.hash(empID, empName, birthDate, dateHired);
    }

    @Override
    public Employee clone() {
        try {
            Employee cloned = (Employee) super.clone();
            cloned.empName = this.empName.clone();
            cloned.birthDate = this.birthDate.clone();
            cloned.dateHired = this.dateHired.clone();
            return cloned;
        } catch (CloneNotSupportedException e) {
            throw new AssertionError();
        }
    }

    @Override
    public String toString() {
        return String.format("ID: %d | Name: %-25s", empID, empName.toString());
    }
}
