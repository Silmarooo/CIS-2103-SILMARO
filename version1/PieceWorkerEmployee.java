package version1;

public class PieceWorkerEmployee {
    private int empID;
    private String empName;
    private int totalPiecesFinished;
    private double ratePerPiece;

    public PieceWorkerEmployee() {
        this.empID = 0;
        this.empName = "N/A";
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(int empID, String empName) {
        this.empID = empID;
        this.empName = empName;
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0.0;
    }

    public PieceWorkerEmployee(int empID, String empName, int totalPiecesFinished, double ratePerPiece) {
        this.empID = empID;
        this.empName = empName;
        setTotalPiecesFinished(totalPiecesFinished);
        setRatePerPiece(ratePerPiece);
    }

    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = (totalPiecesFinished >= 0) ? totalPiecesFinished : 0;
    }

    public double getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(double ratePerPiece) {
        this.ratePerPiece = (ratePerPiece >= 0) ? ratePerPiece : 0.0;
    }

    public double computeSalary() {
        double basePay = totalPiecesFinished * ratePerPiece;
        int bonusFactor = totalPiecesFinished / 100;
        double bonusPay = bonusFactor * (10 * ratePerPiece);
        return basePay + bonusPay;
    }

    public void displayPieceWorkerEmployee() {
        System.out.printf("ID: %d | Name: %s | Pieces Finished: %d | Rate/Piece: ₱%.2f\n", 
                empID, empName, totalPiecesFinished, ratePerPiece);
    }

    @Override
    public String toString() {
        return String.format("PieceWorkerEmployee [ID: %d, Name: %s, Pieces: %d, Rate: ₱%.2f, Total Salary: ₱%,.2f]", 
                empID, empName, totalPiecesFinished, ratePerPiece, computeSalary());
    }
}
