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

    //METHODS
    public void addEmployee(Employee... input) {
        Employees.addAll(Arrays.asList(input));
    }

    public Employee removeEmployee(int id) {
        for (Employee x : Employees) {
            if (x != null && x.getEmpID() == id) {
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

    public void searchEmployee(String keyword) {
        ArrayList<Employee> searchedList = new ArrayList<>();

        for (Employee x : Employees) {
            if (x.getEmpName().toString().toLowerCase().contains(keyword.toLowerCase())) {
                searchedList.add(x);
            }
        }

        System.out.println("Matches that contain keyword: `" + keyword + "`");
        displayAllEmployees(searchedList);
    }

    public void displayAllEmployees() {
        if (Employees.isEmpty()) {
            System.out.println("Employee Roster is Empty!\n");
            return;
        }
        this.printLine();
        System.out.println(String.format(strFormat,
                "ID", "Name", "Type", "Salary"));
        this.printLine();
        for (Employee x : Employees) {

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
