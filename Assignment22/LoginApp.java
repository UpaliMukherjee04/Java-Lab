package Assignment22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class LoginApp {

    public LoginApp() {
    }

    public static void main(String[] args) throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String user = "root";
        String password = "Upali@sql04";

        try {
            Connection con = DriverManager.getConnection(url, user, password);
            System.out.println("Connection established");

            Scanner sc = new Scanner(System.in);
            System.out.print("Enter Username: ");
            String inputUser = sc.nextLine();

            System.out.print("Enter Password: ");
            String inputPass = sc.nextLine();

            String sql = "SELECT * FROM users WHERE username = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, inputUser);
            ps.setString(2, inputPass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                System.out.println("Login successful! Welcome, " + inputUser + ".");
            } else {
                System.out.println("Login failed! Invalid username or password.");
            }

            rs.close();
            ps.close();
            sc.close();
            con.close();
        } catch (Exception e) {
            System.out.println("Connection not established or database error occurred");
        }
    }
}