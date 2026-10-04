package Assignment24;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.awt.*;
import java.sql.*;

public class LibraryGUI {

    private JFrame frame;
    private JTextField txtBookId, txtTitle, txtAuthor, txtPrice;
    private JTable table;
    private DefaultTableModel tableModel;

    private Connection getConnection() throws Exception {
        Class.forName("com.mysql.cj.jdbc.Driver");
        String url = "jdbc:mysql://localhost:3306/jdbc_demo";
        String user = "root";
        String password = "Upali@sql04";
        return DriverManager.getConnection(url, user, password);
    }

    public LibraryGUI() {
        frame = new JFrame("Library Management System");
        frame.setSize(700, 500);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new BorderLayout(10, 10));

        // Form Panel
        JPanel formPanel = new JPanel(new GridLayout(4, 2, 5, 5));

        formPanel.add(new JLabel(" Book ID:"));
        txtBookId = new JTextField();
        formPanel.add(txtBookId);

        formPanel.add(new JLabel(" Title:"));
        txtTitle = new JTextField();
        formPanel.add(txtTitle);

        formPanel.add(new JLabel(" Author:"));
        txtAuthor = new JTextField();
        formPanel.add(txtAuthor);

        formPanel.add(new JLabel(" Price:"));
        txtPrice = new JTextField();
        formPanel.add(txtPrice);

        // Buttons Panel
        JPanel btnPanel = new JPanel(new FlowLayout());
        JButton btnInsert = new JButton("ADD BOOK");
        JButton btnSelect = new JButton("REFRESH / SELECT");
        JButton btnUpdate = new JButton("UPDATE PRICE");
        JButton btnDelete = new JButton("DELETE BOOK");

        btnPanel.add(btnInsert);
        btnPanel.add(btnSelect);
        btnPanel.add(btnUpdate);
        btnPanel.add(btnDelete);

        JPanel topContainer = new JPanel(new BorderLayout());
        topContainer.add(formPanel, BorderLayout.CENTER);
        topContainer.add(btnPanel, BorderLayout.SOUTH);

        // Table Setup
        tableModel = new DefaultTableModel(new String[]{"BOOK_ID", "TITLE", "AUTHOR", "PRICE"}, 0);
        table = new JTable(tableModel);

        frame.add(topContainer, BorderLayout.NORTH);
        frame.add(new JScrollPane(table), BorderLayout.CENTER);

        // Button Action Listeners
        btnInsert.addActionListener(e -> executeInsert());
        btnSelect.addActionListener(e -> executeSelect());
        btnUpdate.addActionListener(e -> executeUpdate());
        btnDelete.addActionListener(e -> executeDelete());

        frame.setVisible(true);
        executeSelect(); // Initial data load
    }

    private void executeInsert() {
        String query = "INSERT INTO books(book_id, title, author, price) VALUES (?,?,?,?)";
        try (Connection con = getConnection();
             PreparedStatement myStmt = con.prepareStatement(query)) {

            myStmt.setInt(1, Integer.parseInt(txtBookId.getText().trim()));
            myStmt.setString(2, txtTitle.getText().trim());
            myStmt.setString(3, txtAuthor.getText().trim());
            myStmt.setDouble(4, Double.parseDouble(txtPrice.getText().trim()));

            myStmt.executeUpdate();
            JOptionPane.showMessageDialog(frame, "1 book inserted successfully!");
            executeSelect();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
        }
    }

    private void executeSelect() {
        tableModel.setRowCount(0);
        String query = "SELECT * FROM books ORDER BY book_id";
        try (Connection con = getConnection();
             PreparedStatement myStmt = con.prepareStatement(query);
             ResultSet rs = myStmt.executeQuery()) {

            while (rs.next()) {
                tableModel.addRow(new Object[]{
                    rs.getInt("book_id"),
                    rs.getString("title"),
                    rs.getString("author"),
                    rs.getDouble("price")
                });
            }
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
        }
    }

    private void executeUpdate() {
        String query = "UPDATE books SET price=? WHERE book_id=?";
        try (Connection con = getConnection();
             PreparedStatement myStmt = con.prepareStatement(query)) {

            myStmt.setDouble(1, Double.parseDouble(txtPrice.getText().trim()));
            myStmt.setInt(2, Integer.parseInt(txtBookId.getText().trim()));

            int rowsUpdated = myStmt.executeUpdate();
            if (rowsUpdated > 0) {
                JOptionPane.showMessageDialog(frame, "1 book price updated!");
            } else {
                JOptionPane.showMessageDialog(frame, "Book ID not found.");
            }
            executeSelect();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
        }
    }

    private void executeDelete() {
        String query = "DELETE FROM books WHERE book_id=?";
        try (Connection con = getConnection();
             PreparedStatement myStmt = con.prepareStatement(query)) {

            myStmt.setInt(1, Integer.parseInt(txtBookId.getText().trim()));

            int rowsDeleted = myStmt.executeUpdate();
            if (rowsDeleted > 0) {
                JOptionPane.showMessageDialog(frame, "1 book deleted!");
            } else {
                JOptionPane.showMessageDialog(frame, "Book ID not found.");
            }
            executeSelect();
        } catch (Exception ex) {
            JOptionPane.showMessageDialog(frame, "Error: " + ex.getMessage());
        }
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(() -> new LibraryGUI());
    }
}