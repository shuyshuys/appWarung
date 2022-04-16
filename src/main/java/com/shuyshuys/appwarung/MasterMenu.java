package com.shuyshuys.appwarung;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

/**
 * @author shuyshuys
 */

class MasterMenu {

    public static void launchApp() {
        MasterMenuFrame masterMenuFrame = new MasterMenuFrame();
        masterMenuFrame.setSize(200, 350);
        masterMenuFrame.setBounds(10, 10, 370, 600);
        masterMenuFrame.setTitle("Master Menu");
        masterMenuFrame.setVisible(true);
        masterMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        masterMenuFrame.setResizable(false);
        // Centering the screen on the desktop
        Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
        Dimension frameSize = masterMenuFrame.getSize();
        masterMenuFrame.setLocation(((screenSize.width - frameSize.width) / 2),
                ((screenSize.height - frameSize.height) / 2));
    }
}

class AppFrame extends javax.swing.JFrame implements ActionListener {

    @Override
    public void actionPerformed(ActionEvent e) {
        // Auto-generated method stub

    }

}

// Creating MainFrame class
class MasterMenuFrame extends JFrame implements ActionListener {

    Container container = getContentPane();
    JLabel barangLabel = new JLabel("Menu Barang");
    JButton barangButton = new JButton("Barang");
    JLabel memberLabel = new JLabel("Menu Pelanggan");
    JButton memberButton = new JButton("Member");
    JLabel transaksiLabel = new JLabel("Menu Transaksi");
    JButton transaksiButton = new JButton("Transaksi");
    JLabel laporanLabel = new JLabel("Menu Laporan");
    JButton laporanButton = new JButton("Laporan");
    JLabel logoutLabel = new JLabel("Logout");
    JButton logoutButton = new JButton("Logout");
    JLabel titleLabel = new JLabel("Menu Utama");

    // Creating constructor of MainFrame() class
    MasterMenuFrame() {
        setLayoutManager();
        setLocationAndSize();
        addComponentsToContainer();
        addActionEvent();// calling addActionEvent() method
    }

    public void setLayoutManager() {
        // Setting layout manager of Container to null
        container.setLayout(null);
    }

    public void setLocationAndSize() {
        // Setting location and size of each component using setBounds() method
        barangLabel.setBounds(50, 100, 100, 30);
        barangButton.setBounds(200, 100, 100, 30);
        transaksiLabel.setBounds(50, 150, 100, 30);
        transaksiButton.setBounds(200, 150, 100, 30);
        memberLabel.setBounds(50, 200, 150, 30);
        memberButton.setBounds(200, 200, 100, 30);
        laporanLabel.setBounds(50, 250, 100, 30);
        laporanButton.setBounds(200, 250, 100, 30);
        logoutButton.setBounds(200, 500, 100, 30);
        titleLabel.setBounds(150, 10, 100, 30);
        // backgroundLabel.setBounds(0, 0, 400, 400);
        // barangButton.setIcon(barangIcon);
        // backgroundLabel.setIcon(backgroundIcon);
    }

    public void addComponentsToContainer() {
        // Adding components to Container using add() method
        container.add(barangLabel);
        container.add(transaksiLabel);
        container.add(memberLabel);
        container.add(laporanLabel);
        container.add(logoutLabel);
        container.add(barangButton);
        container.add(transaksiButton);
        container.add(memberButton);
        container.add(laporanButton);
        container.add(logoutButton);
        container.add(titleLabel);
        // container.add(backgroundLabel);
    }

    public void addActionEvent() {
        // Adding action event to each component using addActionListener() method
        barangButton.addActionListener(this);
        transaksiButton.addActionListener(this);
        memberButton.addActionListener(this);
        laporanButton.addActionListener(this);
        logoutButton.addActionListener(this);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Auto-generated method stub
        if (e.getSource() == barangButton) {
            MasterBarang masterBarang = new MasterBarang();
            masterBarang.setVisible(true);
            dispose();
        } else if (e.getSource() == transaksiButton) {
            PembelianMenu pembelianMenu = new PembelianMenu();
            pembelianMenu.setVisible(true);
            dispose();
        } else if (e.getSource() == memberButton) {
            MemberGUI member = new MemberGUI();
            member.setVisible(true);
            dispose();
        } else if (e.getSource() == laporanButton) {
            Laporan laporan = new Laporan();
            laporan.setVisible(true);
            dispose();
        } else if (e.getSource() == logoutButton) {
            Login login = new Login();
            login.launchApp();
            dispose();
        }
    }
}
