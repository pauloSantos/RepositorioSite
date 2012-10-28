package com.site.dao;

import java.util.List;

import javax.persistence.Query;

import com.site.model.CadastroMedico;
import com.site.model.Dieta;

public class DietaDAO extends PrincipalDAO implements IDietaDAO{

	
	private static final String CADASTRO_MEDICO = "cadastroMedico";
	private static final String ENCONTRAR_DIETA_POR_CADASTRO_MEDICO = 
			"select obj from "  + Dieta.class.getName() + " obj" + 
			" where obj.medico =:" + CADASTRO_MEDICO;

	public DietaDAO(){
		super();
	}
	
	@Override
	@SuppressWarnings("unchecked")
	public List<Dieta> encontrarDietaPorCadastroMedico(CadastroMedico cadastroMedico){
		Query query = getEntityManager().createQuery(ENCONTRAR_DIETA_POR_CADASTRO_MEDICO);
		query.setParameter(CADASTRO_MEDICO, cadastroMedico);
		return (List<Dieta>)query.getResultList();
	}
	
}
