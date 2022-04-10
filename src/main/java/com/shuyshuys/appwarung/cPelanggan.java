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
                add.cls();
                add.border();
                System.out.println(" ⁘⁘ Menu Buat Pelanggan Baru");
                add.border();
                System.out.print("Nama\t: ");
                String nama = add.sc().nextLine();
                System.out.print("Alamat\t: ");
                String alamat = add.sc().nextLine();
                cTransaksi.pembeli[add.idxPembeli] = new cPembeli(nama, alamat);
                add.idxPembeli++;
                Pelanggan();
                break;

            case 2:
                System.out.println(" ⁘⁘ Menu Lihat Pelanggan");
                add.listPembeli();
                Pelanggan();
                break;
            case 3:
                add.backToMenu();
                break;
            default:
                add.salahInput();
                Pelanggan();
                break;
        }
    }
}
