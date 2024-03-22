/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

/**
 *
 * @author Nguyen Van Loi
 */
import java.sql.Connection;
import java.sql.DriverManager;
public class Database {
    




	public static final  String connectionUrl = "jdbc:sqlserver://localhost;databaseName=SUPERDuAn1;user=sa;password=123;encrypt=false";
	public static Connection connection() {
		Connection conn = null;
		try {
			conn = DriverManager.getConnection(connectionUrl);
			return conn;
		} catch (Exception e) {
			System.out.println("loi connec");
		}
		return null;
	
}

}
