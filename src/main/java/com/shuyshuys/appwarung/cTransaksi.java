package com.shuyshuys.appwarung;

/**
 * @author shuyshuys
 */

public class cTransaksi {
    static cPembeli[] pembeli;
    private int jumlahMakanan, jumlahMinuman, idxMaxMakanan, idxMaxMinuman;
    static cMakanan[] tMakanan;
    static cMinuman[] tMinuman;

    static String[][] dbTransaksi = new String[5][add.getMostMenu()];

    static int[][] idTransaksi = new int[5][mineReader.idx_count];
    static String[] tanggalTransaksi = new String[mineReader.idx_count];
    static int[][] porsiMakanan = new int[50][add.getMostMenu()]; // 0 idxmaxpembeli
    static int[][] porsiMinuman = new int[50][add.getMostMenu()]; // 0 idxmaxpembeli
    static int totalHarga;// = new int[mineReader.idx_count];
    static int discount;
    static int beforeDiscount;
    static int bayar;
    static int totalHargaLifeTime = 0;
    static int[] kembalian = new int[mineReader.idx_count];

    cTransaksi() {
        idxMaxMakanan = 5;
        idxMaxMinuman = 5;
        jumlahMakanan = 0;
        jumlahMinuman = 0;

        tMakanan = new cMakanan[idxMaxMakanan];
        tMinuman = new cMinuman[idxMaxMinuman];

        System.out.println("  ↂ  Transaksi dibuat...");
    }

    public void isiPembeli(cPembeli pembeli, int idxPembeli) {
        cTransaksi.pembeli[idxPembeli] = pembeli;
        idTransaksi[add.idxTransaksi][idxPembeli] = add.idTransaksi + 1;
        tanggalTransaksi[add.idxTransaksi] = add.getDateTime();
        System.out.println("ID Transaksi\t: " + idTransaksi[add.idxTransaksi][idxPembeli]);

        for (int i = 0; i < tMakanan.length; i++) {
            tMakanan[i] = null;
            tMinuman[i] = null;
        }
        totalHarga = 0;
        discount = 0;
        beforeDiscount = 0;
        bayar = 0;
        for (int i = 0; i < mineReader.idx_count; i++) {
            kembalian[i] = 0;
        }
        jumlahMakanan = 0;
        jumlahMinuman = 0;
        add.idxTransaksi++;
        add.idTransaksi++;
        System.out.println("  ↂ  Nama Pembeli " + cTransaksi.pembeli[idxPembeli].getNama() + " ditambahkan ke Nota...");
    }

    public void tambahMakanan(cMakanan makanan, int jumlah, int idxPembeli, int idxMakanan) {
        if (jumlahMakanan < idxMaxMakanan) {

            tMakanan[jumlahMakanan] = makanan;
            totalHarga = totalHarga + makanan.getHarga() * jumlah;

            dbTransaksi[0][idxMakanan] = Integer.toString(makanan.getHarga() * jumlah); // jumlah harga makanan
            dbTransaksi[2][idxPembeli] = dbTransaksi[2][idxPembeli] + String.valueOf(makanan.getHarga() * jumlah);

            if (idxPembeli == 0) {
                cMenuCLI.laporanPelanggan[idxPembeli] = cMenuCLI.laporanPelanggan[idxPembeli]
                        + makanan.getHarga() * jumlah;
                cMenuCLI.laporanHargaMakanan[idxMakanan] = makanan.getHarga() * jumlah;
            } else {
                cMenuCLI.laporanPelanggan[idxPembeli] = cMenuCLI.laporanPelanggan[idxPembeli]
                        + (makanan.getHarga() * jumlah * 90 / 100);
                cMenuCLI.laporanHargaMakanan[idxMakanan] = makanan.getHarga() * jumlah * 90 / 100;
            }

            porsiMakanan[idxPembeli][idxMakanan] = jumlah;
            jumlahMakanan++;

            System.out.println(
                    "  ↂ  Makanan " + makanan.getNama() + " ditambahkan ke Nota " + pembeli[idxPembeli].getNama()
                            + "...");
            beli.ToString(idxPembeli);
        } else {
            System.out.println("  ↂ  Barang dalam Nota sudah mencapai maksimal...");
        }
    }

