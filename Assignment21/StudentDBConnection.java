package Assignment21;

import java.sql.Connection;
import java.sql.DriverManager;

public class StudentDBConnection {

    public StudentDBConnection() {
    }

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String user = "root";
        String password = "Upali@sql04";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established");
            System.out.println("Student database is connected successfully.");
            con.close();
        } catch (Exception e) {
            System.out.println("Connection not established");
        }
    }
}