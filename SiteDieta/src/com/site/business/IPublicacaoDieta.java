package com.site.business;

import java.util.Map;

import com.site.model.Dieta;


public interface IPublicacaoDieta {

	boolean criarDieta(Dieta dieta, Map<String, String> nomeAlimentos, Map<String, Integer> quantidade, Map<String, String> listaUnidadeDeMedida, String horarioRefeicaoManha, String horarioRefeicaoTarde, String horarioRefeicaoNoite );
	
}
