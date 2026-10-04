package Assignment22;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.Scanner;

public class HospitalLoginApp {

    public HospitalLoginApp() {
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
            System.out.print("Enter Staff Login ID: ");
            String loginId = sc.nextLine();

            System.out.print("Enter Password: ");
            String pass = sc.nextLine();

            String sql = "SELECT name, role FROM hospital_staff WHERE login_id = ? AND password = ?";
            PreparedStatement ps = con.prepareStatement(sql);
            ps.setString(1, loginId);
            ps.setString(2, pass);

            ResultSet rs = ps.executeQuery();

            if (rs.next()) {
                String staffName = rs.getString("name");
                String role = rs.getString("role");

                System.out.println("\nAuthentication Successful!");
                System.out.println("Welcome, " + role + " " + staffName + ".");

                if ("Doctor".equalsIgnoreCase(role)) {
                    System.out.println("Access Level: Full Medical Records & Prescription Portal");
                } else if ("Nurse".equalsIgnoreCase(role)) {
                    System.out.println("Access Level: Patient Vital Signs & Nursing Care Portal");
                } else {
                    System.out.println("Access Level: General Staff Access");
                }
            } else {
                System.out.println("\nAuthentication Failed! Invalid Login ID or Password.");
                System.out.println("Access Denied.");
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