package employee.version4;

public class EmployeeRoster {

    private Employee[] Employees;
    private int count;
    private int max = 10;
    private final String strFormat = "| %-6s | %-50s | %-50s | %-10s |";

    //CONSTRUCTOR
    public EmployeeRoster() {
        Employees = new Employee[max];
        count = 0;
    }

    public EmployeeRoster(int max) {
        this();
        this.max = max;
    }

    //ACCESSORS (NO MUTATORS)
    public Employee[] getEmployees() {
        return Employees;
    }

    public int getCount() {
        return count;
    }

    //METHODS
    public void addEmployee(Employee... input) {
        for (Employee e : input) {
            //CHECK IF ID IS THERE ALREADY
            Employees[count] = e;
            count++;
        }
    }

    public Employee removeEmployee(int id) {
        for (int x = 0; x < count; x++) {
            if (id == Employees[x].getEmpID()) {
                this.count--;
                for (int y = x; y < count; y++) {
                    Employees[y] = Employees[y + 1];
                }
                x--;
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

    public int countEmpType(String type) {
        int empCount = 0;
        for (int x = 0; x < count; x++) {
            Employee y = Employees[x];
            if (isInstance(y, type)) {
                empCount++;
            }
        }
        return empCount;
    }

    public void displayEmployeeType(String type) {
        int length = this.countEmpType(type), idx = 0;
        if (length == 0) {
            return;
        }
        Employee[] searchArr = new Employee[length];
        System.out.println("Displaying Employees of Type " + type.toUpperCase());
        for (int y = 0; y < count; y++) {
            Employee x = Employees[y];
            if (isInstance(x, type)) {
                searchArr[idx++] = x;
            }
        }
        this.displayAllEmployees(searchArr, length);
    }

    private boolean isInstance(Employee y, String type) {
        boolean ret = false;
        type = type.toUpperCase();
        switch (type) {
            case "HE":
                ret = (y instanceof HourlyEmployee);
            case "PW":
                ret = (y instanceof PieceWorkerEmployee);
            case "CE":
                ret = (y instanceof CommissionEmployee);
            case "BPC":
                ret = (y instanceof BasePlusCommissionEmployee);
        }

        return ret;
    }

    private double getSalary(Employee x) {
        double salary;
        switch (x) {
            case HourlyEmployee he ->
                salary = he.computeSalary();
            case PieceWorkerEmployee pwe ->
                salary = pwe.computeSalary();
            case CommissionEmployee ce ->
                salary = ce.computeSalary();
            default ->
                salary = 0;
        }

        return salary;
    }

    public void searchEmployee(String keyword) {
        Employee[] searchedArr = new Employee[this.count];
        int arrIdx;

        arrIdx = 0;

        for (int i = 0; i < count; i++) {
            Employee x = Employees[i];
            if (x.getEmpName().toString().toLowerCase().contains(keyword.toLowerCase())) {
                searchedArr[arrIdx++] = x;
            }
        }
        System.out.println("Matches that contain keyword: `" + keyword + "`");
        displayAllEmployees(searchedArr, arrIdx);
    }

    public void displayAllEmployees() {
        this.displayAllEmployees(Employees, count);
    }

    public void displayAllEmployees(Employee[] EmpArr, int length) {
        double salary;
        if (length == 0) {
            System.out.println("Employee Roster is Empty!\n");
            return;
        }
        this.printLine();
        System.out.println(String.format(strFormat,
                "ID", "Name", "Type", "Salary"));
        this.printLine();
        for (int y = 0; y < length; y++) {
            Employee x = Employees[y];
            if (x != null) {
                salary = getSalary(x);
                System.out.println(String.format(strFormat,
                        "" + x.getEmpID(),
                        x.getEmpName().toString(),
                        x.getClass().getSimpleName(),
                        salary));
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
