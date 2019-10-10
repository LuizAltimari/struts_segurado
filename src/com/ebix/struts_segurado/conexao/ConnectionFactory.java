package com.ebix.struts_segurado.conexao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionFactory {

	public Connection getConnection(){
		try {
			//Tive que fazer um tratamento aqui por questões de fuso horário
			Class.forName("com.mysql.cj.jdbc.Driver");
			return DriverManager.getConnection("jdbc:mysql://localhost:3306/segurobd?useUnicode=true&useJDBCCompliantTimezoneShift=true&useLegacyDatetimeCode=false&serverTimezone=UTC", "root", "12345");
		}catch (Exception e) {
			throw new RuntimeException(e);
		}
	}
	
	public static void closeConnection(Connection con) {
		try {
			con.close();
		} catch (SQLException e) {			
			System.out.println("Exception: " + e);;
		}
	}
}
