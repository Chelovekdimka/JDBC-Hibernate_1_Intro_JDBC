package Ex_2;

import java.io.FileWriter;
import java.io.IOException;

public class TestFileWriter {
    public static void main(String[] args) {
        try {
            FileWriter writer = new FileWriter("queries.txt");
            writer.write("SELECT * FROM Employees;\n");
            writer.write("UPDATE Employees SET FirstName = 'Ахматова' WHERE FirstName = 'Ахмєтова';\n");
            writer.write("DELETE FROM Employees WHERE FirstName ='Эммануэль';\n");
            writer.close();
        } catch (IOException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}