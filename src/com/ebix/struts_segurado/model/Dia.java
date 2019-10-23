package com.ebix.struts_segurado.model;



public class Dia {
	
	private int id;
	private String dia;
	
	
	public Dia() {
		
	}

	public Dia(int id, String dia) {
		super();
		this.id = id;
		this.dia = dia;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getDia() {
		return dia;
	}

	public void setDia(String dia) {
		this.dia = dia;
	}

	@Override
	public String toString() {
		return dia;
	}
	
	
	
	

}
