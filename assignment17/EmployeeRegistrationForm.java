package assignment17;

import java.awt.event.*;
import javax.swing.*;

public class EmployeeRegistrationForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Employee Registration Form");

        JLabel idLabel = new JLabel("Employee ID:");
        idLabel.setBounds(20, 20, 100, 25);
        JTextField idText = new JTextField();
        idText.setBounds(130, 20, 150, 25);

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 60, 100, 25);
        JTextField nameText = new JTextField();
        nameText.setBounds(130, 60, 150, 25);

        JLabel deptLabel = new JLabel("Department:");
        deptLabel.setBounds(20, 100, 100, 25);
        String[] departments = {"HR", "Engineering", "Finance", "Marketing", "Sales"};
        JComboBox<String> deptBox = new JComboBox<>(departments);
        deptBox.setBounds(130, 100, 150, 25);

        JLabel salaryLabel = new JLabel("Salary:");
        salaryLabel.setBounds(20, 140, 100, 25);
        JTextField salaryText = new JTextField();
        salaryText.setBounds(130, 140, 150, 25);

        JButton submitButton = new JButton("Submit");
        submitButton.setBounds(100, 190, 100, 30);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String empId = idText.getText();
                String name = nameText.getText();
                String dept = (String) deptBox.getSelectedItem();
                String salary = salaryText.getText();

                if (empId.isEmpty() || name.isEmpty() || salary.isEmpty()) {
                    JOptionPane.showMessageDialog(frame, "Please fill in all fields!", "Error", JOptionPane.ERROR_MESSAGE);
                } else {
                    String message = "Employee Details:\n" +
                                     "ID: " + empId + "\n" +
                                     "Name: " + name + "\n" +
                                     "Department: " + dept + "\n" +
                                     "Salary: $" + salary;
                    JOptionPane.showMessageDialog(frame, message, "Registration Successful", JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });

        frame.add(idLabel);
        frame.add(idText);
        frame.add(nameLabel);
        frame.add(nameText);
        frame.add(deptLabel);
        frame.add(deptBox);
        frame.add(salaryLabel);
        frame.add(salaryText);
        frame.add(submitButton);

        frame.setSize(320, 280);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}