package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class tabelpustakawan {
private static Connection koneksi;   
public tabelpustakawan(){
    koneksi = dbpustaka.getKoneksi();
}
public void insert(int kode_pustakawan, String nama, String alamat){
    PreparedStatement prepare = null;
    try{
        String sql = "insert into tabelpustakawan(kode_pustakawan, nama, alamat)"
                + "Values(?, ?, ?, ?);";
        prepare = koneksi.prepareStatement(sql);
        System.out.println("Sukses menyimpan data");
        prepare.setInt(1, kode_pustakawan);
        prepare.setString(2, nama);
        prepare.setString(3, alamat);
        
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

public void update(int kode_pustakawan, String nama, String alamat){
    PreparedStatement prepare = null;
    try{
        String sql = "update tabelpustakawan set nama = ?, alamat = ?" + " where kode_pustakawan = ?";
        prepare = koneksi.prepareStatement(sql);
        System.out.println("Sukses update data");
        
        prepare.setString(1, nama);
        prepare.setString(2, alamat);
        prepare.setInt(3, kode_pustakawan);
        
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

public void delete(int kode_pustakawan){
    PreparedStatement prepare = null;
    
    try{
        String sql = "delete from tabelpustakawan where kode_pustakawan = ?";
        prepare = koneksi.prepareStatement(sql);
        System.out.println("Sukses hapus data");
        
        prepare.setInt(1, kode_pustakawan);
        
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