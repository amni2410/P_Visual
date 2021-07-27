package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class tabelanggota {
private static Connection koneksi;   
public tabelanggota(){
    koneksi = dbpustaka.getKoneksi();
}
public void insert(int kode_anggota, String nama, String alamat, String status_anggota){
    PreparedStatement prepare = null;
    try{
        String sql = "insert into tabelanggota(kode_anggota, nama, alamat, status_anggota)"
                + "Values(?, ?, ?, ?);";
        prepare = koneksi.prepareStatement(sql);
        System.out.println("Sukses menyimpan data");
        prepare.setInt(1, kode_anggota);
        prepare.setString(2, nama);
        prepare.setString(3, alamat);
        prepare.setString(4, status_anggota);
        
        prepare.executeUpdate();
    }catch (SQLException ex){
        System.out.println("Gagal menyimpan data" +ex.getMessage());
    }finally{
        if(prepare != null){
            try{
                prepare.close();
                System.out.println("Sukses menutup prepare");
            }catch (SQLException ex){
                System.out.println("Gagal menutup prepare" +ex.getMessage());
            }
        }
    }
    }

public void update(int kode_anggota, String nama, String alamat, String status_anggota){
    PreparedStatement prepare = null;
    try{
        String sql = "update tabelanggota set nama = ?, alamat = ?, status_anggota = ?" + " where kode_anggota = ?";
        prepare = koneksi.prepareStatement(sql);
        System.out.println("Sukses update data");
        
        prepare.setString(1, nama);
        prepare.setString(2, alamat);
        prepare.setString(3, status_anggota);
        prepare.setInt(4, kode_anggota);
        
        prepare.executeUpdate();
        
    }catch (SQLException ex){
        System.out.println("Gagal update data" +ex.getMessage());
    }finally{
        if(prepare != null){
            try{
                prepare.close();
                System.out.println("Sukses menutup prepare");
            }catch (SQLException ex){
                System.out.println("Gagal menutup prepare" +ex.getMessage());
            }
        }
    }
    }

public void delete(int kode_anggota){
    PreparedStatement prepare = null;
    
    try{
        String sql = "delete from tabelanggota where kode_anggota = ?";
        prepare = koneksi.prepareStatement(sql);
        System.out.println("Sukses hapus data");
        
        prepare.setInt(1, kode_anggota);
        
        prepare.executeUpdate();
        
    }catch (SQLException ex){
        System.out.println("Gagal hapus data" +ex.getMessage());
    }finally{
        if(prepare != null){
            try{
                prepare.close();
                System.out.println("Sukses menutup prepare");
            }catch (SQLException ex){
                System.out.println("Gagal menutup prepare" +ex.getMessage());
            }
        }
    }
    }
}