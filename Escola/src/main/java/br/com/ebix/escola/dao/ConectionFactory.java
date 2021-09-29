package br.com.ebix.escola.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConectionFactory {
	public Connection getConnection(){
		try {
			try {
				Class.forName("com.mysql.jdbc.Driver");
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return DriverManager.getConnection("jdbc:mysql://localhost/escola?useSSL=false", "root", "uut3E26MPmxRQNd4");
		} catch (SQLException e) {
			throw new RuntimeException(e);
		}
	}
}
