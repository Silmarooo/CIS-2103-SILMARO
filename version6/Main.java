package version6;

public class Main {
    public static void main(String[] args) {
        // ======================================================================
        // 1. TESTING ENCAPSULATION & DEFENSIVE COPYING
        // ======================================================================
        System.out.println("======================================================================");
        System.out.println("1. TESTING ENCAPSULATION & DEFENSIVE COPYING");
        System.out.println("======================================================================");
        
        MyDate originalBirth = new MyDate(15, 12, 1995);
        HourlyEmployee emp = new HourlyEmployee(101, new Name("Alice", "M.", "Smith"), 
                originalBirth, new MyDate(1, 6, 2022), 40.0f, 200.0);
        
        System.out.println("Original Birth Month: 12 (Dec)");
        System.out.println("Attempting external tampering: emp.getBirthDate().setMonth(9)...");
        
        // Malicious exploitation attempt targeting returned reference leak points
        emp.getBirthDate().setMonth(9);
        
        System.out.println("Employee's Actual Birth Date after tampering attempt: " + emp.getBirthDate());
        System.out.println("Result: SUCCESS (Internal state protected via defensive copying)");

        // ======================================================================
        // 2. TESTING EXCEPTION HANDLING & INPUT VALIDATION
        // ======================================================================
        System.out.println("\n======================================================================");
        System.out.println("2. TESTING EXCEPTION HANDLING & INPUT VALIDATION");
        System.out.println("======================================================================");
        
        System.out.println("Attempting to create HourlyEmployee with rate: -150.00...");
        try {
            new HourlyEmployee(101, new Name("Test", "User"), new MyDate(1, 1, 2000), new MyDate(1, 1, 2020), 40.0f, -150.00);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Expected Exception: [IllegalArgumentException] " + e.getMessage());
        }

        System.out.println("\nAttempting to assign invalid calendar date: 31 Feb 2026...");
        try {
            new MyDate(31, 2, 2026);
        } catch (IllegalArgumentException e) {
            System.out.println("Caught Expected Exception: [IllegalArgumentException] " + e.getMessage());
        }

        // ======================================================================
        // 3. POLYMORPHIC PAYROLL EXECUTION
        // ======================================================================
        System.out.println("\n======================================================================");
        System.out.println("3. POLYMORPHIC PAYROLL EXECUTION (Target Month: Sep)");
        System.out.println("[Dynamic Dispatch via Abstract Contract computeSalary()]");
        System.out.println("======================================================================");
        
        EmployeeRoster roster = new EmployeeRoster();
        roster.addEmployee(new HourlyEmployee(101, new Name("Alice", "M.", "Smith"), new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.0f, 200.0));
        roster.addEmployee(new PieceWorkerEmployee(201, new Name("Bob", "C.", "Jones", "Jr."), new MyDate(5, 4, 1998), new MyDate(15, 1, 2023), 250, 12.0));
        roster.addEmployee(new CommissionEmployee(301, new Name("Maria", "L.", "Reyes"), new MyDate(12, 9, 1995), new MyDate(20, 8, 2023), 150000.0));
        roster.addEmployee(new BasePlusCommissionEmployee(401, new Name("Kevin", "S.", "Tan"), new MyDate(25, 2, 1992), new MyDate(10, 10, 2020), 60000.0, 15000.0));

        roster.displayPayroll(9);
        System.out.println("======================================================================");
    }
}
