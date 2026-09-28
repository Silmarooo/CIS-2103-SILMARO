package version6;

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
    public void setTotalPiecesFinished(int pieces) {
        if (pieces < 0) throw new IllegalArgumentException("Total pieces finished cannot be negative.");
        this.totalPiecesFinished = pieces;
    }

    public double getRatePerPiece() { return ratePerPiece; }
    public void setRatePerPiece(double rate) {
        if (rate < 0) throw new IllegalArgumentException("Rate per piece cannot be negative.");
        this.ratePerPiece = rate;
    }

    @Override
    public double computeSalary() {
        double basePay = totalPiecesFinished * ratePerPiece;
        int bonusFactor = totalPiecesFinished / 100;
        return basePay + (bonusFactor * 10 * ratePerPiece);
    }

    @Override
    public double computeSalary(int currentMonth) {
        return computeSalary() + getBirthdayBonus(currentMonth);
    }

    @Override
    public void displayEmployee() {
        System.out.printf("[Piece Worker] ID: %d | Name: %s | Payout: ₱%,.2f%n", 
                getEmpID(), getEmpName(), computeSalary());
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
}
