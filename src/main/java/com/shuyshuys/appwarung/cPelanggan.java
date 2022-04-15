package com.shuyshuys.appwarung;

public class cPelanggan {
    static void Pelanggan() {
        add.border();
        System.out.println(" ⁘ Menu Pelanggan");
        add.border();
        System.out.println("1. Buat Pelanggan Baru");
        System.out.println("2. Lihat Pelanggan");
        System.out.println("3. Hapus Pelanggan");
        System.out.println("4. Keluar");
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
                add.cls();
                add.border();
                System.out.println(" ⁘⁘ Menu Hapus Pelanggan");
                add.border();
                add.listPembeli();
                add.border();
                System.out.print("Masukkan Nama : ");
                String hapusNama = add.sc().nextLine();
                boolean found2 = false;
                for (int i = 0; i < add.idxPembeli; i++) {
                    if (cTransaksi.pembeli[i].getNama().equalsIgnoreCase(hapusNama)) {
                        found2 = true;
                        System.out.println(cTransaksi.pembeli[i].ToString());
                        System.out.print("Apakah anda yakin ingin menghapus? (y/n)  : ");
                        String jawab = add.sc().next();
                        if (jawab.equals("y")) {
                            // cTransaksi.pembeli[i] = cTransaksi.pembeli[add.idxPembeli - 1];
                            for (int j = i; j < add.idxPembeli; j++) {
                                if (j == add.idxMinuman - 1) {
                                    cTransaksi.pembeli[j] = null;
                                } else {
                                    cTransaksi.pembeli[j] = cTransaksi.pembeli[j + 1];
                                }
                            }
                            add.idxPembeli--;
                            System.out.println("  ⁂ Member berhasil dihapus");
                        } else {
                            System.out.println("  ⁂ Member tidak dihapus");
                            break;
                        }
                        if (!found2) {
                            System.out.println("  ⁂ Member tidak ditemukan");
                        }
                    }
                }
                add.sleep();
                break;
            case 4:
                cMenuCLI.menuCLI();
                break;
            default:
                add.salahInput();
                Pelanggan();
                break;
        }
    }
}
