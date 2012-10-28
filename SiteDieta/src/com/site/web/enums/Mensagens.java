package com.site.web.enums;

public enum Mensagens{

	ALIMENTO_OBRIGATORIO("Ao menos um alimento deve ser preenchido em cada per&iacute;odo"),
	QUANTIDADE_OBRIGATORIA("Quantidade &eacute; um campo obrigat&oacute;rio"),
	UNIDADE_DE_MEDIDA_OBRIGATORIA("Escolha uma unidade de medida para o alimento"),
	ERRO_PUBLICACAO_DIETA("Ocorreu um erro na publica&ccedil;&atilde;o da dieta"),
	SUCESSO_CADASTRO_DIETA("Dieta cadastrada com sucesso");
	
	private String mensagem;
	
	private Mensagens(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return mensagem;
	}
}
