package version1;

public class main {
    public static void main(String[] args) {
        
        // --- 1. Hourly Employee Test ---
        System.out.println("--- Hourly Employee Test ---");
        HourlyEmployee h1 = new HourlyEmployee(101, "Alice Smith");
        h1.setTotalHoursWorked(45.0f);
        h1.setRatePerHour(200.00);
        
        HourlyEmployee h2 = new HourlyEmployee(102, "John Doe", 38.0f, 150.00);

        System.out.println("[displayHourlyEmployee()]");
        h1.displayHourlyEmployee();
        h2.displayHourlyEmployee();
        System.out.println("\n[toString()]");
        System.out.println(h1);
        System.out.println(h2);
        System.out.println();

        // --- 2. Piece Worker Employee Test ---
        System.out.println("--- Piece Worker Employee Test ---");
        PieceWorkerEmployee p1 = new PieceWorkerEmployee(201, "Bob Jones");
        p1.setTotalPiecesFinished(250);
        p1.setRatePerPiece(15.00);
        
        PieceWorkerEmployee p2 = new PieceWorkerEmployee(202, "Jane Miller", 95, 20.00);

        System.out.println("[displayPieceWorkerEmployee()]");
        p1.displayPieceWorkerEmployee();
        p2.displayPieceWorkerEmployee();
        System.out.println("\n[toString()]");
        System.out.println(p1);
        System.out.println(p2);
        System.out.println();

        // --- 3. Commission Employee Test ---
        System.out.println("--- Commission Employee Test ---");
        CommissionEmployee c1 = new CommissionEmployee(301, "Charlie Green");
        c1.setTotalSale(75000.00);
        
        CommissionEmployee c2 = new CommissionEmployee(302, "Diana Prince", 600000.00);

        System.out.println("[displayCommissionEmployee()]");
        c1.displayCommissionEmployee();
        c2.displayCommissionEmployee();
        System.out.println("\n[toString()]");
        System.out.println(c1);
        System.out.println(c2);
        System.out.println();

        // --- 4. Base Plus Commission Employee Test ---
        System.out.println("--- Base Plus Commission Employee Test ---");
        BasePlusCommissionEmployee b1 = new BasePlusCommissionEmployee(401, "Evan Wright");
        b1.setTotalSale(120000.00);
        b1.setBaseSalary(25000.00);
        
        BasePlusCommissionEmployee b2 = new BasePlusCommissionEmployee(402, "Fiona Gallagher", 45000.00, 15000.00);

        System.out.println("[displayBasePlusCommissionEmployee()]");
        b1.displayBasePlusCommissionEmployee();
        b2.displayBasePlusCommissionEmployee();
        System.out.println("\n[toString()]");
        System.out.println(b1);
        System.out.println(b2);
    }
}
