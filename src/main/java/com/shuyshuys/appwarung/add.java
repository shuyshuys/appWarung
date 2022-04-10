package com.shuyshuys.appwarung;

import java.util.Scanner;
import javax.swing.JOptionPane;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author shuyshuys
 */

public class add {
    public static int idxMakanan = 0;
    public static int idxMinuman = 0;
    // what is idxPelanggan for?
    // public static int idxPelanggan = 0;
    public static int idxPembeli = 0;
    public static int idxTransaksi = 0;
    public static int idTransaksi = 902000;

    private static int pilihBackToMenu = 0;

    public static Scanner sc() {
        return new Scanner(System.in);
    }

    // TODO: String[][] rekapMenu() dan String[][] daftarRekapMenu()
    public static void rekapMenu() {

    }

    static cPembeli searchPembeli(String namaPembeli) {
        for (int j = 0; j < cTransaksi.pembeli.length; j++) {
            if (namaPembeli.equalsIgnoreCase(cTransaksi.pembeli[j].getNama())) {
                return cTransaksi.pembeli[j];
            }
        }
        return null;
    }

    static cMakanan searchMakanan(String namaMakanan) {
        for (int i = 0; i < idxMakanan; i++) {
            if (cMenuCLI.makanan[i].getNama().equalsIgnoreCase(namaMakanan)) {
                return cMenuCLI.makanan[i];
            }
        }
        return null;
    }

    static cMinuman searchMinuman(String namaMinuman) {
        for (int i = 0; i < idxMinuman; i++) {
            if (cMenuCLI.minuman[i].getNama().equalsIgnoreCase(namaMinuman)) {
                return cMenuCLI.minuman[i];
            }
        }
        return null;
    }

    static int searchIdMakanan(String namaMakanan) {
        for (int i = 0; i < idxMakanan; i++) {
            if (cMenuCLI.makanan[i].getNama().equalsIgnoreCase(namaMakanan)) {
                return cMenuCLI.makanan[i].getId();
            }
        }
        return 0;
    }

    static int searchIdMinuman(String namaMinuman) {
        for (int i = 0; i < idxMinuman; i++) {
            if (cMenuCLI.minuman[i].getNama().equalsIgnoreCase(namaMinuman)) {
                return cMenuCLI.minuman[i].getId();
            }
        }
        return 0;
    }

    static int searchIdxMakanan(String namaMakanan) {
        for (int i = 0; i < idxMakanan; i++) {
            if (cMenuCLI.makanan[i].getNama().equalsIgnoreCase(namaMakanan)) {
                return i;
            }
        }
        return 0;
    }

    static int searchIdxMinuman(String namaMinuman) {
        for (int i = 0; i < idxMinuman; i++) {
            if (cMenuCLI.minuman[i].getNama().equalsIgnoreCase(namaMinuman)) {
                return i;
            }
        }
        return 0;
    }

    static int searchById(int idCari, int kodeMenu) {
        int id = 0;
        if (kodeMenu == 0) {
            boolean found = false;
            for (int i = 0; i < add.idxMakanan; i++) {
                if (cMenuCLI.makanan[i].getId() == idCari) {
                    found = true;
                    id = i;
                    if (!found) {
                        System.out.println("Makanan tidak ditemukan");
                    }
                }
            }
        } else if (kodeMenu == 1) {
            boolean found2 = false;
            for (int i = 0; i < add.idxMinuman; i++) {
                if (cMenuCLI.minuman[i].getId() == idCari) {
                    found2 = true;
                    id = i;
                    if (!found2) {
                        System.out.println("Minuman tidak ditemukan");
                    }
                }
            }
        } else {
            System.out.println("Kode menu tidak sesuai!");
        }
        return id;
    }

    public static void listPembeli() {
        System.out.println("  ⁂ Daftar Pembeli");
        for (int i = 0; i < add.idxPembeli; i++) {
            if (cTransaksi.pembeli[i] != null) {
                System.out.println("[Pembeli ke-" + (i + 1) + "] ");
                System.out.println(cTransaksi.pembeli[i].ToString());
                ;
                add.border();
            }
        }
    }

    // TODO: test print v2
    public static void printPembeli() {
        System.out.println("  ⁂ Daftar Pelanggan");
        System.out.println("  ⁂ NO\tID\t\tNAMA\t\tALAMAT");
        for (int i = 0; i < add.idxPembeli; i++) {
            System.out.println("  ⁂ [" + (i + 1) + "] " + cTransaksi.pembeli[i].getId() + "\t"
                    + cTransaksi.pembeli[i].getNama() + "\t\t" + cTransaksi.pembeli[i].getAlamat());
        }
    }

