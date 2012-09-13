package com.site.dao;

import java.util.List;

import javax.persistence.Query;

import com.site.model.MenuUsuario;

public class MenuUsuarioDAO extends PrincipalDAO{

	private static final String TIPO_USUARIO = "tipoUsuario";
	
	private static final String QUERY_ENCONTRAR_TODOS_OS_MENUS = 
			"select obj from " + MenuUsuario.class.getName()  + " obj";
	
	private static final String QUERY_ENCONTRAR_MENUS_POR_USUARIO = 
			"select obj from " + MenuUsuario.class.getName() + " obj" + 
			" where obj.tipoUsuario =:" + TIPO_USUARIO + 
			" order by obj.posicao asc";
	
	public MenuUsuarioDAO() {
		super();
	}

	@SuppressWarnings("unchecked")
	public List<MenuUsuario> encontrarTodos(){
		Query query = getEntityManager().createQuery(QUERY_ENCONTRAR_TODOS_OS_MENUS);
		List<MenuUsuario> listaMenus = (List<MenuUsuario>) query.getResultList();
		return listaMenus;
	}
	
	@SuppressWarnings("unchecked")
	public List<MenuUsuario> encontrarPorTipoUsuario(String tipoUsuario){
		Query query = getEntityManager().createQuery(QUERY_ENCONTRAR_MENUS_POR_USUARIO);
		query.setParameter(TIPO_USUARIO, tipoUsuario);
		return (List<MenuUsuario>) query.getResultList();
	}
}
