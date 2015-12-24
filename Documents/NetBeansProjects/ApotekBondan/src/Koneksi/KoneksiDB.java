/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;
import java.sql.*;
/**
 *
 * @author HP
 */
public class KoneksiDB {
    public static Connection koneksi=null;
    
    public static Connection getKoneksi(){
        if(koneksi==null){
            try {
                String url="jdbc:mysql://localhost/apotek";
                String username="root";
                String password="abc";
                
                DriverManager.registerDriver(new com.mysql.jdbc.Driver());
                koneksi=DriverManager.getConnection(url,username,password);
                
            } catch (SQLException ex) {
                System.out.println(ex);
            }
            
            
        }
        
        return koneksi;
    }
    
    
}