    public static void listMenu(String menu) {
        if (menu == "makanan") {
            border();
            System.out.println("  ⁂ List Menu Makanan");
            border();
            for (int i = 0; i < idxMakanan; i++) {
                // add.border();
                System.out.println(cMenuCLI.makanan[i].ToString());
                border();
            }
        } else if (menu == "minuman") {
            System.out.println("  ⁂ List Menu Minuman");
            border();
            for (int i = 0; i < idxMinuman; i++) {
                // add.border();
                System.out.println(cMenuCLI.minuman[i].ToString());
                border();
            }
        }
    }

    public static void printMenu(String menu) {
        if (menu == "makanan") {
            border();
            System.out.println("  ⁂ List Menu Makanan");
            border();
            System.out.println("  ⁂ NO\tID\tNAMA\t\tHARGA");
            for (int i = 0; i < idxMakanan; i++) {
                // add.border();
                if (cMenuCLI.makanan[i].getNama().length() < 8) {
                    System.out.println("  ⁂ [" + (i + 1) + "] " + cMenuCLI.makanan[i].getId() + "\t"
                            + cMenuCLI.makanan[i].getNama() + "\t\t" + cMenuCLI.makanan[i].getHarga());
                } else {
                    System.out.println("  ⁂ [" + (i + 1) + "] " + cMenuCLI.makanan[i].getId() + "\t"
                            + cMenuCLI.makanan[i].getNama() + "\t" + cMenuCLI.makanan[i].getHarga());
                }
            }
        } else if (menu == "minuman") {
            System.out.println("  ⁂ List Menu Minuman");
            border();
            System.out.println("  ⁂ NO\tID\tNAMA\t\tHARGA");
            for (int i = 0; i < idxMinuman; i++) {
                // add.border();
                if (cMenuCLI.minuman[i].getNama().length() < 8) {
                    System.out.println("  ⁂ [" + (i + 1) + "] " + cMenuCLI.minuman[i].getId() + "\t"
                            + cMenuCLI.minuman[i].getNama() + "\t\t" + cMenuCLI.minuman[i].getHarga());
                } else {
                    System.out.println("  ⁂ [" + (i + 1) + "] " + cMenuCLI.minuman[i].getId() + "\t"
                            + cMenuCLI.minuman[i].getNama() + "\t" + cMenuCLI.minuman[i].getHarga());
                }
            }
        }
        border();
    }

    public static void addMenu(String menu) {
        if (menu == "Makanan") {
            System.out.println(" ⁘⁘⁘ Tambah Makanan");
            String namaMakanan; // input tambah menu makanan
            if (idxMakanan < mineReader.idx_max_makanan) {
                boolean found = false;
                do {
                    // Scanner scMakan = new Scanner(System.in);
                    System.out.print("Nama Makanan\t: ");
                    namaMakanan = add.sc().nextLine();
                    for (int i = 0; i < idxMakanan; i++) {
                        if (cMenuCLI.makanan[i].getNama().equals(namaMakanan)) {
                            found = true;
                        }
                    }
                    if (found == true) {
                        System.out.println("Menu " + namaMakanan + " Sudah ada");
                        break;
                    }
                    System.out.print("Harga Makanan\t: ");
                    int hargaMakanan = add.sc().nextInt();
                    System.out.print("Stok Makanan\t: ");
                    int stokMakanan = add.sc().nextInt();
                    cMenuCLI.makanan[idxMakanan] = new cMakanan(
                            cMenuCLI.makanan[add.idxMakanan - 1].getId() + 1,
                            namaMakanan,
                            hargaMakanan,
                            stokMakanan);
                    add.idxMakanan++;
                    add.border();
                    System.out.println(
                            "Berhasil menambahkan menu " + cMenuCLI.makanan[add.idxMakanan - 1].getNama());
                    break;
                } while (found != true);
                add.border();
            } else {
                System.out.println("Kapasitas menu " + menu + " Penuh!");
            }
        }
        if (menu == "Minuman") {
            System.out.println(" ⁘⁘⁘ Tambah Minuman");
            String namaMinuman; // input tambah menu makanan
            if (idxMakanan < mineReader.idx_max_makanan) {
                boolean found = false;
                do {
                    // Scanner scMakan = new Scanner(System.in);
                    System.out.print("Nama Minuman\t: ");
                    namaMinuman = add.sc().nextLine();
                    for (int i = 0; i < idxMinuman; i++) {
                        if (cMenuCLI.minuman[i].getNama().equals(namaMinuman)) {
                            found = true;
                        }
                    }
                    if (found == true) {
                        System.out.println("Menu " + namaMinuman + "Sudah ada");
                        break;
                    }
                    System.out.print("Harga Minuman\t: ");
                    int hargaMinuman = add.sc().nextInt();
                    System.out.print("Stok Minuman\t: ");
                    int stokMinuman = add.sc().nextInt();
                    cMenuCLI.minuman[add.idxMinuman] = new cMinuman(
                            cMenuCLI.minuman[add.idxMinuman - 1].getId() + 1,
                            namaMinuman,
                            hargaMinuman,
                            stokMinuman);
                    add.idxMinuman++;
                    add.border();
                    System.out.println(
                            "Berhasil menambahkan menu " + cMenuCLI.minuman[add.idxMinuman - 1].getNama());
                    break;
                } while (found != true);
                add.border();
            } else {
                System.out.println("Kapasitas Menu " + menu + " Penuh!");
            }
        }
        border();
    }