    public void tambahMinuman(cMinuman minuman, int jumlah, int idxPembeli, int idxMinuman) {
        if (jumlahMinuman < idxMaxMinuman) {

            tMinuman[jumlahMinuman] = minuman;
            totalHarga = totalHarga + minuman.getHarga() * jumlah;

            dbTransaksi[1][idxMinuman] = String.valueOf(minuman.getHarga() * jumlah);
            dbTransaksi[2][idxPembeli] = String.valueOf(minuman.getHarga() * jumlah);

            if (idxPembeli == 0) {
                cMenuCLI.laporanPelanggan[idxPembeli] = cMenuCLI.laporanPelanggan[idxPembeli]
                        + minuman.getHarga() * jumlah;
                cMenuCLI.laporanHargaMinuman[idxMinuman] = minuman.getHarga() * jumlah;
            } else {
                cMenuCLI.laporanPelanggan[idxPembeli] = cMenuCLI.laporanPelanggan[idxPembeli]
                        + (minuman.getHarga() * jumlah * 90 / 100);
                cMenuCLI.laporanHargaMinuman[idxMinuman] = minuman.getHarga() * jumlah * 90 / 100;
            }

            porsiMinuman[idxPembeli][idxMinuman] = jumlah;
            jumlahMinuman++;

            System.out.println(
                    "  ↂ  Minuman " + minuman.getNama() + " ditambahkan ke Nota " + pembeli[idxPembeli].getNama()
                            + "...");
            beli.ToString(idxPembeli);
        } else {
            System.out.println("  ↂ  Barang dalam Nota sudah mencapai maksimal...");
        }
    }

    public void hapusMakanan(int idxPembeli) {
        if (jumlahMakanan < 0) {
            System.out.println("  ↂ  Makanan kosong...");
        } else {
            add.border();
            for (int i = 0; i < jumlahMakanan; i++) {
                System.out.println(tMakanan[i].getNama() + "\t" + tMakanan[i].getHarga());
            }
            add.border();
            System.out.print("Nama Makanan yang ingin dihapus: ");
            String hapusMakanan = add.sc().nextLine();
            boolean found = false;
            for (int i = 0; i < jumlahMakanan; i++) {
                if (tMakanan[i].getNama().equalsIgnoreCase(hapusMakanan)) {
                    found = true;
                    totalHarga = totalHarga - tMakanan[i].getHarga()
                            * porsiMakanan[idxPembeli][add.searchIdxById(tMakanan[i].getId(), 0)];

                    cMenuCLI.laporanPelanggan[idxPembeli] = cMenuCLI.laporanPelanggan[idxPembeli]
                            - tMakanan[i].getHarga()
                                    * porsiMakanan[idxPembeli][add.searchIdxById(tMakanan[i].getId(), 0)];

                    cMenuCLI.laporanHargaMakanan[add.searchIdxById(tMakanan[i].getId(),
                            0)] = cMenuCLI.laporanHargaMakanan[add.searchIdxById(tMakanan[i].getId(), 0)]
                                    - tMakanan[i].getHarga()
                                            * porsiMakanan[idxPembeli][add.searchIdxById(tMakanan[i].getId(), 0)];

                    tMakanan[i] = null;
                    jumlahMakanan--;
                    for (int j = i; j < jumlahMakanan; j++) {
                        if (j == jumlahMakanan - 1) {
                            tMakanan[j] = null;
                        } else {
                            tMakanan[j] = tMakanan[j + 1];
                        }
                    }
                    System.out.println("  ↂ  Makanan " + hapusMakanan + " dihapus...");
                    break;
                }
            }
            if (!found) {
                System.out.println("  ↂ  Makanan " + hapusMakanan + " tidak ditemukan dalam nota"
                        + pembeli[idxPembeli].getNama() + "...");
            }
            add.sleep();
        }
    }

