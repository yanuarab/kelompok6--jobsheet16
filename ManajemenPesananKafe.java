import java.util.Scanner;

public class ManajemenPesananKafe {
    static String[] menu = {"Kopi Hitam", "Latte", "Teh Tarik", "Mie Goreng", "Pisang Goreng", "Bala-Bala", "Tahu Isi", "Pop Ice", "Air Mineral"};
    static int[] hargaMenu = {15000, 22000, 12000, 18000, 1000, 1000, 1000, 3000, 5000};

    static String[][] dataPesanan = new String[100][4]; 
    static int jumlahPesanan = 0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        do {
            System.out.println("~Selamat Datang di Kedai Ngepunk!~");
            System.out.println("<<<<< MENU UTAMA >>>>>");
            System.out.println("1. Tambahkan Pesanan");
            System.out.println("2. Tampilkan Daftar Pesanan");
            System.out.println("3. Keluar");
            System.out.print("Pilih menu: ");
            pilihan = scanner.nextInt();
            scanner.nextLine();

            switch (pilihan) {
                case 1:
                    tambahkanPesanan(scanner);
                    break;
                case 2:
                    tampilkanDaftarPesanan();
                    break;
                case 3:
                    System.out.println("Terima kasih! Sampai Jumpa Kembali!");
                    break;
                default:
                    System.out.println("Pilihan tidak valid!");
            }
        } while (pilihan != 3);
    }

    static void tambahkanPesanan(Scanner scanner) {
        System.out.print("Masukkan nama pelanggan: ");
        dataPesanan[jumlahPesanan][0] = scanner.nextLine();
        
        int noMeja;

        while (true) {
            System.out.print("Masukkan nomor meja: ");
            noMeja = scanner.nextInt();

            if (noMeja < 1) {
                System.out.println("Meja harus lebih dari 0!");
            }else{
                break;
            }
            dataPesanan[jumlahPesanan][1] = scanner.nextLine();
        } 


        int totalHarga = 0;
        String detailPesanan = "";
        System.out.println("<<<<< MENU KAFE >>>>>");
        for (int i = 0; i < menu.length; i++) {
            System.out.println((i + 1) + ". " + menu[i] + " - Rp " + hargaMenu[i]);
        }

        while (true) {
            System.out.print("Pilih menu (masukkan nomor menu, atau 0 untuk selesai): ");
            int nomorMenu = scanner.nextInt();

            if (nomorMenu == 0) break;    

            if (nomorMenu < 1 || nomorMenu > menu.length) {
                System.out.println("Menu tidak valid!");
                continue;
            }

            System.out.print("Masukkan jumlah item untuk " + menu[nomorMenu - 1] + ": ");
            int jumlahItem = scanner.nextInt();

            if (jumlahItem <= 0) {
                System.out.println("Jumlah item harus lebih dari 0!");
                continue;
            }

            int hargaSatuan = hargaMenu[nomorMenu - 1]; 
            int hargaItem = hargaSatuan * jumlahItem; 
            detailPesanan += menu[nomorMenu - 1] + " (Rp " + hargaSatuan + ") x " + jumlahItem + " = Rp " + hargaItem + "\n";
            
            totalHarga += hargaItem;
        }

        dataPesanan[jumlahPesanan][1] = String.valueOf(noMeja); 
        dataPesanan[jumlahPesanan][2] = detailPesanan; 
        dataPesanan[jumlahPesanan][3] = String.valueOf(totalHarga); 
        jumlahPesanan++;

        System.out.println("Pesanan berhasil ditambahkan.");
    }

    static void tampilkanDaftarPesanan() {
        if (jumlahPesanan == 0) {
            System.out.println("Belum ada pesanan yang tercatat.");
        } else {
            System.out.println("<<<<< DAFTAR PESANAN >>>>>");
            for (int i = 0; i < jumlahPesanan; i++) {
                System.out.println("Nama Pelanggan: " + dataPesanan[i][0]);
                System.out.println("Nomor Meja: " + dataPesanan[i][1]);
                System.out.println("Detail Pesanan:");
                System.out.println(dataPesanan[i][2]);
                System.out.println("Total Harga Pesanan: Rp " + dataPesanan[i][3]);
                System.out.println("- - - - - - - - - - - - - - - -");
            }
        }
    }
}
