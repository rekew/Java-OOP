package lab4.detailed1.com.example.domain;

public class Director extends Manager{
    private double budget;

    public Director(int empId, String name, String ssn, double salary, String deptName, double budget){
        super(empId, name, ssn, salary, deptName);
        this.budget = budget;
    }
}   
