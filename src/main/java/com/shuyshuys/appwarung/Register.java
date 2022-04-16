package com.shuyshuys.appwarung;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
// import java.sql.ResultSet;
// import java.sql.Statement;

/**
 * @author shuyshuys
 */

class Register {

    static String id = "";

    public static void main(String[] args) {
        Register regis = new Register();
        regis.launchApp();
    }

    public static String getUser() {
        return id;
    }

    public void launchApp() {
        RegisterFrame regisFrame = new RegisterFrame();

        regisFrame.setSize(200, 350);
        regisFrame.setBounds(10, 10, 370, 600);

        // NOTE: Centering the screen on the desktop
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = regisFrame.getSize();
        regisFrame.setLocation(((screenSize.width - frameSize.width) / 2),
                ((screenSize.height - frameSize.height) / 2));

        regisFrame.setTitle("Register");
        regisFrame.setVisible(true);
        // regisFrame.setBounds(10, 10, 370, 600);
        regisFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        regisFrame.setResizable(false);
    }
}

// NOTE: Creating RegisterFrame class
class RegisterFrame extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel userLabel = new JLabel("Username");
    JLabel passLabel = new JLabel("Password");
    JTextField userText = new JTextField("");
    public String getUser = userText.getText().toString();
    JPasswordField passText = new JPasswordField("");
    JButton registerButton = new JButton("Register");
    JButton resetButton = new JButton("Reset");
    JButton backButton = new JButton("Back to Login");
    JCheckBox showPass = new JCheckBox("Show Password");

    // NOTE: Creating constructor of RegisterFrame() class
    RegisterFrame() {
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
        registerButton.setBounds(50, 300, 100, 30);
        backButton.setBounds(50, 350, 250, 30);
        resetButton.setBounds(200, 300, 100, 30);
    }

    public void addComponentsToContainer() {
        // NOTE: Adding components to Container using add() method
        container.add(userLabel);
        container.add(passLabel);
        container.add(userText);
        container.add(passText);
        container.add(showPass);
        container.add(registerButton);
        container.add(backButton);
        container.add(resetButton);
    }

    public void addActionEvent() {
        // NOTE: adding Action Listener to components
        registerButton.addActionListener(this);
        resetButton.addActionListener(this);
        backButton.addActionListener(this);
        showPass.addActionListener(this);
    }

    // NOTE: Overriding actionPerformed() method of ActionListener interface
    private static final Login login = new Login();

    @Override
    public void actionPerformed(ActionEvent e) {
        // Coding part of LOGIN button
        if (e.getSource() == registerButton) {
            Register.id = userText.getText();
            String pass = String.valueOf(passText.getPassword());

            try {
                String sql = "INSERT INTO login (Nama, Password) VALUES ('" + Register.id + "', '" + pass + "')";
                Post.getCon().createStatement().executeUpdate(sql);
                JOptionPane.showMessageDialog(null, "Register Success");

                dispose();
                login.launchApp();
            } catch (Exception er) {
                JOptionPane.showMessageDialog(null, er.getMessage());
                System.err.println(er.getMessage());
            }
        }
        if (e.getSource() == backButton) {
            dispose();
            login.launchApp();
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
