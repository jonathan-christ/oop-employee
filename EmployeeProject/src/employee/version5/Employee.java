/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.version5;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author User
 */
public class Employee {

    private int empID;
    private Name empName;
    private Date empDateHired;
    private Date empBirthDate;

//    CONSTRUCTORS
    public Employee() {
        this.empID = -1;
        this.empName = new Name();
        this.empDateHired = new Date();
        this.empBirthDate = new Date();
    }

    public Employee(int empID, Name empName, Date empDateHired, Date empBirthDate) {
        this.empID = empID;
        this.empName = empName;
        this.empDateHired = empDateHired;
        this.empBirthDate = empBirthDate;
    }

    public Employee(int empID,
            String first, String last, String middle, String prefix, String suffix,
            Date empDateHired, Date empBirthDate
    ) {
        this(empID,
                new Name(first, last, middle, prefix, suffix),
                empDateHired, empBirthDate
        );
    }

    public Employee(int id, Name empName,
            int yearHire, int monthHire, int dayHire,
            int yearBirth, int monthBirth, int dayBirth
    ) {
        this.empID = id;
        this.empName = empName;
        this.empBirthDate = new Date(yearBirth, monthBirth, dayBirth);
        this.empDateHired = new Date(yearHire, monthHire, dayHire);
    }

    public Employee(
            int id,
            String first, String last, String middle, String prefix, String suffix,
            int yearHire, int monthHire, int dayHire,
            int yearBirth, int monthBirth, int dayBirth
    ) {

        this(id,
                new Name(first, last, middle, prefix, suffix),
                yearHire, monthHire, dayHire,
                yearBirth, monthBirth, dayBirth
        );
    }

    public Employee(int id, Name empName, String hireDate, String birthDate) {
        this.empID = id;
        this.empName = empName;
        try {
            this.empBirthDate = new SimpleDateFormat("MM/dd/yyyy").parse(birthDate);
        } catch (Exception e) {
            System.out.println("Error birthDate\n\n");
            this.empBirthDate = new Date();
        }

        try {
            this.empDateHired = new SimpleDateFormat("MM/dd/yyyy").parse(hireDate);
        } catch (Exception e) {
            System.out.println("Error hireDate\n\n");
            this.empDateHired = new Date();
        }
    }

    public Employee(int id,
            String first, String last, String middle, String prefix, String suffix,
            String hireDate, String birthDate
    ) {
        this(id, new Name(first, last, middle, prefix, suffix),
                hireDate, birthDate);
    }

//    SETTERS AND GETTERS
    public int getEmpID() {
        return empID;
    }

    public void setEmpID(int empID) {
        this.empID = empID;
    }

    public Name getEmpName() {
        return empName;
    }

    public void setEmpName(Name empName) {
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

//    USER-DEFINED FUNCTIONS
    public void displayInfo() {
        System.out.println(this.toString());
    }

    @Override
    public String toString() {
        SimpleDateFormat hire = new SimpleDateFormat("MM/dd/yyyy");
        String sHire = hire.format(this.empDateHired);

        SimpleDateFormat bday = new SimpleDateFormat("MM/dd/yyyy");
        String sBday = bday.format(this.empBirthDate);

        return this.getClass().getSimpleName()+" Instance{\n\tempID=" + empID + ",\n\tempName=" + empName
                + ",\n\tempDateHired=" + sHire + ",\n\tempBirthDate="
                + sBday;
    }
}
