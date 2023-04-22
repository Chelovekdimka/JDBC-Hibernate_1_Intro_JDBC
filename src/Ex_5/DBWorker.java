package Ex_5;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class DBWorker {
    private final String URL = "jdbc:mysql://localhost:3306/MyJoinsDB";
    private final String LOGIN = "root";
    private final String PASSWORD = "root";

    public List<Employee> getAllPhonesAndAddresses() {
        Connection connection = null;
        Statement statement = null;
        List<Employee> employeePhoneAddress = new ArrayList<>();
        List<Employee> allSingleEmployeesBirthdays = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT Employees.EmployeeID, Employees.FirstName, Employees.LastName, Employees.PhoneNumber, PersonalInfo.Address\n" +
                    "FROM Employees\n" +
                    "INNER JOIN PersonalInfo ON PersonalInfo.EmployeeID = Employees.EmployeeID;");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String phoneNo = resultSet.getString("PhoneNumber");
                String address = resultSet.getString("Address");

                Employee employee = new Employee(id, firstName, lastName, phoneNo, address);
                employeePhoneAddress.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return employeePhoneAddress;
    }

    public List<Employee> getAllSingleEmployeesBirthdays() {
        Connection connection = null;
        Statement statement = null;
        List<Employee> allSingleEmployeesBirthdays = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT Employees.EmployeeID, Employees.FirstName, Employees.LastName, PersonalInfo.MaritalStatus, PersonalInfo.BirthDate, Employees.PhoneNumber \n" +
                    "FROM Employees \n" +
                    "INNER JOIN PersonalInfo ON PersonalInfo.EmployeeID = Employees.EmployeeID\n" +
                    "WHERE PersonalInfo.MaritalStatus LIKE 'холостий';");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                String maritalStatus = resultSet.getString("MaritalStatus");
                Date birthDate = resultSet.getDate("BirthDate");
                String phoneNo = resultSet.getString("PhoneNumber");

                Employee employee = new Employee(id, firstName, lastName, maritalStatus, birthDate, phoneNo);
                allSingleEmployeesBirthdays.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return allSingleEmployeesBirthdays;
    }

    public List<Employee> getAllManagersDetails() {
        Connection connection = null;
        Statement statement = null;
        List<Employee> allManagersDetails = new ArrayList<>();
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery("SELECT Employees.EmployeeID, Employees.FirstName, Employees.LastName, PersonalInfo.BirthDate, Employees.PhoneNumber, Salaries.Position\n" +
                    "FROM Employees \n" +
                    "INNER JOIN PersonalInfo ON Employees.EmployeeID = PersonalInfo.EmployeeID\n" +
                    "INNER JOIN Salaries ON Employees.EmployeeID = Salaries.EmployeeID\n" +
                    "WHERE Salaries.Position = 'менеджер';");

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString("FirstName");
                String lastName = resultSet.getString("LastName");
                Date birthDate = resultSet.getDate("BirthDate");
                String phoneNo = resultSet.getString("PhoneNumber");
                String position = resultSet.getString("Position");


                Employee employee = new Employee(id, firstName, lastName, position, birthDate, phoneNo);
                allManagersDetails.add(employee);
            }

        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            try {
                connection.close();
                statement.close();
            } catch (SQLException e) {
                e.printStackTrace();
            }

        }
        return allManagersDetails;
    }

}

