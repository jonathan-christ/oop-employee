package employee.version6;

import java.util.ArrayList;
import java.util.Arrays;

public class EmployeeRoster {

    private final ArrayList<Employee> Employees;
    private final String strFormat = "| %-6s | %-50s | %-50s | %-10s |";

    //CONSTRUCTOR
    public EmployeeRoster() {
        Employees = new ArrayList<>();
    }

    //ACCESSORS (NO MUTATORS)
    public ArrayList<Employee> getEmployees() {
        return Employees;
    }

    public String getStrFormat() {
        return strFormat;
    }

    //METHODS
        private boolean isInstance(Employee y, String type) {
        boolean ret;
        type = type.toUpperCase();
        switch (type) {
            case "HE" -> ret = (y instanceof HourlyEmployee);
            case "PW" -> ret = (y instanceof PieceWorkerEmployee);
            case "CE" -> ret = (y instanceof CommissionEmployee);
            case "BPC" -> ret = (y instanceof BasePlusCommissionEmployee);
            default -> ret = false;
        }

        return ret;
    }
    
    public void addEmployee(Employee... input) {
        Employees.addAll(Arrays.asList(input));
    }

    public Employee removeEmployee(int id) {
        for (Employee x : Employees) {
            if (x != null && x.getEmpID() == id) {
                Employees.remove(x);
                return x;
            }
        }
        return null;
    }

    public boolean updateEmployee(int id, Name name) {
        for (Employee x : Employees) {
            if (x != null && x.getEmpID() == id) {
                x.setEmpName(name);
                return true;
            }
        }

        return false;
    }
    
    public int countEmpType(String type){
        int empCount=0;
        for(Employee x: Employees){
            if(isInstance(x, type)){
                empCount++;
            }
        }
        return empCount;
    }
    
    public void displayEmployeeType(String type){
        ArrayList<Employee> searchedList = new ArrayList<>();
        System.out.println("Displaying Employees of Type " + type.toUpperCase());
        for(Employee x: Employees){
            if(isInstance(x, type)){
                searchedList.add(x);
            }
        }
        
        this.displayAllEmployees(searchedList);
    }

    public ArrayList<Employee> searchEmployee(String keyword) {
        ArrayList<Employee> searchedList = new ArrayList<>();

        for (Employee x : Employees) {
            if (x.getEmpName().toString().toLowerCase().contains(keyword.toLowerCase())) {
                searchedList.add(x);
            }
        }

        System.out.println("Matches that contain keyword: `" + keyword + "`");
        displayAllEmployees(searchedList);
        return searchedList;
    }

    public void displayAllEmployees() {
        this.displayAllEmployees(Employees);
    }

    public void displayAllEmployees(ArrayList<Employee> EmpArr) {
        if (EmpArr.isEmpty()) {
            System.out.println("Employee Roster is Empty!\n");
            return;
        }
        this.printLine();
        System.out.println(String.format(strFormat,
                "ID", "Name", "Type", "Salary"));
        this.printLine();
        for (Employee x : EmpArr) {
            if (x != null) {
                System.out.println(String.format(strFormat,
                        "" + x.getEmpID(),
                        x.getEmpName().toString(),
                        x.getClass().getSimpleName(),
                        x.computeSalary()));
            }
        }
        this.printLine();
        System.out.println("");
    }

    private void printLine() {
        System.out.print(String.format("%-63s%-64s\n",
                " -------------------------------------------------------------",
                "-----------------------------------------------------------------"));
    }
}
