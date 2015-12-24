/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Koneksi;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 *
 * @author echo
 */
public class DatabaseHelper {

    private static Connection connection;

    public static Connection getConnection() {
	if (connection == null) {
	    try {
		Class.forName("com.mysql.jdbc.Driver");
		connection = DriverManager.getConnection(
			"jdbc:mysql://localhost:3306/apotek",
			"root",
			"");
	    } catch (Throwable t) {
		t.printStackTrace();
	    }
	}
	return connection;
    }
}
