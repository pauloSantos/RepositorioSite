package com.site.business;

import java.util.List;

import com.site.dao.DietaDAO;
import com.site.model.CadastroMedico;
import com.site.model.Dieta;
import com.site.model.Usuario;

public class GerenciadorDietasBusiness implements IGerenciadorDietasBusiness {

	public List<Dieta> getDieta(Usuario usuario){
		CadastroMedico cadastroMedico = usuario.getCadastroMedico();
		DietaDAO dietaDAO = new DietaDAO();
		return dietaDAO.encontrarDietaPorCadastroMedico(cadastroMedico);
	}
	
}
