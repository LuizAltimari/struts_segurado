package com.ebix.struts_segurado.model;

public class SeguradoSeguro {
	
	private Segurado segurado;
	private Seguro seguro;
	
	public SeguradoSeguro() {
		
	}

	public SeguradoSeguro(Segurado segurado, Seguro seguro) {
		super();
		this.segurado = segurado;
		this.seguro = seguro;
	}

	public Segurado getSegurado() {
		return segurado;
	}

	public void setSegurado(Segurado segurado) {
		this.segurado = segurado;
	}

	public Seguro getSeguro() {
		return seguro;
	}

	public void setSeguro(Seguro seguro) {
		this.seguro = seguro;
	}
	
	

}
