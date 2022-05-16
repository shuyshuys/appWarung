package com.shuyshuys.appwarung;

import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * @author shuyshuys
 */

public class add {
    static int idxMakanan = 0;
    static int idxMinuman = 0;
    static int idxPembeli = 0;
    static int idxTransaksi = 1;
    static int idx_max_makanan;
    static int idx_max_minuman;
    static int idTransaksi = 92000;
    static boolean foundIdxMa = false;
    static boolean foundIdxMi = false;
    private static int pilihBackToMenu = 0;

    public static Scanner sc() {
        return new Scanner(System.in);
    }

    static int getMostMenu() {
        int mostMenu;
        if (add.idxMakanan > add.idxMinuman) {
            mostMenu = add.idxMakanan + 5;
        } else {
            mostMenu = add.idxMinuman + 5;
        }
        return mostMenu;
    }

    public static String[][] sort(String[] barang, int[] harga) {
        String[][] hasil = new String[harga.length][2];
        for (int i = 0; i < hasil.length; i++) {
            for (int j = 0; j < hasil.length - 1; j++) {
                if (harga[j] < harga[j + 1]) {
                    // harga
                    int temp = harga[j];
                    harga[j] = harga[j + 1];
                    harga[j + 1] = temp;
                    // barang
                    String t = barang[j];
                    barang[j] = barang[j + 1];
                    barang[j + 1] = t;
                }
            }
        }
        for (int i = 0; i < harga.length; i++) {
            hasil[i][0] = barang[i];
            hasil[i][1] = String.valueOf(barang[i]);
        }
        return hasil;
    }

    static void refeshDbPembeli() {
        mineWriter.writePembeli(add.PATH_PEMBELI,
                cTransaksi.pembeli[0].getId(),
                cTransaksi.pembeli[0].getNama(),
                cTransaksi.pembeli[0].getAlamat());
        for (int i = 1; i < add.idxPembeli; i++) {
            mineWriter.writePembeli(add.PATH_PEMBELI,
                    cTransaksi.pembeli[0].getId(),
                    cTransaksi.pembeli[0].getNama(),
                    cTransaksi.pembeli[0].getAlamat());
        }
    }

    static void refreshDbMakanan() {
        for (int i = 0; i < add.idxMakanan; i++) {
            mineWriter.writeObject(add.PATH_MAKANAN, cMenuCLI.makanan[i].getId(),
                    cMenuCLI.makanan[i].getNama(),
                    cMenuCLI.makanan[i].getHarga());
        }
    }

