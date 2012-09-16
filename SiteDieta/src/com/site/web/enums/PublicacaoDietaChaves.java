package com.site.web.enums;

public enum PublicacaoDietaChaves {

	
	ALIMENTO_MANHA_1("alimento1"),
	ALIMENTO_MANHA_2("alimento2"),
	ALIMENTO_MANHA_3("alimento3"),
	ALIMENTO_MANHA_4("alimento4"),
	ALIMENTO_MANHA_5("alimento5"),
	ALIMENTO_MANHA_6("alimento6"),
	ALIMENTO_MANHA_7("alimento7"),
	ALIMENTO_MANHA_8("alimento8"),
	ALIMENTO_MANHA_9("alimento9"),
	ALIMENTO_MANHA_10("alimento10");
	
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
