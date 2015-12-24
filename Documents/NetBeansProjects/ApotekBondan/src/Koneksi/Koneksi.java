/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author HP
 */
public class Koneksi{
  private static Connection koneksi=null;
	
	public static Connection getKoneksi(){
		if(koneksi==null){
			try{
				String url = "jdbc:mysql://localhost/apotek";
				String user = "root";
				String password = "";
				
				DriverManager.registerDriver(new com.mysql.jdbc.Driver());
				koneksi = DriverManager.getConnection(url,user,password);
			}
			catch(Exception ex)
			{
				System.out.println(ex);
			}
		}
		return koneksi;
	}
}

