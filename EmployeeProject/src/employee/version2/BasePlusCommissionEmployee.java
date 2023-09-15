/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.version2;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author User
 */
public class BasePlusCommissionEmployee extends CommissionEmployee{
    private double baseSalary;
    
    BasePlusCommissionEmployee(){
        super();
        this.baseSalary = 0;
    }
    
    BasePlusCommissionEmployee(int id, String name, Date hireDate, Date birthDate, double sales, double baseSalary){
        super(id, name, hireDate, birthDate, sales);
        this.baseSalary = baseSalary;
    }
    
    BasePlusCommissionEmployee(int id, String name, int yearHire, int monthHire, int dayHire, int yearBirth, int monthBirth, int dayBirth, double sales, double baseSalary){
        super(id, name, yearHire, monthHire, dayHire, yearBirth, monthBirth, dayBirth, sales);
        this.baseSalary = baseSalary;
    }
    
    BasePlusCommissionEmployee(int id, String name, String hireDate, String birthDate, double sales, double baseSalary){
        super(id, name, hireDate, birthDate, sales);
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
    public double computeSalary(){
        return super.computeSalary()+baseSalary;
    }
    @Override
    public void displayInfo(){
         SimpleDateFormat hire = new SimpleDateFormat("MM/dd/yyyy");
        String sHire = hire.format(this.getEmpDateHired());

        SimpleDateFormat bday = new SimpleDateFormat("MM/dd/yyyy");
        String sBday = bday.format(this.getEmpBirthDate());
        
        System.out.print(String.format(
                "[Employee %d's Information]\n"+
                "[-]Name %s\n"+
                "[-]Hire Date: %s\n"+
                "[-]Birth Date: %s\n"+ 
                "[-]Total Sales: %.2f\n"+
                "[-]Base Salary: %.2f\n"+
                "[-]Total Salary: %.2f\n\n",
                this.getEmpID(), this.getEmpName(),  
                sHire, sBday, this.baseSalary,
                this.getTotalSales(), computeSalary()));
    }
    
    @Override
    public String toString() {
        String temp = super.toString();
        return temp.replace("\n}\n", ",\n\tbaseSalary="+baseSalary+"\n}");
    }
}
