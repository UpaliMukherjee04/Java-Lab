package assignment17;

import java.awt.event.*;
import javax.swing.*;

public class StudentRegistrationForm {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Student Registration Form");

        JLabel nameLabel = new JLabel("Name:");
        nameLabel.setBounds(20, 20, 80, 25);
        JTextField nameText = new JTextField();
        nameText.setBounds(110, 20, 150, 25);

        JLabel emailLabel = new JLabel("Email:");
        emailLabel.setBounds(20, 60, 80, 25);
        JTextField emailText = new JTextField();
        emailText.setBounds(110, 60, 150, 25);

        JLabel courseLabel = new JLabel("Course:");
        courseLabel.setBounds(20, 100, 80, 25);
        String[] courses = {"Computer Science", "Information Technology", "Mechanical", "Civil"};
        JComboBox<String> courseBox = new JComboBox<>(courses);
        courseBox.setBounds(110, 100, 150, 25);

        JButton submitButton = new JButton("Register");
        submitButton.setBounds(90, 150, 100, 30);

        JLabel statusLabel = new JLabel("");
        statusLabel.setBounds(20, 190, 260, 30);

        submitButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String name = nameText.getText();
                if (name.isEmpty()) {
                    statusLabel.setText("Please enter a name.");
                } else {
                    statusLabel.setText("Registered: " + name);
                }
            }
        });

        frame.add(nameLabel);
        frame.add(nameText);
        frame.add(emailLabel);
        frame.add(emailText);
        frame.add(courseLabel);
        frame.add(courseBox);
        frame.add(submitButton);
        frame.add(statusLabel);

        frame.setSize(300, 280);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}
