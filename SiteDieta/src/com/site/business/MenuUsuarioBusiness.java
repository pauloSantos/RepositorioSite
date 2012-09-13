package com.site.business;

import java.util.List;

import com.site.dao.MenuUsuarioDAO;
import com.site.model.MenuUsuario;

public class MenuUsuarioBusiness {

	public List<MenuUsuario> getListaMenusPorUsuario(String tipoUsuario){
		MenuUsuarioDAO menuDAO = new MenuUsuarioDAO();
		List<MenuUsuario> menuUsuarioList = menuDAO.encontrarPorTipoUsuario(tipoUsuario);
		return menuUsuarioList;
	}
}
