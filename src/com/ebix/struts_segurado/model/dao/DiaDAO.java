package com.ebix.struts_segurado.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ebix.struts_segurado.conexao.ConnectionFactory;
import com.ebix.struts_segurado.model.Dia;
import com.ebix.struts_segurado.model.Seguro;

public class DiaDAO extends ConnectionFactory {

	public List<Dia> listar() {
		Connection conn = getConnection();
		List<Dia> dias = new ArrayList<>();
		try {
			String sql = "select * from semana;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				dias.add(new Dia(rs.getInt("id"), rs.getString("dia")));
			}
			return dias;
		} catch (SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return null;
		} finally {
			closeConnection(conn);
		}

	}
	
	public Dia selecionar(int id) {
		Dia dia = null;
		Connection conn = getConnection();
		try {
			String sql = "select * from semana where id = " + id + ";";
			PreparedStatement stmt = conn.prepareStatement(sql);
			//stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs != null && rs.next()) {
				dia = new Dia(rs.getInt("id"), rs.getString("dia"));
			}
						
			return dia;
			
		} catch (SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return null;
		} finally {
			closeConnection(conn);
		}
	}

}