    public void hapusMinuman(int idxPembeli) {
        if (jumlahMinuman < 0) {
            System.out.println("  ↂ  Minuman kosong...");
        } else {
            add.border();
            for (int i = 0; i < jumlahMinuman; i++) {
                System.out.println(tMinuman[i].getNama() + "\t" + tMinuman[i].getHarga());
            }
            add.border();
            System.out.print("Nama Minuman yang ingin dihapus: ");
            String hapusMinuman = add.sc().nextLine();
            boolean found = false;
            for (int i = 0; i < jumlahMinuman; i++) {
                if (tMinuman[i].getNama().equalsIgnoreCase(hapusMinuman)) {
                    found = true;
                    totalHarga = totalHarga - tMinuman[i].getHarga()
                            * porsiMinuman[idxPembeli][add.searchIdxById(tMinuman[i].getId(), 1)];

                    cMenuCLI.laporanPelanggan[idxPembeli] = cMenuCLI.laporanPelanggan[idxPembeli]
                            - tMinuman[i].getHarga()
                                    * porsiMinuman[idxPembeli][add.searchIdxById(tMinuman[i].getId(), 1)];

                    cMenuCLI.laporanHargaMinuman[add.searchIdxById(tMinuman[i].getId(),
                            1)] = cMenuCLI.laporanHargaMinuman[add.searchIdxById(tMinuman[i].getId(), 1)]
                                    - tMinuman[i].getHarga()
                                            * porsiMinuman[idxPembeli][add.searchIdxById(tMinuman[i].getId(), 1)];

                    tMinuman[i] = null;
                    jumlahMinuman--;
                    for (int j = i; j < jumlahMinuman; j++) {
                        if (j == jumlahMinuman - 1) {
                            tMinuman[j] = null;
                        } else {
                            tMinuman[j] = tMinuman[j + 1];
                        }
                    }
                    System.out.println("  ↂ  Minuman " + hapusMinuman + " dihapus...");
                    break;
                }
            }
            if (!found) {
                System.out.println("  ↂ  Minuman " + hapusMinuman + " tidak ditemukan dalam nota"
                        + pembeli[idxPembeli].getNama() + "...");
            }
            add.sleep();
        }
    }

    public int getIdTransaksi(int idxTransaksi, int idxPembeli) {
        return idTransaksi[idxTransaksi][idxPembeli];
    }

    public void setIdTransaksi(int idxTransaksi, int idTransaksi, int idxPembeli) {
        cTransaksi.idTransaksi[idxTransaksi][idxPembeli] = idTransaksi;
    }

    public cMakanan getMakanan(int i) {
        return tMakanan[i];
    }

    public cMakanan[] getMakananArray() {
        return tMakanan;
    }

    public cMinuman getMinuman(int i) {
        return tMinuman[i];
    }

    public cMinuman[] getMinumanArray() {
        return tMinuman;
    }

    public int getTotalHarga(int idxPembeli) {
        return totalHarga;
    }

    public void setTotalHarga(int totalHarga, int idxPembeli) {
        cTransaksi.totalHarga = totalHarga;
    }

    public int getBayar() {
        return bayar;
    }

    public void setBayar(int bayar) {
        cTransaksi.bayar = bayar;
    }

    public int getKembalian(int idxPembeli) {
        return kembalian[idxPembeli];
    }

    public void setKembalian(int kembalian, int idxPembeli) {
        cTransaksi.kembalian[idxPembeli] = kembalian;
    }

    public String getTanggalTransaksi(int idxPembeli) {
        return tanggalTransaksi[idxPembeli];
    }

    public void setTanggalTransaksi(String tanggalTransaksi, int idxPembeli) {
        cTransaksi.tanggalTransaksi[idxPembeli] = tanggalTransaksi;
    }

