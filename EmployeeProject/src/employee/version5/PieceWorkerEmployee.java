/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.version5;
import java.util.Date;

/**
 *
 * @author User
 */
public class PieceWorkerEmployee extends Employee {

    private int totalPiecesFinished;
    private float ratePerPiece;

// CONSTRUCTORS
    public PieceWorkerEmployee() {
        super();
        this.totalPiecesFinished = 0;
        this.ratePerPiece = 0;
    }

    public PieceWorkerEmployee(int id, Name name,
            Date hireDate, Date birthDate,
            int totalPieces, float ratePiece
    ) {
        super(id, name, hireDate, birthDate);
        this.totalPiecesFinished = totalPieces;
        this.ratePerPiece = ratePiece;
    }

    public PieceWorkerEmployee(int id,
            String first, String last, String middle, String prefix, String suffix,
            Date hireDate, Date birthDate,
            int totalPieces, float ratePiece
    ) {
        super(id, new Name(first, last, middle, prefix, suffix),
                hireDate, birthDate);
        this.totalPiecesFinished = totalPieces;
        this.ratePerPiece = ratePiece;
    }

    public PieceWorkerEmployee(int id, Name name,
            int yearHire, int monthHire, int dayHire,
            int yearBirth, int monthBirth, int dayBirth,
            int totalPieces, float ratePiece
    ) {
        super(id, name, yearHire, monthHire, dayHire, yearBirth, monthBirth, dayBirth);
        this.totalPiecesFinished = totalPieces;
        this.ratePerPiece = ratePiece;
    }

    public PieceWorkerEmployee(int id,
            String first, String last, String middle, String prefix, String suffix,
            int yearHire, int monthHire, int dayHire,
            int yearBirth, int monthBirth, int dayBirth,
            int totalPieces, float ratePiece
    ) {
        this(id, new Name(first, last, middle, prefix, suffix), yearHire, monthHire, dayHire, yearBirth, monthBirth, dayBirth, totalPieces, ratePiece);
    }

    public PieceWorkerEmployee(int id, Name name,
            String hireDate, String birthDate,
            int totalPieces, float ratePiece
    ) {
        super(id, name, hireDate, birthDate);
        this.totalPiecesFinished = totalPieces;
        this.ratePerPiece = ratePiece;
    }

    public PieceWorkerEmployee(int id,
            String first, String last, String middle, String prefix, String suffix,
            String hireDate, String birthDate,
            int totalPieces, float ratePiece
    ) {
        this(id, new Name(first, last, middle, prefix, suffix), hireDate, birthDate, totalPieces, ratePiece);
    }

// SETTERS AND GETTERS
    public int getTotalPiecesFinished() {
        return totalPiecesFinished;
    }

    public void setTotalPiecesFinished(int totalPiecesFinished) {
        this.totalPiecesFinished = totalPiecesFinished;
    }

    public float getRatePerPiece() {
        return ratePerPiece;
    }

    public void setRatePerPiece(float ratePerPiece) {
        this.ratePerPiece = ratePerPiece;
    }

// USER-DEFINED FUNCTIONS
    public double computeSalary() {
        final int piecesForBonus = 100;

        double salary;
        int bonus;

        bonus = totalPiecesFinished / piecesForBonus;
        salary = (totalPiecesFinished * ratePerPiece) + ratePerPiece * 10 * (bonus);

        return salary;
    }

//  OVERRIDE FUNCTIONS  
    @Override
    public void displayInfo() {
        String temp = this.toString().replace("\n}\n", ",\n\tsalary=" + this.computeSalary() + "\n}\n"); 
        System.out.println(temp);
    }

    @Override
    public String toString() {
        String temp = super.toString();
        return temp + ",\n\ttotalPiecesFinished=" + totalPiecesFinished
                + ",\n\tratePerHour=" + ratePerPiece + "\n}\n";
    }
}
