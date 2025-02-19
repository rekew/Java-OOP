package lab4.detailed2.com.example.domain;

public class Employee{
    public int empId;
    public String name;
    public String ssn;
    public double salary;

    public Employee(int empid, String name, String ssn, double salary){
        this.empId = empid;
        this.name = name;
        this.ssn = ssn;
        this.salary = salary;
    }

    public void setName(String name){
        if (name != null){
            this.name = name;
        }
        else{
            System.out.println("Please set the name of person");
        }
    }

    public void raiseSalary(double increase){
        if(increase < 0){
            System.out.println("Can't increase negative value");
        }
        else{
            salary += increase;
        }
    }

    public int getEmpId(){
        return empId;
    }

    public String getName(){
        return name;
    }

    public String getSsn(){
        return ssn;
    }

    public double getSalary(){
        return salary;
    }
}