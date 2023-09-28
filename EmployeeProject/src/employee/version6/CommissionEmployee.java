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
public class CommissionEmployee extends Employee {

    private double totalSales;

//  CONSTRUCTORS
    public CommissionEmployee() {
        super();
        this.totalSales = 0;
    }

    public CommissionEmployee(int id, Name name,
            Date hireDate, Date birthDate, double sales
    ) {
        super(id, name, hireDate, birthDate);
        this.totalSales = sales;
    }

    public CommissionEmployee(int id,
            String first, String last, String middle, String prefix, String suffix,
            Date hireDate, Date birthDate, double sales
    ) {
        this(id, new Name(first, last, middle, prefix, suffix),
                hireDate, birthDate, sales);
    }

    public CommissionEmployee(int id, Name name,
            int yearHire, int monthHire, int dayHire,
            int yearBirth, int monthBirth, int dayBirth, double sales
    ) {
        super(id, name, yearHire, monthHire, dayHire,
                yearBirth, monthBirth, dayBirth);
        this.totalSales = sales;
    }

    public CommissionEmployee(int id,
            String first, String last, String middle, String prefix, String suffix,
            int yearHire, int monthHire, int dayHire,
            int yearBirth, int monthBirth, int dayBirth, double sales
    ) {
        this(id, new Name(first, last, middle, prefix, suffix),
                yearHire, monthHire, dayHire,
                yearBirth, monthBirth, dayBirth, sales);
    }

    public CommissionEmployee(int id, Name name,
            String hireDate, String birthDate, double sales
    ) {
        super(id, name, hireDate, birthDate);
        this.totalSales = sales;
    }

    public CommissionEmployee(int id,
            String first, String last, String middle, String prefix, String suffix,
            String hireDate, String birthDate, double sales
    ) {
        this(id, new Name(first, last, middle, prefix, suffix),
                hireDate, birthDate, sales);
    }

//  SETTERS AND GETTERS
    public double getTotalSales() {
        return totalSales;
    }

    public void setTotalSales(double totalSales) {
        this.totalSales = totalSales;
    }

//  USER-DEFINED METHODS
    @Override
    public double computeSalary() {
        final double[] salesPercent = {0.05, 0.2, 0.3, 0.5};
        double salary;
        int salaryIdx = 0;

        if (totalSales >= 50000 && totalSales < 100000) {
            salaryIdx = 1;
        } else if (totalSales >= 100000 && totalSales < 500000) {
            salaryIdx = 2;
        } else if (totalSales >= 500000) {
            salaryIdx = 3;
        }

        salary = salesPercent[salaryIdx] * totalSales;
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
        return temp + ",\n\ttotalSales=" + totalSales + "\n}\n";
    }
}
