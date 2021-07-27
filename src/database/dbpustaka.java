package database;

import java.sql.Connection;
import java.sql.Driver;
import java.sql.DriverManager;
import java.sql.DriverPropertyInfo;
import java.sql.SQLException;
import java.sql.SQLFeatureNotSupportedException;
import java.util.Properties;
import java.util.logging.Logger;

public class dbpustaka {
    private static Connection koneksi;
    public static Connection getKoneksi() {
        if(koneksi == null)    {
            try {
                Driver driver = new Driver() {
                    @Override
                    public Connection connect(String string, Properties prprts) throws SQLException {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public boolean acceptsURL(String string) throws SQLException {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public DriverPropertyInfo[] getPropertyInfo(String string, Properties prprts) throws SQLException {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public int getMajorVersion() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public int getMinorVersion() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public boolean jdbcCompliant() {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }

                    @Override
                    public Logger getParentLogger() throws SQLFeatureNotSupportedException {
                        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
                    }
                };
                DriverManager.registerDriver(driver);
                String url = "jdbc:mysql://localhost:3306/akademikpti";
                String user = "root";
                String pass = "";
                koneksi = DriverManager.getConnection(url, user, pass);
                System.out.println("Sukses Akses Database akademikpti");
            }catch (SQLException ex) {
                System.out.println("Gagal Akses Database akademikpti");
                System.out.println("Error" +ex.getMessage());
                
            }
        }
            
        return koneksi;
    }
}