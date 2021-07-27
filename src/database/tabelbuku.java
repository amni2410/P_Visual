package database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class tabelbuku {
private static Connection koneksi;   
public tabelbuku(){
    koneksi = dbpustaka.getKoneksi();
}
public void insert(int kode_buku, String judul, String penulis, int tahun_terbit){
    PreparedStatement prepare = null;
    try{
        String sql = "insert into tabelbuku(kode_buku, judul, penulis, tahun_terbit)"
                + "Values(?, ?, ?, ?);";
        prepare = koneksi.prepareStatement(sql);
        System.out.println("Sukses menyimpan data");
        prepare.setInt(1, kode_buku);
        prepare.setString(2, judul);
        prepare.setString(3, penulis);
        prepare.setInt(4, tahun_terbit);
        
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

public void update(int kode_buku, String judul, String penulis, int tahun_terbit){
    PreparedStatement prepare = null;
    try{
        String sql = "update tabelbuku set judul = ?, penulis = ?, tahun_terbit = ?" + " where kode_buku = ?";
        prepare = koneksi.prepareStatement(sql);
        System.out.println("Sukses update data");
        
        prepare.setString(1, judul);
        prepare.setString(2, penulis);
        prepare.setInt(3, tahun_terbit);
        prepare.setInt(4, kode_buku);
        
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

public void delete(int kode_buku){
    PreparedStatement prepare = null;
    
    try{
        String sql = "delete from tabelbuku where kode_buku = ?";
        prepare = koneksi.prepareStatement(sql);
        System.out.println("Sukses hapus data");
        
        prepare.setInt(1, kode_buku);
        
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