import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class EmployeeTestInteractive {

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        EmployeeDAOFactory factory = new EmployeeDAOFactory();
        EmployeeDAO dao = factory.createEmployeeDAO();

        while (true) {
            System.out.println("\n[C]reate [R]ead [U]pdate [D]elete [L]ist [Q]uit:");
            String choice = in.nextLine().trim().toUpperCase();

            switch (choice) {
                case "C":
                    Employee emp = inputEmployee(in);
                    dao.add(emp);
                    System.out.println("Successfully added Employee Record: " + emp.getId());
                    System.out.println("\nCreated " + emp);
                    break;

                case "R":
                    System.out.print("Enter employee ID to find: ");
                    int id = Integer.parseInt(in.nextLine());
                    Employee found = dao.findById(id);
                    if (found != null) {
                        System.out.println(found);
                    } else {
                        System.out.println("Employee not found.");
                    }
                    break;

                case "U":
                    Employee updated = inputEmployee(in);
                    dao.update(updated);
                    System.out.println("Updated " + updated);
                    break;

                case "D":
                    System.out.print("Enter employee ID to delete: ");
                    int delId = Integer.parseInt(in.nextLine());
                    dao.delete(delId);
                    System.out.println("Deleted employee with ID " + delId);
                    break;

                case "L":
                    Employee[] employees = dao.getAllEmployees();
                    for (Employee e : employees) {
                        System.out.println(e);
                    }
                    break;

                case "Q":
                    System.out.println("Exiting.");
                    return;

                default:
                    System.out.println("Invalid choice.");
            }
        }
    }

    private static Employee inputEmployee(Scanner in) {
        Employee emp = new Employee();

        System.out.print("Enter ID (0-9): ");
        emp.setId(Integer.parseInt(in.nextLine()));

        System.out.print("Enter First Name: ");
        emp.setFirstName(in.nextLine());

        System.out.print("Enter Last Name: ");
        emp.setLastName(in.nextLine());

        System.out.print("Enter Birth Date (e.g. Nov 26, 1976): ");
        try {
            Date date = new SimpleDateFormat("MMM dd, yyyy").parse(in.nextLine());
            emp.setBirthDate(date);
        } catch (Exception e) {
            System.out.println("Invalid date. Using current date.");
            emp.setBirthDate(new Date());
        }

        System.out.print("Enter Salary: ");
        emp.setSalary(Float.parseFloat(in.nextLine()));

        return emp;
    }
}
