package com.shuyshuys.appwarung;

// import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * @author shuyshuys
 */

class mineWriter {

    public static void writeLog(String path, String content) {
        try {
            File file = new File(path);
            FileWriter writer = new FileWriter(file, true);

            writer.write("\n" + add.getDateTime() + "   " + content);
            writer.close();

            // BufferedWriter buffer = new BufferedWriter(writer);
            // buffer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    static void writeTransaksi(int idxPembeli) {
        try {
            File file = new File(add.PATH_TRANSAKSI);
            FileWriter writer = new FileWriter(file, true);

            writer.write("ID Transaksi:  " + cTransaksi.idTransaksi[add.idxTransaksi - 1][idxPembeli] + "\n");
            writer.write("Tanggal:  " + cTransaksi.tanggalTransaksi[idxPembeli] + "\n");
            writer.write("Nama Pembeli: " + cTransaksi.pembeli[idxPembeli].getNama() + "\n");
            try {
                for (int i = 0; i < cTransaksi.tMakanan.length; i++) {
                    if (cTransaksi.tMakanan[i] != null) {
                        // System.out.println("Nama Makanan\t: " + tMakanan[i].getNama());
                        // System.out.println("Harga Makanan\t: " + tMakanan[i].getHarga());

                        // System.out.println(
                        // "Jumlah Makanan\t: " +
                        // porsiMakanan[idxPembeli][add.searchById(tMakanan[i].getId(), 0)]);
                        System.out.println(
                                cTransaksi.tMakanan[i].getNama() + "\t" + cTransaksi.tMakanan[i].getHarga() + "\tx"
                                        + cTransaksi.porsiMakanan[idxPembeli][add
                                                .searchIdxById(cTransaksi.tMakanan[i].getId(), 0)]
                                        + "\t"
                                        + (cTransaksi.tMakanan[i].getHarga() * cTransaksi.porsiMakanan[idxPembeli][add
                                                .searchIdxById(cTransaksi.tMakanan[i].getId(), 0)]));
                        System.out.println("\t\t\tDiscount 10% : " + (cTransaksi.tMakanan[i].getHarga()
                                * cTransaksi.porsiMakanan[idxPembeli][add.searchIdxById(cTransaksi.tMakanan[i].getId(),
                                        0)])
                                * 10 / 100);
                    }
                }
            } catch (Exception e) {
            }
            // writer.write("\n" + add.getDateTime() + " " + add.getTransaksi());
            writer.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void write(String path, String[] category, String[] menu, int[] harga, int[] porsi) {
        File file = new File(path);
        // try {
        // if (file.createNewFile()) {
        // System.out.println("File created: " + file.getName());
        // } else {
        // System.out.println("File already exists with name " + file.getName());
        // }
        // } catch (IOException e) {
        // System.out.println("An error occurred.");
        // e.printStackTrace();
        // }
        // menulis ke file
        if (menu != null) {
            try {
                FileWriter writer = new FileWriter(path);
                for (int i = 0; i < menu.length; i++) {
                    System.out.print(menu[i] + "  ");
                    System.out.print(harga[i] + "  ");
                    System.out.print(porsi[i] + "  ");
                    writer.write(menu[i] + "\n");
                    writer.write(harga[i] + "\n");
                    writer.write(porsi[i] + "\n");
                    writer.write("\n");
                }
                writer.close();
                System.out.println("Successfully wrote to " + file.getName());
                System.out.println();
            } catch (IOException e) {
                System.out.println("An error occurred.");
                e.printStackTrace();
            }
        }
    }
    //
    // public static void writeMenuMakanan() {
    // // cek file
    // try {
    // File myObj = new File("./src/Kasir/menuMakanan.txt");
    // if (myObj.createNewFile()) {
    // System.out.println("File created: " + myObj.getName());
    // } else {
    // System.out.println("File already exists with name " + myObj.getName());
    // }
    // } catch (IOException e) {
    // System.out.println("An error occurred.");
    // e.printStackTrace();
    // }
    // // menulis ke file
    // try {
    // FileWriter writeMakanan = new FileWriter("./src/Kasir/menuMakanan.txt");
    // for (int i = 0; i < Main.menuMakanan.length; i++) {
    // System.out.println(Main.menuMakanan[i]);
    // writeMakanan.write(Main.menuMakanan[i]);
    // writeMakanan.write("\n");
    // }
    // writeMakanan.close();
    // System.out.println("Successfully wrote to the file.");
    // System.out.println();
    // } catch (IOException e) {
    // System.out.println("An error occurred.");
    // e.printStackTrace();
    // }
    // }

    // public static void writeMenuMinuman() {
    // try {
    // File fileMinuman = new File("./src/Kasir/menuMinuman.txt");
    // if (fileMinuman.createNewFile()) {
    // System.out.println("File created: " + fileMinuman.getName());
    // } else {
    // System.out.println("File already exists.");
    // }
    // } catch (IOException e) {
    // System.out.println("An error occurred.");
    // e.printStackTrace();
    // }
    // try {
    // FileWriter writeMinuman = new FileWriter("./src/Kasir/menuMinuman.txt");
    // for (int i = 0; i < Main.menuMinuman.length; i++) {
    // System.out.println(Main.menuMinuman[i]);
    // writeMinuman.write(Main.menuMinuman[i]);
    // writeMinuman.write("\n");
    // }
    // writeMinuman.close();
    // System.out.println("Successfully wrote to the file.");
    // System.out.println();
    // } catch (IOException e) {
    // System.out.println("An error occurred.");
    // e.printStackTrace();
    // }
    // }
}
