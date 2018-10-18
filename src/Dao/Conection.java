package Dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class Conection {
	static final String URL = "jdbc:postgresql://localhost:5432/ejemplo";
	static final String USER = "postgres";
	static final String PASS = "123";
	 
	public static Connection crearConexion() throws ClassNotFoundException, SQLException{
		Class.forName("org.postgresql.Driver");
		Connection conexion = DriverManager.getConnection(URL, USER, PASS);
		if (conexion != null){
			System.out.print("Conexion establecida...");
			return conexion;
		}
		return null;
	}
}
