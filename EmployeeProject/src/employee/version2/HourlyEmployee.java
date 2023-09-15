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
public class HourlyEmployee extends Employee{
    private float totalHoursWorked;
    private float ratePerHour;
     
// CONSTRUCTORS
    public HourlyEmployee(){
        super();
        this.totalHoursWorked  = 0;
        this.ratePerHour = 0;
    }
    
    public HourlyEmployee(int id, String name, 
            Date hireDate, Date birthDate, 
            float totalHours, float rateHour
    ){
        super(id, name, hireDate, birthDate);
        this.totalHoursWorked  = totalHours;
        this.ratePerHour = rateHour;
    }
    
    public HourlyEmployee(
            int id, String name, 
            int yearHire, int monthHire, int dayHire, 
            int yearBirth, int monthBirth, int dayBirth, 
            float totalHours, float rateHour
    ){
        super(id, name, yearHire, monthHire, dayHire, yearBirth, monthBirth, dayBirth);
        this.totalHoursWorked = totalHours;
        this.ratePerHour = rateHour;
    }
    
    public HourlyEmployee(
            int id, String name, 
            String hireDate, String birthDate, 
            float totalHours, float rateHour
    ){
        super(id, name, hireDate, birthDate);
        this.totalHoursWorked = totalHours;
        this.ratePerHour = rateHour;
     }
     
// SETTERS AND GETTERS

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
    
// USER-DEFINED FUNCTIONS
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
    
//  OVERRIDE FUNCTIONS  
    @Override  
    public void displayInfo(){
        super.displayInfo();
        System.out.println(String.format(
                "[-]Total Hours: %.2f\n" +
                "[-]Hourly Rate: %.2f\n"+
                "[-]Week Salary: %.2f\n\n",
                this.totalHoursWorked,
                this.ratePerHour, 
                this.computeSalary()));
    }
    
    @Override
    public String toString() {
        String temp = super.toString();
        return temp+",\n\ttotalHoursWorked=" + totalHoursWorked + 
                ",\n\tratePerHour=" + ratePerHour + "\n}\n";
    }
     
}
