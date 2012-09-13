package com.site.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.site.business.AutenticacaoLoginBusiness;
import com.site.business.enums.TipoUsuario;
import com.site.model.Usuario;

public class AutenticacaoLogin extends HttpServlet {

	private static final String ERRO_LOGIN = "WEB-INF/paginas/paginaErroLogin.jsp";
	private static final String HOME_MEDICO = "WEB-INF/paginas/homeMedico.jsp";
	private static final String HOME_ADMINISTRADOR = "WEB-INF/paginas/homeAdministrador.jsp";
	private static final long serialVersionUID = -5212877687087164982L;

	public void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException, ServletException{
		String login = request.getParameter("campo_login");
		String senha = request.getParameter("campo_senha");

		AutenticacaoLoginBusiness autenticacaoLoginBusiness = new AutenticacaoLoginBusiness();
		Usuario usuario = autenticacaoLoginBusiness.getUsuarioAutenticado(login, senha);
		if (usuario != null) {
			setUsuarioAutenticado(request, usuario);

			RequestDispatcher requestDispatcher = getRequestDispatcher(request, response, usuario);
			requestDispatcher.forward(request, response);
		}else{
			RequestDispatcher requestDispatcher = request.getRequestDispatcher(ERRO_LOGIN);
			requestDispatcher.forward(request, response);
		}
	}

	private RequestDispatcher getRequestDispatcher(HttpServletRequest request, HttpServletResponse response, Usuario usuario) throws ServletException, IOException {
		RequestDispatcher requestDispatcher = null;
		TipoUsuario tipoUsuario = usuario.getTipoUsuario();
		if (TipoUsuario.ADMIN.equals(tipoUsuario)) {
			requestDispatcher = request.getRequestDispatcher(HOME_ADMINISTRADOR);
		}else if(TipoUsuario.MEDICO.equals(tipoUsuario)){
			requestDispatcher = request.getRequestDispatcher(HOME_MEDICO);
		}else{
			requestDispatcher = request.getRequestDispatcher(ERRO_LOGIN);
		}
		return requestDispatcher;
	}

	private void setUsuarioAutenticado(HttpServletRequest request, Usuario usuario) {
		HttpSession session = request.getSession();
		session.setAttribute("usuario", usuario);
	}
}
