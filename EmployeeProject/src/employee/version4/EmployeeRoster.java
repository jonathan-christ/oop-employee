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
    
    public EmployeeRoster(int max){
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
    public void addEmployee(Employee ... input) {
        for(Employee e : input){
            //CHECK IF ID IS THERE ALREADY
            Employees[count] = e;
            count++;
        }
    }

    public Employee removeEmployee(int id) {
        for(int x=0; x<count; x++){
            if(id == Employees[x].getEmpID()){
                this.count--;
                for(int y=x; y<count; y++){
                    Employees[y] = Employees[y+1];
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

    public void searchEmployee(String keyword) {
        Employee[] searchedArr = new Employee[this.count];
        int arrIdx;
        arrIdx = 0;

        for (int i=0; i<count; i++) {
            Employee x = Employees[i];
            if (x.getEmpName().toString().toLowerCase().contains(keyword.toLowerCase())) {
                searchedArr[arrIdx++] = x;
            }
        }
        System.out.println("Matches found!");
        displayAllEmployees(searchedArr);
    }

    public void displayAllEmployees() {
        if(count == 0){
            System.out.println("Employee Roster is Empty!\n");
            return;
        }
        System.out.println(String.format(strFormat,
                "ID", "Name", "Type", "Salary"));
        System.out.println(String.format(strFormat,
                "","","","",""));
        for (int i=0; i<count; i++) {
            Employee x=Employees[i];
            if (x != null) {
                System.out.println(String.format(strFormat,
                        "" + x.getEmpID(),
                        x.getEmpName().toString(),
                        x.getClass().getSimpleName(),
                        x.computeSalary()));
            }
        }
        System.out.println("");
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
        System.out.println("");
    }

}
