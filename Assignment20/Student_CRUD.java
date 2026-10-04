package Assignment20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class Student_CRUD {

    static void create_table(Connection con) throws SQLException {
        try (Statement st = con.createStatement()) {
            String sqlDrop = "DROP TABLE IF EXISTS student_records";
            st.executeUpdate(sqlDrop);
            System.out.println("Dropped existing table (if any).");

            String sqlCreate = "CREATE TABLE student_records (" +
                               "rollno INT PRIMARY KEY NOT NULL, " +
                               "name VARCHAR(50) NOT NULL, " +
                               "course VARCHAR(50) NOT NULL, " +
                               "marks DOUBLE NOT NULL)";
            st.executeUpdate(sqlCreate);
            System.out.println("Table Created Successfully");
        }
    }

    static void insert_student(Connection con, Scanner sc) throws SQLException {
        String sql = "INSERT INTO student_records (rollno, name, course, marks) VALUES (?, ?, ?, ?)";

        System.out.print("Enter Roll No: ");
        int rollno = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter Name: ");
        String name = sc.nextLine();

        System.out.print("Enter Course: ");
        String course = sc.nextLine();

        System.out.print("Enter Marks: ");
        double marks = sc.nextDouble();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, rollno);
            ps.setString(2, name);
            ps.setString(3, course);
            ps.setDouble(4, marks);

            int rowsInserted = ps.executeUpdate();
            if (rowsInserted > 0) {
                System.out.println("Student record inserted successfully.");
            }
        }
    }

    static void read_students(Connection con) throws SQLException {
        String sql = "SELECT * FROM student_records ORDER BY rollno;";

        try (PreparedStatement ps = con.prepareStatement(sql);
             ResultSet rs = ps.executeQuery()) {

            int count = 0;
            while (rs.next()) {
                System.out.println("ROLL NO = " + rs.getInt("rollno"));
                System.out.println("NAME = " + rs.getString("name"));
                System.out.println("COURSE = " + rs.getString("course"));
                System.out.println("MARKS = " + rs.getDouble("marks"));
                System.out.println();
                count++;
            }
            if (count == 0) {
                System.out.println("No student records found.");
            }
        }
    }

    static void update_student(Connection con, Scanner sc) throws SQLException {
        String sql = "UPDATE student_records SET course = ?, marks = ? WHERE rollno = ?";

        System.out.print("Enter Roll No to update: ");
        int rollno = sc.nextInt();
        sc.nextLine();

        System.out.print("Enter New Course: ");
        String course = sc.nextLine();

        System.out.print("Enter New Marks: ");
        double marks = sc.nextDouble();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setString(1, course);
            ps.setDouble(2, marks);
            ps.setInt(3, rollno);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Record updated. Rows affected: " + rowsAffected);
            } else {
                System.out.println("Record not found for Roll No: " + rollno);
            }
        }
    }

    static void delete_student(Connection con, Scanner sc) throws SQLException {
        String sql = "DELETE FROM student_records WHERE rollno = ?";

        System.out.print("Enter Roll No to delete: ");
        int rollno = sc.nextInt();

        try (PreparedStatement ps = con.prepareStatement(sql)) {
            ps.setInt(1, rollno);

            int rowsAffected = ps.executeUpdate();
            if (rowsAffected > 0) {
                System.out.println("Record deleted. Rows affected: " + rowsAffected);
            } else {
                System.out.println("Record not found for Roll No: " + rollno);
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
                        System.out.println("\n--- STUDENT MANAGEMENT MENU ---");
                        System.out.println("1. Create Table");
                        System.out.println("2. Insert Student Record");
                        System.out.println("3. Display All Students");
                        System.out.println("4. Update Student Details");
                        System.out.println("5. Delete Student Record");
                        System.out.println("6. Exit");
                        System.out.print("Enter choice: ");

                        int choice = sc.nextInt();

                        switch (choice) {
                            case 1:
                                Student_CRUD.create_table(con);
                                break;
                            case 2:
                                Student_CRUD.insert_student(con, sc);
                                break;
                            case 3:
                                Student_CRUD.read_students(con);
                                break;
                            case 4:
                                Student_CRUD.update_student(con, sc);
                                break;
                            case 5:
                                Student_CRUD.delete_student(con, sc);
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