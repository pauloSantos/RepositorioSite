package com.site.dao;

import java.util.HashMap;
import java.util.Map;

import javax.persistence.NoResultException;
import javax.persistence.Query;

import com.site.model.Usuario;


public class UsuarioDAO extends PrincipalDAO{

	private static final String LOGIN = "login";
	private static final String ENCONTRAR_USUARIO_POR_LOGIN =
			"select obj from " + Usuario.class.getName()  + " obj" +
			" where obj.login=:" + LOGIN ; 
	
	public UsuarioDAO() {
		super();
	}
	
	public Usuario encontrarUsuario(String login){
		Map<String, Object> parametros = new HashMap<String, Object>();
		parametros.put(LOGIN, login);
		Query query = getEntityManager().createQuery(ENCONTRAR_USUARIO_POR_LOGIN);
		query.setParameter(LOGIN, login);
		try{
			return (Usuario)query.getSingleResult();
			
		} catch (NoResultException e) {
			return null; 
		}
	}
}
