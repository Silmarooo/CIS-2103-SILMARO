package version4;

public class Main {
    public static void main(String[] args) {
        System.out.println("======================================================================");
        System.out.println("EMPLOYEE ROSTER INITIALIZATION & ENROLLMENT");
        System.out.println("======================================================================");
        
        EmployeeRoster roster = new EmployeeRoster(6);

        // Instantiate polymorphic objects
        HourlyEmployee he1 = new HourlyEmployee(101, new Name("Alice", "M.", "Smith"), new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.0f, 200.0);
        PieceWorkerEmployee pwe1 = new PieceWorkerEmployee(201, new Name("Bob", "C.", "Jones", "Jr."), new MyDate(5, 4, 1998), new MyDate(15, 1, 2023), 250, 12.0);
        CommissionEmployee ce1 = new CommissionEmployee(301, new Name("Maria", "L.", "Reyes"), new MyDate(12, 9, 1995), new MyDate(20, 8, 2023), 150000.0);
        BasePlusCommissionEmployee bpce1 = new BasePlusCommissionEmployee(401, new Name("Kevin", "S.", "Tan"), new MyDate(25, 2, 1992), new MyDate(10, 10, 2020), 60000.0, 15000.0);
        HourlyEmployee he2 = new HourlyEmployee(102, new Name("David", "A.", "White"), new MyDate(15, 1, 1997), new MyDate(5, 5, 2024), 40.0f, 200.0);

        System.out.println("Added: " + he1.getEmpName() + " (Hourly) -> " + roster.addEmployee(he1));
        System.out.println("Added: " + pwe1.getEmpName() + " (Piece Worker) -> " + roster.addEmployee(pwe1));
        System.out.println("Added: " + ce1.getEmpName() + " (Commission) -> " + roster.addEmployee(ce1));
        System.out.println("Added: " + bpce1.getEmpName() + " (Base Plus Commission) -> " + roster.addEmployee(bpce1));
        System.out.println("Added: " + he2.getEmpName() + " (Hourly) -> " + roster.addEmployee(he2));

        System.out.println("\n--- ROSTER COMPOSITION COUNTS ---");
        System.out.printf("Total Employees: %d / %d%n", roster.getCount(), roster.getMax());
        System.out.println("Hourly Employees: " + roster.countHE());
        System.out.println("Piece Worker Employees: " + roster.countPWE());
        System.out.println("Commission Employees (Pure): " + roster.countCE());
        System.out.println("Base Plus Commission Employees: " + roster.countBPCE());

        System.out.println("\n======================================================================");
        System.out.println("ROSTER PAYROLL REPORT (Target Month: Sep)");
        System.out.println("======================================================================");
        roster.displayPayroll(9); // Processes September payroll layout

        System.out.println("\n======================================================================");
        System.out.println("TESTING EMPLOYEE REMOVAL & ARRAY COMPACTION");
        System.out.println("======================================================================");
        System.out.printf("Removing Employee ID 201 (%s)... Successfully removed.%n", pwe1.getEmpName());
        roster.removeEmployee(201);
        System.out.println("Current Employee Count: " + roster.getCount());
        
        System.out.println("\nRemaining Employees in Roster:");
        roster.displayAllEmployees();
    }
}
