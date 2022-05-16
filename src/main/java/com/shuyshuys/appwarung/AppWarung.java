package com.shuyshuys.appwarung;

import java.util.Scanner;
import javax.swing.JOptionPane;

/**
 * @author shuyshuys
 */

public class AppWarung {
    private static Scanner sc = new Scanner(System.in);
    public static String user;

    public static void main(String[] args) {
        add.cls();
        int pilihan = 0;

        mineReader.getReader(add.PATH_MAKANAN, "makanan");
        // PostReader.getPostReader("makanan");
        // PostReader.getPostReader("minuman");
        mineReader.getReader(add.PATH_MINUMAN, "minuman");
        mineReader.getReader(add.PATH_PEMBELI, "pembeli");
        // mineReader.getReader(add.PATH_TRANSAKSI, "transaksi");

        cMenuCLI.laporanHargaMakanan = new int[add.idxMakanan];
        cMenuCLI.laporanHargaMinuman = new int[add.idxMinuman];
        cMenuCLI.laporanPelanggan = new int[add.idxPembeli + 5];

        while (pilihan != 3) {
            add.border();
            System.out.println("Selamat datang di App Warung by @shuyshuys");
            add.border();
            System.out.print(
                    "Silahkan pilih opsi yang tersedia \n1. CLI \n2. GUI (under development)\n3. Exit \nPilihan : ");
            pilihan = sc.nextInt();
            switch (pilihan) {
                case 1:
                    while (user == null) {
                        add.cls();
                        System.out.println("===========================================================");
                        System.out.println("Selamat datang di menu CLI");
                        System.out.print("Login\t\t: ");
                        user = add.sc().nextLine();
                        System.out.print("Password\t: ");
                        String pass = add.sc().nextLine();
                        if (user.equals("admin") && pass.equals("admin")) {
                            cMenuCLI.menuCLI();
                        } else {
                            JOptionPane.showMessageDialog(null, "Username atau password salah!", "Login CLI",
                                    JOptionPane.ERROR_MESSAGE);
                            user = null;
                        }
                    }
                    break;
                case 2:
                    JOptionPane.showMessageDialog(null,
                            "Jika nanti terjadi 'too many connections', mohon diulangi kembali karena DB online terlimitasi 5 request",
                            "Login GUI",
                            JOptionPane.INFORMATION_MESSAGE);
                    Login login = new Login();
                    login.launchApp();
                    break;
                case 3:
                    add.border();
                    add.exit();
                    break;
                default:
                    add.salahInput();
                    break;
            }
        }
    }
}
