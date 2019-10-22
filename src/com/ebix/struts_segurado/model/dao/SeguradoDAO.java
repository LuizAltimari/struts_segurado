package com.ebix.struts_segurado.model.dao;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

import com.ebix.struts_segurado.conexao.ConnectionFactory;
import com.ebix.struts_segurado.model.Segurado;

public class SeguradoDAO extends ConnectionFactory {

	public List<Segurado> listar() {
		Connection conn = getConnection();
		List<Segurado> segurados = new ArrayList<>();
		SeguradoDiaDAO sdDao = new SeguradoDiaDAO();
		SeguradoSeguroDAO ssDao = new SeguradoSeguroDAO();
		try {
			String sql = "select * from segurado;";
			PreparedStatement stmt = conn.prepareStatement(sql);
			ResultSet rs = stmt.executeQuery();

			while (rs.next()) {
				Segurado seg = new Segurado(rs.getString("nome"), rs.getString("cpf"), rs.getBoolean("correntista"),
						rs.getDate("dataNascimento"), rs.getDate("dataCadastro"), rs.getDate("dataAlteracao"),
						rs.getString("sexo"), rs.getString("rg"));
				seg.setSeguros(ssDao.listarPorCpf(seg.getCpf()));
				seg.setDiasDeVisita(sdDao.listarPorCpf(seg.getCpf()));
				segurados.add(seg);
			}
			return segurados;
		} catch (SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return null;
		} finally {
			closeConnection(conn);
		}

	}

	public Segurado selecionar(String cpf) {
		Segurado segurado = null;
		SeguradoDiaDAO sdDao = new SeguradoDiaDAO();
		SeguradoSeguroDAO ssDao = new SeguradoSeguroDAO();
		Connection conn = getConnection();
		try {
			String sql = "select * from segurado where cpf = '" + cpf + "';";
			PreparedStatement stmt = conn.prepareStatement(sql);
			// stmt.setInt(1, id);
			ResultSet rs = stmt.executeQuery(sql);

			if (rs != null && rs.next()) {
				segurado = new Segurado(rs.getString("nome"), rs.getString("cpf"), rs.getBoolean("correntista"),
						rs.getDate("dataNascimento"), rs.getDate("dataCadastro"), rs.getDate("dataAlteracao"),
						rs.getString("sexo"), rs.getString("rg"));
				segurado.setDiasDeVisita(sdDao.listarPorCpf(cpf));
				segurado.setSeguros(ssDao.listarPorCpf(cpf));
			}

			return segurado;

		} catch (SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return null;
		} finally {
			closeConnection(conn);
		}
	}

	public boolean salvar(Segurado segurado) {
		Connection conn = getConnection();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String sql = "insert into segurado (nome, cpf, correntista, dataNascimento, dataCadastro, dataAlteracao,"
					+ " sexo, rg) values (?,?,?,?,?,?,?,?)";
			PreparedStatement stmt = conn.prepareStatement(sql);
			stmt.setString(1, segurado.getNome());
			stmt.setString(2, segurado.getCpf());
			stmt.setBoolean(3, segurado.isCorrentista());

			stmt.setString(4, sdf.format (new Timestamp(segurado.getDataNascimento().getTime())));
			stmt.setString(5, sdf.format (new Timestamp(new java.util.Date().getTime())));
			stmt.setString(6, sdf.format (new Timestamp(new java.util.Date().getTime())));
			stmt.setString(7, segurado.getSexo());
			stmt.setString(8, segurado.getRg());
			
			

			stmt.executeUpdate();
			return true;
		} catch (SQLException e) {
			System.out.println("Execption: " + e.getMessage());
			return false;
		} finally {
			closeConnection(conn);
		}
	}

	public boolean alterar(Segurado seg) {
		Connection conn = getConnection();
		try {
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy/MM/dd");
			String sql = "update segurado set nome = '" + seg.getNome()  + "', "
					+ "correntista = " + seg.isCorrentista() + ", " + "dataNascimento = '" + sdf.format(seg.getDataNascimento())
					+ "', sexo = '" + seg.getSexo() + "'," + "rg = '" + seg.getRg() + "' where cpf = '"+ seg.getCpf() + "';";
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

	public boolean deletar(String cpf) {
		Connection conn = getConnection();
		SeguradoDiaDAO sdDao = new SeguradoDiaDAO();
		SeguradoSeguroDAO ssDao = new SeguradoSeguroDAO();
		try {
			String sql = "delete from segurado where cpf = '" + cpf + "';";
			PreparedStatement stmt = conn.prepareStatement(sql);
			sdDao.deletarPorSegurado(cpf);
			ssDao.deletarPorSegurado(cpf);
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
