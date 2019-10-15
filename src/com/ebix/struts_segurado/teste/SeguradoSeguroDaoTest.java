package com.ebix.struts_segurado.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.ebix.struts_segurado.model.Seguro;
import com.ebix.struts_segurado.model.Segurado;
import com.ebix.struts_segurado.model.SeguradoSeguro;
import com.ebix.struts_segurado.model.dao.SeguradoSeguroDAO;

public class SeguradoSeguroDaoTest {


	@Test	
	@Ignore
	public void salvar() {
							
		SeguradoSeguroDAO dao3 = new SeguradoSeguroDAO();
		if (dao3.salvar("11111111111", 2)) {
			System.out.println("Salvou");
		} else {
			System.out.println("deu ruim");
		}
	}

	@Test
	@Ignore
	public void listar() {
		SeguradoSeguroDAO dao = new SeguradoSeguroDAO();
		List<SeguradoSeguro> lista = dao.listar();

		for (SeguradoSeguro sd : lista) {

			System.out.println(sd.toString());
		}
	}

	@Test	
	
	public void ListarPorCpf() {

		SeguradoSeguroDAO dao = new SeguradoSeguroDAO();

		List<Seguro> seguros = dao.listarPorCpf("11111111111");

		for (Seguro d : seguros) {
			System.out.println(d.toString());
		}

	}

	@Test	
	@Ignore
	public void ListarPorSeguro() {

		SeguradoSeguroDAO dao = new SeguradoSeguroDAO();

		List<Segurado> segs = dao.listarPorSeguro(3);

		for (Segurado s : segs) {
			System.out.println(s.toString());
		}
	}
	
	
	@Test
	@Ignore
	public void deletar() {
							
		SeguradoSeguroDAO dao3 = new SeguradoSeguroDAO();
		if (dao3.deletar("11111111111", 3)) {
			System.out.println("Deletou");
		} else {
			System.out.println("deu ruim");
		}
	}
	
	
	@Test
	@Ignore
	public void deletarPorSeguro() {
							
		SeguradoSeguroDAO dao3 = new SeguradoSeguroDAO();
		if (dao3.deletarPorSeguro(1)) {
			System.out.println("Deletou");
		} else {
			System.out.println("deu ruim");
		}
	}
}
