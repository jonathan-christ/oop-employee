/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.version2;

import java.util.Date;

/**
 *
 * @author User
 */
public class PieceWorkerEmployee extends Employee{
    private int totalPiecesFinished;
    private float ratePerPiece;
     
// CONSTRUCTORS
    public PieceWorkerEmployee(){
        super();
        this.totalPiecesFinished  = 0;
        this.ratePerPiece = 0;
    }
    
    public PieceWorkerEmployee(int id, String name, Date hireDate, Date birthDate, int totalPieces, float ratePiece){
        super(id, name, hireDate, birthDate);
        this.totalPiecesFinished  = totalPieces;
        this.ratePerPiece = ratePiece;
    }
    
    public PieceWorkerEmployee(int id, String name, int yearHire, int monthHire, int dayHire, int yearBirth, int monthBirth, int dayBirth, int totalPieces, float ratePiece){
        super(id, name, yearHire, monthHire, dayHire, yearBirth, monthBirth, dayBirth);
        this.totalPiecesFinished = totalPieces;
        this.ratePerPiece = ratePiece;
    }
    
    public PieceWorkerEmployee(int id, String name, String hireDate, String birthDate, int totalPieces, float ratePiece){
        super(id, name, hireDate, birthDate);
        this.totalPiecesFinished = totalPieces;
        this.ratePerPiece = ratePiece;
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
    public double computeSalary(){
        final int piecesForBonus = 100;
        
        double salary;
        int bonus;
        
        bonus = totalPiecesFinished/piecesForBonus;
        salary = (totalPiecesFinished*ratePerPiece) + ratePerPiece*10*(bonus);
        
        return salary;
    }
    
//  OVERRIDE FUNCTIONS  
    @Override  
    public void displayInfo(){
        super.displayInfo();
        System.out.println(String.format(
                "[-]Total Pieces Done: %d (Weekly)\n"+
                "[-]Piece Rate: %.2f\n"+
                "[-]Week Salary: %.2f\n",
                this.totalPiecesFinished,
                this.ratePerPiece,
                this.computeSalary()));
    }
    
    @Override
    public String toString() {
        String temp = super.toString();
        return temp+",\n\ttotalPiecesFinished=" + totalPiecesFinished + 
                ",\n\tratePerHour=" + ratePerPiece + "\n}\n";
    }
}
