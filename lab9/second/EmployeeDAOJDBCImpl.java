import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class EmployeeDAOJDBCImpl implements EmployeeDAO {
    private Connection con = null;

    public EmployeeDAOJDBCImpl() {
         try {
            // Register PostgreSQL JDBC driver
            Class.forName("org.postgresql.Driver");

            String url = "jdbc:postgresql://localhost:5432/employee";
            String username = "rekewka";
            String password = "Qaragandy123!";
            con = DriverManager.getConnection(url, username, password);
        } 
        catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void add(Employee emp) throws DAOException {
        try (Statement stmt = con.createStatement()) {
            String query = "INSERT INTO Employee (ID, FIRSTNAME, LASTNAME, BIRTHDATE, SALARY) " +
                           "VALUES (" + emp.getId() + ", '" + emp.getFirstName() + "', '" +
                           emp.getLastName() + "', '" + new java.sql.Date(emp.getBirthDate().getTime()) + "', " +
                           emp.getSalary() + ")";
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            throw new DAOException("Error adding employee", e);
        }
    }

    @Override
    public Employee findById(int id) throws DAOException {
        Employee emp = null;
        try (Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM Employee WHERE ID = " + id;
            ResultSet rs = stmt.executeQuery(query);
            if (rs.next()) {
                emp = new Employee(rs.getInt("ID"), rs.getString("FIRSTNAME"),
                        rs.getString("LASTNAME"), rs.getDate("BIRTHDATE"), rs.getFloat("SALARY"));
            }
        } catch (SQLException e) {
            throw new DAOException("Error finding employee", e);
        }
        return emp;
    }

    @Override
    public void update(Employee emp) throws DAOException {
        try (Statement stmt = con.createStatement()) {
            String query = "UPDATE Employee SET FIRSTNAME='" + emp.getFirstName() + "', LASTNAME='" +
                           emp.getLastName() + "', BIRTHDATE='" + new java.sql.Date(emp.getBirthDate().getTime()) +
                           "', SALARY=" + emp.getSalary() + " WHERE ID=" + emp.getId();
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            throw new DAOException("Error updating employee", e);
        }
    }

    @Override
    public void delete(int id) throws DAOException {
        try (Statement stmt = con.createStatement()) {
            String query = "DELETE FROM Employee WHERE ID=" + id;
            stmt.executeUpdate(query);
        } catch (SQLException e) {
            throw new DAOException("Error deleting employee", e);
        }
    }

    @Override
    public List<Employee> getAllEmployees() throws DAOException {
        List<Employee> employees = new ArrayList<>();
        try (Statement stmt = con.createStatement()) {
            String query = "SELECT * FROM Employee";
            ResultSet rs = stmt.executeQuery(query);
            while (rs.next()) {
                Employee emp = new Employee(rs.getInt("ID"), rs.getString("FIRSTNAME"),
                        rs.getString("LASTNAME"), rs.getDate("BIRTHDATE"), rs.getFloat("SALARY"));
                employees.add(emp);
            }
        } catch (SQLException e) {
            throw new DAOException("Error retrieving all employees", e);
        }
        return employees;
    }

    @Override
    public void close() throws DAOException {
        try {
            if (con != null) {
                con.close();
            }
        } catch (SQLException e) {
            throw new DAOException("Error closing connection", e);
        }
    }
}
