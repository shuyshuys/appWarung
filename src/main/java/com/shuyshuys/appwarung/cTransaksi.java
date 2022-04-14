package com.shuyshuys.appwarung;

/**
 * @author shuyshuys
 */

public class cTransaksi {
    static cPembeli[] pembeli;
    private int jumlahMakanan, jumlahMinuman, idxMaxMakanan, idxMaxMinuman;
    static cMakanan[] tMakanan;
    static cMinuman[] tMinuman;

    static String[][] dbTransaksi = new String[5][add.getMostMenu()]; // 0 makanan 1 minuman 2 harga 3 jumlah 4
                                                                      // porsiPembeli

    static int[][] idTransaksi = new int[5][add.idxPembeli + 5];
    static String[] tanggalTransaksi = new String[mineReader.idx_count];
    static int[][] porsiMakanan = new int[50][add.getMostMenu()]; // 0 idxmaxpembeli
    static int[][] porsiMinuman = new int[50][add.getMostMenu()]; // 0 idxmaxpembeli
    static int totalHarga;// = new int[mineReader.idx_count];
    static int discount;
    static int beforeDiscount;
    static int bayar;
    static int totalHargaLifeTime;
    static int[] kembalian = new int[mineReader.idx_count];

    // cTransaksi(int idTransaksi,
    // String namaPembeli,
    // String namaBarang,
    // int hargaBarang,
    // int jumlahBarang,
    // int totalHarga,
    // int bayar,
    // int kembalian,
    // String tanggalTransaksi) {
    // this.idTransaksi = idTransaksi;
    // this.namaPembeli = namaPembeli;
    // this.namaBarang = namaBarang;
    // this.hargaBarang = hargaBarang;
    // this.jumlahBarang = jumlahBarang;
    // this.totalHarga = totalHarga;
    // this.bayar = bayar;
    // this.kembalian = kembalian;
    // this.tanggalTransaksi = tanggalTransaksi;
    // System.out.println(" ⁂ Objek Nota " + namaPembeli + " dibuat...");
    // }

    cTransaksi() {
        idxMaxMakanan = 5;
        idxMaxMinuman = 5;
        jumlahMakanan = 0;
        jumlahMinuman = 0;

        tMakanan = new cMakanan[idxMaxMakanan];
        tMinuman = new cMinuman[idxMaxMinuman];

        System.out.println("  ↂ  Nota dibuat...");
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
        // jumlahMakanan = 0;
        // jumlahMinuman = 0;
        add.idxTransaksi++;
        add.idTransaksi++;
        System.out.println("  ↂ  Nama Pembeli " + cTransaksi.pembeli[idxPembeli].getNama() + " ditambahkan ke Nota...");
    }

