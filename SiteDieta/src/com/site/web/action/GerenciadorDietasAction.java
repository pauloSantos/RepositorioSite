package com.site.web.action;

import java.util.List;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import com.site.business.GerenciadorDietasBusiness;
import com.site.business.IGerenciadorDietasBusiness;
import com.site.dao.UsuarioDAO;
import com.site.model.Dieta;
import com.site.model.Usuario;

@UrlBinding("/action/gerenciador/dietas")
public class GerenciadorDietasAction extends SiteActionBean {
	
	private static final String VIEW = "/WEB-INF/paginas/gerenciamentoDietas.jsp";
	private Long identificacaoUsuario;
	private List<Dieta> dieta;

	@Override
	public Resolution view(){
		if (identificacaoUsuario != null) {
			UsuarioDAO usuarioDAO = new UsuarioDAO();
			Usuario usuario = usuarioDAO.encontrarPorId(getIdentificacaoUsuario());
			IGerenciadorDietasBusiness gerenciadorDietasBusiness = new GerenciadorDietasBusiness();
			List<Dieta> listaDieta = gerenciadorDietasBusiness.getDieta(usuario);
			setDieta(listaDieta);
		}
		return new ForwardResolution(VIEW);
	}
	
	public List<Dieta> getAlimentosDieta(){
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.encontrarPorId(getIdentificacaoUsuario());
		
		IGerenciadorDietasBusiness gerenciadorDietasBusiness = new GerenciadorDietasBusiness();
		return gerenciadorDietasBusiness.getDieta(usuario);
	}

	public Long getIdentificacaoUsuario() {
		return identificacaoUsuario;
	}

	public void setIdentificacaoUsuario(Long identificacaoUsuario) {
		this.identificacaoUsuario = identificacaoUsuario;
	}

	public List<Dieta> getDieta() {
		return dieta;
	}

	public void setDieta(List<Dieta> dieta) {
		this.dieta = dieta;
	}

}
