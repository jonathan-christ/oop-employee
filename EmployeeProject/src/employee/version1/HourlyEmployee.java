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
public class HourlyEmployee {
    private int empID;
    private String empName;
    private Date empDateHired;
    private Date empBirthDate;
    
    private float totalHoursWorked;
    private float ratePerHour;
    
    
//    CONSTRUCTORS
    HourlyEmployee(){
        this.empID = 0;
        this.empName = "";
        this.empDateHired = new Date();
        this.empBirthDate = new Date();
        this.totalHoursWorked  = 0;
        this.ratePerHour = 0;
    }
    
    HourlyEmployee(int id, String name, Date hireDate, Date birthDate, float totalHours, float rateHour){
        this.empID = id;
        this.empName = name;
        this.empDateHired = hireDate;
        this.empBirthDate = birthDate;
        this.totalHoursWorked  = totalHours;
        this.ratePerHour = rateHour;
    }
    
    HourlyEmployee(int id, String name, int yearHire, int monthHire, int dayHire, int yearBirth, int monthBirth, int dayBirth, float totalHours, float rateHour){
        this.empID = id;
        this.empName = name;
        this.empBirthDate = new Date(yearBirth, monthBirth, dayBirth); 
        this.empDateHired = new Date(yearHire, monthHire, dayHire);
        this.totalHoursWorked = totalHours;
        this.ratePerHour = rateHour;
    }
    
     HourlyEmployee(int id, String name,String hireDate, String birthDate, float totalHours, float rateHour){
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

        this.totalHoursWorked = totalHours;
        this.ratePerHour = rateHour;
     }

//  ACCESSORS AND MUTATORS
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

    public float getTotalHoursWorked() {
        return totalHoursWorked;
    }

    public void setTotalHoursWorked(float totalHoursWorked) {
        this.totalHoursWorked = totalHoursWorked;
    }

    public float getRatePerHour() {
        return ratePerHour;
    }

    public void setRatePerHour(float ratePerHour) {
        this.ratePerHour = ratePerHour;
    }

//  METHODS
    public double computeSalary(){
        final int workDailyHours, workDays, weeklyHours;
        final double excessMultiplier;
        
        workDailyHours = 8;
        workDays = 5;
        excessMultiplier = 1.5;
        weeklyHours = workDailyHours * workDays;
        
        double salary, excess;
        excess = weeklyHours - totalHoursWorked;
        salary = ratePerHour*((double)weeklyHours + excessMultiplier*((excess<0)? excess*-1: excess));
        
        return salary;
    }
    
    public void displayInfo(){
        SimpleDateFormat hire = new SimpleDateFormat("MM/dd/yyyy");
        String sHire = hire.format(this.empDateHired);
        
        SimpleDateFormat bday = new SimpleDateFormat("MM/dd/yyyy");
        String sBday = bday.format(this.empBirthDate);
        
        System.out.print(String.format(
                "[Employee %d's Information]\n[-]Employee type: Hourly Employee\n[-]Name: %s\n[-]Hire Date: %s\n[-]Birth Date: %s\n"
                        + "[-]Total Hours: %.2f (Weekly)\n[-]Hourly Rate: %.2f\n[-]Week Salary: %.2f\n\n",
                this.empID, this.empName,  
                sHire, sBday, 
                this.totalHoursWorked, this.ratePerHour, computeSalary()));
    }
    
    @Override
    public String toString() {
        SimpleDateFormat hire = new SimpleDateFormat("MM/dd/yyyy");
        String sHire = hire.format(this.empDateHired);
        
        SimpleDateFormat bday = new SimpleDateFormat("MM/dd/yyyy");
        String sBday = bday.format(this.empBirthDate);
        
        return "HourlyEmployee Instance{\n\tempID=" + empID + ",\n\tempName=" + empName + 
                ",\n\tempDateHired=" + sHire + ",\n\tempBirthDate=" + 
                sBday + ",\n\ttotalHoursWorked=" + totalHoursWorked + 
                ",\n\tratePerHour=" + ratePerHour + "\n}\n";
    }
    
     
}
