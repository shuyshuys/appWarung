package com.shuyshuys.appwarung;

/**
 * @author shuyshuys
 */

public class cPembeli {
    private int id;
    private String nama;
    private String alamat;

    cPembeli() {
        this.id = cTransaksi.pembeli[add.idxPembeli - 1].getId() + 1;
        this.nama = "Non Pelanggan";
        this.alamat = "Non Pelanggan";
        System.out.println("  ↂ  Objek Pembeli " + cTransaksi.pembeli[add.idxPembeli - 1] + " dibuat");
    }

    cPembeli(int id, String nama, String alamat) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        System.out.println("  ↂ  Object " + nama + " dibuat...");
    }

    cPembeli(String nama, String alamat) {
        this.id = cTransaksi.pembeli[add.idxPembeli - 1].getId() + 1;
        this.nama = nama;
        this.alamat = alamat;
        System.out.println("  ↂ  Objek " + nama + " dibuat...");
    }

    cPembeli(String nama) {
        this.id = cTransaksi.pembeli[add.idxPembeli - 1].getId() + 1;
        this.nama = nama;
        this.alamat = "-";
        System.out.println("  ↂ  Objek " + nama + " dibuat...");
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getAlamat() {
        return alamat;
    }

    public void setAlamat(String alamat) {
        this.alamat = alamat;
    }

    public String ToString() {
        return "ID: " + id +
                "\nNama: " + nama +
                "\nAlamat: " + alamat;
        // "\nPembelian berulang: " + jPembelian;
    }
}
