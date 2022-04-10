package com.shuyshuys.appwarung;

/**
 * @author shuyshuys
 */

public class cTransaksi {
    public static cPembeli[] pembeli;
    private int jumlahMakanan, jumlahMinuman, idxMaxMakanan, idxMaxMinuman;
    cMakanan tMakanan[];
    cMinuman tMinuman[];

    static int getMostMenu() {
        int mostMenu;
        if (add.idxMakanan > add.idxMinuman) {
            mostMenu = add.idxMakanan + 5;
        } else {
            mostMenu = add.idxMinuman + 5;
        }
        return mostMenu;
    }

    static String[][] akumulasi = new String[5][getMostMenu()]; // 0 makanan 1 minuman 2 harga 3 jumlah 4 porsiPembeli
    static int idPembeli;
    // private int maxPembelian;

    private int[] idTransaksi = new int[mineReader.idx_count];
    // private String namaPembeli;
    // private String[] namaBarang = new String[mineReader.idx_count];
    // private int[] hargaBarang = new int[mineReader.idx_count];
    private static int[][] porsiMakanan = new int[50][getMostMenu()]; // 0 idxmaxpembeli
    private static int[][] porsiMinuman = new int[50][getMostMenu()]; // 0 idxmaxpembeli
    // private int[] jumlahBarang = new int[mineReader.idx_count];
    private static int[] totalHarga = new int[mineReader.idx_count];
    private int totalHargaLifeTime;
    private int[] bayar = new int[mineReader.idx_count];
    private static int[] kembalian = new int[mineReader.idx_count];
    private String[] tanggalTransaksi = new String[mineReader.idx_count];

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
        jumlahMakanan = 0; // TODO: pake array
        jumlahMinuman = 0;
        tMakanan = new cMakanan[idxMaxMakanan];
        tMinuman = new cMinuman[idxMaxMinuman];
        tanggalTransaksi[add.idxTransaksi] = add.getDate();
        add.idTransaksi++;
        System.out.println("  ⁂ Objek Nota dibuat...");
    }

    public void isiPembeli(cPembeli pembeli, int idxPembeli) {
        cTransaksi.pembeli[idxPembeli] = pembeli;
        System.out.println("  ⁂ Nama Pembeli " + cTransaksi.pembeli[idxPembeli].getNama() + " ditambahkan ke Nota...");
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
            // System.out.println("Akumulasi 3 idxMakanan: " + akumulasi[3][idxMakanan]);
            // System.out.println("Akumulasi 4 idxPembeli: " + akumulasi[4][idxPembeli]);
            // System.out.println("idxMakanan: " + idxMakanan);
            // System.out.println("idxPembeli: " + idxPembeli);
            tanggalTransaksi[idxPembeli] = add.getDateTime();
            idTransaksi[idxPembeli] = add.idTransaksi + 1;
            porsiMakanan[idxPembeli][idxMakanan] = jumlah;
            jumlahMakanan++;
            System.out.println(
                    "  ⁂ Makanan " + makanan.getNama() + " ditambahkan ke Nota " + pembeli[idxPembeli].getNama()
                            + "...");
            beli.ToString(idxPembeli);
        } else {
            System.out.println("  ⁂ Jumlah Makanan sudah mencapai maksimal...");
        }
    }

    public void tambahMinuman(cMinuman minuman, int jumlah, int idxPembeli, int idxMinuman) {
        if (jumlahMinuman < idxMaxMinuman) {
            tMinuman[jumlahMinuman] = minuman;
            totalHarga[idxPembeli] = totalHarga[idxPembeli] + minuman.getHarga() * jumlah;
            totalHargaLifeTime = totalHargaLifeTime + totalHarga[idxPembeli];
            akumulasi[1][idxMinuman] = minuman.getNama();
            akumulasi[2][idxMinuman] = String.valueOf(minuman.getHarga());
            jumlahMinuman++;
            System.out.println(
                    "  ⁂ Objek Minuman " + minuman.getNama() + " ditambahkan ke Nota " + pembeli[idxPembeli].getNama()
                            + "...");
        } else {
            System.out.println("  ⁂ Jumlah Minuman sudah mencapai maksimal...");
        }
    }

    public void hapusMakanan(int idxPembeli) {
        if (jumlahMakanan < 0) {
            System.out.println("  ⁂ Makanan kosong...");
        } else {
            add.border();
            for (int i = 0; i < tMakanan.length; i++) {
                System.out.println(tMakanan[i].getNama() + " " + tMakanan[i].getHarga());
            }
            add.border();
            System.out.print("Makanan yang dihapus: ");
            String hapusMakanan = add.sc().nextLine();
            boolean found = false;
            for (int i = 0; i < jumlahMakanan; i++) {
                if (tMakanan[i].getNama().equals(hapusMakanan)) {
                    found = true;
                    totalHarga[idxPembeli] = totalHarga[idxPembeli] - tMakanan[i].getHarga();
                    tMakanan[i] = null;
                    jumlahMakanan--;
                    for (int j = i; j < jumlahMakanan; j++) {
                        if (j == jumlahMakanan - 1) {
                            tMakanan[j] = null;
                        } else {
                            tMakanan[j] = tMakanan[j + 1];
                        }
                    }
                    System.out.println("  ⁂ Makanan " + hapusMakanan + " dihapus...");
                    break;
                }
            }
            if (!found) {
                System.out.println("  ⁂ Makanan " + hapusMakanan + " tidak ditemukan dalam nota...");
            }
        }
    }

    public void hapusMinuman(int idxPembeli) {
        if (jumlahMinuman < 0) {
            System.out.println("  ⁂ Minuman kosong...");
        } else {
            add.border();
            for (int i = 0; i < tMinuman.length; i++) {
                System.out.println(tMinuman[i].getNama() + " " + tMinuman[i].getHarga());
            }
            add.border();
            System.out.print("Minuman yang dihapus: ");
            String hapusMinuman = add.sc().nextLine();
            boolean found = false;
            for (int i = 0; i < jumlahMinuman; i++) {
                if (tMinuman[i].getNama().equals(hapusMinuman)) {
                    found = true;
                    totalHarga[idxPembeli] = totalHarga[idxPembeli] - tMinuman[i].getHarga();
                    tMinuman[i] = null;
                    jumlahMinuman--;
                    for (int j = i; j < jumlahMinuman; j++) {
                        if (j == jumlahMinuman - 1) {
                            tMinuman[j] = null;
                        } else {
                            tMinuman[j] = tMinuman[j + 1];
                        }
                    }
                    System.out.println("  ⁂ Minuman " + hapusMinuman + " dihapus...");
                    break;
                }
            }
            if (!found) {
                System.out.println("  ⁂ Minuman " + hapusMinuman + " tidak ditemukan dalam nota...");
            }
        }
    }

    public String cetakNota(int idxPembeli) {
        String nota = "  ⁂ Nota " + pembeli[idxPembeli].getNama() + " dicetak..." + "\n" +
                "  ⁂ Tanggal Transaksi : " + tanggalTransaksi + "\n" +
                "  ⁂ Nama Pembeli : " + pembeli[idxPembeli].getNama() + "\n" +
                // for (int i = 0; i < tMakanan.length; i++) {
                // if (tMakanan[i] != null) {
                // System.out.println(" ⁂ Makanan " + tMakanan[i].getNama() + " " +
                // tMakanan[i].getHarga() + " x "
                // + akumulasi[3][i]);
                // }
                // }
                // for (int i = 0; i < tMinuman.length; i++) {
                // if (tMinuman[i] != null) {
                // System.out.println(" ⁂ Minuman " + tMinuman[i].getNama() + " " +
                // tMinuman[i].getHarga() + " x "
                // + akumulasi[3][i]);
                // }
                // }
                "  ⁂ Total Harga : " + totalHarga[idxPembeli] + "\n" +
                "  ⁂ Kembalian : " + kembalian[idxPembeli];
        return nota;
    }

    public int getIdTransaksi(int idxPembeli) {
        return idTransaksi[idxPembeli];
    }

    public void setIdTransaksi(int idTransaksi, int idxPembeli) {
        // this.idTransaksi = cMenuCLI.transaksi[add.idxTransaksi - 1].getIdTransaksi()
        // + 1;
        this.idTransaksi[idxPembeli] = idTransaksi;
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

    public int getBayar(int idxPembeli) {
        return bayar[idxPembeli];
    }

    public void setBayar(int bayar, int idxPembeli) {
        this.bayar[idxPembeli] = bayar;
    }

    public int getKembalian(int idxPembeli) {
        return kembalian[idxPembeli];
    }

    public void setKembalian(int kembalian, int idxPembeli) {
        this.kembalian[idxPembeli] = kembalian;
    }

    public String getTanggalTransaksi(int idxPembeli) {
        return tanggalTransaksi[idxPembeli];
    }

    public void setTanggalTransaksi(String tanggalTransaksi, int idxPembeli) {
        this.tanggalTransaksi[idxPembeli] = tanggalTransaksi;
    }

    public void ToString(int idxPembeli) {
        add.border();
        add.border();
        System.out.println("ID Transaksi\t: " + idTransaksi[idxPembeli]);
        // TODO: mungkin dijadikan 2d array biar dibedakan jam dan tanggal
        System.out.println("Tanggal\t\t: " + tanggalTransaksi[idxPembeli]);
        System.out.println("Nama Pembeli\t: " + pembeli[idxPembeli].getNama());
        add.border();
        try {
            for (int i = 0; i < tMakanan.length; i++) {
                if (tMakanan[i] != null) {
                    // System.out.println("Nama Makanan\t: " + tMakanan[i].getNama());
                    // System.out.println("Harga Makanan\t: " + tMakanan[i].getHarga());

                    // System.out.println(
                    // "Jumlah Makanan\t: " +
                    // porsiMakanan[idxPembeli][add.searchById(tMakanan[i].getId(), 0)]);
                    System.out.println(tMakanan[i].getNama() + "\t" + tMakanan[i].getHarga() + "\tx"
                            + porsiMakanan[idxPembeli][add.searchById(tMakanan[i].getId(), 0)] + "\t"
                            + (tMakanan[i].getHarga()
                                    * porsiMakanan[idxPembeli][add.searchById(tMakanan[i].getId(), 0)]));
                }
            }
        } catch (Exception e) {
        }
        try {
            for (int i = 0; i < tMinuman.length; i++) {
                if (tMinuman[i] != null) {
                    // System.out.println("Nama Minuman\t: " + tMinuman[i].getNama());
                    // System.out.println("Harga Minuman\t: " + tMinuman[i].getHarga());
                    // System.out.println(
                    // "Jumlah Minuman\t: " + porsiMinuman[idxPembeli]);// +
                    // // porsiPembeli[idxPembeli][add.searchById(tMinuman[i].getId(),
                    // // 1)]);
                    System.out.println(tMinuman[i].getNama() + "\t" + tMinuman[i].getHarga() + "\tx"
                            + porsiMinuman[idxPembeli][add.searchById(tMinuman[i].getId(), 1)] + "\t"
                            + (tMinuman[i].getHarga()
                                    * porsiMinuman[idxPembeli][add.searchById(tMinuman[i].getId(), 1)]));
                }
            }
        } catch (Exception e) {
        }
        add.border();
        System.out.println("Total Harga\t\t\t" + totalHarga[idxPembeli]);
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
    // static int[][] porsiPembeli;
    public static cTransaksi beli = new cTransaksi();

    public static void Transaksi() {
        int pilihanPembelian;
        do {
            // add.cls();
            add.border();
            System.out.println(" ⁘ MENU Pembelian");
            System.out.println("1. Tambah Pesanan");
            System.out.println("2. Tampilkan Pesanan");
            System.out.println("3. Hapus Pesanan");
            System.out.println("4. Kembali");
            System.out.print("Pilihan : ");
            pilihanPembelian = add.sc().nextInt();
            switch (pilihanPembelian) {
                case 1:
                    add.cls();
                    add.border();
                    int[][] jumlah = new int[5][2];
                    // TODO: set pembeli belum beres
                    // TODO: tambah pesanan - siapkan buat perulangan lanjut ga
                    // cTransaksi beli = new cTransaksi();
                    System.out.println(" ⁘⁘ Tambah Transaksi");
                    add.border();
                    System.out.println("\t[list] untuk melihat list pembeli");
                    System.out.print("Nama pembeli baru : ");
                    String pilih = add.sc().nextLine();
                    add.border();
                    if (pilih.equals("list")) {
                        add.printPembeli();
                        add.border();
                        System.out.print("Pilih nomor: ");
                        pilihPembeli = add.sc().nextInt();
                        // add.idxPembeli++; FIXME:
                        beli.isiPembeli(cTransaksi.pembeli[pilihPembeli - 1], (pilihPembeli - 1));
                        // beli.isiPembeli(cTransaksi.pembeli[pilihPembeli - 1], pilihPembeli - 1);
                        // System.out.println("Pembeli [" + beli.getNamaPembeli() + "] ditambahkan ke
                        // transaksi");
                        boolean belilagi = false;
                        do {
                            add.cls();
                            add.border();
                            System.out.println(
                                    " ⁘⁘⁘ Tambah Pesanan - " + cTransaksi.pembeli[pilihPembeli - 1].getNama());
                            System.out.println("Input Kode Menu\n\t0 untuk makanan\n\t1 untuk minuman");
                            System.out.print("Kode menu: ");
                            int kodeMenu = add.sc().nextInt();
                            if (kodeMenu == 0) {
                                add.printMenu("makanan");
                            }
                            if (kodeMenu == 1) {
                                add.printMenu("minuman");
                            }
                            System.out.print("ID menu: ");
                            int idMenu = add.sc().nextInt();
                            int id = add.searchById(idMenu, kodeMenu);
                            System.out.print("Jumlah: ");
                            jumlah[id][kodeMenu] = add.sc().nextInt();
                            akumulasi[3][id] = String.valueOf(jumlah[id][kodeMenu]);
                            // System.out.println(id);
                            // System.out.println(akumulasi[3][id]);
                            // FIXME: jumlah makan / minum kayanya perlu diperbaiki
                            if (kodeMenu == 0) {
                                beli.tambahMakanan(cMenuCLI.makanan[id], jumlah[id][kodeMenu], (pilihPembeli - 1), id);
                                porsiMakanan[pilihPembeli - 1][id] = jumlah[id][kodeMenu];
                                // System.out.println("Pesanan ditambahkan");
                            }
                            if (kodeMenu == 1) {
                                beli.tambahMinuman(cMenuCLI.minuman[id], jumlah[id][kodeMenu], (pilihPembeli - 1), id);
                                porsiMinuman[pilihPembeli - 1][id] = jumlah[id][kodeMenu];
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
                    } else {
                        // beli.isiPembeli(cMenuCLI.pembeli[add.idxPembeli - 1]);
                        // System.out.println("Pembeli [" + beli.getNamaPembeli() + "] ditambahkan ke
                        // transaksi");
                        add.border();
                        // TODO: tambah pesanan dengan pembeli baru

                    }
                    add.border();
                    add.idxTransaksi++; // FIXME: check emang ini dipake ya?
                    boolean paidInFull = false;
                    do {
                        add.cls();
                        beli.ToString(pilihPembeli - 1);
                        add.border();
                        System.out.println(" ⁘⁘⁘ Bayar");
                        System.out.println("Total Harga\t\t: " + beli.getTotalHarga(pilihPembeli - 1));
                        System.out.println("Bayar\t\t\t: ");
                        int bayar = add.sc().nextInt();
                        if (bayar >= beli.getTotalHarga(pilihPembeli - 1)) {
                            paidInFull = true;
                            kembalian[pilihPembeli - 1] = bayar - beli.getTotalHarga(pilihPembeli - 1);
                            System.out.println("Kembalian\t\t: " + kembalian[pilihPembeli - 1]);
                        } else {
                            System.out.println("Uang anda kurang");
                        }
                    } while (paidInFull == false);
                    add.border();
                    add.backToMenu();
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
                case 2:
                    add.cls();
                    add.border();
                    System.out.println(" ⁘⁘ Lihat Transaksi");
                    add.border();
                    for (int i = 0; i < add.idxTransaksi; i++) {
                        System.out.println("[Transaksi ke-" + (i + 1) + "] ");
                        beli.ToString(i);
                        add.border();
                    }
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
                case 3:
                    add.cls();
                    add.border();
                    System.out.println(" ⁘⁘ Hapus Pesanan");
                    add.border();
                    for (int i = 0; i < add.idxTransaksi; i++) {
                        System.out.println("[Transaksi ke-" + (i + 1) + "] ");
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
                case 4:
                    cMenuCLI.menuCLI();
                    break;
                default:
                    add.salahInput();
                    Transaksi();
                    break;
            }
        } while (pilihanPembelian != 4);
    }
}
