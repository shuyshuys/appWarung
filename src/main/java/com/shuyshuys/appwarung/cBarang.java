package com.shuyshuys.appwarung;

/**
 * @author shuyshuys
 */

public class cBarang {

    private String nama;
    private int harga;
    private int id;
    private int stok;
    // private String kategori;
    // private String detail;

    // try {
    // String sql = "SELECT ";
    // koneksi.getCon().createStatement().executeUpdate(sql);
    // } catch (SQLException ex) {
    // JOptionPane.showMessageDialog(null, ex.getMessage(), "",
    // JOptionPane.ERROR_MESSAGE);
    // Logger.getLogger(cBarang.class.getName()).log(Level.SEVERE, null, ex);
    // }

    cBarang(int id, String nama, int harga) {
        this.id = id;
        this.nama = nama;
        this.harga = harga;
        // this.stok = stok;
        // this.kategori = kategori;
        // this.detail = detail;
        System.out.println("  ⁂ Objek " + nama + " dibuat...");
    }

    // cBarang(int id, String nama, int harga, int stok) {
    // this.id = id;
    // this.nama = nama;
    // this.harga = harga;
    // this.stok = stok;
    // System.out.println("Object " + nama + " created...");
    // }

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

    // public int getStok() {
    // return stok;
    // }

    // public void setStok(int stok) {
    // this.stok = stok;
    // }

    // public String getKategori() {
    // return kategori;
    // }

    // public void setKategori(String kategori) {
    // this.kategori = kategori;
    // }

    // public String getDetail() {
    // return detail;
    // }

    // public void setDetail(String detail) {
    // this.detail = detail;
    // }

    public String ToString() {
        return "ID: " + id + "\nNama: " + nama + "\nHarga: " + harga;
    }
}