    public void ToString(int idxPembeli) {
        add.border();
        System.out.println("ID Transaksi\t: " + idTransaksi[add.idxTransaksi - 1][idxPembeli]);
        System.out.println("Tanggal\t\t: " + tanggalTransaksi[add.idxTransaksi - 1]);
        if (idxPembeli == 0) {
            System.out.println("Nama Pembeli\t: " + pembeli[idxPembeli].getNama());
        } else {
            System.out.println("Nama Pembeli\t: " + pembeli[idxPembeli].getNama() + "  [Member]");
        }

        add.border();
        try {
            for (int i = 0; i < tMakanan.length; i++) {
                if (tMakanan[i] != null) {
                    if (tMakanan[i].getNama().length() < 8) {
                        System.out.println(tMakanan[i].getNama() + "\t\t\t" +
                                tMakanan[i].getHarga() + "\tx"
                                + porsiMakanan[idxPembeli][add.searchIdxById(tMakanan[i].getId(), 0)] + "\t"
                                + (tMakanan[i].getHarga()
                                        * porsiMakanan[idxPembeli][add.searchIdxById(tMakanan[i].getId(), 0)]));
                    } else if (tMakanan[i].getNama().length() < 16) {
                        System.out.println(tMakanan[i].getNama() + "\t\t" +
                                tMakanan[i].getHarga() + "\tx"
                                + porsiMakanan[idxPembeli][add.searchIdxById(tMakanan[i].getId(), 0)] + "\t"
                                + (tMakanan[i].getHarga()
                                        * porsiMakanan[idxPembeli][add.searchIdxById(tMakanan[i].getId(), 0)]));
                    } else {
                        System.out.println(tMakanan[i].getNama() + "\t" +
                                tMakanan[i].getHarga() + "\tx"
                                + porsiMakanan[idxPembeli][add.searchIdxById(tMakanan[i].getId(), 0)] + "\t"
                                + (tMakanan[i].getHarga()
                                        * porsiMakanan[idxPembeli][add.searchIdxById(tMakanan[i].getId(), 0)]));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        try {
            for (int i = 0; i < tMinuman.length; i++) {
                if (tMinuman[i] != null) {
                    if (tMinuman[i].getNama().length() < 8) {
                        System.out.println(tMinuman[i].getNama() + "\t\t\t" + tMinuman[i].getHarga() + "\tx"
                                + porsiMinuman[idxPembeli][add.searchIdxById(tMinuman[i].getId(), 1)] + "\t"
                                + (tMinuman[i].getHarga()
                                        * porsiMinuman[idxPembeli][add.searchIdxById(tMinuman[i].getId(), 1)]));
                    } else if (tMinuman[i].getNama().length() < 16) {
                        System.out.println(tMinuman[i].getNama() + "\t\t" + tMinuman[i].getHarga() + "\tx"
                                + porsiMinuman[idxPembeli][add.searchIdxById(tMinuman[i].getId(), 1)] + "\t"
                                + (tMinuman[i].getHarga()
                                        * porsiMinuman[idxPembeli][add.searchIdxById(tMinuman[i].getId(), 1)]));
                    } else {
                        System.out.println(tMinuman[i].getNama() + "\t" + tMinuman[i].getHarga() + "\tx"
                                + porsiMinuman[idxPembeli][add.searchIdxById(tMinuman[i].getId(), 1)] + "\t"
                                + (tMinuman[i].getHarga()
                                        * porsiMinuman[idxPembeli][add.searchIdxById(tMinuman[i].getId(), 1)]));
                    }
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        add.border();
        System.out.println("Total Harga\t\t\t\t" + totalHarga);
        add.border();
    }

    static int pilihPembeli;
    public static cTransaksi beli = new cTransaksi();
    static int[][] jumlah = new int[add.getMostMenu()][2];

    public static void Transaksi() {
        int pilihanPembelian;
        do {
            add.cls();
            add.border();
            System.out.println(" ⁘ MENU Pembelian");
            System.out.println("1. Tambah Pembeli");
            System.out.println("2. Tambah Pesanan");
            System.out.println("3. Hapus Pesanan");
            System.out.println("4. Tampilkan dan Bayar Pesanan");
            System.out.println("5. Lihat Transaksi");
            System.out.println("6. Hapus Transaksi");
            System.out.println("7. Kembali");
            System.out.print("Pilihan : ");
            pilihanPembelian = add.sc().nextInt();
            switch (pilihanPembelian) {
                case 1:
                    add.cls();
                    add.border();
                    System.out.println(" ⁘⁘ Pilih Pembeli");
                    add.border();
                    System.out.println("\t[list] untuk melihat list member");
                    System.out.print("Nama pembeli baru\t: ");
                    String pilih = add.sc().nextLine();
                    if (pilih.equals("list")) {
                        add.border();
                        add.printPembeli();
                        // add.printPembeli();
                        add.border();
                        System.out.print("Pilih nomor: ");
                        pilihPembeli = add.sc().nextInt();
                        beli.isiPembeli(cTransaksi.pembeli[pilihPembeli - 1], (pilihPembeli - 1));
                    } else {
                        System.out.print("Alamat\t\t\t: ");
                        String alamat = add.sc().nextLine();
                        if (pilih != "" && alamat == "") {
                            cTransaksi.pembeli[add.idxPembeli] = new cPembeli(pilih);
                            beli.isiPembeli(pembeli[add.idxPembeli], add.idxPembeli - 1);
                            add.idxPembeli++;
                            pilihPembeli = add.idxPembeli - 1;
                        } else if (alamat == "" && pilih == "") {
                            // cTransaksi.pembeli = new cPembeli();
                            beli.isiPembeli(pembeli[0], 0);
                            pilihPembeli = 1;
                        } else {
                            cTransaksi.pembeli[add.idxPembeli] = new cPembeli(pilih, alamat);
                            beli.isiPembeli(pembeli[add.idxPembeli], add.idxPembeli - 1);
                            add.idxPembeli++;
                            pilihPembeli = add.idxPembeli - 1;
                        }
                        add.border();
                    }
                    add.sleep();
                    cTransaksi.Transaksi();
                    break;
                case 2:
                    boolean belilagi = false;
                    do {
                        add.cls();
                        add.border();
                        // System.out.println("pilih pembeli: " + pilihPembeli);
                        if (pilihPembeli - 1 == 0) {
                            System.out.println(" ⁘⁘⁘ Tambah Pesanan [" + pembeli[pilihPembeli - 1].getNama() + "]");
                        } else {
                            System.out.println(
                                    " ⁘⁘⁘ Tambah Pesanan [" + pembeli[pilihPembeli - 1].getNama() + "]   [Member]");
                        }
                        System.out.println(
                                "Input Kode Menu\n\t0 untuk makanan\n\t1 untuk minuman\n\t2 untuk pencarian");
                        System.out.print("Kode menu: ");
                        int kodeMenu = add.sc().nextInt();
                        int idMenu;
                        int idx = 0;
                        if (kodeMenu == 0) {
                            add.printMenu("makanan");
                            System.out.print("ID menu: ");
                            idMenu = add.sc().nextInt();
                            idx = add.searchIdxById(idMenu, kodeMenu);
                            if (add.foundIdxMa == false) {
                                System.out.println(
                                        " ⁘⁘⁘ ID Minuman tidak ditemukan!\n  Kembali ke menu transaksi dalam 3s...");
                                add.sleep();
                                cTransaksi.Transaksi();
                            }
                        }
                        if (kodeMenu == 1) {
                            add.printMenu("minuman");
                            System.out.print("ID menu: ");
                            idMenu = add.sc().nextInt();
                            idx = add.searchIdxById(idMenu, kodeMenu);
                            if (add.foundIdxMi == false) {
                                System.out.println(
                                        " ⁘⁘⁘ID Minuman tidak ditemukan!\n  Kembali ke menu transaksi dalam 3s...");
                                add.sleep();
                                cTransaksi.Transaksi();
                            }
                        }
                        if (kodeMenu == 2) {
                            boolean found = false;
                            do {
                                System.out.println(" ⁘⁘⁘ Pencarian");
                                System.out.println("\t[exit] untuk keluar");
                                System.out.print("Cari menu: ");
                                String cari = add.sc().nextLine();
                                if (cari.equals("exit")) {
                                    cTransaksi.Transaksi();
                                }
                                if (found == false) {
                                    cMakanan ketemu = add.searchMakanan(cari);
                                    if (ketemu != null) {
                                        found = true;
                                        kodeMenu = 0;
                                        idx = add.searchIdxById(ketemu.getId(), kodeMenu);
                                    }
                                }
                                if (found == false) {
                                    cMinuman ketemu = add.searchMinuman(cari);
                                    if (ketemu != null) {
                                        found = true;
                                        kodeMenu = 1;
                                        idx = add.searchIdxById(ketemu.getId(), kodeMenu);
                                    }
                                }
                                if (found == false) {
                                    System.out.println("Menu tidak ditemukan");
                                    add.border();
                                }
                            } while (found == false);
                        }
                        System.out.print("Jumlah: ");
                        jumlah[idx][kodeMenu] = add.sc().nextInt();

                        if (kodeMenu == 0) {
                            beli.tambahMakanan(cMenuCLI.makanan[idx], jumlah[idx][kodeMenu], (pilihPembeli - 1), idx);
                            porsiMakanan[pilihPembeli - 1][idx] = jumlah[idx][kodeMenu];
                        }
                        if (kodeMenu == 1) {
                            beli.tambahMinuman(cMenuCLI.minuman[idx], jumlah[idx][kodeMenu], (pilihPembeli - 1), idx);
                            porsiMinuman[pilihPembeli - 1][idx] = jumlah[idx][kodeMenu];
                        }
                        System.out.println("\tTambah Pesanan Lagi? (0 Tidak/1 Ya)");
                        System.out.print("\tPilihan: ");
                        int pilihLagi = add.sc().nextInt();
                        if (pilihLagi == 0) {
                            belilagi = false;
                        } else {
                            belilagi = true;
                        }
                    } while (belilagi == true);
                    add.border();
                    break;
                case 3:
                    add.cls();
                    add.border();
                    System.out.println(" ⁘⁘ Hapus Pesanan  [" + pembeli[pilihPembeli - 1].getNama() + "]");
                    System.out.println("1. Hapus Makanan dari Pesanan");
                    System.out.println("2. Hapus Minuman dari Pesanan");
                    System.out.print("Pilih : ");
                    int pilihMenuHapus = add.sc().nextInt();
                    switch (pilihMenuHapus) {
                        case 1:
                            beli.hapusMakanan(pilihPembeli - 1);
                            break;
                        case 2:
                            beli.hapusMinuman(pilihPembeli - 1);
                            break;
                        default:
                            add.salahInput();
                            break;
                    }
                    break;
                case 4:
                    boolean paidInFull = false;
                    boolean notEnough = false;
                    do {
                        add.cls();
                        add.border();
                        System.out.println(" ⁘⁘ Lihat Transaksi");
                        beli.ToString(pilihPembeli - 1);
                        System.out.println(" ⁘⁘⁘ Bayar");
                        if (notEnough == true) {
                            System.out.println("UANG ANDA KURANG!");
                            notEnough = false;
                        } else {
                            if (pilihPembeli - 1 != 0) {
                                discount = totalHarga * 10 / 100;
                                totalHarga = totalHarga - discount;
                            }
                        }
                        if (pilihPembeli - 1 != 0) {
                            System.out.println("\t\t\tDisc 10% :      " + discount);
                            System.out.println("Total Bayar\t\t\t\t" + totalHarga);
                        } else {
                            System.out.println("Total Bayar\t\t\t\t" + totalHarga);
                        }
                        System.out.print("Bayar\t\t\t\t\t");
                        bayar = add.sc().nextInt();
                        if (bayar >= totalHarga) {
                            paidInFull = true;
                            kembalian[pilihPembeli - 1] = bayar - totalHarga;
                            System.out.println("Kembalian\t\t\t\t" + kembalian[pilihPembeli - 1]);
                        } else {
                            notEnough = true;
                        }
                        add.sleep();
                    } while (paidInFull == false);
                    add.border();
                    mineWriter.writeTransaksi(pilihPembeli - 1);
                    mineWriter.struk(add.PATH_STRUK, pilihPembeli - 1);
                    totalHargaLifeTime = totalHargaLifeTime + totalHarga;
                    add.backToMenu();
                    break;
                case 5:
                    add.cls();
                    add.border();
                    System.out.println(" ⁘⁘ Lihat Transaksi");
                    add.border();
                    System.out.println("Under development");
                    add.backToMenu();
                    break;
                case 6:
                    add.cls();
                    add.border();
                    System.out.println(" ⁘⁘ Hapus Transaksi");
                    System.out.println("Under development");
                    add.border();
                    break;
                case 7:
                    cMenuCLI.menuCLI();
                    break;
                default:
                    add.salahInput();
                    Transaksi();
                    break;
            }
        } while (pilihanPembelian != 6);
    }
}
