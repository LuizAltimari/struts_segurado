package com.ebix.struts_segurado.model.enums;

public enum DiaDaSemana {

	SEGUNDA (1, "Segunda-feira"),
	TERCA(2, "Terça-feira"),
	QUARTA(3, "Quarta-feira"),
	QUINTA(4, "Quinta-feira"),
	SEXTA(5, "Sexta-feira");
	
	private int cod;
	private String descricao;
	
	private DiaDaSemana(int cod, String descricao) {
		this.cod = cod;
		this.descricao = descricao;
	}

	public int getCod() {
		return cod;
	}

	public String getDescricao() {
		return descricao;
	}
	
	public static DiaDaSemana toEnum(Integer cod) {
		if(cod == null) {
			return null;
		}
		
		for(DiaDaSemana dia : DiaDaSemana.values()) {
			if(cod.equals(dia.cod)) {
				return dia;
			}
		}			
		throw new IllegalArgumentException("Código inválido: " + cod);
	}
}

