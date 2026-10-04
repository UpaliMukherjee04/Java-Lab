package Assignment24;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class BookIssueGUI {

    private JFrame frame;
    private JTextField txtIssueId, txtBookId, txtStudentName, txtIssueDate, txtReturnDate;
    private JTable table;
    private DefaultTableModel tableModel;

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String user = "root";
        String password = "Upali@sql04";
        return DriverManager.getConnection(url, user, password);
    }

    public BookIssueGUI() {
        frame = new JFrame("Book Issue Tracking System");
        frame.setSize(750, 550);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(5, 2, 5, 5));

        formPanel.add(new JLabel(" Issue ID (for Update/Delete):"));
        txtIssueId = new JTextField();
        formPanel.add(txtIssueId);

        formPanel.add(new JLabel(" Book ID:"));
        txtBookId = new JTextField();
        formPanel.add(txtBookId);

        formPanel.add(new JLabel(" Student Name:"));
        txtStudentName = new JTextField();
        formPanel.add(txtStudentName);

        formPanel.add(new JLabel(" Issue Date (YYYY-MM-DD):"));
        txtIssueDate = new JTextField();
        formPanel.add(txtIssueDate);

        formPanel.add(new JLabel(" Return Date (YYYY-MM-DD):"));
        txtReturnDate = new JTextField();
        formPanel.add(txtReturnDate);

        // Buttons Panel
        JPanel btnPanel = new JPanel(new FlowLayout());
        JButton btnIssue = new JButton("ISSUE BOOK");
        JButton btnSelect = new JButton("REFRESH / SELECT");
        JButton btnUpdate = new JButton("UPDATE RETURN DATE");
        JButton btnDelete = new JButton("DELETE RECORD");

        btnPanel.add(btnIssue);
        btnPanel.add(btnSelect);
        btnPanel.add(btnUpdate);
        btnPanel.add(btnDelete);

        JPanel topContainer = new JPanel(new BorderLayout());
        topContainer.add(formPanel, BorderLayout.CENTER);
        topContainer.add(btnPanel, BorderLayout.SOUTH);

        // Table Setup
        tableModel = new DefaultTableModel(new String[]{"ISSUE_ID", "BOOK_ID", "STUDENT_NAME", "ISSUE_DATE", "RETURN_DATE"}, 0);
        table = new JTable(tableModel);

        frame.add(topContainer, BorderLayout.NORTH);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        // Button Action Listeners
        btnIssue.addActionListener(e -> executeInsert());
        btnSelect.addActionListener(e -> executeSelect());
        btnUpdate.addActionListener(e -> executeUpdate());
        btnDelete.addActionListener(e -> executeDelete());

        frame.setVisible(true);
        executeSelect(); // Initial data load
    }

    private void executeInsert() {
        String query = "INSERT INTO book_issue(book_id, student_name, issue_date, return_date) VALUES (?,?,?,?)";
        try (Connection con = getConnection();
             PreparedStatement myStmt = con.prepareStatement(query)) {

            myStmt.setInt(1, Integer.parseInt(txtBookId.getText().trim()));
            myStmt.setString(2, txtStudentName.getText().trim());
            myStmt.setDate(3, Date.valueOf(txtIssueDate.getText().trim()));
            
            String retDate = txtReturnDate.getText().trim();
            if (retDate.isEmpty()) {
                myStmt.setNull(4, Types.DATE);
            } else {
                myStmt.setDate(4, Date.valueOf(retDate));
            }

            myStmt.executeUpdate();
            JOptionPane.showMessageDialog(frame, "Book issued successfully!");
            executeSelect();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
        }
    }

    private void executeSelect() {
        tableModel.setRowCount(0);
        String query = "SELECT * FROM book_issue ORDER BY issue_id";
        try (Connection con = getConnection();
             PreparedStatement myStmt = con.prepareStatement(query);
             ResultSet rs = myStmt.executeQuery()) {

            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    rs.getInt("issue_id"),
                    rs.getInt("book_id"),
                    rs.getString("student_name"),
                    rs.getDate("issue_date"),
                    rs.getDate("return_date")
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
        }
    }

    private void executeUpdate() {
        String query = "UPDATE book_issue SET return_date=? WHERE issue_id=?";
        try (Connection con = getConnection();
             PreparedStatement myStmt = con.prepareStatement(query)) {

            myStmt.setDate(1, Date.valueOf(txtReturnDate.getText().trim()));
            myStmt.setInt(2, Integer.parseInt(txtIssueId.getText().trim()));

            int rowsUpdated = myStmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(frame, "Return date updated successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "Issue ID not found.");
            }
            executeSelect();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
        }
    }

    private void executeDelete() {
        String query = "DELETE FROM book_issue WHERE issue_id=?";
        try (Connection con = getConnection();
             PreparedStatement myStmt = con.prepareStatement(query)) {

            myStmt.setInt(1, Integer.parseInt(txtIssueId.getText().trim()));

            int rowsDeleted = myStmt.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(frame, "Record deleted successfully!");
            } else {
                JOptionPane.showMessageDialog(frame, "Issue ID not found.");
            }
            executeSelect();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new BookIssueGUI());
    }
}