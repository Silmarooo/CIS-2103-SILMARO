package version5;

import java.util.ArrayList;
import java.util.List;

public class EmployeeRoster {
    private List<Employee> empList;

    public EmployeeRoster() {
        this.empList = new ArrayList<>();
    }

    public EmployeeRoster(int initialCapacity) {
        this.empList = new ArrayList<>(initialCapacity);
    }

    public boolean addEmployee(Employee emp) {
        if (emp == null) {
            return false;
        }
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

    public Employee searchEmployee(int empID) {
        for (Employee emp : empList) {
            if (emp.getEmpID() == empID) {
                return emp;
            }
        }
        return null;
    }

    public int countEmployees() {
        return empList.size();
    }

    public int countHE() {
        int c = 0;
        for (Employee emp : empList) {
            if (emp instanceof HourlyEmployee) c++;
        }
        return c;
    }

    public int countPWE() {
        int c = 0;
        for (Employee emp : empList) {
            if (emp instanceof PieceWorkerEmployee) c++;
        }
        return c;
    }
    public int countCE() {
        int c = 0;
        for (Employee emp : empList) {
            if (emp instanceof CommissionEmployee && !(emp instanceof BasePlusCommissionEmployee)) {
                c++;
            }
        }
        return c;
    }

    public int countBPCE() {
        int c = 0;
        for (Employee emp : empList) {
            if (emp instanceof BasePlusCommissionEmployee) c++;
        }
        return c;
    }

    public void displayHE() {
        for (Employee emp : empList) {
            if (emp instanceof HourlyEmployee) {
                ((HourlyEmployee) emp).displayHourlyEmployee();
            }
        }
    }

    public void displayPWE() {
        for (Employee emp : empList) {
            if (emp instanceof PieceWorkerEmployee) {
                ((PieceWorkerEmployee) emp).displayPieceWorkerEmployee();
            }
        }
    }

    public void displayCE() {
        for (Employee emp : empList) {
            if (emp instanceof CommissionEmployee && !(emp instanceof BasePlusCommissionEmployee)) {
                ((CommissionEmployee) emp).displayCommissionEmployee();
            }
        }
    }

    public void displayBPCE() {
        for (Employee emp : empList) {
            if (emp instanceof BasePlusCommissionEmployee) {
                ((BasePlusCommissionEmployee) emp).displayBasePlusCommissionEmployee();
            }
        }
    }

    public void displayPayroll(int currentMonth) {
        for (Employee emp : empList) {
            double salary = emp.computeSalary(currentMonth);
            boolean bonusApplied = (emp.getBirthDate() != null && emp.getBirthDate().getMonth() == currentMonth);
            
            System.out.printf("ID: %d | Name: %-25s | Payout: ₱%,.2f%s%n",
                    emp.getEmpID(), emp.getEmpName().toString(), salary,
                    (bonusApplied ? " (Birthday Bonus Applied)" : ""));
        }
    }

    public void displayAllEmployees() {
        int idx = 1;
        for (Employee emp : empList) {
            System.out.println(idx++ + ". " + emp);
        }
    }
}
