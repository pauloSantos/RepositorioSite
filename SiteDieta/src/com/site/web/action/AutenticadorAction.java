package com.site.web.action;

import javax.servlet.http.HttpSession;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import com.site.business.AutenticacaoLoginBusiness;
import com.site.business.enums.TipoUsuario;
import com.site.model.Usuario;

@UrlBinding("/action/autenticacao")
public class AutenticadorAction extends SiteActionBean {

	private static final String ERRO_LOGIN = "/WEB-INF/paginas/paginaErroLogin.jsp";
	private static final String HOME_MEDICO = "/WEB-INF/paginas/homeMedico.jsp";
	private static final String HOME_ADMINISTRADOR = "/WEB-INF/paginas/homeAdministrador.jsp";

	String login;
	String senha;

	@Override
	public Resolution view() {
		return new ForwardResolution("/WEB-INF/paginas/estatisticas.jsp");
	}

	public Resolution autenticar(){
		AutenticacaoLoginBusiness autenticacaoLoginBusiness = new AutenticacaoLoginBusiness();
		Usuario usuario = autenticacaoLoginBusiness.getUsuarioAutenticado(login, senha);
		
		if (usuario != null) {
			setUsuarioAutenticado(usuario);

			String pageToForward = getPageToRedirect(usuario);
			new RedirectResolution(pageToForward);
		}else{
			return new ForwardResolution(ERRO_LOGIN);
		}
		return null;
	}
	
	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	
	private String getPageToRedirect(Usuario usuario){
		TipoUsuario tipoUsuario = usuario.getTipoUsuario();
		if (TipoUsuario.ADMIN.equals(tipoUsuario)) {
			return HOME_ADMINISTRADOR;
		}else if(TipoUsuario.MEDICO.equals(tipoUsuario)){
			return HOME_MEDICO;
		}else{
			return ERRO_LOGIN;
		}
	}
	
	private void setUsuarioAutenticado(Usuario usuario) {
		HttpSession session = getContext().getRequest().getSession();
		session.setAttribute("usuario", usuario);
	}

}
