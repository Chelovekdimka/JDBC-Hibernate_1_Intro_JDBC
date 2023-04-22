package Ex_6_3_Update;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/MyJoinsDB";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    private static final String UPDATE_EMPLOYEE = "UPDATE Employees SET EmployeeID = 6, FirstName = 'Эммануэль', LastName = 'Макрон', PhoneNumber = '+38-097-654-78-85' WHERE EmployeeID = 9 ";

    public static void main(String[] args) {
        registerDriver();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.prepareStatement(UPDATE_EMPLOYEE);
            statement.executeUpdate();
            int res = statement.executeUpdate();
            System.out.println("Оновлено рядків : " + res);
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
    }

    private static void registerDriver() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            System.out.println("Driver loading success!");
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
