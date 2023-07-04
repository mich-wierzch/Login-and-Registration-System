package org.example;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class WelcomePage implements ActionListener {
    JFrame frame = new JFrame();
    JLabel welcomeLabel = new JLabel();
    JButton logoutButton = new JButton("Logout");
    WelcomePage(String userID){
        welcomeLabel.setBounds(125,150,200,35);
        welcomeLabel.setFont(new Font(null,Font.PLAIN,25));
        welcomeLabel.setText("Hello"+ " " + userID);

        logoutButton.setBounds(150,200,100,25);
        logoutButton.setFocusable(false);
        logoutButton.addActionListener(this);

        frame.add(welcomeLabel);
        frame.add(logoutButton);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,420);
        frame.setLayout(null);
        frame.setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==logoutButton) {
            Users users = new Users();
            LoginPage loginPage = new LoginPage(users.getLoginInfo());
            frame.dispose();
        }
    }
}