    public static void backToMenu() {
        // Scanner sc = new Scanner(System.in);
        while (pilihBackToMenu != 1) {
            System.out.println("1. Back to Menu");
            System.out.println("2. Back to Login");
            System.out.println("3. Keluar Aplikasi");
            System.out.print("Pilihan : ");
            int pilihBackToMenu = add.sc().nextInt();
            switch (pilihBackToMenu) {
                case 1:
                    cMenuCLI.menuCLI();
                    break;
                case 2:
                    AppWarung.main(null);
                    break;
                case 3:
                    exit();
                    break;
                default:
                    salahInput();
            }
        }
    }

    public static void exit() {
        System.out.println("Terima Kasih Telah Menggunakan Program ini!");
        // JOptionPane.showMessageDialog(null, "Terima Kasih Telah Menggunakan Program
        // ini!");
        System.exit(0);
    }

    public static void border() {
        System.out.println("===========================================================");
    }

    public static void salahInput() {
        // JOptionPane.showMessageDialog(null, "Pilihan salah, mohon ulangi!", "",
        // JOptionPane.ERROR_MESSAGE);
        System.out.println("Pilihan salah, mohon ulangi!");
    }

    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    static String logTime(String status) {
        return "⁂  " + status + " berhasil pada : " + getDateTime();
    }

    static String getDateTime() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    static String getDate() {
        DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy");
        Date date = new Date();
        return dateFormat.format(date);
    }

    static String getTime() {
        DateFormat dateFormat = new SimpleDateFormat("HH:mm:ss");
        Date date = new Date();
        return dateFormat.format(date);
    }

    public static String PATH_MAKANAN = "./src/main/java/com/shuyshuys/appwarung/Kasir/makananMenu.txt";
    public static String PATH_MINUMAN = "./src/main/java/com/shuyshuys/appwarung/Kasir/minumanMenu.txt";
    public static String PATH_PEMBELI = "./src/main/java/com/shuyshuys/appwarung/Kasir/pembeli.txt";
    public static String PATH_TRANSAKSI = "./src/main/java/com/shuyshuys/appwarung/Kasir/transaksi.txt";
    public static String PATH_LOG = "./src/main/java/com/shuyshuys/appwarung/Kasir/log.txt";

    // public static String PATH_ID_MAKANAN =
    // "./src/main/java/com/shuyshuys/appwarung/Kasir/makananId.txt";
    // public static String PATH_HARGA_MAKANAN =
    // "./src/main/java/com/shuyshuys/appwarung/Kasir/makananHarga.txt";
    // public static String PATH_STOK_MAKANAN =
    // "./src/main/java/com/shuyshuys/appwarung/Kasir/makananStok.txt";
    // public static String PATH_ID_MINUMAN =
    // "./src/main/java/com/shuyshuys/appwarung/Kasir/minumanMenu.txt";
    // public static String PATH_HARGA_MINUMAN =
    // "./src/main/java/com/shuyshuys/appwarung/Kasir/hargaMinuman.txt";
    // public static String PATH_STRUK =
    // "./src/main/java/com/shuyshuys/appwarung/Kasir/struk.txt";

}
