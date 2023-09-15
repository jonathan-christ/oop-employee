/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.version1;

import java.text.SimpleDateFormat;
import java.util.Date;

public class PieceWorkerEmployee {
    private int empID;
    private String empName;
    private Date empDateHired;
    private Date empBirthDate;
    private int totalPiecesFinished;
    private float ratePerPiece;
    
//    CONSTRUCTORS
    PieceWorkerEmployee(){
        this.empID = 0;
        this.empName = "";
        this.empDateHired = new Date();
        this.empBirthDate = new Date();
        this.totalPiecesFinished  = 0;
        this.ratePerPiece = 0;
    }
    
    PieceWorkerEmployee(int id, String name, Date hireDate, Date birthDate, int totalPieces, float ratePiece){
        this.empID = id;
        this.empName = name;
        this.empDateHired = hireDate;
        this.empBirthDate = birthDate;
        this.totalPiecesFinished  = totalPieces;
        this.ratePerPiece = ratePiece;
    }
    
    PieceWorkerEmployee(int id, String name, int yearHire, int monthHire, int dayHire, int yearBirth, int monthBirth, int dayBirth, int totalPieces, float ratePiece){
        this.empID = id;
        this.empName = name;
        this.empBirthDate = new Date(yearBirth, monthBirth, dayBirth); 
        this.empDateHired = new Date(yearHire, monthHire, dayHire);
        this.totalPiecesFinished  = totalPieces;
        this.ratePerPiece = ratePiece;
    }
    
    PieceWorkerEmployee(int id, String name, String hireDate, String birthDate, int totalPieces, float ratePiece){
        this.empID = id;
        this.empName = name;
        try{
            this.empBirthDate = new SimpleDateFormat("MM/dd/yyyy").parse(birthDate); 
        } catch(Exception e){
            System.out.println("Error birthDate\n\n");
            this.empBirthDate = new Date();
        }
        
        try{
            this.empDateHired = new SimpleDateFormat("MM/dd/yyyy").parse(hireDate); 
        } catch(Exception e){
            System.out.println("Error hireDate\n\n");
            this.empDateHired = new Date();
        }
        this.totalPiecesFinished  = totalPieces;
        this.ratePerPiece = ratePiece;
    }
    
// ACCESSORS AND MUTATORS

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

    public Date getEmpDateHired() {
        return empDateHired;
    }

    public void setEmpDateHired(Date empDateHired) {
        this.empDateHired = empDateHired;
    }

    public Date getEmpBirthDate() {
        return empBirthDate;
    }

    public void setEmpBirthDate(Date empBirthDate) {
        this.empBirthDate = empBirthDate;
    }

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
     
// METHODS
    public double computeSalary(){
        final int piecesForBonus = 100;
        
        double salary;
        int bonus;
        
        bonus = totalPiecesFinished/piecesForBonus;
        salary = (totalPiecesFinished*ratePerPiece) + ratePerPiece*10*(bonus);
        
        return salary;
    }
    
    public void displayInfo(){
        SimpleDateFormat hire = new SimpleDateFormat("MM/dd/yyyy");
        String sHire = hire.format(this.empDateHired);
        
        SimpleDateFormat bday = new SimpleDateFormat("MM/dd/yyyy");
        String sBday = bday.format(this.empBirthDate);
        
        System.out.print(String.format(
                "[Employee %d's Information]\n[-]Employee type: Piece Worker Employee\n[-]Name: %s\n[-]Hire Date: %s\n[-]Birth Date: %s\n"
                        + "[-]Total Pieces Done: %d (Weekly)\n[-]Piece Rate: %.2f\n[-]Week Salary: %.2f\n\n",
                this.empID, this.empName, 
                sHire, sBday, 
                this.totalPiecesFinished, this.ratePerPiece, computeSalary()));
    }
    
    @Override
    public String toString() {
        SimpleDateFormat hire = new SimpleDateFormat("MM/dd/yyyy");
        String sHire = hire.format(this.empDateHired);
        
        SimpleDateFormat bday = new SimpleDateFormat("MM/dd/yyyy");
        String sBday = bday.format(this.empBirthDate);
        
        return "PieceWorkerEmployee Instance{\n\tempID=" + empID + ",\n\tempName=" + empName + 
                ",\n\tempDateHired=" + sHire + ",\n\tempBirthDate=" + 
                sBday + ",\n\ttotalPiecesFinished=" + totalPiecesFinished + 
                ",\n\tratePerHour=" + ratePerPiece + "\n}\n";
    }

}