    static void refreshDbMinuman() {
        for (int i = 0; i < add.idxMinuman; i++) {
            mineWriter.writeObject(add.PATH_MINUMAN, cMenuCLI.minuman[i].getId(),
                    cMenuCLI.minuman[i].getNama(),
                    cMenuCLI.minuman[i].getHarga());
            // add.idxMakanan++;
        }
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

    static int searchIdxById(int idCari, int kodeMenu) {
        // int id = -1;
        int id = 0;
        if (kodeMenu == 0) {
            for (int i = 0; i < add.idxMakanan; i++) {
                if (cMenuCLI.makanan[i].getId() == idCari) {
                    foundIdxMa = true;
                    id = i;
                }
            }
            if (!foundIdxMa) {
                System.out.println("Makanan tidak ditemukan");
            }
        } else if (kodeMenu == 1) {
            for (int i = 0; i < add.idxMinuman; i++) {
                if (cMenuCLI.minuman[i].getId() == idCari) {
                    foundIdxMi = true;
                    id = i;
                }
            }
            if (!foundIdxMi) {
                System.out.println("Minuman tidak ditemukan");
            }
        } else {
            System.out.println("Kode menu tidak sesuai!");
        }
        return id;
    }

    public static void listPembeli() {
        System.out.println("  ⁂ Daftar Pembeli");
        for (int i = 1; i < add.idxPembeli; i++) {
            if (cTransaksi.pembeli[i] != null) {
                System.out.println("[Member ke-" + i + "] ");
                System.out.println(cTransaksi.pembeli[i].ToString());
                ;
                add.border();
            }
        }
    }

    public static void printPembeli() {
        System.out.println("  ⁂ Daftar Pelanggan");
        System.out.println("    NO\tID\t\tNAMA\t\tALAMAT");
        for (int i = 0; i < add.idxPembeli; i++) {
            if (cTransaksi.pembeli[i].getNama().length() < 16) {
                System.out.println("   [" + (i + 1) + "] " + cTransaksi.pembeli[i].getId() + "\t"
                        + cTransaksi.pembeli[i].getNama() + "\t\t" + cTransaksi.pembeli[i].getAlamat());
            } else {
                System.out.println("   [" + (i + 1) + "] " + cTransaksi.pembeli[i].getId() + "\t"
                        + cTransaksi.pembeli[i].getNama() + "\t" + cTransaksi.pembeli[i].getAlamat());
            }
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
            System.out.println("     NO\tID\tNAMA\t\t\tHARGA");
            for (int i = 0; i < idxMakanan; i++) {
                // add.border();
                if (cMenuCLI.makanan[i].getNama().length() < 8) {
                    System.out.println(" ⁂ [" + (i + 1) + "]\t" + cMenuCLI.makanan[i].getId() + "\t"
                            + cMenuCLI.makanan[i].getNama() + "\t\t\t" + cMenuCLI.makanan[i].getHarga());
                }
                if (cMenuCLI.makanan[i].getNama().length() < 16) {
                    System.out.println(" ⁂ [" + (i + 1) + "]\t" + cMenuCLI.makanan[i].getId() + "\t"
                            + cMenuCLI.makanan[i].getNama() + "\t\t" + cMenuCLI.makanan[i].getHarga());
                } else {
                    System.out.println(" ⁂ [" + (i + 1) + "]\t" + cMenuCLI.makanan[i].getId() + "\t"
                            + cMenuCLI.makanan[i].getNama() + "\t" + cMenuCLI.makanan[i].getHarga());
                }
            }
        } else if (menu == "minuman") {
            System.out.println("  ⁂ List Menu Minuman");
            border();
            System.out.println("     NO\tID\tNAMA\t\tHARGA");
            for (int i = 0; i < idxMinuman; i++) {
                // add.border();
                if (cMenuCLI.minuman[i].getNama().length() < 8) {
                    System.out.println(" ⁂ [" + (i + 1) + "]\t" + cMenuCLI.minuman[i].getId() + "\t"
                            + cMenuCLI.minuman[i].getNama() + "\t\t\t" + cMenuCLI.minuman[i].getHarga());
                } else if (cMenuCLI.minuman[i].getNama().length() < 16) {
                    System.out.println(" ⁂ [" + (i + 1) + "]\t" + cMenuCLI.minuman[i].getId() + "\t"
                            + cMenuCLI.minuman[i].getNama() + "\t\t" + cMenuCLI.minuman[i].getHarga());
                } else {
                    System.out.println(" ⁂ [" + (i + 1) + "]\t" + cMenuCLI.minuman[i].getId() + "\t"
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
            if (idxMakanan < add.idx_max_makanan) {
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

                    cMenuCLI.makanan[idxMakanan] = new cMakanan(
                            cMenuCLI.makanan[add.idxMakanan - 1].getId() + 1,
                            namaMakanan,
                            hargaMakanan);
                    add.idxMakanan++;
                    add.border();
                    System.out.println(
                            "  ⁂ Berhasil menambahkan menu " + cMenuCLI.makanan[add.idxMakanan - 1].getNama());
                    break;
                } while (found != true);
            } else {
                System.out.println("  ⁂ Kapasitas menu " + menu + " Penuh!");
            }
        }
        if (menu == "Minuman") {
            System.out.println(" ⁘⁘⁘ Tambah Minuman");
            String namaMinuman; // input tambah menu makanan
            if (idxMakanan < add.idx_max_minuman) {
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

                    cMenuCLI.minuman[add.idxMinuman] = new cMinuman(
                            cMenuCLI.minuman[add.idxMinuman - 1].getId() + 1,
                            namaMinuman,
                            hargaMinuman);
                    add.idxMinuman++;
                    add.border();
                    System.out.println(
                            "  ⁂ Berhasil menambahkan menu " + cMenuCLI.minuman[add.idxMinuman - 1].getNama());
                    break;
                } while (found != true);
            } else {
                System.out.println("  ⁂ Kapasitas Menu " + menu + " Penuh!");
            }
        }
        border();
    }

    public static void backToMenu() {
        while (pilihBackToMenu != 1) {
            add.border();
            System.out.println("1. Back to Menu");
            System.out.println("2. Back to Login");
            System.out.println("3. Exit");
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
        border();
        System.out.println("Terima Kasih Telah Menggunakan Program ini!");
        border();
        System.exit(0);
    }

    public static void border() {
        System.out.println("=================================================");
    }

    public static String borderString() {
        return "=================================================";
    }

    public static void salahInput() {
        System.out.println("Pilihan salah, mohon ulangi!");
    }

    public static void cls() {
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static void sleep() {
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
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

    public static String PATH_MAKANAN = "./src/main/java/com/shuyshuys/appwarung/database/makananMenu.txt";
    public static String PATH_MINUMAN = "./src/main/java/com/shuyshuys/appwarung/database/minumanMenu.txt";
    public static String PATH_PEMBELI = "./src/main/java/com/shuyshuys/appwarung/database/pembeli.txt";
    public static String PATH_TRANSAKSI = "./src/main/java/com/shuyshuys/appwarung/database/transaksi.txt";
    public static String PATH_LOG = "./src/main/java/com/shuyshuys/appwarung/database/log.txt";
    public static String PATH_STRUK = "./src/main/java/com/shuyshuys/appwarung/database/struk.txt";
}
