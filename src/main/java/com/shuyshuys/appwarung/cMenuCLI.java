package com.shuyshuys.appwarung;

// import java.util.Arrays;
import java.util.Scanner;

// import com.mysql.cj.x.protobuf.MysqlxDatatypes.Array;

/**
 * @author shuyshuys
 */

public class cMenuCLI {
    static Scanner sc = new Scanner(System.in);

    public static cMakanan[] makanan;
    public static cMinuman[] minuman;
    static int pilihan;
    static boolean found = false;

    static int[] laporanHargaMakanan;
    static int[] laporanHargaMinuman;
    static int[] laporanPelanggan;

    public static void menuCLI() {
        do {
            add.cls();
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
            System.out.println("5. Back to Login");
            System.out.println("6. Exit");
            System.out.print("Pilihan : ");
            pilihan = sc.nextInt();
            switch (pilihan) {
                case 1:
                    add.cls();
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
                            add.cls();
                            add.border();
                            System.out.println(" ⁘⁘ Tambah Barang");
                            System.out.println("1. Makanan");
                            System.out.println("2. Minuman");
                            System.out.println("3. Kembali");
                            System.out.print("Pilihan : ");
                            int pilihanTambahBarang = sc.nextInt();
                            switch (pilihanTambahBarang) {
                                case 1:
                                    add.cls();
                                    add.border();
                                    add.addMenu("Makanan");
                                    mineWriter.clean(add.PATH_MAKANAN);
                                    add.refreshDbMakanan();
                                    add.backToMenu();
                                    break;
                                case 2:
                                    add.cls();
                                    add.border();
                                    add.addMenu("Minuman");
                                    mineWriter.clean(add.PATH_MINUMAN);
                                    add.refreshDbMinuman();
                                    add.backToMenu();
                                    break;
                                case 3:
                                    cMenuCLI.menuCLI();
                                    break;
                            }
                        case 2:
                            add.cls();
                            add.border();
                            System.out.println(" ⁘⁘ Menu Hapus Barang");
                            System.out.println("1. Makanan");
                            System.out.println("2. Minuman");
                            System.out.println("3. Kembali");
                            System.out.print("Pilihan : ");
                            int pilihanHapusBarang = sc.nextInt();
                            switch (pilihanHapusBarang) {
                                case 1:
                                    add.cls();
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
                                                // cMenuCLI.makanan[i] = cMenuCLI.makanan[add.idxMakanan - 1];
                                                for (int j = i; j < add.idxMakanan; j++) {
                                                    if (j == add.idxMakanan - 1) {
                                                        cMenuCLI.makanan[j] = null;
                                                    } else {
                                                        cMenuCLI.makanan[j] = cMenuCLI.makanan[j + 1];
                                                    }
                                                }
                                                add.idxMakanan--;
                                                mineWriter.clean(add.PATH_MAKANAN);
                                                add.refreshDbMakanan();
                                                System.out.println("  ⁂ Makanan berhasil dihapus");
                                            } else {
                                                System.out.println("  ⁂ Makanan tidak dihapus");
                                                break;
                                            }
                                            if (!found) {
                                                System.out.println("  ⁂ Makanan tidak ditemukan");
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
                                    add.cls();
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
                                                // cMenuCLI.minuman[i] = cMenuCLI.minuman[add.idxMinuman - 1];
                                                for (int j = i; j < add.idxMinuman; j++) {
                                                    if (j == add.idxMinuman - 1) {
                                                        cMenuCLI.minuman[j] = null;
                                                    } else {
                                                        cMenuCLI.minuman[j] = cMenuCLI.minuman[j + 1];
                                                    }
                                                }
                                                add.idxMinuman--;
                                                mineWriter.clean(add.PATH_MINUMAN);
                                                add.refreshDbMinuman();
                                                System.out.println("  ⁂ Minuman berhasil dihapus");
                                            } else {
                                                System.out.println("  ⁂ Minuman tidak dihapus");
                                                break;
                                            }
                                            if (!found2) {
                                                System.out.println("  ⁂ Minuman tidak ditemukan");
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
                            add.cls();
                            add.border();
                            System.out.println(" ⁘⁘ Menu Ubah Barang");
                            System.out.println("1. Makanan");
                            System.out.println("2. Minuman");
                            System.out.println("3. Kembali");
                            System.out.print("Pilihan : ");
                            int pilihanUbahBarang = sc.nextInt();
                            switch (pilihanUbahBarang) {
                                case 1:
                                    add.cls();
                                    add.printMenu("makanan");
                                    System.out.println(" ⁘⁘⁘ Menu Ubah Makanan");
                                    System.out.print("Id Makanan\t: ");
                                    int idMakananUbah = sc.nextInt();
                                    found = false;
                                    for (int i = 0; i < add.idxMakanan; i++) {
                                        if (cMenuCLI.makanan[i].getId() == idMakananUbah) {
                                            found = true;
                                            add.border();
                                            System.out.println(cMenuCLI.makanan[i].ToString());
                                            add.border();
                                            System.out.print("Apakah anda yakin ingin ubah? (y/n)  : ");
                                            String jawab = sc.next();
                                            if (jawab.equals("y")) {
                                                System.out.print("Nama Makanan\t: ");
                                                String namaMakananUbah = add.sc().nextLine();
                                                System.out.print("Harga Makanan\t: ");
                                                int hargaMakananUbah = add.sc().nextInt();
                                                cMenuCLI.makanan[i].setNama(namaMakananUbah);
                                                cMenuCLI.makanan[i].setHarga(hargaMakananUbah);
                                                mineWriter.clean(add.PATH_MAKANAN);
                                                add.refreshDbMakanan();
                                                System.out.println("  ⁂ Makanan berhasil diubah");
                                            } else {
                                                System.out.println("  ⁂ Makanan tidak diubah");
                                                break;
                                            }
                                        }
                                    }
                                    if (!found) {
                                        System.out.println("  ⁂ Makanan tidak ditemukan");
                                    }
                                    add.border();
                                    add.backToMenu();
                                    break;
                                case 2:
                                    add.cls();
                                    add.border();
                                    add.printMenu("minuman");
                                    add.border();
                                    System.out.println(" ⁘⁘⁘ Menu Ubah Minuman");
                                    System.out.print("Id Minuman\t: ");
                                    int idMinumanUbah = sc.nextInt();
                                    found = false;
                                    for (int i = 0; i < add.idxMinuman; i++) {
                                        if (cMenuCLI.minuman[i].getId() == idMinumanUbah) {
                                            found = true;
                                            add.border();
                                            System.out.println(cMenuCLI.minuman[i].ToString());
                                            add.border();
                                            System.out.print("Apakah anda yakin ingin menghapus? (y/n)  : ");
                                            String jawab = sc.next();
                                            if (jawab.equalsIgnoreCase("y")) {
                                                System.out.print("Nama Minuman\t: ");
                                                String namaMinumanUbah = add.sc().nextLine();
                                                System.out.print("Harga Minuman\t: ");
                                                int hargaMinumanUbah = add.sc().nextInt();
                                                cMenuCLI.minuman[i].setNama(namaMinumanUbah);
                                                cMenuCLI.minuman[i].setHarga(hargaMinumanUbah);
                                                mineWriter.clean(add.PATH_MINUMAN);
                                                add.refreshDbMinuman();
                                                System.out.println("  ⁂ Minuman berhasil diubah");
                                            } else {
                                                System.out.println("  ⁂ Minuman tidak diubah");
                                                break;
                                            }
                                        }
                                        // break;
                                    }
                                    if (!found) {
                                        System.out.println("  ⁂ Minuman tidak ditemukan");
                                    }
                                    add.border();
                                    add.backToMenu();
                                    break;
                                case 3:
                                    menuCLI();
                                    break;
                            }
                        case 4:
                            add.cls();
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
                    add.cls();
                    cPelanggan.Pelanggan();
                    break;
                case 4:
                    add.cls();
                    add.border();
                    System.out.println(" ⁘ Menu Laporan");
                    System.out.println("1. Laporan Pendapatan");
                    System.out.println("2. Laporan Pelanggan");
                    System.out.println("3. Kembali");
                    System.out.print("Pilihan : ");
                    int pilihLaporan = add.sc().nextInt();
                    switch (pilihLaporan) {
                        case 1:
                            add.cls();
                            add.border();
                            System.out.println(" ⁘⁘ Menu Laporan Pendapatan");
                            add.border();
                            // String[] sortlaporanHargaMakanan = new String[add.idxMakanan];
                            String[] laporanNamaMakanan = new String[add.idxMakanan];
                            String[] laporanNamaMinuman = new String[add.idxMinuman];
                            for (int i = 0; i < add.idxMakanan; i++) {
                                laporanNamaMakanan[i] = cMenuCLI.makanan[i].getNama();
                            }
                            for (int i = 0; i < add.idxMinuman; i++) {
                                laporanNamaMinuman[i] = cMenuCLI.minuman[i].getNama();
                            }

                            // System.out.println("Laporan nama makanan: " +
                            // Arrays.toString(laporanNamaMakanan));
                            // add.border();
                            // System.out.println("Laporan nama minuman: " +
                            // Arrays.toString(laporanNamaMinuman));

                            String[] combinedBarang = new String[add.idxMakanan + add.idxMinuman];
                            int idx = 0;
                            for (String nama : laporanNamaMakanan) {
                                combinedBarang[idx] = nama;
                                idx++;
                            }
                            for (String nama : laporanNamaMinuman) {
                                combinedBarang[idx] = nama;
                                idx++;
                            }

                            // add.border();
                            // System.out.println("Combined arrays barang: " +
                            // Arrays.toString(combinedBarang));
                            // String[][] laporanMakanan = add.sort(laporanNamaMakanan,
                            // laporanHargaMakanan);
                            // String[][] laporanMinuman = add.sort(laporanNamaMinuman,
                            // laporanHargaMinuman);

                            // System.out.println("Laporan makanan: " + Arrays.toString(laporanMakanan));
                            // System.out.println("Laporan minuman: " + Arrays.toString(laporanMinuman));

                            int[] combinedHarga = new int[add.idxMakanan + add.idxMinuman];
                            idx = 0;
                            for (int harga : laporanHargaMakanan) {
                                combinedHarga[idx] = harga;
                                idx++;
                            }
                            for (int harga : laporanHargaMinuman) {
                                combinedHarga[idx] = harga;
                                idx++;
                            }
                            // add.border();
                            // System.out.println("Combined arrays harga: " +
                            // Arrays.toString(combinedHarga));
                            // add.border();
                            add.sort(combinedBarang, combinedHarga);

                            System.out.println("\t\t" + add.getDate());
                            System.out.println("\tTotal Pendapatan: " + cTransaksi.totalHargaLifeTime);
                            add.border();
                            for (int i = 0; i < add.idxMakanan; i++) {
                                if (combinedHarga[i] != 0) {
                                    if (combinedBarang[i].length() < 8) {
                                        System.out.println(
                                                combinedBarang[i] + "\t\t\t" +
                                                        combinedHarga[i]);
                                    } else if (combinedBarang[i].length() < 16) {
                                        System.out.println(
                                                combinedBarang[i] + "\t\t" +
                                                        combinedHarga[i]);
                                    } else {
                                        System.out.println(
                                                combinedBarang[i] + "\t" +
                                                        combinedHarga[i]);
                                    }
                                }
                            }
                            // for (int i = 0; i < add.idxMinuman; i++) {
                            // if (combinedHarga < 8) {
                            // if (laporanHargaMinuman[i] != 0) {
                            // System.out.println(
                            // cMenuCLI.minuman[i].getNama() + "\t\t" +
                            // laporanHargaMinuman[i]);
                            // }
                            // } else {
                            // System.out.println(
                            // cMenuCLI.minuman[i].getNama() + "\t" +
                            // laporanHargaMinuman[i]);
                            // }
                            // }
                            add.backToMenu();
                            break;
                        case 2:
                            add.cls();
                            add.border();
                            // FIXME: non pelanggan null, cek lainnya [I@ apa ga

                            System.out.println(" ⁘⁘ Menu Laporan Pelanggan");
                            add.border();
                            System.out.println("\t\t" + add.getDate());
                            // System.out.println("1. "+cTransaksi.pembeli[o]);
                            for (int i = 1; i < add.idxPembeli; i++) {
                                if (cMenuCLI.laporanPelanggan[i] != 0) {
                                    if (cTransaksi.pembeli[i].getNama().length() < 13) {
                                        System.out.println(
                                                "\t" + cTransaksi.pembeli[i].getNama() + "\t\t\t"
                                                        + cMenuCLI.laporanPelanggan[i]);
                                    } else {
                                        System.out.println(
                                                "\t" + cTransaksi.pembeli[i].getNama() + "\t\t"
                                                        + cMenuCLI.laporanPelanggan[i]);
                                    }
                                }
                            }
                            if (cMenuCLI.laporanPelanggan[0] != 0) {
                                System.out.println(
                                        "\t" + cTransaksi.pembeli[0].getNama() + "\t\t"
                                                + cMenuCLI.laporanPelanggan[0]);
                            }
                            add.backToMenu();
                            break;
                        case 3:
                            menuCLI();
                            break;
                        default:
                            add.salahInput();
                            break;
                    }
                    break;
                case 5:
                    AppWarung.main(null);
                    break;
                case 6:
                    add.border();
                    System.out.println("- Terima Kasih Telah Menggunakan Program ini -");
                    add.border();
                    System.exit(0);
                    break;
            }
        } while (pilihan != 7);
    }
}
