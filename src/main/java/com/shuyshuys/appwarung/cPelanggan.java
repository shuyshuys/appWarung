package com.shuyshuys.appwarung;

public class cPelanggan {
    static void Pelanggan() {
        System.out.println(" ⁘ Menu Pelanggan");
        System.out.println("1. Buat Pelanggan Baru");
        System.out.println("2. Lihat Pelanggan");
        System.out.println("3. Keluar");
        System.out.print("Pilihan: ");
        int pilih = add.sc().nextInt();
        switch (pilih) {
            case 1:
                System.out.println(" ⁘ Menu Buat Pelanggan Baru");
                System.out.print("Nama: ");
                String nama = add.sc().next();
                System.out.print("Alamat: ");
                String alamat = add.sc().next();
                cTransaksi.pembeli = new cPelanggan(nama, alamat);
                System.out.println("  ⁂ Pelanggan " + nama + " dibuat");
                Pelanggan();
                break;
            case 2:
                System.out.println(" ⁘ Menu Lihat Pelanggan");
                System.out.println("  ⁂ Pelanggan");
                for (int i = 0; i < add.idxPelanggan; i++) {
                    System.out.println("  " + (i + 1) + ". " + cTransaksi.pembeli[i].getNama());
                }
                System.out.print("Pilih Pelanggan: ");
                int pilihPelanggan = add.sc().nextInt();
                System.out.println("  ⁂ Pelanggan " + add.pembeli[pilihPelanggan - 1].getNama());
                System.out.println("  ⁂ Alamat " + add.pembeli[pilihPelanggan - 1].getAlamat());
                Pelanggan();
                break;
            case 3:
                System.out.println(" ⁘ Keluar");
                break;
            default:
                System.out.println(" ⁘ Menu Pelanggan");
                System.out.println("  ⁂ Pilihan tidak ada");
                Pelanggan();
                break;
        }
    }
}
