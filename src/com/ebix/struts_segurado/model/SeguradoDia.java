package com.ebix.struts_segurado.model;

public class SeguradoDia {
	
	private Segurado segurado;
	private Dia dia;
	
	public SeguradoDia(Segurado segurado, Dia dia) {
		super();
		this.segurado = segurado;
		this.dia = dia;
	}

	public Segurado getSegurado() {
		return segurado;
	}

	public void setSegurado(Segurado segurado) {
		this.segurado = segurado;
	}

	public Dia getDia() {
		return dia;
	}

	public void setDia(Dia dia) {
		this.dia = dia;
	}

	@Override
	public String toString() {
		return "SeguradoDia [segurado=" + segurado.toString() + ", dia=" + dia + "]";
	}
	
	

}
