package com.shuyshuys.appwarung;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import javax.swing.JOptionPane;

/**
 * @author shuyshuys
 */

// TODO: create string to array reader

public class mineReader {
    public static int idx_count;
    public static int idx_max_makanan;
    public static int idx_max_minuman;
    public static int idx_max_pembeli;
    public static int idx_max_transaksi = 0;

    private static String line;

    public static void getReader(String path, String category) {
        add.border();
        try {
            File file = new File(path);
            FileReader reader = new FileReader(path);
            BufferedReader bufferedReader = new BufferedReader(reader);

            long lineCount = Files.lines(Paths.get(path)).count();

            idx_count = (int) lineCount + 5;

            if (category == "makanan") {
                cMenuCLI.makanan = new cMakanan[idx_count];
                idx_max_makanan = idx_count;

                for (int i = 0; i < cMenuCLI.makanan.length; i++) {

                    while ((line = bufferedReader.readLine()) != null) {
                        // System.out.println(line);
                        cMenuCLI.makanan[i] = new cMakanan(
                                Integer.parseInt(line.split("  ")[0]),
                                line.split("  ")[1],
                                Integer.parseInt(line.split("  ")[2]));
                        i++;
                        add.idxMakanan++;
                    }
                }
            } else if (category == "minuman") {
                cMenuCLI.minuman = new cMinuman[idx_count];
                idx_max_minuman = idx_count;

                for (int i = 0; i < cMenuCLI.minuman.length; i++) {
                    while ((line = bufferedReader.readLine()) != null) {
                        cMenuCLI.minuman[i] = new cMinuman(
                                Integer.parseInt(line.split("  ")[0]),
                                line.split("  ")[1],
                                Integer.parseInt(line.split("  ")[2]));
                        i++;
                        add.idxMinuman++;
                    }
                }
            } else if (category == "pembeli") {
                cTransaksi.pembeli = new cPembeli[idx_count];
                idx_max_pembeli = idx_count;

                for (int i = 0; i < cTransaksi.pembeli.length; i++) {
                    while ((line = bufferedReader.readLine()) != null) {
                        cTransaksi.pembeli[i] = new cPembeli(
                                Integer.parseInt(line.split("  ")[0]),
                                line.split("  ")[1],
                                line.split("  ")[2],
                                Integer.parseInt(line.split("  ")[3]));
                        i++;
                        add.idxPembeli++;
                    }
                }
            } else if (category == "transaksi") {
                cTransaksi.beli = new cTransaksi();
                idx_max_transaksi = idx_count;

                for (int i = 0; i <= lineCount; i++) {
                    while ((line = bufferedReader.readLine()) != null) {
                        cPembeli foundPembeli = add.searchPembeli(line.split("  ")[1]);
                        cTransaksi.beli.isiPembeli(foundPembeli, add.idxTransaksi);
                        cTransaksi.beli.setIdTransaksi(Integer.parseInt(line.split("  ")[0]), i); // FIXME:
                        cMakanan hasilCariMakanan = add.searchMakanan(line.split("  ")[2]);
                        cMinuman hasilCariMinuman = add.searchMinuman(line.split("  ")[2]);
                        try {
                            cTransaksi.beli.tambahMakanan(hasilCariMakanan, Integer.parseInt(line.split("  ")[4]),
                                    add.idxTransaksi,
                                    add.searchIdxMakanan(line.split("  ")[2]));
                        } catch (Exception e) {
                        }

                        try {
                            cTransaksi.beli.tambahMinuman(hasilCariMinuman, Integer.parseInt(line.split("  ")[4]),
                                    add.idxTransaksi,
                                    add.searchIdxMinuman(line.split("  ")[2]));
                        } catch (Exception e) {
                        }
                        cTransaksi.beli.setTotalHarga(Integer.parseInt(line.split("  ")[5]), add.idxTransaksi);
                        cTransaksi.beli.setBayar(Integer.parseInt(line.split("  ")[6]), add.idxTransaksi);
                        cTransaksi.beli.setKembalian(Integer.parseInt(line.split("  ")[7]), add.idxTransaksi);
                        cTransaksi.beli.setTanggalTransaksi(line.split("  ")[8], add.idxTransaksi);
                        add.idxTransaksi++;

                        // cTransaksi.beli.setNamaBarang(line.split(" ")[2], add.idxTransaksi);
                        // cTransaksi.beli.setHargaBarang(Integer.parseInt(line.split(" ")[3]),
                        // add.idxTransaksi);
                        // cTransaksi.beli.setJumlahBarang(Integer.parseInt(line.split(" ")[4]),
                        // add.idxTransaksi);
                        // i++;
                    }
                }

                // for (int i = 0; i < cMenuCLI.transaksi.length; i++) {
                // while ((line = bufferedReader.readLine()) != null) {
                // cMenuCLI.transaksi[i] = new cTransaksi(
                // Integer.parseInt(line.split(" ")[0]),
                // line.split(" ")[1],
                // line.split(" ")[2],
                // Integer.parseInt(line.split(" ")[3]),
                // Integer.parseInt(line.split(" ")[4]),
                // Integer.parseInt(line.split(" ")[5]),
                // Integer.parseInt(line.split(" ")[6]),
                // Integer.parseInt(line.split(" ")[7]),
                // line.split(" ")[8]);
                // i++;
                // add.idxTransaksi++;
                // }
                // }
            } else {
                System.out.println("Error");
            }
            System.out.println("List " + category + " telah di import dari " + file.getName());
            bufferedReader.close();

        } catch (IOException e) {
            add.border();
            JOptionPane.showMessageDialog(null, "An error occured" + e.getMessage(), "Reader error",
                    JOptionPane.ERROR_MESSAGE);
            e.printStackTrace();
        }
    }
}
