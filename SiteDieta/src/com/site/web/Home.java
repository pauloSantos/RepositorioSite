package com.site.web;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.business.enums.TipoUsuario;
import com.site.model.Usuario;

public class Home extends HttpServlet {
	
	private static final long serialVersionUID = 1L;

	public void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Usuario usuario = (Usuario)request.getSession().getAttribute("usuario");
		RequestDispatcher requestDispatcher = null;
		if(usuario != null) {
			TipoUsuario tipoUsuario = usuario.getTipoUsuario();
			if (TipoUsuario.ADMIN.equals(tipoUsuario)) {
				requestDispatcher = request.getRequestDispatcher("WEB-INF/paginas/homeAdministrador.jsp");
			}else if (TipoUsuario.MEDICO.equals(tipoUsuario)) {
				requestDispatcher = request.getRequestDispatcher("WEB-INF/paginas/homeMedico.jsp");
			}
		}else{
			requestDispatcher = request.getRequestDispatcher("WEB-INF/paginas/home.jsp");

		}

		response.setDateHeader("Expires",0);  
		response.setHeader("Pragma", "no-cache");  
		if(request.getProtocol().equals("HTTP/1.1"))  
			response.setHeader("Cache-Control", "no-cache");  

		requestDispatcher.forward(request, response);
	}
}
