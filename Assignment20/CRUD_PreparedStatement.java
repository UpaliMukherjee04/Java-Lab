package Assignment20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CRUD_PreparedStatement {

    static void create_table(Connection con) throws SQLException {
        try (Statement st = con.createStatement()) {
            String sqlDrop = "DROP TABLE IF EXISTS COMPANY";
            st.executeUpdate(sqlDrop);
            System.out.println("Dropped existing table (if any).");

            String sqlCreate = "CREATE TABLE COMPANY (ID INT PRIMARY KEY NOT NULL, NAME VARCHAR(50) NOT NULL, AGE INT NOT NULL, ADDRESS VARCHAR(50), SALARY INT)";
            st.executeUpdate(sqlCreate);
            System.out.println("Table Created Successfully");
        }
    }

    static void insert_table(Connection con, Scanner sc) throws SQLException {
        String sql = "INSERT INTO COMPANY (ID, NAME, AGE, ADDRESS, SALARY) VALUES (?, ?, ?, ?, ?)";
        
        System.out.print("Enter ID: ");
        int id = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Age: ");
        int age = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Address: ");
        String address = sc.nextLine();

        System.out.print("Enter Salary: ");
        int salary = sc.nextInt();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            ps.setString(2, name);
            ps.setInt(3, age);
            ps.setString(4, address);
            ps.setInt(5, salary);
            
            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Record inserted successfully.");
            }
        }
    }

    static void read_table(Connection con) throws SQLException {
        String sql = "SELECT * FROM COMPANY;";
        
        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {
            
            int count = 0;
            while (rs.next()) {
                System.out.println("ID = " + rs.getInt("id"));
                System.out.println("NAME = " + rs.getString("name"));
                System.out.println("AGE = " + rs.getInt("age"));
                System.out.println("ADDRESS = " + rs.getString("address"));
                System.out.println("SALARY = " + rs.getInt("salary"));
                System.out.println();
                count++;
            }
            if (count == 0) {
                System.out.println("No records found.");
            }
        }
    }

    static void update_table(Connection con, Scanner sc) throws SQLException {
        String sql = "UPDATE COMPANY set SALARY = ? where ID = ?";
        
        System.out.print("Enter ID to update salary: ");
        int id = sc.nextInt();

        System.out.print("Enter New Salary: ");
        int salary = sc.nextInt();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, salary);
            ps.setInt(2, id);
            
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Record updated. Rows affected: " + rowsAffected);
            } else {
                System.out.println("Record not found for ID: " + id);
            }
        }
    }

    static void delete_table(Connection con, Scanner sc) throws SQLException {
        String sql = "DELETE from COMPANY where ID = ?";
        
        System.out.print("Enter ID to delete: ");
        int id = sc.nextInt();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, id);
            
            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Record deleted. Rows affected: " + rowsAffected);
            } else {
                System.out.println("Record not found for ID: " + id);
            }
        }
    }

    public static void main(String[] args) {
        String db = "jdbc:mysql://localhost:3306/jdbc_demo";
        String user = "root";
        String password = "Upali@sql04";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");

            try (Connection con = DriverManager.getConnection(db, user, password);
                 Scanner sc = new Scanner(System.in)) {

                if (con != null) {
                    System.out.println("Connection established successfully!\n");
                    
                    boolean exit = false;
                    while (!exit) {
                        System.out.println("\n--- MENU ---");
                        System.out.println("1. Create Table");
                        System.out.println("2. Insert Record");
                        System.out.println("3. Display All Records");
                        System.out.println("4. Update Salary");
                        System.out.println("5. Delete Record");
                        System.out.println("6. Exit");
                        System.out.print("Enter choice: ");
                        
                        int choice = sc.nextInt();
                        
                        switch (choice) {
                            case 1:
                                CRUD_PreparedStatement.create_table(con);
                                break;
                            case 2:
                                CRUD_PreparedStatement.insert_table(con, sc);
                                break;
                            case 3:
                                CRUD_PreparedStatement.read_table(con);
                                break;
                            case 4:
                                CRUD_PreparedStatement.update_table(con, sc);
                                break;
                            case 5:
                                CRUD_PreparedStatement.delete_table(con, sc);
                                break;
                            case 6:
                                exit = true;
                                System.out.println("Exiting program...");
                                break;
                            default:
                                System.out.println("Invalid choice!");
                        }
                    }

                } else {
                    System.out.println("Connection not established");
                }
            }
        } catch (SQLException e) {
            System.err.println("Database Error:");
            e.printStackTrace();
        } catch (ClassNotFoundException e) {
            System.err.println("JDBC Driver not found:");
            e.printStackTrace();
        }
    }
}