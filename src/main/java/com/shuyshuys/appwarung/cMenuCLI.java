package com.shuyshuys.appwarung;

import java.util.Scanner;

/**
 * @author shuyshuys
 */

public class cMenuCLI {
    static Scanner sc = new Scanner(System.in);

    public static cMakanan[] makanan;
    public static cMinuman[] minuman;
    static int pilihan;

    public static void menuCLI() {
        do {
            // add.cls();
            System.out.println();
            System.out.println("Selamat Datang " + AppWarung.user);
            System.out.println(add.logTime("Login"));
            mineWriter.writeLog(add.PATH_LOG, "Selamat Datang " + AppWarung.user);
            mineWriter.writeLog(add.PATH_LOG, add.logTime("Login"));
            add.border();
            System.out.println("1. Menu Barang");
            System.out.println("2. Menu Transaksi");
            System.out.println("3. Menu Pelanggan");
            System.out.println("4. Menu Laporan");
            System.out.println("5. Save to File");
            System.out.println("6. Back to Login");
            System.out.println("7. Exit");
            System.out.print("Pilihan : ");
            pilihan = sc.nextInt();
            switch (pilihan) {
                case 1:
                    // add.cls();
                    add.border();
                    System.out.println(" ⁘ Menu Barang");
                    System.out.println("1. Tambah Barang");
                    System.out.println("2. Hapus Barang");
                    System.out.println("3. Ubah Barang");
                    System.out.println("4. Tampilkan Barang");
                    System.out.println("5. Kembali");
                    System.out.print("Pilihan : ");
                    int pilihanBarang = sc.nextInt();
                    switch (pilihanBarang) {
                        case 1:
                            // add.cls();
                            add.border();
                            System.out.println(" ⁘⁘ Tambah Barang");
                            System.out.println("1. Makanan");
                            System.out.println("2. Minuman");
                            System.out.println("3. Kembali");
                            System.out.print("Pilihan : ");
                            int pilihanTambahBarang = sc.nextInt();
                            switch (pilihanTambahBarang) {
                                case 1:
                                    // add.cls();
                                    add.border();
                                    add.addMenu("Makanan");
                                    add.backToMenu();
                                    break;
                                case 2:
                                    // add.cls();
                                    add.border();
                                    add.addMenu("Minuman");
                                    add.backToMenu();
                                    break;
                                case 3:
                                    cMenuCLI.menuCLI();
                                    break;
                            }
                        case 2:
                            // add.cls();
                            add.border();
                            System.out.println(" ⁘⁘ Menu Hapus Barang");
                            System.out.println("1. Makanan");
                            System.out.println("2. Minuman");
                            System.out.println("3. Kembali");
                            System.out.print("Pilihan : ");
                            int pilihanHapusBarang = sc.nextInt();
                            switch (pilihanHapusBarang) {
                                case 1:
                                    // add.cls();
                                    add.border();
                                    add.printMenu("makanan");
                                    add.border();
                                    System.out.println(" ⁘⁘⁘ Menu Hapus Makanan");
                                    System.out.print("Id Makanan\t: ");
                                    int idMakananHapus = sc.nextInt();
                                    boolean found = false;
                                    for (int i = 0; i < add.idxMakanan; i++) {
                                        if (cMenuCLI.makanan[i].getId() == idMakananHapus) {
                                            found = true;
                                            System.out.println(cMenuCLI.makanan[i].ToString());
                                            System.out.print("Apakah anda yakin ingin menghapus? (y/n)  : ");
                                            String jawab = sc.next();
                                            if (jawab.equals("y")) {
                                                cMenuCLI.makanan[i] = cMenuCLI.makanan[add.idxMakanan - 1];
                                                for (int j = 0; j < add.idxMakanan; j++) {
                                                    if (j == add.idxMakanan - 1) {
                                                        cMenuCLI.makanan[j] = null;
                                                    } else {
                                                        cMenuCLI.makanan[j] = cMenuCLI.makanan[j + 1];
                                                    }
                                                }
                                                add.idxMakanan--;
                                                System.out.println("Makanan berhasil dihapus");
                                            } else {
                                                System.out.println("Makanan tidak dihapus");
                                                break;
                                            }
                                            if (!found) {
                                                System.out.println("Makanan tidak ditemukan");
                                            }
                                        }
                                        // else {
                                        // System.out.println("Data makanan kosong");
                                        // }
                                        // break;
                                    }
                                    add.border();
                                    add.backToMenu();
                                    break;
                                case 2:
                                    // add.cls();
                                    add.border();
                                    add.printMenu("minuman");
                                    add.border();
                                    System.out.println(" ⁘⁘⁘ Menu Hapus Minuman");
                                    System.out.print("Id Minuman\t: ");
                                    int idMinumanHapus = sc.nextInt();
                                    boolean found2 = false;
                                    for (int i = 0; i < add.idxMinuman; i++) {
                                        if (cMenuCLI.minuman[i].getId() == idMinumanHapus) {
                                            found2 = true;
                                            System.out.println(cMenuCLI.minuman[i].ToString());
                                            System.out.print("Apakah anda yakin ingin menghapus? (y/n)  : ");
                                            String jawab = sc.next();
                                            if (jawab.equals("y")) {
                                                cMenuCLI.minuman[i] = cMenuCLI.minuman[add.idxMinuman - 1];
                                                for (int j = 0; j < add.idxMinuman; j++) {
                                                    if (j == add.idxMinuman - 1) {
                                                        cMenuCLI.minuman[j] = null;
                                                    } else {
                                                        cMenuCLI.minuman[j] = cMenuCLI.minuman[j + 1];
                                                    }
                                                }
                                                add.idxMinuman--;
                                                System.out.println("Minuman berhasil dihapus");
                                            } else {
                                                System.out.println("Minuman tidak dihapus");
                                                break;
                                            }
                                            if (!found2) {
                                                System.out.println("Minuman tidak ditemukan");
                                            }
                                        }
                                        // else {
                                        // System.out.println("Data minuman kosong");
                                        // }
                                        // break;
                                    }
                                    add.border();
                                    add.backToMenu();
                                    break;
                                case 3:
                                    menuCLI();
                                    break;
                            }
                        case 3:
                            // add.cls();
                            add.border();
                            System.out.println(" ⁘⁘ Menu Ubah Barang");
                            System.out.println("1. Makanan");
                            System.out.println("2. Minuman");
                            System.out.println("3. Spesifik");
                            System.out.println("4. Kembali");
                            System.out.print("Pilihan : ");
                            int pilihanUbahBarang = sc.nextInt();
                            switch (pilihanUbahBarang) {
                                case 1:
                                    // add.cls();
                                    add.border();
                                    add.printMenu("makanan");
                                    add.border();
                                    System.out.println(" ⁘⁘⁘ Menu Ubah Makanan");
                                    System.out.print("Id Makanan\t: ");
                                    int idMakananUbah = sc.nextInt();
                                    boolean found = false;
                                    for (int i = 0; i < add.idxMakanan; i++) {
                                        if (cMenuCLI.makanan[i].getId() == idMakananUbah) {
                                            found = true;
                                            add.border();
                                            System.out.println(cMenuCLI.makanan[i].ToString());
                                            add.border();
                                            System.out.print("Nama Makanan\t: ");
                                            String namaMakananUbah = add.sc().nextLine();
                                            System.out.print("Harga Makanan\t: ");
                                            int hargaMakananUbah = add.sc().nextInt();
                                            System.out.print("Stok Makanan\t: ");
                                            int stokMakananUbah = add.sc().nextInt();
                                            cMenuCLI.makanan[i].setNama(namaMakananUbah);
                                            cMenuCLI.makanan[i].setHarga(hargaMakananUbah);
                                            cMenuCLI.makanan[i].setStok(stokMakananUbah);
                                            System.out.println("Makanan berhasil diubah");
                                        }
                                        // break;
                                    }
                                    if (!found) {
                                        System.out.println("Makanan tidak ditemukan");
                                    }
                                    add.border();
                                    add.backToMenu();
                                    break;
                                case 2:
                                    // add.cls();
                                    add.border();
                                    add.printMenu("minuman");
                                    add.border();
                                    System.out.println(" ⁘⁘⁘ Menu Ubah Minuman");
                                    System.out.print("Id Minuman\t: ");
                                    int idMinumanUbah = sc.nextInt();
                                    boolean found2 = false;
                                    for (int i = 0; i < add.idxMinuman; i++) {
                                        if (cMenuCLI.minuman[i].getId() == idMinumanUbah) {
                                            found2 = true;
                                            add.border();
                                            System.out.println(cMenuCLI.minuman[i].ToString());
                                            add.border();
                                            System.out.print("Nama Minuman\t: ");
                                            String namaMinumanUbah = add.sc().nextLine();
                                            System.out.print("Harga Minuman\t: ");
                                            int hargaMinumanUbah = add.sc().nextInt();
                                            System.out.print("Stok Minuman\t: ");
                                            int stokMinumanUbah = add.sc().nextInt();
                                            cMenuCLI.minuman[i].setNama(namaMinumanUbah);
                                            cMenuCLI.minuman[i].setHarga(hargaMinumanUbah);
                                            cMenuCLI.minuman[i].setStok(stokMinumanUbah);
                                            System.out.println("Minuman berhasil diubah");
                                        }
                                        // break;
                                    }
                                    if (!found2) {
                                        System.out.println("Minuman tidak ditemukan");
                                    }
                                    add.border();
                                    add.backToMenu();
                                    break;
                                case 3:
                                    // add.cls();
                                    add.border();
                                    add.printMenu("makanan");
                                    add.border();
                                    // TODO: custom spesifikmu lo
                                    System.out.println(" ⁘⁘⁘ Menu Ubah Spesifik per setter");
                                    // System.out.print("Id Makanan\t: ");
                                    // int idMakananUbahSpesifik = sc.nextInt();
                                    // boolean found3 = false;
                                    // for (int i = 0; i < add.idxMakanan; i++) {
                                    // if (cMenuCLI.makanan[i].getId() == idMakananUbahSpesifik) {
                                    // found3 = true;
                                    // System.out.println(cMenuCLI.makanan[i].ToString());
                                    // System.out.print("Nama Makanan\t: ");
                                    // String namaMakananUbahSpesifik = sc.next();
                                    // System.out.print("Harga Makanan\t: ");
                                    // int hargaMakananUbahSpesifik = sc.nextInt();
                                    // cMenuCLI.makanan[i].setNama(namaMakananUbahSpesifik);
                                    // cMenuCLI.makanan[i].setHarga(hargaMakananUbahSpesifik);

                                    // System.out.println("Makanan berhasil diubah");
                                    // } else {
                                    // System.out.println("Data makanan kosong");
                                    // }
                                    // // break;
                                    // }
                                    add.border();
                                    add.backToMenu();
                                    break;
                                case 4:
                                    menuCLI();
                                    break;
                            }
                        case 4:
                            // add.cls();
                            add.border();
                            System.out.println(" ⁘⁘ Tampilkan Barang");
                            System.out.println("1. Makanan");
                            System.out.println("2. Minuman");
                            System.out.println("3. Kembali");
                            System.out.print("Pilihan : ");
                            int pilihanTampilBarang = sc.nextInt();
                            switch (pilihanTampilBarang) {
                                case 1:
                                    // add.cls();
                                    add.printMenu("makanan");
                                    add.backToMenu();
                                    break;
                                case 2:
                                    // add.cls();
                                    add.printMenu("minuman");
                                    add.backToMenu();
                                    break;
                                case 3:
                                    menuCLI();
                                    break;
                            }
                        case 5:
                            menuCLI();
                            break;
                    }
                case 2:
                    cTransaksi.Transaksi();
                case 3:
                    // add.cls();
                    add.border();
                    // TODO: set menu atur pelanggan
                    cPelanggan.Pelanggan();
                    break;
                case 4:
                    // add.cls();
                    add.border();
                    // TODO: set menu laporan
                    System.out.println(" ⁘ Menu Laporan");
                    break;
                case 5:
                    // TODO: set writer here
                    break;
                case 6:
                    AppWarung.main(null);
                    break;
                case 7:
                    System.out.println("Terima Kasih Telah Menggunakan Program ini");
                    System.exit(0);
                    break;
            }
        } while (pilihan != 7);
    }
}
