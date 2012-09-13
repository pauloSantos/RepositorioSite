package com.site.business;

import com.site.business.enums.StatusMedico;
import com.site.business.enums.TipoUsuario;
import com.site.dao.UsuarioDAO;
import com.site.model.Usuario;

public class AutenticacaoLoginBusiness {

	public Usuario getUsuarioAutenticado(String login, String senha) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.encontrarUsuario(login);
		return validarUsuario(senha, usuario);
	}

	private Usuario validarUsuario(String senha, Usuario usuario) {
		if (usuario != null && usuario.getSenha().equals(senha)) {
			if(isCadastroConfirmado(usuario)){
				return usuario;
			}
		}
		return null;
	}

	private boolean isCadastroConfirmado(Usuario usuario){
		if (TipoUsuario.ADMIN.equals(usuario.getTipoUsuario())) {
			return true;
		}else {
			StatusMedico statusMedico = usuario.getCadastroMedico().getStatusMedico();
			if (StatusMedico.CONFIRMADO.equals(statusMedico)) {
				return true;
			}
		}
		return false;
	}
}
