package com.ebix.struts_segurado.model.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.ebix.struts_segurado.conexao.ConnectionFactory;
import com.ebix.struts_segurado.model.Dia;
import com.ebix.struts_segurado.model.Segurado;
import com.ebix.struts_segurado.model.SeguradoDia;

public class SeguradoDiaDAO extends ConnectionFactory {

	public boolean salvar(String cpf, int id_dia) {

		Connection conn = getConnection();
		try {
			String sql = "insert into segurado_semana (cpf_segurado, id_dia) values (?, ?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, cpf);
			stmt.setInt(2, id_dia);

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return false;
		} finally {
			closeConnection(conn);
		}
	}

	public List<SeguradoDia> listar() {

		Connection conn = getConnection();
		List<SeguradoDia> sd = new ArrayList<>();
		SeguradoDAO segdao = new SeguradoDAO();
		DiaDAO diadao = new DiaDAO();
		try {
			String sql = "select * from segurado_semana;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				sd.add(new SeguradoDia(segdao.selecionar(rs.getString("cpf_segurado")),
						diadao.selecionar(rs.getInt("id_dia"))));
			}
			return sd;
		} catch (SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return null;
		} finally {
			closeConnection(conn);
		}

	}

	public List<Dia> listarPorCpf(String cpf) {
		List<Dia> d = new ArrayList<>();
		DiaDAO diadao = new DiaDAO();
		Connection conn = getConnection();
		try {
			String sql = "select * from segurado_semana where cpf_segurado = '" + cpf + "';";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				d.add(diadao.selecionar(rs.getInt("id_dia")));
			}
			return d;

		} catch (SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return null;
		} finally {
			closeConnection(conn);
		}
	}

	public List<Segurado> listarPorDia(int id) {
		List<Segurado> s = new ArrayList<>();
		SeguradoDAO sdao = new SeguradoDAO();
		Connection conn = getConnection();
		try {
			String sql = "select * from segurado_semana where id_dia = " + id + ";";
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

	public boolean deletar(String cpf, int id_dia) {

		Connection conn = getConnection();
		try {
			String sql = "Delete from segurado_semana where id_dia = " + id_dia + " and cpf_segurado = '" + cpf + "'";
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
	
	public boolean deletarPorDia(int id_dia) {

		Connection conn = getConnection();
		try {
			String sql = "Delete from segurado_semana where id_dia = " + id_dia + "; ";
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
			String sql = "Delete from segurado_semana where cpf_segurado = " + cpf + "; ";
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
