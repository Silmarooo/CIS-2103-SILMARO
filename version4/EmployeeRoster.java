package version4;

public class EmployeeRoster {
    private Employee[] empList;
    private int max;
    private int count;

    public EmployeeRoster() {
        this.max = 10;
        this.empList = new Employee[this.max];
        this.count = 0;
    }

    public EmployeeRoster(int max) {
        this.max = max > 0 ? max : 10;
        this.empList = new Employee[this.max];
        this.count = 0;
    }

    public int getCount() { return count; }
    public int getMax() { return max; }

    public boolean addEmployee(Employee emp) {
        if (emp == null || count >= max) {
            return false;
        }
        empList[count++] = emp;
        return true;
    }

    public Employee removeEmployee(int empID) {
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) {
                Employee removed = empList[i];
                for (int j = i; j < count - 1; j++) {
                    empList[j] = empList[j + 1];
                }
                empList[--count] = null;
                return removed;
            }
        }
        return null;
    }

    public Employee searchEmployee(int empID) {
        for (int i = 0; i < count; i++) {
            if (empList[i].getEmpID() == empID) {
                return empList[i];
            }
        }
        return null;
    }

    public int countHE() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) c++;
        }
        return c;
    }

    public int countPWE() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) c++;
        }
        return c;
    }

    public int countCE() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof CommissionEmployee && !(empList[i] instanceof BasePlusCommissionEmployee)) {
                c++;
            }
        }
        return c;
    }

    public int countBPCE() {
        int c = 0;
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) c++;
        }
        return c;
    }

    public void displayHE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof HourlyEmployee) {
                ((HourlyEmployee) empList[i]).displayHourlyEmployee();
            }
        }
    }

    public void displayPWE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof PieceWorkerEmployee) {
                ((PieceWorkerEmployee) empList[i]).displayPieceWorkerEmployee();
            }
        }
    }

    public void displayCE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof CommissionEmployee && !(empList[i] instanceof BasePlusCommissionEmployee)) {
                ((CommissionEmployee) empList[i]).displayCommissionEmployee();
            }
        }
    }

    public void displayBPCE() {
        for (int i = 0; i < count; i++) {
            if (empList[i] instanceof BasePlusCommissionEmployee) {
                ((BasePlusCommissionEmployee) empList[i]).displayBasePlusCommissionEmployee();
            }
        }
    }

    public void displayAllEmployees() {
        System.out.printf("%-5s | %-20s | %-30s%n", "ID", "Name", "Type Pattern");
        System.out.println("----------------------------------------------------------------------");
        for (int i = 0; i < count; i++) {
            System.out.printf("%-5d | %-20s | %-30s%n", 
                    empList[i].getEmpID(), 
                    empList[i].getEmpName().toString(), 
                    empList[i].getClass().getSimpleName());
        }
    }

    public void displayPayroll(int currentMonth) {
        for (int i = 0; i < count; i++) {
            Employee emp = empList[i];
            double salary = 0;
            String type = "";
            boolean bonusApplied = (emp.getBirthDate() != null && emp.getBirthDate().getMonth() == currentMonth);

            if (emp instanceof HourlyEmployee) {
                HourlyEmployee he = (HourlyEmployee) emp;
                salary = he.computeSalary(currentMonth);
                type = "Hourly";
            } else if (emp instanceof PieceWorkerEmployee) {
                PieceWorkerEmployee pwe = (PieceWorkerEmployee) emp;
                salary = pwe.computeSalary(currentMonth);
                type = "Piece Worker";
            } else if (emp instanceof BasePlusCommissionEmployee) {
                BasePlusCommissionEmployee bpce = (BasePlusCommissionEmployee) emp;
                salary = bpce.computeSalary(currentMonth);
                type = "Base Plus Commission";
            } else if (emp instanceof CommissionEmployee) {
                CommissionEmployee ce = (CommissionEmployee) emp;
                salary = ce.computeSalary(currentMonth);
                type = "Commission";
            }

            System.out.printf("[%s] ID: %d | Name: %s | Salary: ₱%,.2f%s%n", 
                    type, emp.getEmpID(), emp.getEmpName(), salary, 
                    (bonusApplied ? " (Birthday Bonus Applied)" : ""));
        }
    }
}
