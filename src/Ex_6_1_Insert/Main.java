package Ex_6_1_Insert;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

//Создать базу данных в Workbench и подключить к IntelijIdea и создать тестовую таблицу.
//        Заполнить ее данными с помощью запросов MySQL в IntelijIdea.
//        Используя JDBC написать пример выполнения всех запросов.
public class Main {
    private static final String URL = "jdbc:mysql://localhost:3306/MyJoinsDB";
    private static final String LOGIN = "root";
    private static final String PASSWORD = "root";

    private static final String INSERT_NEW_EMPLOYEE = "INSERT INTO employees(FirstName, LastName, PhoneNumber) " + " VALUES(?,?,?)";

    public static void main(String[] args) {
        registerDriver();
        Connection connection = null;
        PreparedStatement statement = null;
        try {
            connection = DriverManager.getConnection(URL, LOGIN, PASSWORD);
            statement = connection.prepareStatement(INSERT_NEW_EMPLOYEE);
            statement.setString(1, "Ганна");
            statement.setString(2, "Ахмєтова");
            statement.setString(3, "+38-067-555-22-44");
            statement.execute();

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
