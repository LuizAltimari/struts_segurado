package com.ebix.struts_segurado.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class Segurado {
	
	private String nome;
	private String cpf;
	private String rg;
	private String sexo;
	private boolean correntista;
	private List<Dia> diasDeVisita = new ArrayList<>();
	private Date dataNascimento;
	private Date dataCadastro;
	private Date dataAlteracao;
	private List<Seguro> seguros = new ArrayList<>();
	
	public Segurado() {
		
	}

	public Segurado(String nome, String cpf, boolean correntista, Date dataNascimento,
			Date dataCadastro, Date dataAlteracao, String sexo, String rg) {
		super();
		this.nome = nome;
		this.cpf = cpf;
		this.correntista = correntista;		
		this.dataNascimento = dataNascimento;
		this.dataCadastro = dataCadastro;
		this.dataAlteracao = dataAlteracao;
		this.sexo = sexo;
		this.rg = rg;
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
	
	public List<Seguro> getSeguros() {
		return seguros;
	}

	public void setSeguros(List<Seguro> seguros) {
		this.seguros = seguros;
	}

	public List<Dia> getDiasDeVisita() {
		return diasDeVisita;
	}

	public void setDiasDeVisita(List<Dia> diasDeVisita) {
		this.diasDeVisita = diasDeVisita;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((cpf == null) ? 0 : cpf.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Segurado other = (Segurado) obj;
		if (cpf == null) {
			if (other.cpf != null)
				return false;
		} else if (!cpf.equals(other.cpf))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Segurado [nome = " + nome + ", cpf = " + cpf + ", rg = " + rg + ", sexo= " + sexo + ", correntista = "
				+ correntista + ", diasDeVisita = " + diasDeVisita + ", dataNascimento = " + dataNascimento
				+ ", dataCadastro = " + dataCadastro + ", dataAlteracao = " + dataAlteracao + ", seguros = " + seguros + "]";
	}


	
	
	

}
