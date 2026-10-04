package Assignment23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayEmployees {

    public static void main(String[] args) {
        String dbUrl = "jdbc:mysql://localhost:3306/jdbc_demo";
        String user = "root";
        String password = "Upali@sql04";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found!");
            return;
        }

        try (Connection con = DriverManager.getConnection(dbUrl, user, password)) {
            System.out.println("Connection established successfully.\n");

            readEmployeesOneByOne(con);

        } catch (SQLException e) {
            System.err.println("Database Error:");
            e.printStackTrace();
        }
    }

    static void readEmployeesOneByOne(Connection con) throws SQLException {
        String sql = "SELECT id, name, department, salary FROM employee ORDER BY id";

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("--- Employee Records (Displayed One by One) ---");
            int recordNum = 1;

            while (rs.next()) {
                System.out.println("Record #" + recordNum + ":");
                System.out.println("  Employee ID : " + rs.getInt("id"));
                System.out.println("  Name        : " + rs.getString("name"));
                System.out.println("  Department  : " + rs.getString("department"));
                System.out.println("  Salary      : " + rs.getDouble("salary"));
                System.out.println("-------------------------------------------");
                recordNum++;
            }

            if (recordNum == 1) {
                System.out.println("No employee records found in table.");
            }
        }
    }
}