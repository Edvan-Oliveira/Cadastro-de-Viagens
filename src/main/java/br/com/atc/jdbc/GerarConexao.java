package br.com.atc.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class GerarConexao {
	
	public Connection getConexao() {
		try {
			Class.forName("org.postgresql.Driver");
		} catch (ClassNotFoundException e1) {
			e1.printStackTrace();
		}
		
		try {
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/atcCrud", "edvan", "junior");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
