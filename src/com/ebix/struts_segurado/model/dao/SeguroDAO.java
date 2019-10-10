package com.ebix.struts_segurado.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ebix.struts_segurado.conexao.ConnectionFactory;
import com.ebix.struts_segurado.model.Seguro;

public class SeguroDAO extends ConnectionFactory {
	
	
	public List<Seguro> listar(){
		Connection conn = getConnection();
		List<Seguro> seguros = new ArrayList<>();
		try {
			String sql = "select * from seguro;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();
			
			while(rs.next()) {
				seguros.add(new Seguro(rs.getInt("id") , rs.getString("seguro"), rs.getDouble("valor")));
			}
			return seguros;
		} catch(SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return null;
		} finally {
			closeConnection(conn);
		}
		
	} 
	
	public Seguro selecionar(int id) {
		Seguro seguro = null;
		Connection conn = getConnection();
		try {
			String sql = "select * from seguro where id = " + id + ";";
			PreparedStatement stmt = conn.prepareStatement(sql);
			//stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery(sql);
			
			if(rs != null && rs.next()) {
				seguro = new Seguro(rs.getInt("id") , rs.getString("seguro"), rs.getDouble("valor"));
			}
						
			return seguro;
			
		} catch (SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return null;
		} finally {
			closeConnection(conn);
		}
	}
		
	public boolean salvar(Seguro seguro) {
		Connection conn = getConnection();
		try {			
			String sql = "insert into seguro (seguro, valor) values (?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql); 
			stmt.setString(1, seguro.getSeguro());
			stmt.setDouble(2, seguro.getValor());
			
			stmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return false;
		}finally {
			closeConnection(conn);
		}
	}
	
	public boolean alterar(Seguro seg) {
		Connection conn = getConnection();
		try {
			String sql = "update seguro set seguro = '" + seg.getSeguro() +"', valor = "+ seg.getValor() +" where id = " + seg.getId() +";";
			PreparedStatement stmt = conn.prepareStatement(sql); 
			
			stmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return false;
		} finally {
			closeConnection(conn);
		}
	}
	
	public boolean deletar(int id) {
		Connection conn = getConnection();
		try {
			String sql = "delete from seguro where id = " + id + ";";
			PreparedStatement stmt = conn.prepareStatement(sql); 						
			stmt.executeUpdate();
			return true;
		}catch(SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return false;
		} finally {
			closeConnection(conn);
		}
		
	}
	
	
}
