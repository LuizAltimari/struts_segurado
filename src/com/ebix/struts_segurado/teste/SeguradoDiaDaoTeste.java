package com.ebix.struts_segurado.teste;

import java.text.ParseException;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.ebix.struts_segurado.model.Dia;
import com.ebix.struts_segurado.model.Segurado;
import com.ebix.struts_segurado.model.SeguradoDia;
import com.ebix.struts_segurado.model.dao.DiaDAO;
import com.ebix.struts_segurado.model.dao.SeguradoDAO;
import com.ebix.struts_segurado.model.dao.SeguradoDiaDAO;

public class SeguradoDiaDaoTeste {

	@Test	
	@Ignore
	public void salvar() {
							
		SeguradoDiaDAO dao3 = new SeguradoDiaDAO();
		if (dao3.salvar("11111111111", 3)) {
			System.out.println("Salvou");
		} else {
			System.out.println("deu ruim");
		}
	}

	@Test
	@Ignore
	public void listar() {
		SeguradoDiaDAO dao = new SeguradoDiaDAO();
		List<SeguradoDia> lista = dao.listar();

		for (SeguradoDia sd : lista) {

			System.out.println(sd.toString());
		}
	}

	@Test
	@Ignore
	public void ListarPorCpf() {

		SeguradoDiaDAO dao = new SeguradoDiaDAO();

		List<Dia> dias = dao.listarPorCpf("11111111111");

		for (Dia d : dias) {
			System.out.println(d.toString());
		}

	}

	@Test
	@Ignore
	public void ListarPorDia() {

		SeguradoDiaDAO dao = new SeguradoDiaDAO();

		List<Segurado> segs = dao.listarPorDia(3);

		for (Segurado s : segs) {
			System.out.println(s.toString());
		}
	}
	
	
	@Test
	@Ignore
	public void deletar() {
							
		SeguradoDiaDAO dao3 = new SeguradoDiaDAO();
		if (dao3.deletar("11111111111", 3)) {
			System.out.println("Deletou");
		} else {
			System.out.println("deu ruim");
		}
	}
	
	
	@Test
	@Ignore
	public void deletarPorDia() {
							
		SeguradoDiaDAO dao3 = new SeguradoDiaDAO();
		if (dao3.deletarPorDia(1)) {
			System.out.println("Deletou");
		} else {
			System.out.println("deu ruim");
		}
	}
	

}
