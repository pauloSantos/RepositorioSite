package com.site.model;

public class Alimento {

	private String nomeAlimento;
	private int quantidade;
	private String unidadeDeMedida;
	
	public Alimento(String nomeAlimento, int quantidadeAlimento, String unidadeDeMedida){
		this.nomeAlimento = nomeAlimento;
		this.quantidade = quantidadeAlimento;
		this.unidadeDeMedida = unidadeDeMedida;
	}
	
	public String getNomeAlimento() {
		return nomeAlimento;
	}
	
	public void setNomeAlimento(String nomeAlimento) {
		this.nomeAlimento = nomeAlimento;
	}
	
	public int getQuantidade() {
		return quantidade;
	}
	public void setQuantidade(int quantidade) {
		this.quantidade = quantidade;
	}
	public String getUnidadeDeMedida() {
		return unidadeDeMedida;
	}
	public void setUnidadeDeMedida(String unidadeDeMedida) {
		this.unidadeDeMedida = unidadeDeMedida;
	}
	
}
