package com.ebix.struts_segurado.action;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.ebix.struts_segurado.model.Dia;
import com.ebix.struts_segurado.model.Segurado;
import com.ebix.struts_segurado.model.Seguro;
import com.ebix.struts_segurado.model.dao.SeguradoDAO;
import com.ebix.struts_segurado.model.dao.SeguroDAO;
import com.opensymphony.xwork2.ActionSupport;

public class SeguradoAction extends ActionSupport {

	private static final long serialVersionUID = 1L;
	private List<Segurado> lista = new ArrayList<>();
	private Segurado segurado;
	private String nome;
	private String cpf;
	private String rg;
	private String sexo;
	private boolean correntista;
	private Date dataNascimento;
	private Date dataCadastro;
	private Date dataAlteracao;
	private List<Dia> diasDeVisita = new ArrayList<>();
	private List<Seguro> seguros = new ArrayList<>();
	private List<Seguro> listaSeguros = new ArrayList<>();

	public String listar() {
		SeguradoDAO dao = new SeguradoDAO();

		this.lista = dao.listar();

		if (this.lista != null) {

			return "success";

		} else {
			return "error";
		}
	}
	
	public String cadastrar() {
		SeguradoDAO dao = new SeguradoDAO();
		this.segurado = new Segurado(this.nome, this.cpf, this.correntista, this.getDataNascimento(), new Date(), new Date(), this.sexo, this.rg);
		if(dao.salvar(this.segurado)) {
			return "success";
		}
		else {
			return "error";
		}
	}
	
	public String deletar() {
		SeguradoDAO dao = new SeguradoDAO();

		if (dao.deletar(this.cpf)) {
			return "success";
		} else {
			return "error";
		}
	}
	
	public String carregar() {
		SeguradoDAO dao = new SeguradoDAO();
		try {
			this.segurado = dao.selecionar(cpf);
			this.correntista = segurado.isCorrentista();
			this.dataAlteracao = segurado.getDataAlteracao();
			this.dataCadastro = segurado.getDataCadastro();
			this.dataNascimento = segurado.getDataNascimento();
			this.diasDeVisita = segurado.getDiasDeVisita();
			this.nome = segurado.getNome();
			this.rg = segurado.getRg();
			this.seguros = segurado.getSeguros();
			
			return "success";
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return "error";
		}

	}
	
	public String alterar() {		
		SeguradoDAO dao = new SeguradoDAO();

		try {			
			this.segurado = dao.selecionar(cpf);
			if (this.segurado != null) {
				this.segurado = new Segurado(nome, cpf, correntista, dataNascimento, dataCadastro, dataAlteracao, sexo, rg);
				dao.alterar(this.segurado);
				return "success";
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return "error";
		}
		
		return "input";
	
	}
	
	public String carregarSeguros(){
		SeguroDAO dao = new SeguroDAO();
		
		this.setListaSeguros(dao.listar());
		return "success";
	}

	public List<Segurado> getLista() {
		return lista;
	}

	public void setLista(List<Segurado> lista) {
		this.lista = lista;
	}

	public Segurado getSegurado() {
		return segurado;
	}

	public void setSegurado(Segurado segurado) {
		this.segurado = segurado;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getSexo() {
		return sexo;
	}

	public void setSexo(String sexo) {
		this.sexo = sexo;
	}

	public boolean isCorrentista() {
		return correntista;
	}

	public void setCorrentista(boolean correntista) {
		this.correntista = correntista;		
	}

	public Date getDataNascimento() {
		return dataNascimento;
	}

	public void setDataNascimento(Date dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public Date getDataCadastro() {
		return dataCadastro;
	}

	public void setDataCadastro(Date dataCadastro) {
		this.dataCadastro = dataCadastro;
	}

	public Date getDataAlteracao() {
		return dataAlteracao;
	}

	public void setDataAlteracao(Date dataAlteracao) {
		this.dataAlteracao = dataAlteracao;
	}

	public List<Dia> getDiasDeVisita() {
		return diasDeVisita;
	}

	public void setDiasDeVisita(List<Dia> diasDeVisita) {
		this.diasDeVisita = diasDeVisita;
	}

	public List<Seguro> getSeguros() {
		return seguros;
	}

	public void setSeguros(List<Seguro> seguros) {
		this.seguros = seguros;
	}

	public List<Seguro> getListaSeguros() {
		return listaSeguros;
	}

	public void setListaSeguros(List<Seguro> listaSeguros) {
		this.listaSeguros = listaSeguros;
	}

}
