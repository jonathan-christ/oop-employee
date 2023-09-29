/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package employee.version4;

/**
 *
 * @author User
 */
public class Main {

    public static void main(String[] args) {
        HourlyEmployee hourly = new HourlyEmployee(0, "Bryan", "Sanchez", "Middle", "", "", "8/9/2022", "09/02/2002", 45f, 10f);//(1, "Sir Hourly", "9/20/2023", "3/19/2003", 107, 100);
        PieceWorkerEmployee piece = new PieceWorkerEmployee(1, "Tangello", "Puma", "Middle", "", "", "8/9/2022", "09/02/2002", 500, 10f);//(1, "Magnus Carlsen", "2/2/2023", "7/30/2002", 107, 5);
        CommissionEmployee comm = new CommissionEmployee(2, "Pomello", "Umap", "Middle", "", "", "8/9/2022", "09/02/2002", 107000);//(1, "Conditioner", "5/13/2023", "1/24/2005", 107000);
        BasePlusCommissionEmployee bpc = new BasePlusCommissionEmployee(3, "Rey", "Gikapoy", "Middle", "", "", "8/9/2022", "09/02/2002", 107000, 15);//(1, "Shampoo", "12/25/2023", "10/11/1993", 107000, 5000);

        EmployeeRoster er = new EmployeeRoster();

        hourly.displayInfo();
        piece.displayInfo();
        comm.displayInfo();
        bpc.displayInfo();

        er.addEmployee(bpc, hourly, piece, comm);
        er.displayAllEmployees();
        System.out.println("Removed: " + er.removeEmployee(0));
        er.displayAllEmployees();
        er.searchEmployee("Middle");
        er.updateEmployee(3, new Name("Rey Laurence", "Gikapoy", "Middle"));
        er.searchEmployee("gikapoy");
        er.displayAllEmployees();
        er.displayEmployeeType("bpc");
    }
}
