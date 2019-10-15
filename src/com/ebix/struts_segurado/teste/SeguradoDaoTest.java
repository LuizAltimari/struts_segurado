package com.ebix.struts_segurado.teste;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;

import com.ebix.struts_segurado.model.Segurado;
import com.ebix.struts_segurado.model.dao.SeguradoDAO;


public class SeguradoDaoTest {

	@Test
	@Ignore
	public void salvar() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Segurado seg = new Segurado("Luiz", "11111111111", true, sdf.parse("03/06/1998"),
				sdf.parse("11/10/2019"), sdf.parse("11/10/2019"), "Masculino", "111111111");
		SeguradoDAO dao = new SeguradoDAO();
		if (dao.salvar(seg)) {
			System.out.println("Salvou");
		} else {
			System.out.println("deu ruim");
		}
	}
	
	@Test
	@Ignore
	public void selecionar() {
		SeguradoDAO dao = new SeguradoDAO();
		Segurado seg = dao.selecionar("11111111111");
		System.out.println(seg.toString());
	}
	
	
	@Test
	@Ignore
	public void listar() {
		SeguradoDAO dao = new SeguradoDAO();
		List<Segurado> seg = dao.listar();
		
		System.out.println(seg.toString());
	}
	
	@Test
	@Ignore
	public void alterar() throws ParseException {

		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
		Segurado seg = new Segurado("Luiz", "11111111111", true, sdf.parse("03/06/1998"),
				sdf.parse("10/10/2019"), sdf.parse("11/10/2019"), "Masculino", "111111111");
		SeguradoDAO dao = new SeguradoDAO();
		if (dao.alterar(seg)) {
			System.out.println("Alterou");
		} else {
			System.out.println("deu ruim");
		}
	}
	
	@Test
	@Ignore
	public void deletar() {
		SeguradoDAO dao = new SeguradoDAO();
		
		if (dao.deletar("1111111111")) {
			System.out.println("Deletou");
		} else {
			System.out.println("deu ruim");
		}
	}

}
