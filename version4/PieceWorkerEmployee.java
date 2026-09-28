package version4;

import java.util.Objects;

public class PieceWorkerEmployee extends Employee {
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        super();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(int empID, Name empName, MyDate birthDate, MyDate dateHired, int totalPiecesFinished, double ratePerPiece) {
        super(empID, empName, birthDate, dateHired);
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getTotalPiecesFinished() { return totalPiecesFinished; }
    public void setTotalPiecesFinished(int pieces) { this.totalPiecesFinished = pieces >= 0 ? pieces : 0; }

    public double getRatePerPiece() { return ratePerPiece; }
    public void setRatePerPiece(double rate) { this.ratePerPiece = rate >= 0 ? rate : 0.0; }

    public double computeSalary() {
        double basePay = totalPiecesFinished * ratePerPiece;
        int bonusFactor = totalPiecesFinished / 100;
        return basePay + (bonusFactor * 10 * ratePerPiece);
    }

    public double computeSalary(int currentMonth) {
        double salary = computeSalary();
        if (getBirthDate() != null && getBirthDate().getMonth() == currentMonth) {
            salary += 5000.00;
        }
        return salary;
    }

    public void displayPieceWorkerEmployee() {
        super.displayEmployee();
        System.out.printf("   Pieces Finished: %d | Rate/Piece: ₱%.2f%n", totalPiecesFinished, ratePerPiece);
    }

    @Override
    public boolean equals(Object obj) {
        if (!super.equals(obj)) return false;
        PieceWorkerEmployee other = (PieceWorkerEmployee) obj;
        return totalPiecesFinished == other.totalPiecesFinished &&
               Double.compare(ratePerPiece, other.ratePerPiece) == 0;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), totalPiecesFinished, ratePerPiece);
    }

    @Override
    public String toString() {
        return String.format("PieceWorkerEmployee [%s, Pieces: %d, Rate: ₱%.2f, Total Salary: ₱%,.2f]", 
                super.toString(), totalPiecesFinished, ratePerPiece, computeSalary());
    }
}