    public void tambahMakanan(cMakanan makanan, int jumlah, int idxPembeli, int idxMakanan) {
        if (jumlahMakanan < idxMaxMakanan) {

            tMakanan[jumlahMakanan] = makanan;
            totalHarga = totalHarga + makanan.getHarga() * jumlah;

            totalHargaLifeTime = totalHargaLifeTime + totalHarga;
            dbTransaksi[0][idxMakanan] = makanan.getNama();
            // dbTransaksi[2][idxMakanan] = String.valueOf(jumlah);
            dbTransaksi[1][idxMakanan] = Integer.toString(makanan.getHarga() * jumlah);
            // dbTransaksi[4][idxPembeli] = String.valueOf(jumlah);
            dbTransaksi[4][idxPembeli] = String.valueOf(makanan.getHarga() * jumlah);

            cMenuCLI.laporanHargaMakanan[idxMakanan] = makanan.getHarga() * jumlah;

            porsiMakanan[idxPembeli][idxMakanan] = jumlah; // TODO: ini buat ToString kayanya
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

            totalHargaLifeTime = totalHargaLifeTime + totalHarga;
            dbTransaksi[2][idxMinuman] = minuman.getNama();
            // dbTransaksi[2][idxMinuman] = String.valueOf(jumlah);
            dbTransaksi[3][idxMinuman] = String.valueOf(minuman.getHarga() * jumlah);
            // dbTransaksi[4][idxPembeli] = String.valueOf(jumlah);
            dbTransaksi[4][idxPembeli] = String.valueOf(minuman.getHarga() * jumlah);

            cMenuCLI.laporanHargaMinuman[idxMinuman] = minuman.getHarga() * jumlah;

            porsiMinuman[idxPembeli][idxMinuman] = jumlah; // TODO: ini buat ToString kayanya
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
            // beli.ToString(idxPembeli);
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
            // beli.ToString(idxPembeli);
            for (int i = 0; i < jumlahMinuman; i++) {
                System.out.println(tMinuman[i].getNama() + "\t" + tMinuman[i].getHarga());
            }
            // add.border();
            add.border();
            System.out.print("Nama Minuman yang ingin dihapus: ");
            String hapusMinuman = add.sc().nextLine();
            boolean found = false;
            for (int i = 0; i < jumlahMinuman; i++) {
                if (tMinuman[i].getNama().equalsIgnoreCase(hapusMinuman)) {
                    found = true;
                    totalHarga = totalHarga - tMinuman[i].getHarga()
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

    // public String cetakNota(int idxPembeli) {
    // String nota = " ⁂ Nota " + pembeli[idxPembeli].getNama() + " dicetak..." +
    // "\n" +
    // " ⁂ Tanggal Transaksi : " + tanggalTransaksi + "\n" +
    // " ⁂ Nama Pembeli : " + pembeli[idxPembeli].getNama() + "\n" +
    // // for (int i = 0; i < tMakanan.length; i++) {
    // // if (tMakanan[i] != null) {
    // // System.out.println(" ⁂ Makanan " + tMakanan[i].getNama() + " " +
    // // tMakanan[i].getHarga() + " x "
    // // + dbTransaksi[3][i]);
    // // }
    // // }
    // // for (int i = 0; i < tMinuman.length; i++) {
    // // if (tMinuman[i] != null) {
    // // System.out.println(" ⁂ Minuman " + tMinuman[i].getNama() + " " +
    // // tMinuman[i].getHarga() + " x "
    // // + dbTransaksi[3][i]);
    // // }
    // // }
    // " ⁂ Total Harga : " + totalHarga + "\n" +
    // " ⁂ Kembalian : " + kembalian[idxPembeli];
    // return nota;
    // }

    public int getIdTransaksi(int idxTransaksi, int idxPembeli) {
        return idTransaksi[idxTransaksi][idxPembeli];
    }

    public void setIdTransaksi(int idxTransaksi, int idTransaksi, int idxPembeli) {
        // this.idTransaksi = cMenuCLI.transaksi[add.idxTransaksi - 1].getIdTransaksi()
        // + 1;
        cTransaksi.idTransaksi[idxTransaksi][idxPembeli] = idTransaksi;
    }

    public cMakanan getMakanan(int i) {
        return tMakanan[i];
    }

    public cMinuman[] getMinuman() {
        return tMinuman;
    }
    // public String getNamaPembeli() {
    // return namaPembeli;
    // }

    // public void setNamaPembeli(String namaPembeli) {
    // this.pembeli = namaPembeli;
    // }

    // public String getNamaBarang(int idxPembeli) {
    // return namaBarang[idxPembeli];
    // }

    // public void setNamaBarang(String namaBarang, int idxPembeli) {
    // this.namaBarang[idxPembeli] = namaBarang;
    // }

    // public int getHargaBarang(int idxPembeli) {
    // return hargaBarang[idxPembeli];
    // }

    // public void setHargaBarang(int hargaBarang, int idxPembeli) {
    // this.hargaBarang[idxPembeli] = hargaBarang;
    // }

    // public int getJumlahBarang(int idxPembeli) {
    // return jumlahBarang[idxPembeli];
    // }

    // public void setJumlahBarang(int jumlahBarang, int idxPembeli) {
    // this.jumlahBarang[idxPembeli] = jumlahBarang;
    // }

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
        // int idxTransaksi = 0;
        // for (int j = 0; j < add.idxTransaksi; j++) {
        // for (int k = 0; k < dbTransaksi.length; k++) {
        // if (idTransaksi[j][idxPembeli] != null) {
        System.out.println("ID Transaksi\t: " + idTransaksi[add.idxTransaksi - 1][idxPembeli]);
        // idxTransaksi = j;
        // }
        // }
        // }
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
        }
        add.border();
        System.out.println("Total Harga\t\t\t\t" + totalHarga);

        // System.out.println("Bayar\t\t: " + bayar[idxPembeli]);
        // System.out.println("Kembalian\t: " + kembalian[idxPembeli]);
        add.border();
    }

    // public String ToString(int idxPembeli) {
    // return "Id Transaksi\t\t: " + idTransaksi + "\n" +
    // "Tanggal Transaksi\t: " + tanggalTransaksi[idxPembeli] + "\n" +
    // "Nama Pembeli\t\t: " + namaPembeli + "\n" +
    // "Nama Makanan\t\t: " + tMakanan[idxPembeli] + "\n" +
    // "Harga Barang\t\t: " + hargaBarang[idxPembeli] + "\n" +
    // "Jumlah Barang\t\t: " + jumlahBarang[idxPembeli] + "\n" +
    // "Total Harga\t\t: " + totalHarga[idxPembeli] + "\n" +
    // "Kembalian\t\t: " + kembalian[idxPembeli];
    // }

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
            System.out.println("4. Tampilkan Pesanan");
            System.out.println("5. Hapus Pesanan");
            System.out.println("6. Kembali");
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
                            cTransaksi.pembeli[0] = new cPembeli();
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
                                System.out.print("\t[exit] untuk keluar");
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
                        // dbTransaksi[3][idx] = String.valueOf(jumlah[idx][kodeMenu]);

                        if (kodeMenu == 0) {
                            beli.tambahMakanan(cMenuCLI.makanan[idx], jumlah[idx][kodeMenu], (pilihPembeli - 1), idx);
                            porsiMakanan[pilihPembeli - 1][idx] = jumlah[idx][kodeMenu];
                            // System.out.println("Pesanan ditambahkan");
                        }
                        if (kodeMenu == 1) {
                            beli.tambahMinuman(cMenuCLI.minuman[idx], jumlah[idx][kodeMenu], (pilihPembeli - 1), idx);
                            porsiMinuman[pilihPembeli - 1][idx] = jumlah[idx][kodeMenu];
                            // System.out.println("Pesanan ditambahkan");
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
                // add.border();
                // cTransaksi.pembeli.setNama(pilihPembeli);
                // add.printMenu("makanan");
                // add.printMenu("minuman");
                // add.border();
                // System.out.print("Pilih Id Menu : ");
                // int idMenu = add.sc().nextInt();
                // add.border();
                // System.out.print("Jumlah Pesanan : ");
                // int jumlahPesanan = add.sc().nextInt();
                // add.border();
                // cMenuCLI.transaksi[add.idxTransaksi] = new cTransaksi(
                // cMenuCLI.transaksi[add.idxTransaksi - 1].getIdTransaksi() + 1,
                // cMenuCLI.pembeli[idPembeli - 1].getNama(),
                // cMenuCLI.makanan[idMenu - 1].getNama(),
                // cMenuCLI.makanan[idMenu - 1].getHarga(),
                // jumlahPesanan,
                // cMenuCLI.makanan[idMenu - 1].getHarga() * jumlahPesanan);

                // System.out.println(cMenuCLI.makanan);
                // add.border();
                // add.backToMenu();
                // break;
                // cTransaksi transaksi = new cTransaksi();
                // if (pilih > 0 && pilih <= add.idxPembeli) {
                // add.border();
                // System.out.println(cMenuCLI.pembeli[pilih - 1].ToString());
                // add.border();
                // } else {
                // add.salahInput();
                // }
                // switch (pilih) {
                // case 1:
                // break;
                // case 2:
                // break;
                // default:
                // add.salahInput();
                // break;
                // }
                // add.backToMenu();
                // break;
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
                    // add.cls();
                    // bug gaes :)
                    // for (int i = 0; i < add.idxTransaksi; i++) {
                    // String temp = beli[i].getMakanan().getNama();
                    // if (beli[i].getMakanan(i) != null) {
                    // System.out.println("[Transaksi ke-" + (i + 1) + "] ");
                    if (tMakanan[0] == null && tMinuman[0] == null) {
                        add.border();
                        System.out.println("Belum mengisi pesanan!");
                        add.border();
                        add.sleep();
                        cTransaksi.Transaksi();
                    }
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
                    add.border();
                    add.backToMenu();
                    break;
                case 5:
                    add.cls();
                    add.border();
                    System.out.println(" ⁘⁘ Hapus Transaksi");
                    add.border();
                    System.out.println("Under development");
                    // for (int i = 0; i < add.idxTransaksi; i++) {
                    // System.out.println("[Transaksi ke-" + (i + 1) + "] ");
                    // beli.ToString(i);
                    // // System.out.println(print.ToString(i));
                    // add.border();
                    // // if (cMenuCLI.transaksi[i] != null) {
                    // // add.border();
                    // // System.out.println(i);
                    // // System.out.println("[Transaksi ke-" + (i + 1) + "] ");
                    // // System.out.println(cMenuCLI.transaksi[i].ToString());
                    // // add.border();
                    // // i++;
                    // // }
                    // }
                    add.backToMenu();
                    break;
                case 6:
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
