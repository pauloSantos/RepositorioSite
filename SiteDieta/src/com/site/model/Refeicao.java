package com.site.model;

import java.util.List;

public class Refeicao {

	private String horarioRefeicao;
	
	private List<Alimento> listaAlimentos;
	
	public String getHorarioRefeicao() {
		return horarioRefeicao;
	}
	
	public void setHorarioRefeicao(String horarioRefeicao) {
		this.horarioRefeicao = horarioRefeicao;
	}
	
	public List<Alimento> getListaAlimentos() {
		return listaAlimentos;
	}
	
	public void setListaAlimentos(List<Alimento> listaAlimentos) {
		this.listaAlimentos = listaAlimentos;
	}
}
