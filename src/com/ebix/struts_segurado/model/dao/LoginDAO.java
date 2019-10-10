package com.ebix.struts_segurado.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.ebix.struts_segurado.conexao.ConnectionFactory;
import com.ebix.struts_segurado.model.Login;

public class LoginDAO {
	
	private Connection conn;
	
	public LoginDAO() {
		this.conn = new ConnectionFactory().getConnection();
	}
	
	public boolean loginExiste(Login login) {
		ResultSet rs;
		try {
			String sql = "select usuario, senha from login where usuario = '" + login.getUsuario() +"' and senha = '" + login.getSenha() +"';";
			PreparedStatement stmt = this.conn.prepareStatement(sql);
			
			//stmt.setString(1, login.getUsuario());
			//stmt.setString(2, login.getSenha());
			
			rs = stmt.executeQuery(sql);
			
			if(rs != null) {
				return true;
			}
			else {
				return false;
			}
			
		} catch(SQLException e) {
			System.out.println(e.getMessage());
			return false;
		}
		finally {
			ConnectionFactory.closeConnection(this.conn);
		}
		
	}

}
