package org.example;

import org.example.Database.dbConnection;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;

public class RegistrationPage implements ActionListener {
    JFrame frame = new JFrame();

    JLabel regPageLabel = new JLabel("Registration");
    JLabel userIDRegistrationLabel = new JLabel("username: ");
    JLabel userPasswordRegistrationLabel = new JLabel("password: ");
    JTextField userIDRegistrtionField = new JTextField();
    JPasswordField userPasswordRegistrationField = new JPasswordField();
    JButton registerButton = new JButton("Register");
    JButton returnButton = new JButton("Return");
    JLabel messageLabel = new JLabel();

    HashMap<String,String> loginInfo;
    RegistrationPage(HashMap<String, String> loginInfoOriginal){
        loginInfo = loginInfoOriginal;
        regPageLabel.setBounds(170,30,100,100);
        userIDRegistrationLabel.setBounds(50,100,75,25);
        userPasswordRegistrationLabel.setBounds(50,150,75,25);

        messageLabel.setBounds(125,250,250,35);
        messageLabel.setFont(new Font(null,Font.ITALIC,25));

        userIDRegistrtionField.setBounds(125,100,200,25);
        userPasswordRegistrationField.setBounds(125,150,200,25);

        registerButton.setBounds(125,200,100,25);
        registerButton.setFocusable(false);
        registerButton.addActionListener(this);

        returnButton.setBounds(225,200,100,25);
        returnButton.setFocusable(false);
        returnButton.addActionListener(this);

        frame.add(messageLabel);
        frame.add(regPageLabel);
        frame.add(returnButton);
        frame.add(registerButton);
        frame.add(userIDRegistrationLabel);
        frame.add(userIDRegistrtionField);
        frame.add(userPasswordRegistrationLabel);
        frame.add(userPasswordRegistrationField);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==returnButton){
            Users users = new Users();
            LoginPage loginPage = new LoginPage(users.getLoginInfo());
            frame.dispose();
        }
        if (e.getSource()==registerButton){
            String userID = userIDRegistrtionField.getText();
            String userPassword = String.valueOf(userPasswordRegistrationField.getPassword());

            if (userID.isEmpty() || userPassword.isEmpty() ) {
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Fields can't be empty!");
                return;
            }

            if(loginInfo.containsKey(userID)){
                messageLabel.setForeground(Color.red);
                messageLabel.setText("Username taken!");
                return;
            }

            String addUserQuery =  "INSERT INTO public.\"Users\"(username, password) VALUES ('"
                    + userID + "', '" +  userPassword + "')";
            try {
                Connection connection = dbConnection.connectToDatabase();
                Statement statement = connection.createStatement();
                statement.execute(addUserQuery);
                connection.close();
            } catch (SQLException exception) {
                throw new RuntimeException();
            }
            messageLabel.setForeground(Color.green);
            messageLabel.setText("Registration complete");
        }
    }
}
