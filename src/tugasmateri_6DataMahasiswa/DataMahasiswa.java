/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */



package tugasmateri_6DataMahasiswa;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;


/**
 *
 * @author TUAN MUDA PULANGMAGANG
 */
public class DataMahasiswa {

     Scanner input;
    String fileName;
    ArrayList<String> Mahasiswa;
    boolean cek_ubah=false;

    public DataMahasiswa(){

        buatFile();
    }
    void buatFile(){
        Mahasiswa = new ArrayList<>();
        String filePath = System.console() == null ? "/src/dataMahasiswa.txt" :
                "/dataMahasiswa.txt";
        fileName = System.getProperty("user.dir") + filePath;
        System.out.println("FILE: " + fileName);
    }
    public void TambahData() {
        System.out.println("MASUKKAN DATA MAHASISWA");
        System.out.println("1.NIDN: 2.NIM: 3.Nama: 4.Alamat: 5.Status: 6.Phone:");

        input = new Scanner(System.in);
        String newTodoList = input.nextLine();
        try {

            FileWriter fileWriter = new FileWriter(fileName, true);
            fileWriter.append(String.format("%s%n", newTodoList));
            fileWriter.close();

            System.out.println("Data Berhasil ditambahkan!");
        } catch (IOException e) {


            System.out.println("Terjadi kesalahan karena: " + e.getMessage());
        }
    }
    void BacaFileMahasiswa(){
        try {
            File file = new File(fileName);
            Scanner fileReader = new Scanner(file);
            Mahasiswa.clear();
            while (fileReader.hasNextLine()) {
                String data = fileReader.nextLine();
                Mahasiswa.add(data);
            }

        } catch (FileNotFoundException e) {
            System.out.println("Error karena: " + e.getMessage());
        }
    }
    public void TampilDataMahasiswa(){
        BacaFileMahasiswa();
        if (Mahasiswa.size() > 0) {
            System.out.println("DATA MAHASISWA:");
            int index = 0;
            for (String data : Mahasiswa) {
                System.out.println(String.format("[%d] %s", index, data));
                index++;
            }

        } else {
            System.out.println("Data Tidak Tersedia");
        }
    }
    public void ubahDataMahasiswa() {
        cek_ubah = true;
        TampilDataMahasiswa();
        try {
            System.out.println("-----------------");
            System.out.print("Pilih Indeks> ");
            input = new Scanner(System.in);
            int index = Integer.parseInt(input.nextLine());
            if (index > Mahasiswa.size()) {
                throw new IndexOutOfBoundsException("Anda Memberikan Data Yang Salah! ");
            } else {

                System.out.print("Ubah Pilihan Mahasiswa: ");
                String newData = input.nextLine();
                Mahasiswa.set(index, newData);
                System.out.println(Mahasiswa.toString());
                try {

                    FileWriter fileWriter = new FileWriter(fileName, false);

                    for (String data : Mahasiswa) {
                        fileWriter.append(String.format("%s%n", data));
                    }
                    fileWriter.close();
                    System.out.println("Berhasil diubah!");
                } catch (IOException e) {
                    System.out.println("Terjadi kesalahan karena: " +
                            e.getMessage());
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        cek_ubah = false;
    }
    public void HapusDataMahasiswa() {
        cek_ubah = true;
        TampilDataMahasiswa();
        System.out.println("-----------------");
        System.out.print("Pilih Indeks> ");
        input = new Scanner(System.in);
        int index = Integer.parseInt(input.nextLine());
        try {
            if (index > Mahasiswa.size()) {
                throw new IndexOutOfBoundsException("Anda Memberikan Data Yang Salah!");
            } else {
                System.out.println("Kamu akan menghapus Data:");
                System.out.println(String.format("[%d] %s", index,
                        Mahasiswa.get(index)));
                System.out.println("Apakah kamu yakin untuk hapus?");
                System.out.print("Jawab (Ya/Tidak): ");
                String jawab = input.nextLine();
                if (jawab.equalsIgnoreCase("Ya")) {
                    Mahasiswa.remove(index);

                    try {
                        FileWriter fileWriter = new FileWriter(fileName, false);

                        for (String data : Mahasiswa) {
                            fileWriter.append(String.format("%s%n", data));
                        }
                        fileWriter.close();
                        System.out.println("Berhasil dihapus!");
                    } catch (IOException e) {
                        System.out.println("Terjadi kesalahan karena: " +
                                e.getMessage());
                    }
                }
            }
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        cek_ubah = false;
    }
}
