package com.shuyshuys.appwarung;

/**
 * @author shuyshuys
 */

public class cPembeli {
    private int id;
    private String nama;
    private String alamat;
    static int jPembelian = 0;

    cPembeli() {
        this.id = cTransaksi.pembeli[add.idxPembeli - 1].getId() + 1;
        this.nama = "Non Pelanggan";
        this.alamat = "Non Pelanggan";
        cPembeli.jPembelian = 0;
        System.out.println("  ⁂ Objek Pembeli " + nama + " dibuat");
    }

    cPembeli(int id, String nama, String alamat, int jPembelian) {
        this.id = id;
        this.nama = nama;
        this.alamat = alamat;
        cPembeli.jPembelian = jPembelian;
        System.out.println("  ⁂ Object " + nama + " dibuat...");
    }

    cPembeli(String nama, String alamat) {
        this.id = cTransaksi.pembeli[add.idxPembeli - 1].getId() + 1;
        this.nama = nama;
        this.alamat = alamat;
        cPembeli.jPembelian = 0;
        System.out.println("  ⁂ Objek " + nama + " dibuat...");
    }

    cPembeli(String nama) {
        this.id = cTransaksi.pembeli[add.idxPembeli - 1].getId() + 1;
        this.nama = nama;
        this.alamat = "-";
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

    public int getjPembelian() {
        return jPembelian;
    }

    public void setjPembelian() {
        cPembeli.jPembelian++;
    }

    public String ToString() {
        return "ID: " + id +
                "\nNama: " + nama +
                "\nAlamat: " + alamat +
                "\nPembelian berulang: " + jPembelian;
    }
}
