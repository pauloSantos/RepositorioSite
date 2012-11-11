package com.site.dao;

import javax.persistence.NoResultException;
import javax.persistence.Parameter;
import javax.persistence.Query;

import com.site.model.CadastroMedico;
import com.site.model.Usuario;


public class UsuarioDAO extends PrincipalDAO{

	private static final String LOGIN = "login";
	private static final String ID_USUARIO = "idUsuario";
	private static final String  CADASTRO_MEDICO = "cadastroMedico";
	
	private static final String ENCONTRAR_USUARIO_POR_LOGIN =
			"select obj from " + Usuario.class.getName()  + " obj" +
			" where obj.login=:" + LOGIN ;
	
	private static final String ENCONTRAR_USUARIO_POR_ID = 
			"select obj from "  + Usuario.class.getName() + " obj" + 
			" where obj.id =:" + ID_USUARIO; 
	
	private static final String DELETAR_USUARIO_POR_CADASTRO_MEDICO =
			"delete from " + Usuario.class.getName() +" obj" +
			" where obj.cadastroMedico =:" + CADASTRO_MEDICO;
	
	public UsuarioDAO() {
		super();
	}
	
	public Usuario encontrarUsuario(String login){
		Query query = getEntityManager().createQuery(ENCONTRAR_USUARIO_POR_LOGIN);
		query.setParameter(LOGIN, login);
		try{
			return (Usuario)query.getSingleResult();
			
		} catch (NoResultException e) {
			return null; 
		}
	}
	
	public Usuario encontrarPorId(Long id){
		Query query = getEntityManager().createQuery(ENCONTRAR_USUARIO_POR_ID);
		query.setParameter(ID_USUARIO, id);
		return (Usuario) query.getSingleResult();
	}
	
	public void deletarUsuario(CadastroMedico cadastroMedico){
		Query query = manager.createQuery(DELETAR_USUARIO_POR_CADASTRO_MEDICO);
		query.setParameter(CADASTRO_MEDICO, cadastroMedico);
		manager.getTransaction().begin();
		query.executeUpdate();
		manager.getTransaction().commit();
	}
}
