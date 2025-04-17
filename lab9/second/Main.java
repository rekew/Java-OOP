public class Main {
    public static void main(String[] args) {
        EmployeeDAO employeeDAO = EmployeeDAOFactory.getEmployeeDAO();

        try {
            // Add new employee
            Employee emp = new Employee(1, "John", "Doe", new java.util.Date(), 50000);
            employeeDAO.add(emp);

            // Find employee by ID
            Employee foundEmp = employeeDAO.findById(1);
            System.out.println("Found Employee: " + foundEmp.getFirstName());

            // Update employee
            foundEmp.setSalary(55000);
            employeeDAO.update(foundEmp);

            // Get all employees
            System.out.println("All Employees: " + employeeDAO.getAllEmployees());

            // Delete employee
            employeeDAO.delete(1);

        } catch (DAOException e) {
            e.printStackTrace();
        } 
        finally {
            try {
                employeeDAO.close();
            } catch (DAOException e) {
                e.printStackTrace();
            }
        }
    }
}

