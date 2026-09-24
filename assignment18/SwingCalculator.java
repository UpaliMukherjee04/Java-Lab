package assignment18;

import java.awt.event.*;
import javax.swing.*;

public class SwingCalculator {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Simple Calculator");

        JLabel num1Label = new JLabel("First Number:");
        num1Label.setBounds(20, 20, 100, 25);
        JTextField num1Text = new JTextField();
        num1Text.setBounds(130, 20, 120, 25);

        JLabel num2Label = new JLabel("Second Number:");
        num2Label.setBounds(20, 60, 100, 25);
        JTextField num2Text = new JTextField();
        num2Text.setBounds(130, 60, 120, 25);

        JButton addButton = new JButton("Add (+)");
        addButton.setBounds(20, 100, 110, 30);

        JButton subButton = new JButton("Subtract (-)");
        subButton.setBounds(140, 100, 110, 30);

        JLabel resultLabel = new JLabel("Result: ");
        resultLabel.setBounds(20, 150, 230, 25);

        // Addition Event Handling
        addButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double n1 = Double.parseDouble(num1Text.getText());
                    double n2 = Double.parseDouble(num2Text.getText());
                    double sum = n1 + n2;
                    resultLabel.setText("Result: " + sum);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Error: Enter valid numbers!");
                }
            }
        });

        // Subtraction Event Handling
        subButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double n1 = Double.parseDouble(num1Text.getText());
                    double n2 = Double.parseDouble(num2Text.getText());
                    double diff = n1 - n2;
                    resultLabel.setText("Result: " + diff);
                } catch (NumberFormatException ex) {
                    resultLabel.setText("Error: Enter valid numbers!");
                }
            }
        });

        frame.add(num1Label);
        frame.add(num1Text);
        frame.add(num2Label);
        frame.add(num2Text);
        frame.add(addButton);
        frame.add(subButton);
        frame.add(resultLabel);

        frame.setSize(300, 240);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}