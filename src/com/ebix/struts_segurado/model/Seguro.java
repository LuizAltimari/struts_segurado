package com.ebix.struts_segurado.model;

public class Seguro {

	private int id;
	private String seguro;
	private double valor;	
	
	public Seguro() {
		
	}

	public Seguro(String seguro, double valor) {
		super();
		this.seguro = seguro;
		this.valor = valor;
	}
	
	public Seguro(int id, String seguro, double valor) {
		super();
		this.id = id;
		this.seguro = seguro;
		this.valor = valor;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public double getValor() {
		return valor;
	}

	public void setValor(double valor) {
		this.valor = valor;
	}
	

	public String getSeguro() {
		return seguro;
	}

	public void setSeguro(String seguro) {
		this.seguro = seguro;
	}

	
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
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
		Seguro other = (Seguro) obj;
		if (id != other.id)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return seguro;
	}
	
	
	
}
