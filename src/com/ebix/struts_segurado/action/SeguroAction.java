package com.ebix.struts_segurado.action;

import java.util.ArrayList;
import java.util.List;

import com.ebix.struts_segurado.model.Seguro;
import com.ebix.struts_segurado.model.dao.SeguroDAO;
import com.opensymphony.xwork2.ActionSupport;

public class SeguroAction extends ActionSupport {

	private static final long serialVersionUID = 1L;

	private List<Seguro> lista = new ArrayList<>();
	private Integer id;
	private String seguro;
	private double valor;
	private Seguro seg;

	public String listar() {
		SeguroDAO dao = new SeguroDAO();

		this.lista = dao.listar();

		if (this.lista != null) {

			return "success";

		} else {
			return "error";
		}
	}

	public String deletar() {
		SeguroDAO dao = new SeguroDAO();

		if (dao.deletar(id)) {
			return "success";
		} else {
			return "error";
		}
	}

	public String cadastrar() {
		SeguroDAO dao = new SeguroDAO();
		Seguro seg = new Seguro(seguro, valor);
		if (dao.salvar(seg)) {
			return "success";
		}

		else {
			return "error";
		}

	}

	public String alterar() {
		SeguroDAO dao = new SeguroDAO();

		try {
			this.setSeg(dao.selecionar(id));
			if (this.seg != null) {
				this.seg = new Seguro(id, seguro, valor);
				dao.alterar(this.seg);
				return "success";
			}

		} catch (Exception e) {
			System.err.println(e.getMessage());
			return "error";
		}

		return INPUT;
	}

	public String carregar() {
		SeguroDAO dao = new SeguroDAO();
		try {
			this.seg = dao.selecionar(id);
			this.seguro = this.seg.getSeguro();
			this.valor = this.seg.getValor();
			return "success";
		} catch (Exception e) {
			System.err.println(e.getMessage());
			return "error";
		}

	}

	public List<Seguro> getLista() {
		return lista;
	}

	public void setLista(List<Seguro> lista) {
		this.lista = lista;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getSeguro() {
		return seguro;
	}

	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}

	public Seguro getSeg() {
		return seg;
	}

	public void setSeg(Seguro seg) {
		this.seg = seg;
	}

}
