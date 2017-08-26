package br.fundatec.lpii.produtorest;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {
	
	public Connection fabricate(){
		try {
			Class.forName("org.postgresql.Driver").newInstance();
			return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres", "postgres", "fundatec");
		} catch (Exception e) {
			throw new RuntimeException();
		}
	}
	
}
