package com.shuyshuys.appwarung;

public class cPelanggan {
    static void Pelanggan() {
        add.border();
        System.out.println(" ⁘ Menu Pelanggan");
        add.border();
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
                if (alamat == "") {
                    cTransaksi.pembeli[add.idxPembeli] = new cPembeli(nama);
                } else if (alamat != "" && nama != "") {
                    cTransaksi.pembeli[add.idxPembeli] = new cPembeli(nama, alamat);
                } else if (nama == "") {
                    System.out.println("  ⁂ Nama tidak boleh kosong");
                }
                add.idxPembeli++;
                Pelanggan();
                break;
            case 2:
                add.border();
                System.out.println(" ⁘⁘ Menu Lihat Pelanggan");
                add.border();
                add.listPembeli();
                Pelanggan();
                break;
            case 3:
                cMenuCLI.menuCLI();
                break;
            default:
                add.salahInput();
                Pelanggan();
                break;
        }
    }
}
