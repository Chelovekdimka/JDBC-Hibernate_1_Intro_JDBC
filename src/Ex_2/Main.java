package Ex_2;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Main {
    public static void main(String[] args) {
        try {
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/MyJoinsDB", "root", "root");
            Statement stmt = conn.createStatement();

            FileReader fileReader = new FileReader("queries.txt");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                int rowsAffected = stmt.executeUpdate(line);
                System.out.println("Rows affected: " + rowsAffected);
            }
            bufferedReader.close();
            conn.close();
        } catch (SQLException | IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}

