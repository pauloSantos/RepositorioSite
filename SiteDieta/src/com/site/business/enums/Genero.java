package com.site.business.enums;

public enum Genero {

	M("MASCULINO"),
	F("FEMININO");
	
	private String descricao;
	
	Genero(String descricao){
		this.descricao =descricao;
	}

	public String getDescricao() {
		return descricao;
	}
	
}
