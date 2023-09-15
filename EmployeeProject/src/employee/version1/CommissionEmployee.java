/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.version1;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author User
 */
public class CommissionEmployee {
    private int empID;
    private String empName;
    private Date empDateHired;
    private Date empBirthDate;
    
    private double totalSales;
    
    CommissionEmployee(){
        this.empID = 0;
        this.empName = "";
        this.empDateHired = new Date();
        this.empBirthDate = new Date();
        this.totalSales = 0;
    }
    
    CommissionEmployee(int id, String name, Date hireDate, Date birthDate, double sales){
        this.empID = id;
        this.empName = name;
        this.empDateHired = hireDate;
        this.empBirthDate = birthDate;
        this.totalSales = sales;
    }
    
    CommissionEmployee(int id, String name, int yearHire, int monthHire, int dayHire, int yearBirth, int monthBirth, int dayBirth, double sales){
        this.empID = id;
        this.empName = name;
        this.empBirthDate = new Date(yearBirth, monthBirth, dayBirth); 
        this.empDateHired = new Date(yearHire, monthHire, dayHire);
        this.totalSales = sales;
    }
    
    CommissionEmployee(int id, String name, String hireDate, String birthDate, double sales){
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
        this.totalSales = sales;
    }
    
//    ACCESSORS AND MUTATORS

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

    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }
    
// METHODS
    public double computeSalary(){
        final double[] salesPercent = {0.05, 0.2, 0.3, 0.5};
        double salary;
        int salaryIdx = 0;
        
        if(totalSales>= 50000 && totalSales<100000){
            salaryIdx = 1;
        }else if(totalSales>=100000 && totalSales<500000){
            salaryIdx = 2;
        }else if(totalSales>=500000){
            salaryIdx = 3;
        }
        
        salary = salesPercent[salaryIdx]*totalSales;
        return salary;
    }
    
    public void displayInfo(){
        SimpleDateFormat hire = new SimpleDateFormat("MM/dd/yyyy");
        String sHire = hire.format(this.empDateHired);

        SimpleDateFormat bday = new SimpleDateFormat("MM/dd/yyyy");
        String sBday = bday.format(this.empBirthDate);

        System.out.print(String.format(
                "[Employee %d's Information]\n[-]Employee type: Commission Employee\n[-]Name %s\n[-]Hire Date: %s\n[-]Birth Date: %s\n"
                        + "[-]Total Sales: %.2f\n[-]Total Salary: %.2f\n\n",
                this.empID, this.empName,  
                sHire, sBday, 
                this.totalSales, computeSalary()));
    }
    
    @Override
    public String toString() {
        SimpleDateFormat hire = new SimpleDateFormat("MM/dd/yyyy");
        String sHire = hire.format(this.empDateHired);
        
        SimpleDateFormat bday = new SimpleDateFormat("MM/dd/yyyy");
        String sBday = bday.format(this.empBirthDate);
        
        return "CommissionEmployee Instance{\n\ttempID=" + empID + ",\n\tempName=" + empName + 
                ",\n\tempDateHired=" + sHire + ",\n\tempBirthDate=" + 
                sBday + ",\n\ttotalSales=" + totalSales +"\n}\n";
    }
    
}
