package com.ebix.struts_segurado.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ebix.struts_segurado.conexao.ConnectionFactory;
import com.ebix.struts_segurado.model.Segurado;

import com.ebix.struts_segurado.model.SeguradoSeguro;
import com.ebix.struts_segurado.model.Seguro;

public class SeguradoSeguroDAO extends ConnectionFactory {
	
	public boolean salvar(String cpf, int id_seguro) {

		Connection conn = getConnection();
		try {
			String sql = "insert into segurado_seguro (cpf_segurado, id_seguro) values (?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, cpf);
			stmt.setInt(2, id_seguro);

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return false;
		} finally {
			closeConnection(conn);
		}
	}

	public List<SeguradoSeguro> listar() {

		Connection conn = getConnection();
		List<SeguradoSeguro> sd = new ArrayList<>();
		SeguradoDAO segDao = new SeguradoDAO();
		SeguroDAO segurDao = new SeguroDAO();
		try {
			String sql = "select * from segurado_seguro;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				sd.add(new SeguradoSeguro(segDao.selecionar(rs.getString("cpf_segurado")),
						segurDao.selecionar(rs.getInt("id_seguro"))));
			}
			return sd;
		} catch (SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return null;
		} finally {
			closeConnection(conn);
		}

	}

	public List<Seguro> listarPorCpf(String cpf) {
		List<Seguro> s = new ArrayList<>();
		SeguroDAO seguroDao = new SeguroDAO();
		Connection conn = getConnection();
		try {
			String sql = "select * from segurado_seguro where cpf_segurado = '" + cpf + "';";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				s.add(seguroDao.selecionar(rs.getInt("id_seguro")));
			}
			return s;

		} catch (SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return null;
		} finally {
			closeConnection(conn);
		}
	}

	public List<Segurado> listarPorSeguro(int id) {
		List<Segurado> s = new ArrayList<>();
		SeguradoDAO sdao = new SeguradoDAO();
		Connection conn = getConnection();
		try {
			String sql = "select * from segurado_seguro where id_seguro = " + id + ";";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				s.add(sdao.selecionar(rs.getString("cpf_segurado")));
			}
			return s;

		} catch (SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return null;
		} finally {
			closeConnection(conn);
		}
	}

	public boolean deletar(String cpf, int id_seguro) {

		Connection conn = getConnection();
		try {
			String sql = "Delete from segurado_seguro where id_seguro = " + id_seguro + " and cpf_segurado = '" + cpf + "'";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return false;
		} finally {
			closeConnection(conn);
		}
	}
	
	public boolean deletarPorSeguro(int id_seguro) {

		Connection conn = getConnection();
		try {
			String sql = "Delete from segurado_seguro where id_seguro = " + id_seguro + "; ";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return false;
		} finally {
			closeConnection(conn);
		}
	}
	
	
	public boolean deletarPorSegurado(String cpf) {

		Connection conn = getConnection();
		try {
			String sql = "Delete from segurado_seguro where cpf_segurado = " + cpf + "; ";
			PreparedStatement stmt = conn.prepareStatement(sql);

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return false;
		} finally {
			closeConnection(conn);
		}
	}

}
