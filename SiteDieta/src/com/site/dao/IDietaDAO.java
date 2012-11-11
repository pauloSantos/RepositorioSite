package com.site.dao;

import java.util.List;

import com.site.model.CadastroMedico;
import com.site.model.Dieta;

public interface IDietaDAO {

	List<Dieta> encontrarDietaPorCadastroMedico(CadastroMedico cadastroMedico);
	List<Dieta> encontrarDietaPorNome(String nomeDieta);
	Dieta encontrarDietaPorNomeExato(String nomeDieta);
}
