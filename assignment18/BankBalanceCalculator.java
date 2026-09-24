package assignment18;

import java.awt.event.*;
import javax.swing.*;

public class BankBalanceCalculator {

    public static void main(String[] args) {

        JFrame frame = new JFrame("Bank Balance Calculator");

        JLabel initLabel = new JLabel("Initial Balance:");
        initLabel.setBounds(20, 20, 130, 25);
        JTextField initText = new JTextField();
        initText.setBounds(150, 20, 120, 25);

        JLabel amountLabel = new JLabel("Transaction Amount:");
        amountLabel.setBounds(20, 60, 130, 25);
        JTextField amountText = new JTextField();
        amountText.setBounds(150, 60, 120, 25);

        JButton depositButton = new JButton("Deposit (+)");
        depositButton.setBounds(20, 100, 120, 30);

        JButton withdrawButton = new JButton("Withdraw (-)");
        withdrawButton.setBounds(150, 100, 120, 30);

        JLabel statusLabel = new JLabel("Updated Balance: ");
        statusLabel.setBounds(20, 150, 260, 25);

        // Deposit Event Handling
        depositButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double balance = Double.parseDouble(initText.getText());
                    double amount = Double.parseDouble(amountText.getText());

                    if (amount < 0) {
                        statusLabel.setText("Error: Deposit amount must be positive!");
                        return;
                    }

                    double newBalance = balance + amount;
                    initText.setText(String.valueOf(newBalance));
                    amountText.setText("");
                    statusLabel.setText("Updated Balance: Rs." + newBalance);
                } catch (NumberFormatException ex) {
                    statusLabel.setText("Error: Enter valid numbers!");
                }
            }
        });

        // Withdrawal Event Handling
        withdrawButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double balance = Double.parseDouble(initText.getText());
                    double amount = Double.parseDouble(amountText.getText());

                    if (amount < 0) {
                        statusLabel.setText("Error: Amount must be positive!");
                        return;
                    }

                    if (amount > balance) {
                        statusLabel.setText("Error: Insufficient funds!");
                        return;
                    }

                    double newBalance = balance - amount;
                    initText.setText(String.valueOf(newBalance));
                    amountText.setText("");
                    statusLabel.setText("Updated Balance: Rs." + newBalance);
                } catch (NumberFormatException ex) {
                    statusLabel.setText("Error: Enter valid numbers!");
                }
            }
        });

        frame.add(initLabel);
        frame.add(initText);
        frame.add(amountLabel);
        frame.add(amountText);
        frame.add(depositButton);
        frame.add(withdrawButton);
        frame.add(statusLabel);

        frame.setSize(310, 230);
        frame.setLayout(null);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
}