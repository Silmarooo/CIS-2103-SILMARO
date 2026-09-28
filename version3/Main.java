package version3;

public class Main {
    public static void main(String[] args) {
        int targetMonth = 9; // September

        // Instantiate component references
        Name n1 = new Name("Alice", "M.", "Smith");
        MyDate d1 = new MyDate(18, 9, 2000); // Eligible for bonus in Sept
        MyDate h1 = new MyDate(1, 6, 2022);

        Name n2 = new Name("Bob", "C.", "Jones", "Jr.");
        MyDate d2 = new MyDate(5, 4, 1998);  // Ineligible in Sept (April)
        MyDate h2 = new MyDate(15, 1, 2023);

        Name n3 = new Name("Charlie", "D.", "Brown");
        MyDate d3 = new MyDate(12, 12, 1998); // Ineligible in Sept (Dec)
        MyDate h3 = new MyDate(20, 8, 2023);

        Name n4 = new Name("Diana", "E.", "Prince");
        MyDate d4 = new MyDate(25, 9, 1992); // Eligible for bonus in Sept
        MyDate h4 = new MyDate(10, 10, 2020);

        // ======================================================================
        // 1. POLYMORPHIC COLLECTION & PAYROLL PROCESSING
        // ======================================================================
        Employee[] roster = new Employee[] {
            new HourlyEmployee(101, n1, d1, h1, 45.0f, 200.0),
            new PieceWorkerEmployee(201, n2, d2, h2, 250, 12.0),
            new CommissionEmployee(301, n3, d3, h3, 150000.0),
            new BasePlusCommissionEmployee(401, n4, d4, h4, 60000.0, 15000.0)
        };

        System.out.println("======================================================================");
        System.out.printf("POLYMORPHIC PAYROLL REPORT (Target Month: Sep)%n");
        System.out.println("======================================================================");
        for (int i = 0; i < roster.length; i++) {
            Employee emp = roster[i];
            double totalPayout = emp.computeSalary(targetMonth);
            double basePay = emp.computeSalary();
            double bonus = totalPayout - basePay;
            
            System.out.printf("%d. %s%n", i + 1, emp);
            System.out.printf("   Base Pay: ₱%,.2f | Birthday Bonus: ₱%,.2f (%s)%n", 
                    basePay, bonus, (bonus > 0 ? "Eligible" : "Ineligible"));
            System.out.printf("   Total Payout: ₱%,.2f%n%n", totalPayout);
        }

        // ======================================================================
        // 2. EQUIVALENCE & HASH CODE VERIFICATION
        // ======================================================================
        System.out.println("======================================================================");
        System.out.println("OBJECT CONTRACT TESTS (equals & hashCode)");
        System.out.println("======================================================================");
        HourlyEmployee emp1 = new HourlyEmployee(101, new Name("Alice", "M.", "Smith"), new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.0f, 200.0);
        HourlyEmployee emp1Identical = new HourlyEmployee(101, new Name("Alice", "M.", "Smith"), new MyDate(18, 9, 2000), new MyDate(1, 6, 2022), 45.0f, 200.0);
        HourlyEmployee emp2 = new HourlyEmployee(102, new Name("Bob", "C.", "Jones"), new MyDate(5, 4, 1998), new MyDate(15, 1, 2023), 40.0f, 150.0);

        System.out.println("emp1 equals emp1Identical: " + emp1.equals(emp1Identical));
        System.out.printf("emp1 hashCode: %d | emp1Identical hashCode: %d (Match: %b)%n", 
                emp1.hashCode(), emp1Identical.hashCode(), (emp1.hashCode() == emp1Identical.hashCode()));
        System.out.println("emp1 equals emp2: " + emp1.equals(emp2));
        System.out.println();

        // ======================================================================
        // 3. DEEP CLONE VERIFICATION (clone)
        // ======================================================================
        System.out.println("======================================================================");
        System.out.println("DEEP CLONE VERIFICATION");
        System.out.println("======================================================================");
        HourlyEmployee empOriginal = (HourlyEmployee) roster[0]; // <--- FIXED: Targeted index 0
        HourlyEmployee empClone = (HourlyEmployee) empOriginal.clone();

        System.out.println("[Pre-Modification Balance States]");
        System.out.println("Original: " + empOriginal.getEmpName());
        System.out.println("Cloned  : " + empClone.getEmpName());
        
        // Mutate deep properties inside the copy reference
        empClone.getEmpName().setFirstName("Zack");
        empClone.getBirthDate().setMonth(1); // Shift from Sep to Jan

        System.out.println("\n[Post-Modification Deep Copy State Divergence check]");
        System.out.println("Original (Should be Alice / Sep): " + empOriginal.getEmpName() + " | Birth Month: " + empOriginal.getBirthDate().getMonth());
        System.out.println("Cloned   (Should be Zack / Jan) : " + empClone.getEmpName() + " | Birth Month: " + empClone.getBirthDate().getMonth());
        System.out.println("======================================================================");
    }
}
