package DataBase;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/*
 * @author Muhammad Ahmed Memon
 * 
 * This is a manager and connector for the DataBase
 */

public class DatabaseManager {
    public static void main(String[] args) {
        String url = "jdbc:mysql://localhost:3306/myDB"; //URL for the DataBase
        String user = "root"; //Username for the DataBase
        String password = "DICEDICE"; //Password for the Database 
        String testQuery = "SELECT 1"; //Testing Query 


        /*
         * Try and catch block to set up the connection with the DataBase 
         * Prints a message to indicate success
         */
        try (Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(testQuery)) {

            if (rs.next()) {
                System.out.println("Database connection successful: " + rs.getInt(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}