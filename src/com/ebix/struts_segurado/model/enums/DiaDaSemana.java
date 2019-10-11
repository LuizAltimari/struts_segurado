package com.ebix.struts_segurado.model.enums;

public enum DiaDaSemana {

	SEGUNDA (1, "Segunda"),
	TERCA(2, "Terça"),
	QUARTA(3, "Quarta"),
	QUINTA(4, "Quinta"),
	SEXTA(5, "Sexta");
	
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
	
	public static DiaDaSemana toEnum(String descricao) {
		if(descricao == null) {
			return null;
		}
		
		for(DiaDaSemana dia : DiaDaSemana.values()) {
			if(descricao.equals(dia.descricao)) {
				return dia;
			}
		}			
		throw new IllegalArgumentException("Descrição inválida: " + descricao);
	}
}

