package com.site.dao;

import java.util.List;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.site.model.CadastroMedico;
import com.site.model.Dieta;

public class DietaDAO extends PrincipalDAO implements IDietaDAO{

	
	private static final String CADASTRO_MEDICO = "cadastroMedico";
	private static final String NOME_DIETA = "nomeDieta";
	private static final String ENCONTRAR_DIETA_POR_CADASTRO_MEDICO = 
			"select obj from "  + Dieta.class.getName() + " obj" + 
			" where obj.medico =:" + CADASTRO_MEDICO;
	
	private static final String ENCONTRAR_DIETA_POR_NOME = 
			"select obj from " + Dieta.class.getName() + " obj" +
			" where obj.nomeDieta LIKE CONCAT('%', :" + NOME_DIETA + ", '%')";
	
	private static final String ENCONTRAR_DIETA_POR_NOME_EXATO = 
			"select obj from " + Dieta.class.getName() + " obj" +
					" where obj.nomeDieta =:" + NOME_DIETA;
	

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

	@Override
	@SuppressWarnings("unchecked")
	public List<Dieta> encontrarDietaPorNome(String nomeDieta) {
		Query query = getEntityManager().createQuery(ENCONTRAR_DIETA_POR_NOME);
		query.setParameter(NOME_DIETA, nomeDieta);
		return (List<Dieta>)query.getResultList();
	}
	
	@Override
	public Dieta encontrarDietaPorNomeExato(String nomeDieta) {
		Query query = getEntityManager().createQuery(ENCONTRAR_DIETA_POR_NOME_EXATO);
		query.setParameter(NOME_DIETA, nomeDieta);
		try {
			return (Dieta) query.getSingleResult();
		} catch (NoResultException e) {
			return null;
		}
		
	}
	
	
	
}
