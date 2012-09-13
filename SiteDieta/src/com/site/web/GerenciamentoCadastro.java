package com.site.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.business.CadastroMedicoBusiness;

/**
 * Servlet implementation class GerenciamentoCadastro
 */
public class GerenciamentoCadastro extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static final String PAGINA_SUCESSO = "WEB-INF/paginas/gerenciamentoCadastro.jsp";

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String idCadastroEscolhido = request.getParameter("cadastro_escolhido");
		String opcaoEscolhida = request.getParameter("opcao_escolhida");
		
		CadastroMedicoBusiness cadastroMedicoBusiness = new CadastroMedicoBusiness();
		cadastroMedicoBusiness.atualizarCadastrosMedico(idCadastroEscolhido, opcaoEscolhida);
		
		request.setAttribute("mensagemSucesso", "Cadastro Atualizado !!!");
		
		RequestDispatcher view  = request.getRequestDispatcher(PAGINA_SUCESSO);
		view.forward(request, response);
	}
}
