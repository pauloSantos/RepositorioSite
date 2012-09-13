package com.site.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.business.facade.AplicacaoSiteFacade;
import com.site.business.facade.AplicacaoSiteFacadeImpl;
import com.site.model.CadastroMedico;

public class BuscadorMedico extends HttpServlet {

	private static final long serialVersionUID = 1L;
       
	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
	
	public List<CadastroMedico> getCadastrosPendentes(){
		AplicacaoSiteFacade facade = new AplicacaoSiteFacadeImpl();
		return facade.visualizarCadastrosPendentes();
	}
}
