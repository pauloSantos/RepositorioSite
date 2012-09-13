package com.site.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.business.MenuUsuarioBusiness;
import com.site.business.enums.TipoUsuario;
import com.site.model.MenuUsuario;

public class MenuUsuarioServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {}
	
	public List<MenuUsuario> getMenuPadrao(){
		MenuUsuarioBusiness menuUsuarioBusiness = new MenuUsuarioBusiness();
		return menuUsuarioBusiness.getListaMenusPorUsuario(TipoUsuario.PADRAO.name());
	}
	
	public List<MenuUsuario> getMenuAdmin(){
		MenuUsuarioBusiness menuUsuarioBusiness = new MenuUsuarioBusiness();
		return menuUsuarioBusiness.getListaMenusPorUsuario(TipoUsuario.ADMIN.name());
	}
	public List<MenuUsuario> getMenuMedico(){
		MenuUsuarioBusiness menuUsuarioBusiness = new MenuUsuarioBusiness();
		return menuUsuarioBusiness.getListaMenusPorUsuario(TipoUsuario.MEDICO.name());
	}
}