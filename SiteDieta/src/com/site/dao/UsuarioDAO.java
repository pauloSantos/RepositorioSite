package com.site.dao;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.site.model.Usuario;


public class UsuarioDAO extends PrincipalDAO{

	private static final String LOGIN = "login";
	private static final String ID_USUARIO = "idUsuario";
	
	private static final String ENCONTRAR_USUARIO_POR_LOGIN =
			"select obj from " + Usuario.class.getName()  + " obj" +
			" where obj.login=:" + LOGIN ;
	
	private static final String ENCONTRAR_USUARIO_POR_ID = 
			"select obj from "  + Usuario.class.getName() + " obj" + 
			" where obj.id =:" + ID_USUARIO; 
	
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

}
