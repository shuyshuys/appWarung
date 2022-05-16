package com.shuyshuys.appwarung;

/**
 * @author shuyshuys
 * @author naishlts
 */

public class cBarang {

    private String nama;
    private int harga;
    private int id;

    cBarang(int id, String nama, int harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
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

    public int getHarga() {
        return harga;
    }

    public void setHarga(int harga) {
        this.harga = harga;
    }

    public String ToString() {
        return "ID: " + id + "\nNama: " + nama + "\nHarga: " + harga;
    }
}
