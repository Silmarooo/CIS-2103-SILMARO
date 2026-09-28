package version2;

public class Version2 {
    public static void main(String[] args) {
        System.out.println("--- Name & Date Output Verification ---");
        Name sampleName = new Name("Alice", "M.", "Smith");
        MyDate sampleDate = new MyDate(18, 9, 2026);
        
        System.out.print("Name: ");
        sampleName.displayName();
        System.out.print("Date: ");
        sampleDate.displayDate();
        System.out.println();

        // ==========================================
        // 1. HOURLY EMPLOYEE TEST
        // ==========================================
        System.out.println("--- Hourly Employee Payroll Test ---");
        Name name1 = new Name("Alice", "M.", "Smith");
        MyDate dob1 = new MyDate(18, 9, 2000); // September Birth Month
        MyDate hire1 = new MyDate(1, 6, 2022);
        
        // 45 hours worked at ₱200/hr -> Overtime calculation included
        HourlyEmployee hourlyEmp = new HourlyEmployee(101, name1, dob1, hire1, 45.0f, 200.0);

        System.out.println("[displayHourlyEmployee()]");
        hourlyEmp.displayHourlyEmployee();
        System.out.println();

        System.out.println("[toString()]");
        System.out.println(hourlyEmp);
        System.out.println();

        System.out.println("[Birthday Incentive Check]");
        System.out.printf("Regular Month (Oct) Salary: ₱%,.2f%n", hourlyEmp.computeSalary(10));
        System.out.printf("Birth Month (Sep) Salary (+₱5,000.00): ₱%,.2f%n", hourlyEmp.computeSalary(9));
        System.out.println();

        // ==========================================
        // 2. PIECE WORKER EMPLOYEE TEST
        // ==========================================
        System.out.println("--- Piece Worker Employee Payroll Test ---");
        Name name2 = new Name("Bob", "C.", "Jones", "Jr.");
        MyDate dob2 = new MyDate(5, 5, 1995); // May Birth Month
        MyDate hire2 = new MyDate(15, 3, 2021);
        
        // 250 pieces finished at ₱12.00/piece -> Includes two 100-piece batch bonuses
        PieceWorkerEmployee pieceEmp = new PieceWorkerEmployee(102, name2, dob2, hire2, 250, 12.0);

        System.out.println("[displayPieceWorkerEmployee()]");
        pieceEmp.displayPieceWorkerEmployee();
        System.out.println();

        System.out.println("[toString()]");
        System.out.println(pieceEmp);
        System.out.println();

        System.out.println("[Birthday Incentive Check]");
        System.out.printf("Regular Month (Jan) Salary: ₱%,.2f%n", pieceEmp.computeSalary(1));
        System.out.printf("Birth Month (May) Salary (+₱5,000.00): ₱%,.2f%n", pieceEmp.computeSalary(5));
        System.out.println();

        // ==========================================
        // 3. COMMISSION EMPLOYEE TEST
        // ==========================================
        System.out.println("--- Commission Employee Payroll Test ---");
        Name name3 = new Name("Charlie", "D.", "Brown");
        MyDate dob3 = new MyDate(12, 12, 1998); // December Birth Month
        MyDate hire3 = new MyDate(20, 8, 2023);
        
        // ₱150,000.00 sales -> Lands in the 15% commission tier
        CommissionEmployee commEmp = new CommissionEmployee(103, name3, dob3, hire3, 150000.0);

        System.out.println("[displayCommissionEmployee()]");
        commEmp.displayCommissionEmployee();
        System.out.println();

        System.out.println("[toString()]");
        System.out.println(commEmp);
        System.out.println();

        System.out.println("[Birthday Incentive Check]");
        System.out.printf("Regular Month (Jan) Salary: ₱%,.2f%n", commEmp.computeSalary(1));
        System.out.printf("Birth Month (Dec) Salary (+₱5,000.00): ₱%,.2f%n", commEmp.computeSalary(12));
        System.out.println();

        // ==========================================
        // 4. BASE PLUS COMMISSION EMPLOYEE TEST
        // ==========================================
        System.out.println("--- Base Plus Commission Employee Payroll Test ---");
        Name name4 = new Name("Diana", "E.", "Prince");
        MyDate dob4 = new MyDate(25, 2, 1992); // February Birth Month
        MyDate hire4 = new MyDate(10, 10, 2020);
        
        // ₱60,000.00 sales (10% tier) + ₱15,000.00 base salary
        BasePlusCommissionEmployee baseCommEmp = new BasePlusCommissionEmployee(104, name4, dob4, hire4, 60000.0, 150000.0);

        System.out.println("[displayBasePlusCommissionEmployee()]");
        baseCommEmp.displayBasePlusCommissionEmployee();
        System.out.println();

        System.out.println("[toString()]");
        System.out.println(baseCommEmp);
        System.out.println();

        System.out.println("[Birthday Incentive Check]");
        System.out.printf("Regular Month (Jan) Salary: ₱%,.2f%n", baseCommEmp.computeSalary(1));
        System.out.printf("Birth Month (Feb) Salary (+₱5,000.00): ₱%,.2f%n", baseCommEmp.computeSalary(2));
        System.out.println();
    }
}
