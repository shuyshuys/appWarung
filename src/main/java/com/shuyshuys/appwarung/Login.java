package com.shuyshuys.appwarung;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.sql.Statement;

/**
 * @author shuyshuys
 */

class Login {

    // public String getUser() {
    // LoginFrame lf = new LoginFrame();
    // return lf.getUser;
    // }

    public void launchApp() {
        LoginFrame loginFrame = new LoginFrame();

        loginFrame.setSize(200, 350);
        loginFrame.setBounds(10, 10, 370, 600);

        // NOTE: Centering the screen on the desktop
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = loginFrame.getSize();
        loginFrame.setLocation(((screenSize.width - frameSize.width) / 2),
                ((screenSize.height - frameSize.height) / 2));

        loginFrame.setTitle("Login");
        loginFrame.setVisible(true);
        // loginFrame.setBounds(10, 10, 370, 600);
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setResizable(false);
    }
}

// class AppFrame extends JFrame implements ActionListener {
// AppFrame() {

// }

// @Override
// public void actionPerformed(ActionEvent e) {
// // Auto-generated method stub

// }
// }

// NOTE: Creating LoginFrame class
class LoginFrame extends JFrame implements ActionListener {

    Container container = getContentPane();

    JLabel userLabel = new JLabel("Username");
    JLabel passLabel = new JLabel("Password");

    String getRegister = Register.getUser();
    JTextField userText = new JTextField(getRegister);

    // public void setUser(String user) {
    // // this.userLabel.setText(user);
    // usertex
    // userText.setText(user);
    // System.out.println();
    // System.out.println(user + " lf");
    // }

    String getUser = userText.getText();
    JPasswordField passText = new JPasswordField();
    JButton loginButton = new JButton("Login");
    JButton registerButton = new JButton("Register");
    JButton resetButton = new JButton("Reset");
    JCheckBox showPass = new JCheckBox("Show Password");

    // NOTE: Creating constructor of LoginFrame() class
    LoginFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();// calling addActionEvent() method
    }

    public void setLayoutManager() {
        // NOTE: Setting layout manager of Container to null
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        // NOTE: Setting location and size of each component using setBounds() method
        userLabel.setBounds(50, 150, 100, 30);
        passLabel.setBounds(50, 220, 100, 30);
        userText.setBounds(150, 150, 150, 30);
        passText.setBounds(150, 220, 150, 30);
        showPass.setBounds(150, 250, 150, 30);
        loginButton.setBounds(50, 350, 250, 30);
        resetButton.setBounds(200, 300, 100, 30);
        registerButton.setBounds(50, 400, 250, 30);
    }

    public void addComponentsToContainer() {
        // NOTE: Adding components to Container using add() method
        container.add(userLabel);
        container.add(passLabel);
        container.add(userText);
        container.add(passText);
        container.add(showPass);
        container.add(loginButton);
        container.add(resetButton);
        container.add(registerButton);
    }

    public void addActionEvent() {
        // NOTE: adding Action Listener to components
        loginButton.addActionListener(this);
        resetButton.addActionListener(this);
        showPass.addActionListener(this);
        registerButton.addActionListener(this);
    }

    // NOTE: Overriding actionPerformed() method of ActionListener interface
    @Override
    public void actionPerformed(ActionEvent e) {
        // Coding part of LOGIN button
        if (e.getSource() == loginButton) {
            String id = userText.getText();
            String pass = String.valueOf(passText.getPassword());
            /*
             * var pass = passText.getText();
             * Deprecated in Java 8
             */
            try {
                String sql = "SELECT * FROM login where Nama= '" + id + "'and password='" + pass + "'";
                Statement statement = Post.getCon().createStatement();
                ResultSet rs = statement.executeQuery(sql);

                if (rs.next()) {
                    JOptionPane.showMessageDialog(this, "Login Success!");
                    MasterMenu.launchApp();
                    this.dispose();
                } else {
                    JOptionPane.showMessageDialog(this, "Invalid username or password!");
                }
            } catch (Exception er) {
                // handle exception
                JOptionPane.showMessageDialog(null, er);
                System.out.println(er);
            }
        }
        // Coding part of REGISTER button
        if (e.getSource() == registerButton) {
            Register register = new Register();
            register.launchApp();
            this.dispose();
        }
        // Coding part of RESET button
        if (e.getSource() == resetButton) {
            userText.setText("");
            passText.setText("");
        }
        // Coding part of SHOW PASSWORD checkbox
        if (e.getSource() == showPass) {
            if (showPass.isSelected()) {
                passText.setEchoChar((char) 0);
            } else {
                passText.setEchoChar('*');
            }
        }
    }
}
