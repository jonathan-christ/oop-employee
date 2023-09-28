/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.version6;

import java.util.Date;

/**
 *
 * @author User
 */
public class HourlyEmployee extends Employee {

    private float totalHoursWorked;
    private float ratePerHour;

// CONSTRUCTORS
    public HourlyEmployee() {
        super();
        this.totalHoursWorked = 0;
        this.ratePerHour = 0;
    }

    public HourlyEmployee(int id, Name name,
            Date hireDate, Date birthDate,
            float totalHours, float rateHour
    ) {
        super(id, name, hireDate, birthDate);
        this.totalHoursWorked = totalHours;
        this.ratePerHour = rateHour;
    }

    public HourlyEmployee(int id,
            String first, String last, String middle, String prefix, String suffix,
            Date hireDate, Date birthDate,
            float totalHours, float rateHour
    ) {
        this(id, new Name(first, last, middle, prefix, suffix),
                hireDate, birthDate,
                totalHours, rateHour);
    }

    public HourlyEmployee(int id, Name name,
            int yearHire, int monthHire, int dayHire,
            int yearBirth, int monthBirth, int dayBirth,
            float totalHours, float rateHour
    ) {
        super(id, name, yearHire, monthHire, dayHire, yearBirth, monthBirth, dayBirth);
        this.totalHoursWorked = totalHours;
        this.ratePerHour = rateHour;
    }

    public HourlyEmployee(int id,
            String first, String last, String middle, String prefix, String suffix,
            int yearHire, int monthHire, int dayHire,
            int yearBirth, int monthBirth, int dayBirth,
            float totalHours, float rateHour
    ) {
        this(id, new Name(first, last, middle, prefix, suffix),
                yearHire, monthHire, dayHire,
                yearBirth, monthBirth, dayBirth,
                totalHours, rateHour);
    }

    public HourlyEmployee(int id, Name name,
            String hireDate, String birthDate,
            float totalHours, float rateHour
    ) {
        super(id, name, hireDate, birthDate);
        this.totalHoursWorked = totalHours;
        this.ratePerHour = rateHour;
    }

    public HourlyEmployee(int id,
            String first, String last, String middle, String prefix, String suffix,
            String hireDate, String birthDate,
            float totalHours, float rateHour
    ) {
        this(id, new Name(first, last, middle, prefix, suffix),
                hireDate, birthDate,
                totalHours, rateHour);
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


//  OVERRIDE FUNCTIONS  
    @Override
    public double computeSalary() {
        final int workDailyHours, workDays, weeklyHours;
        final double excessMultiplier;

        workDailyHours = 8;
        workDays = 5;
        excessMultiplier = 1.5;
        weeklyHours = workDailyHours * workDays;

        double salary, excess;
        excess = weeklyHours - totalHoursWorked;
        salary = ratePerHour
                * ((double) weeklyHours + excessMultiplier
                * ((excess < 0) ? excess * -1 : excess));

        return salary;
    }
    
    @Override
    public void displayInfo() {
        String temp = this.toString().replace("\n}\n", ",\n\tsalary=" + this.computeSalary() + "\n}\n");
        System.out.println(temp);
    }

    @Override
    public String toString() {
        String temp = super.toString();
        return temp + ",\n\ttotalHoursWorked=" + totalHoursWorked
                + ",\n\tratePerHour=" + ratePerHour + "\n}\n";
    }

}
