/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package tugasmateri_6DataMahasiswa;
import tugasmateri_6DataMahasiswa.DataMahasiswa;
import java.util.Scanner;

/**
 *
 * @author TUAN MUDA PULANGMAGANG
 */
public class Main {

    static Scanner input;
    static DataMahasiswa data=new DataMahasiswa();

    public static void main(String[] args) {
        input = new Scanner(System.in);

        while (true) {
            // panggil method
            TampilMenu();
        }
    }


    static void HapusLayar(){
        try {
            final String os = System.getProperty("os.name");
            if (os.contains("Windows")) {

                new ProcessBuilder("cmd", "/c", "cls")
                        .inheritIO()
                        .start()
                        .waitFor();

            } else {

                Runtime.getRuntime().exec("clear");
                System.out.print("\033[H\033[2J");
                System.out.flush();
            }
        } catch (final Exception e) {
            System.out.println("Terjadi Error karena: " + e.getMessage());
        }
    }
    static void TampilMenu() {
        System.out.println("===== MAHASISWA =====");
        System.out.println("[1] Lihat Data Mahasiswa");
        System.out.println("[2] Tambah Data Mahasiswa");
        System.out.println("[3] Edit Data Mahasiswa");
        System.out.println("[4] Hapus Data Mahasiswa");
        System.out.println("[0] Keluar");
        System.out.println("---------------------");
        System.out.print("Pilih menu> ");


        String selectedMenu = input.nextLine();


        if (selectedMenu.equals("1")) {
            HapusLayar();
            data.TampilDataMahasiswa();
            KembaliKeMenu();


        } else if (selectedMenu.equals("2")) {
            HapusLayar();
            data.TambahData();
            KembaliKeMenu();


        } else if (selectedMenu.equals("3")) {
            HapusLayar();
            data.ubahDataMahasiswa();
            KembaliKeMenu();
        } else if (selectedMenu.equals("4")) {
            HapusLayar();
            data.HapusDataMahasiswa();
            KembaliKeMenu();

        } else if (selectedMenu.equals("0")) {
            System.exit(0);
        } else {


            System.out.println("Anda salah pilih menu, Ulang lagi!");

            KembaliKeMenu();
        }
    }

    static void KembaliKeMenu() {
        System.out.println("");
        System.out.print("Tekan [Enter] untuk kembali..");
        input.nextLine();
        HapusLayar();
    }


    static void BacaFileDataMahasiswa() {
    }


    static void TampilDataMahasiswa() {
    }


    static void TambahDataMahasiswa() {
    }


    static void UbahDataMahasiswa() {
    }


    static void HapusDataMahasiswa() {
    }
}
