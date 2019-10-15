package com.ebix.struts_segurado.teste;

import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.ebix.struts_segurado.model.Seguro;
import com.ebix.struts_segurado.model.dao.SeguroDAO;

public class SeguroDaoTest {
	
	@Test
	@Ignore
	public void salvar() {
		Seguro seg = new Seguro("Seguro de Imóvel", 1000.0);
		SeguroDAO dao = new SeguroDAO();
		if(dao.salvar(seg)) {
			System.out.println("Salvou");
		}
		else {
			System.out.println("deu ruim");
		}
	}
	
	@Test
	@Ignore
	public void listar() {
		SeguroDAO dao = new SeguroDAO();
		List<Seguro> seguros = dao.listar();
		
		System.out.println(seguros.get(0).toString());
	}
	
	@Test
	public void selecionar() {
		SeguroDAO dao = new SeguroDAO();
		Seguro seg = dao.selecionar(2);
		System.out.println(seg.toString());
	}
	
	@Test
	@Ignore
	public void deletar() {
		
		SeguroDAO dao = new SeguroDAO();
		if(dao.deletar(1)) {
			System.out.println("Deletou");
		}
		else {
			System.out.println("deu ruim");
		}
	}
	
	@Test
	@Ignore
	public void alterar() {
		SeguroDAO dao = new SeguroDAO();
		Seguro seg = dao.selecionar(2);
		seg.setValor(450.0);
		if(dao.alterar(seg)) {
			System.out.println("Alterou");
		}
		else {
			System.out.println("deu ruim");
		}
	}

}
