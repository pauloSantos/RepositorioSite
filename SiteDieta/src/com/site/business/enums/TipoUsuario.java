package com.site.business.enums;

public enum TipoUsuario {

	PADRAO("padrao"),
	ADMIN("admin"),
	MEDICO("medico");
	
	private String value;

	TipoUsuario(String value){
		this.value = value;
	}
	
	public String getValue(){
		return value;
	}
}
