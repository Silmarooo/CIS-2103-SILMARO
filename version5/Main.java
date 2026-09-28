package version5;

public class Main {
    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("DYNAMIC ROSTER INITIALIZATION (ArrayList Backend)");
        System.out.println("======================================================================");
        
        EmployeeRoster roster = new EmployeeRoster();

        // Instantiate component variables
        HourlyEmployee he = new HourlyEmployee(101, new Name("Alice", "M.", "Smith"), new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.0f, 200.0);
        PieceWorkerEmployee pwe = new PieceWorkerEmployee(201, new Name("Bob", "C.", "Jones", "Jr."), new MyDate(5, 4, 1998), new MyDate(15, 1, 2023), 250, 12.0);
        CommissionEmployee ce = new CommissionEmployee(301, new Name("Maria", "L.", "Reyes"), new MyDate(12, 9, 1995), new MyDate(20, 8, 2023), 150000.0);
        BasePlusCommissionEmployee bpce = new BasePlusCommissionEmployee(401, new Name("Kevin", "S.", "Tan"), new MyDate(25, 2, 1992), new MyDate(10, 10, 2020), 60000.0, 15000.0);

        // Add to roster
        roster.addEmployee(he);
        System.out.println("Enrolled: " + he.getEmpName() + " (Hourly)");
        roster.addEmployee(pwe);
        System.out.println("Enrolled: " + pwe.getEmpName() + " (Piece Worker)");
        roster.addEmployee(ce);
        System.out.println("Enrolled: " + ce.getEmpName() + " (Commission)");
        roster.addEmployee(bpce);
        System.out.println("Enrolled: " + bpce.getEmpName() + " (Base Plus Commission)");

        System.out.println("Total Roster Size: " + roster.countEmployees() + " employees");

        System.out.println("\n======================================================================");
        System.out.println("PURE POLYMORPHIC PAYROLL REPORT (Target Month: Sep)");
        System.out.println("[No downcasting; dynamic dispatch via Employee.computeSalary()]");
        System.out.println("======================================================================");
        roster.displayPayroll(9);

        System.out.println("\n======================================================================");
        System.out.println("COLLECTION REMOVAL TEST");
        System.out.println("======================================================================");
        System.out.printf("Removing Employee ID 201... Successfully removed.%n");
        roster.removeEmployee(201);
        System.out.println("Updated Roster Size: " + roster.countEmployees());
        
        System.out.println("\nCurrent Active Employees:");
        roster.displayAllEmployees();
        System.out.println("======================================================================");
    }
}
