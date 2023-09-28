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
public class BasePlusCommissionEmployee extends CommissionEmployee {

    private double baseSalary;

    BasePlusCommissionEmployee() {
        super();
        this.baseSalary = 0;
    }

    BasePlusCommissionEmployee(
            int id, Name name,
            Date hireDate, Date birthDate,
            double sales, double baseSalary
    ) {
        super(id, name, hireDate, birthDate, sales);
        this.baseSalary = baseSalary;
    }

    BasePlusCommissionEmployee(int id,
            String first, String last, String middle, String prefix, String suffix,
            Date hireDate, Date birthDate, double sales, double baseSalary
    ) {
        this(id, new Name(first, last, middle, prefix, suffix),
                hireDate, birthDate, sales, baseSalary);
    }

    BasePlusCommissionEmployee(int id, Name name,
            int yearHire, int monthHire, int dayHire,
            int yearBirth, int monthBirth, int dayBirth, double sales, double baseSalary
    ) {
        super(id, name,
                yearHire, monthHire, dayHire,
                yearBirth, monthBirth, dayBirth,
                sales);
        this.baseSalary = baseSalary;
    }

    BasePlusCommissionEmployee(int id,
            String first, String last, String middle, String prefix, String suffix,
            int yearHire, int monthHire, int dayHire,
            int yearBirth, int monthBirth, int dayBirth,
            double sales, double baseSalary
    ) {
        this(id, new Name(first, last, middle, prefix, suffix),
                yearHire, monthHire, dayHire, yearBirth, monthBirth, dayBirth,
                sales, baseSalary);
    }

    BasePlusCommissionEmployee(int id, Name name,
            String hireDate, String birthDate,
            double sales, double baseSalary
    ) {
        super(id, name, hireDate, birthDate, sales);
        this.baseSalary = baseSalary;
    }

    BasePlusCommissionEmployee(int id,
            String first, String last, String middle, String prefix, String suffix,
            String hireDate, String birthDate, double sales, double baseSalary
    ) {
        this(id, new Name(first, last, middle, prefix, suffix),
                hireDate, birthDate, sales, baseSalary);
        this.baseSalary = baseSalary;
    }

//    ACCESSORS AND MUTATORS
    public double getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(double baseSalary) {
        this.baseSalary = baseSalary;
    }

//  OVERRIDDEN METHODS
    @Override
    public double computeSalary() {
        return super.computeSalary() + baseSalary;
    }

    @Override
    public void displayInfo() {
        String temp = this.toString().replace("\n}\n", ",\n\tsalary=" + this.computeSalary() + "\n}\n"); 
        System.out.println(temp);
    }

    @Override
    public String toString() {
        String temp = super.toString();
        return temp.replace("\n}\n", ",\n\tbaseSalary=" + baseSalary + "\n}\n");
    }
}
