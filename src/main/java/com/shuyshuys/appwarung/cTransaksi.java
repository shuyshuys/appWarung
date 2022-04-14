package com.shuyshuys.appwarung;

/**
 * @author shuyshuys
 */

public class cTransaksi {
    static cPembeli[] pembeli;
    private int jumlahMakanan, jumlahMinuman, idxMaxMakanan, idxMaxMinuman;
    static cMakanan[] tMakanan;
    static cMinuman[] tMinuman;

    static String[][] akumulasi = new String[5][add.getMostMenu()]; // 0 makanan 1 minuman 2 harga 3 jumlah 4
                                                                    // porsiPembeli
    static int idPembeli;
    // private int maxPembelian;

    static int[][] idTransaksi = new int[5][add.idxPembeli + 5];
    static String[] tanggalTransaksi = new String[mineReader.idx_count];
    // private String namaPembeli;
    // private String[] namaBarang = new String[mineReader.idx_count];
    // private int[] hargaBarang = new int[mineReader.idx_count];
    static int[][] porsiMakanan = new int[50][add.getMostMenu()]; // 0 idxmaxpembeli
    static int[][] porsiMinuman = new int[50][add.getMostMenu()]; // 0 idxmaxpembeli
    // private int[] jumlahBarang = new int[mineReader.idx_count];
    static int[] totalHarga = new int[mineReader.idx_count];
    static int bayar;
    static int totalHargaLifeTime;
    // private int[] bayar = new int[mineReader.idx_count];
    static int[] kembalian = new int[mineReader.idx_count];

    // NOTE: constructor untuk reader TODO: kayanya ada yg kurang di setter ny
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

    // TODO: pembayaran

