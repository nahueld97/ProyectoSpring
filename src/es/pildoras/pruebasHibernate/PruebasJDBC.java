package es.pildoras.pruebasHibernate;

import java.sql.*;

public class PruebasJDBC {
	public static void main(String[] args) {
		String jdbcUrl = "jdbc:mysql://@localhost:3306/puebashibernate?useSSL=false";
		String user="root";
		String pass="bd-dcic";
		try {
			System.out.println("Intentando conectar con la BBDD: " + jdbcUrl);
			Connection connection= DriverManager.getConnection(jdbcUrl, user, pass);
			System.out.println("Conexion exitosa!");
			
			
			
			connection.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
