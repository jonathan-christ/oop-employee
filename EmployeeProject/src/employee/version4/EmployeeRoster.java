package employee.version4;

public class EmployeeRoster {

    private Employee[] Employees;
    private int count;
    private final int max = 10;
    private final String strFormat = "| %-6s | %-50s | %-50s | %-10s |";

    //CONSTRUCTOR
    public EmployeeRoster() {
        Employees = new Employee[max];
        count = 0;
    }

    //ACCESSORS (NO MUTATORS)
    public Employee[] getEmployees() {
        return Employees;
    }

    public int getCount() {
        return count;
    }

    //METHODS
    public void addEmployee(Employee ... input) {
        for(Employee e : input){
            Employees[count] = e;
            count++;
        }
    }

    public Employee removeEmployee(int id) {
        for (Employee x : Employees) {
            if (x.getEmpID() == id) {
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
        Employee[] searchedArr = new Employee[this.count];
        int arrIdx;
        arrIdx = 0;

        for (Employee x : Employees) {
            if (x != null && x.getEmpName().toString().toLowerCase().contains(keyword.toLowerCase())) {
                searchedArr[arrIdx++] = x;
            }
        }
        System.out.println("Matches found!");
        displayAllEmployees(searchedArr);
    }

    public void displayAllEmployees() {
        System.out.println(String.format(strFormat,
                "ID", "Name", "Type", "Salary"));
        System.out.println(String.format(strFormat,
                "","","","",""));
        for (Employee x : Employees) {
            if (x != null) {
                System.out.println(String.format(strFormat,
                        "" + x.getEmpID(),
                        x.getEmpName().toString(),
                        x.getClass().getSimpleName(),
                        x.computeSalary()));
            }
        }
    }

    public void displayAllEmployees(Employee[] EmpArr) {
        System.out.println(String.format(strFormat,
                "ID", "Name", "Type", "Salary"));
        for (Employee x : EmpArr) {
            if (x != null) {
                System.out.println(String.format(strFormat,
                        "" + x.getEmpID(),
                        x.getEmpName().toString(),
                        x.getClass().getSimpleName(),
                        x.computeSalary()));
            }
        }
    }

}