    public void tambahMakanan(cMakanan makanan, int jumlah, int idxPembeli, int idxMakanan) {
        if (jumlahMakanan < idxMaxMakanan) {

            tMakanan[jumlahMakanan] = makanan;
            totalHarga[idxPembeli] = totalHarga[idxPembeli] + makanan.getHarga() * jumlah;

            totalHargaLifeTime = totalHargaLifeTime + totalHarga[idxPembeli];
            akumulasi[0][idxMakanan] = makanan.getNama();
            akumulasi[2][idxMakanan] = Integer.toString(makanan.getHarga());
            akumulasi[3][idxMakanan] = String.valueOf(jumlah); // +akumulasi[3][idxMakanan];
            akumulasi[4][idxPembeli] = String.valueOf(jumlah);

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
            totalHarga[idxPembeli] = totalHarga[idxPembeli] + minuman.getHarga() * jumlah;

            totalHargaLifeTime = totalHargaLifeTime + totalHarga[idxPembeli];
            akumulasi[1][idxMinuman] = minuman.getNama();
            akumulasi[2][idxMinuman] = String.valueOf(minuman.getHarga());
            akumulasi[3][idxMinuman] = String.valueOf(jumlah); // +akumulasi[3][idxMinuman];
            akumulasi[4][idxPembeli] = String.valueOf(jumlah);

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
            for (int i = 0; i < tMakanan.length; i++) {
                System.out.println(tMakanan[i].getNama() + " " + tMakanan[i].getHarga());
            }
            System.out.print("Nama Makanan yang ingin dihapus: ");
            String hapusMakanan = add.sc().nextLine();
            add.border();
            boolean found = false;
            for (int i = 0; i < jumlahMakanan; i++) {
                if (tMakanan[i].getNama().equals(hapusMakanan)) {
                    found = true;
                    totalHarga[idxPembeli] = totalHarga[idxPembeli] - tMakanan[i].getHarga()
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
        }
    }

    public void hapusMinuman(int idxPembeli) {
        if (jumlahMinuman < 0) {
            System.out.println("  ↂ  Minuman kosong...");
        } else {
            add.border();
            // beli.ToString(idxPembeli);
            for (int i = 0; i < tMinuman.length; i++) {
                System.out.println(tMinuman[i].getNama() + " " + tMinuman[i].getHarga());
            }
            // add.border();
            System.out.print("Nama Minuman yang ingin dihapus: ");
            add.border();
            String hapusMinuman = add.sc().nextLine();
            boolean found = false;
            for (int i = 0; i < jumlahMinuman; i++) {
                if (tMinuman[i].getNama().equals(hapusMinuman)) {
                    found = true;
                    totalHarga[idxPembeli] = totalHarga[idxPembeli] - tMinuman[i].getHarga()
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
    // // + akumulasi[3][i]);
    // // }
    // // }
    // // for (int i = 0; i < tMinuman.length; i++) {
    // // if (tMinuman[i] != null) {
    // // System.out.println(" ⁂ Minuman " + tMinuman[i].getNama() + " " +
    // // tMinuman[i].getHarga() + " x "
    // // + akumulasi[3][i]);
    // // }
    // // }
    // " ⁂ Total Harga : " + totalHarga[idxPembeli] + "\n" +
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
        return totalHarga[idxPembeli];
    }

    public void setTotalHarga(int totalHarga, int idxPembeli) {
        cTransaksi.totalHarga[idxPembeli] = totalHarga;
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

    // FIXME: to string
    public void ToString(int idxPembeli) {
        add.border();
        // int idxTransaksi = 0;
        // for (int j = 0; j < add.idxTransaksi; j++) {
        // for (int k = 0; k < akumulasi.length; k++) {
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
        if (idxPembeli == 0) {
            System.out.println("Total Harga\t\t\t\t\t" + totalHarga[idxPembeli]);
        } else {
            int discount = totalHarga[idxPembeli] * 10 / 100;
            System.out.println("\t\t\tDiscount 10% :  " + discount);
            int afterDiscount = totalHarga[idxPembeli] - discount;
            System.out.println("Total Harga\t\t\t\t" + afterDiscount);

        }
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
                    // add.cls();
                    add.border();

                    // TODO: set pembeli belum beres
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
                    cTransaksi.Transaksi();
                    break;
                case 2:
                    add.cls();
                    add.border();
                    System.out.println(" ⁘⁘ Tambah Transaksi");
                    add.border();
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
                        add.border();
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
                        }
                        if (kodeMenu == 1) {
                            add.printMenu("minuman");
                            System.out.print("ID menu: ");
                            idMenu = add.sc().nextInt();
                            idx = add.searchIdxById(idMenu, kodeMenu);
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
                        // akumulasi[3][idx] = String.valueOf(jumlah[idx][kodeMenu]);

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
                    // add.idxTransaksi++; // FIXME: check emang ini dipake ya?
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
                    System.out.println(" ⁘⁘ Hapus Pesanan");
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
                    boolean paidInFull = false;
                    do {
                        add.cls();
                        add.border();
                        System.out.println(" ⁘⁘ Lihat Transaksi");
                        beli.ToString(pilihPembeli - 1);
                        boolean notEnough = false;
                        System.out.println(" ⁘⁘⁘ Bayar");
                        if (notEnough == true) {
                            System.out.println("UANG ANDA KURANG!");
                        }
                        System.out.println("Total Harga\t\t\t\t" + beli.getTotalHarga(pilihPembeli - 1));
                        System.out.print("Bayar\t\t\t\t\t");
                        bayar = add.sc().nextInt();
                        if (bayar >= beli.getTotalHarga(pilihPembeli - 1)) {
                            paidInFull = true;
                            kembalian[pilihPembeli - 1] = bayar - beli.getTotalHarga(pilihPembeli - 1);
                            System.out.println("Kembalian\t\t\t\t" + kembalian[pilihPembeli - 1]);
                        } else {
                            notEnough = true;
                            System.out.println("Uang anda kurang");
                        }
                    } while (paidInFull == false);
                    add.border();
                    mineWriter.writeTransaksi(pilihPembeli - 1);
                    // add.border();
                    // }
                    // beli.ToString(i);
                    // }
                    // System.out.println(cMenuCLI.transaksi[i].ToString());
                    // System.out.println(beli.cetakNota(i));
                    // if (cMenuCLI.transaksi[i] != null) {
                    // add.border();
                    // System.out.println(i);
                    // System.out.println("[Transaksi ke-" + (i + 1) + "] ");
                    // System.out.println(cMenuCLI.transaksi[i].ToString());
                    // add.border();
                    // i++;
                    // }
                    add.border();
                    add.backToMenu();
                    break;
                // System.out.println(" ⁘⁘ Tambah Pesanan");
                // add.border();
                // System.out.print("Pembeli\t: ");
                // int pilihPembeli = add.sc().nextInt();
                // System.out.print("Alamat\t: ");
                // String alamatPembeli = add.sc().next();
                // cMenuCLI.pembeli[add.idxPembeli] = new cPembeli(
                // cMenuCLI.pembeli[add.idxPembeli - 1].getId() + 1,
                // namaPembeli,
                // alamatPembeli);
                // System.out.println("[Pembeli id: " + cMenuCLI.pembeli[0].getId() + " nama: "
                // + cMenuCLI.pembeli[0].getNama() + "] ");
                // break;
                case 5:
                    add.cls();
                    add.border();
                    System.out.println(" ⁘⁘ Hapus Pesanan");
                    add.border();
                    for (int i = 0; i < add.idxTransaksi; i++) {
                        System.out.println("[Transaksi ke-" + (i + 1) + "] ");
                        beli.ToString(i);
                        // System.out.println(print.ToString(i));
                        add.border();
                        // if (cMenuCLI.transaksi[i] != null) {
                        // add.border();
                        // System.out.println(i);
                        // System.out.println("[Transaksi ke-" + (i + 1) + "] ");
                        // System.out.println(cMenuCLI.transaksi[i].ToString());
                        // add.border();
                        // i++;
                        // }
                    }
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
