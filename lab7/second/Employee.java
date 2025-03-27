

import java.util.Date;

public class Employee {
    private int id;
    private String firstName;
    private String lastName;
    private Date birthDate;
    private float salary;

    public int getId() { return id; }
    public void setId(int id) { this.id = id; }

    public String getFirstName() { return firstName; }
    public void setFirstName(String firstName) { this.firstName = firstName; }

    public String getLastName() { return lastName; }
    public void setLastName(String lastName) { this.lastName = lastName; }

    public Date getBirthDate() { return birthDate; }
    public void setBirthDate(Date birthDate) { this.birthDate = birthDate; }

    public float getSalary() { return salary; }
    public void setSalary(float salary) { this.salary = salary; }

    @Override
    public String toString() {
        return id + ": " + firstName + " " + lastName + ", $" + salary + ", Born: " + birthDate;
    }
}
