package com.site.business.enums;

public enum RespostaCadastro {

	SUCESSO ("Parab&eacute;ns seu cadastro foi feito"),
	NOME_INVALIDO ("Nome &eacute; um campo obrigat&oacute;rio"), 
	TIPO_REGISTRO_INVALIDO ("Tipo de Registro Inv&aacute;lido"),
	CPF_INVALIDO ("CPF Inv&aacute;lido"),
	REGISTRO_PROFISSIONAL_INVALIDO ("N&uacute;mero Registro Profissional Inv&aacute;lido"),
	LOGIN_INVALIDO ("Login inv&aacute;lido"), 
	LOGIN_JA_EXISTE ("Login j&aacute; existe"),
	SENHA_NAO_CONFIRMADA ("Senha e confirma&ccedil;&atilde;o de senha s&atilde;o diferentes"), 
	SENHA_INVALIDA ("Senha Inv&aacute;lida"),
	ERRO("");

	String mensagem;

	private RespostaCadastro(String mensagem) {
		this.mensagem = mensagem;
	}

	public String getMensagem() {
		return this.mensagem;
	}
}
