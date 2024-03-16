package sb;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.Date;
import static javax.swing.JFrame.EXIT_ON_CLOSE;

public class AdInterface extends JFrame implements ActionListener {

    // define labels and buttons
    JLabel titleLabel, nameLabel, balanceLabel, transactionLabel, paymentLabel;
    JTextField nameField, balanceField, paymentField;
    JButton payButton, viewTransactionButton;

    // define transaction history list
    ArrayList<String> transactionHistory = new ArrayList<String>();

    // define constructor
    public AdInterface() {
        // set window properties
        setTitle("Student Billing System");
        setSize(400, 300);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setLocationRelativeTo(null);
        setResizable(false);

        // create labels
        titleLabel = new JLabel("Student Billing System");
        titleLabel.setFont(new Font("Arial", Font.BOLD, 16));
        nameLabel = new JLabel("Name:");
        balanceLabel = new JLabel("Balance:");
        paymentLabel = new JLabel("Payment Amount:");
        transactionLabel = new JLabel("Transaction History:");

        // create text fields
        nameField = new JTextField(20);
        balanceField = new JTextField(10);
        paymentField = new JTextField(10);

        // create buttons
        payButton = new JButton("Pay");
        payButton.addActionListener(this);
        viewTransactionButton = new JButton("View Transaction History");
        viewTransactionButton.addActionListener(this);

        // add components to the window
        JPanel panel = new JPanel();
        panel.setLayout(new GridBagLayout());
        GridBagConstraints gbc = new GridBagConstraints();
        gbc.insets = new Insets(5, 5, 5, 5);
        gbc.gridx = 0;
        gbc.gridy = 0;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(titleLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 1;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(nameLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 1;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(nameField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(balanceLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 2;
        gbc.anchor = GridBagConstraints.EAST;
        panel.add(balanceField, gbc);

        gbc.gridx = 0;
        gbc.gridy = 3;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(transactionLabel, gbc);

        gbc.gridx = 0;
        gbc.gridy = 4;
        gbc.gridwidth = 2;
        gbc.anchor = GridBagConstraints.CENTER;
        panel.add(viewTransactionButton, gbc);

        gbc.gridx = 0;
        gbc.gridy = 5;
        gbc.gridwidth = 1;
        gbc.anchor = GridBagConstraints.WEST;
        panel.add(paymentLabel, gbc);

        gbc.gridx = 1;
        gbc.gridy = 5;
        gbc.anchor= GridBagConstraints.EAST;
        panel.add(paymentField, gbc);
            gbc.gridx = 0;
    gbc.gridy = 6;
    gbc.gridwidth = 2;
    gbc.anchor = GridBagConstraints.CENTER;
    panel.add(payButton, gbc);

    // add panel to the window
    add(panel);

    // make the window visible
    setVisible(true);
}

// method to handle button clicks
public void actionPerformed(ActionEvent e) {
    if (e.getSource() == payButton) {
        // get input values
        String name = nameField.getText();
        String balanceStr = balanceField.getText();
        String paymentStr = paymentField.getText();

        // convert balance and payment to doubles
        double balance = Double.parseDouble(balanceStr);
        double payment = Double.parseDouble(paymentStr);

        // update balance and transaction history
        balance -= payment;
        Date date = new Date();
        String transaction = date.toString() + " - Payment of ₱" + payment + " made. New balance is ₱" + balance;
        transactionHistory.add(transaction);
        balanceField.setText(Double.toString(balance));
        paymentField.setText("");

        // show confirmation message
        JOptionPane.showMessageDialog(this, "Payment of ₱" + payment + " made.");
    } else if (e.getSource() == viewTransactionButton) {
        // display transaction history
        StringBuilder history = new StringBuilder();
        for (String transaction : transactionHistory) {
            history.append(transaction).append("\n");
        }
        JOptionPane.showMessageDialog(this, history.toString());
    }
}

public static void main(String[] args) {
    new AdInterface();
 }
}


