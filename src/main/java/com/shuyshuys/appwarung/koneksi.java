package com.shuyshuys.appwarung;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;

/**
 * @author shuyshuys
 * @author Naishaltss
 * @author arnica13
 */

public class koneksi {

    public static Connection conn;
    public static Statement stm;

    public static Connection getConnection() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String db = "bp2_uts";
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, "root", "");
            stm = conn.createStatement();
            System.out.println("  Koneksi ke database " + db + " Berhasil!");
        } catch (Exception e) {
            System.err.println("  Koneksi ke database Gagal! " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    public static Connection getCon() {
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            String db = "bp2"; // NOTE: nama database
            conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/" + db, "root", "");
            stm = conn.createStatement();
            System.out.println("  Koneksi ke database " + db + " Berhasil!");
        } catch (Exception e) {
            System.err.println("  Koneksi ke database Gagal! " + e.getMessage());
            e.printStackTrace();
        }
        return conn;
    }

    public static void main(String args[]) {
        koneksi.getConnection();
        koneksi.getCon();
        System.out.println(System.lineSeparator().repeat(100));
    }

}
