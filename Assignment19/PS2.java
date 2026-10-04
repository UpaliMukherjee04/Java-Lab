package Assignment19;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PS2 {

    public static void main(String[] args) throws Exception {
        
        Class.forName("com.mysql.cj.jdbc.Driver");
        
        String db = "jdbc:mysql://localhost:3306/jdbc_demo";
        String user = "root";
        String password = "Upali@sql04";

        try (Connection con = DriverManager.getConnection(db, user, password)) {

            if (con != null) {
                readProductData(con);
            } else {
                System.out.println("Connection not established");
            }

        } catch (SQLException e) {
            System.err.println("Database Error: " + e.getMessage());
        }
    }

    static void readProductData(Connection con) throws SQLException {
        
        String selectQuery = "SELECT id, name, quantity, price FROM product ORDER BY id";

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(selectQuery)) {

            System.out.println("\n  --- Product Details ---");
            int count = 0;
            
            while (rs.next()) {
                System.out.printf("  ID: %d, Name: %s, Quantity: %d, Price: %.2f%n",
                        rs.getInt("id"),
                        rs.getString("name"),
                        rs.getInt("quantity"),
                        rs.getDouble("price"));
                count++;
            }

            if (count == 0) {
                System.out.println("  No products found in the database.");
            }
            
        }
    }
}