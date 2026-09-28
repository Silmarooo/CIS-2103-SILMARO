package version6;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRoster {
    private final List<Employee> empList;

    public EmployeeRoster() {
        this.empList = new ArrayList<>();
    }

    public EmployeeRoster(int initialCapacity) {
        this.empList = new ArrayList<>(initialCapacity);
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null) return false;
        return empList.add(emp);
    }

    public Employee removeEmployee(int empID) {
        for (int i = 0; i < empList.size(); i++) {
            if (empList.get(i).getEmpID() == empID) {
                return empList.remove(i);
            }
        }
        return null;
    }

    public int countEmployees() { return empList.size(); }

    public void displayPayroll(int currentMonth) {
        for (Employee emp : empList) {
            double salary = emp.computeSalary(currentMonth);
            boolean bonusApplied = (emp.getBirthDate().getMonth() == currentMonth);
            
            System.out.printf("ID: %d | Name: %-25s | Payout: ₱%,.2f%s%n",
                    emp.getEmpID(), 
                    emp.getEmpName().toString(), 
                    salary,
                    (bonusApplied ? " (Bonus Applied)" : ""));
        }
    }

    public void displayAllEmployees() {
        for (Employee emp : empList) {
            emp.displayEmployee();
        }
    }
}
