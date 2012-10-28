package com.site.web.enums;

public enum PublicacaoDietaChaves {

	
	ALIMENTO_MANHA_1("alimentoManha1"),
	ALIMENTO_MANHA_2("alimentoManha2"),
	ALIMENTO_MANHA_3("alimentoManha3"),
	ALIMENTO_MANHA_4("alimentoManha4"),
	ALIMENTO_MANHA_5("alimentoManha5"),
	ALIMENTO_MANHA_6("alimentoOpcionalManha6"),
	ALIMENTO_MANHA_7("alimentoOpcionalManha7"),
	ALIMENTO_MANHA_8("alimentoOpcionalManha8"),
	ALIMENTO_MANHA_9("alimentoOpcionalManha9"),
	ALIMENTO_MANHA_10("alimentoOpcionalManha10"),
	
	ALIMENTO_TARDE_1("alimentoTarde1"),
	ALIMENTO_TARDE_2("alimentoTarde2"),
	ALIMENTO_TARDE_3("alimentoTarde3"),
	ALIMENTO_TARDE_4("alimentoTarde4"),
	ALIMENTO_TARDE_5("alimentoTarde5"),
	ALIMENTO_TARDE_6("alimentoOpcionalTarde6"),
	ALIMENTO_TARDE_7("alimentoOpcionalTarde7"),
	ALIMENTO_TARDE_8("alimentoOpcionalTarde8"),
	ALIMENTO_TARDE_9("alimentoOpcionalTarde9"),
	ALIMENTO_TARDE_10("alimentoOpcionalTarde10"),
	
	ALIMENTO_NOITE_1("alimentoNoite1"),
	ALIMENTO_NOITE_2("alimentoNoite2"),
	ALIMENTO_NOITE_3("alimentoNoite3"),
	ALIMENTO_NOITE_4("alimentoNoite4"),
	ALIMENTO_NOITE_5("alimentoNoite5"),
	ALIMENTO_NOITE_6("alimentoOpcionalNoite6"),
	ALIMENTO_NOITE_7("alimentoOpcionalNoite7"),
	ALIMENTO_NOITE_8("alimentoOpcionalNoite8"),
	ALIMENTO_NOITE_9("alimentoOpcionalNoite9"),
	ALIMENTO_NOITE_10("alimentoOpcionalNoite10");
	
	private String chave;
	
	PublicacaoDietaChaves(String chave){
		this.chave = chave;
	}
	
	public String getChave(){
		return chave;
	}
	
	public static void main(String[] args) {
		PublicacaoDietaChaves[] values = values();
		for (PublicacaoDietaChaves p : values) {
			System.out.println(p.toString());
		}
	}
}
