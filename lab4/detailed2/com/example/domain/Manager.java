package lab4.detailed2.com.example.domain;

public class Manager extends Employee{
    private String deptName;
    private Employee[] staff;
    private int employeeCount;

    public Manager(int empId, String name, String ssn, double salary, String deptName){
        super(empId, name, ssn, salary);
        this.deptName = deptName;
        this.staff = new Employee[20];
        this.employeeCount = 0;
    }

    public String getDeptName(){
        return deptName;
    }

    public int findEmployee(Employee emp) {
        for (int i = 0; i < employeeCount; i++) {
            if (staff[i].getEmpId() == emp.getEmpId()) {
                return i; 
            }
        }
        return -1;  
    }


    public boolean addEmployee(Employee emp){
        if(findEmployee(emp) != -1){
            return false;
        }
        
        if(employeeCount < staff.length){
            staff[employeeCount] = emp;
            employeeCount++;
            return true;
        }

        return false;
    }

    public boolean removeEmployee(Employee emp) {
        boolean found = false;
        Employee[] tempStaff = new Employee[20];
        int tempCount = 0;

        for (int i = 0; i < employeeCount; i++) {
            if (staff[i].getEmpId() == emp.getEmpId()) {
                found = true;
            } else {
                tempStaff[tempCount++] = staff[i];  
            }
        }

        if (found) {
            staff = tempStaff;  
            employeeCount = tempCount;
        }
        return found;
    }

    public void printStaffDetails() {
        System.out.println("Manager: " + getName());
        for (int i = 0; i < employeeCount; i++) {
            System.out.println("Employee ID: " + staff[i].getEmpId() + ", Name: " + staff[i].getName());
        }
    }
}
