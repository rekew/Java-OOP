package lab4.detailed2.com.example.domain;

public class EmployeeTest {
    public static void main(String[] args) {
        Manager manager = new Manager(101, "Alice Johnson", "123-45-6789", 90000.00, "Marketing");

        Employee emp1 = new Employee(201, "Bob Smith", "987-65-4321", 50000.00);
        Employee emp2 = new Employee(202, "Charlie Brown", "876-54-3210", 55000.00);
        Employee emp3 = new Employee(203, "David Wilson", "765-43-2109", 52000.00);

        System.out.println("Adding employees...");
        System.out.println("Added emp1: " + manager.addEmployee(emp1)); 
        System.out.println("Added emp2: " + manager.addEmployee(emp2)); 
        System.out.println("Added emp3: " + manager.addEmployee(emp3)); 
        System.out.println("Trying to add emp1 again: " + manager.addEmployee(emp1)); 

        System.out.println("\nManager's staff after adding employees:");
        manager.printStaffDetails();

        System.out.println("\nFinding Employees:");
        System.out.println("Finding emp2 (should return index 1): " + manager.findEmployee(emp2));
        System.out.println("Finding non-existing emp (should return -1): " + manager.findEmployee(new Employee(999, "Ghost Employee", "000-00-0000", 0.00)));

        System.out.println("\nRemoving an Employee...");
        System.out.println("Removed emp2: " + manager.removeEmployee(emp2));
        System.out.println("Trying to remove emp2 again: " + manager.removeEmployee(emp2)); 

        System.out.println("\nManager's staff after removing emp2:");
        manager.printStaffDetails();
    }
}
