package Assignment19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class PS1 {

    public static void main(String[] args) throws Exception {
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        String db = "jdbc:mysql://localhost:3306/jdbc_demo";
        String user = "root";
        String password = "Upali@sql04";

       
        try (Connection con = DriverManager.getConnection(db, user, password);
             Scanner sc = new Scanner(System.in)) {

            if (con != null) {
                System.out.print("Enter roll no: ");
                int rollno = sc.nextInt();
                sc.nextLine(); 
                System.out.print("Enter Name: ");
                String name = sc.nextLine();

                String query = "INSERT INTO student VALUES (?, ?)";

                try (PreparedStatement myStmt = con.prepareStatement(query)) {
                    myStmt.setInt(1, rollno);
                    myStmt.setString(2, name);
                    
                    int rowsInserted = myStmt.executeUpdate(); 
                    if (rowsInserted > 0) {
                        System.out.println("1 row inserted successfully!");
                    }
                }

                
                readAllData(con);
                
            } else {
                System.out.println("Connection not established");
            }
        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
    }

    static void readAllData(Connection con) throws SQLException {
        
        String selectQuery = "SELECT * FROM student ORDER BY rollno";

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(selectQuery)) {

            System.out.println("\n  --- Current Table Data ---");
            int count = 0;
            while (rs.next()) {
                
                System.out.printf("  Roll No: %d, Name: %s%n",
                        rs.getInt("rollno"),
                        rs.getString("name"));
                count++;
            }
            if (count == 0) {
                System.out.println("  Table is empty.");
            }
            
        }
    }
}