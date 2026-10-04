package Assignment23;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DisplayOnebyOne {

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
            
            readRecordsOneByOne(con);

        } catch (SQLException e) {
            System.err.println("Database Error:");
            e.printStackTrace();
        }
    }

    static void readRecordsOneByOne(Connection con) throws SQLException {
        String sql = "SELECT ID, NAME, AGE, ADDRESS, SALARY FROM COMPANY ORDER BY ID";

        try (Statement st = con.createStatement();
             ResultSet rs = st.executeQuery(sql)) {

            System.out.println("--- Reading Records One by One ---");
            int recordNum = 1;

            while (rs.next()) {
                System.out.println("Record #" + recordNum + ":");
                System.out.println("  ID      : " + rs.getInt("ID"));
                System.out.println("  Name    : " + rs.getString("NAME"));
                System.out.println("  Age     : " + rs.getInt("AGE"));
                System.out.println("  Address : " + rs.getString("ADDRESS"));
                System.out.println("  Salary  : " + rs.getInt("SALARY"));
                System.out.println("---------------------------------");
                recordNum++;
            }

            if (recordNum == 1) {
                System.out.println("No records found in table.");
            }
        }
    }
}