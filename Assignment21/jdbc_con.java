package Assignment21;
import java.sql.Connection;
import java.sql.DriverManager;

public class jdbc_con {
    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String db = "jdbc:mysql://localhost:3306/jdbc_demo";
        String user = "root";
        String password = "Upali@sql04";
        try {
            Connection con = DriverManager.getConnection(db, user, password);
            System.out.println("Connection established");
            con.close();
        } catch (Exception e) {
            System.out.println("Connection not established");
        }
    }
}