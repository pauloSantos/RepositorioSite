package com.site.web.action;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

import com.site.dao.DietaDAO;
import com.site.dao.IDietaDAO;
import com.site.model.Dieta;

@UrlBinding("/action/pesquisador/medicos")
public class PesquisadorMedicoAction extends SiteActionBean {

	private static final String VIEW = "/WEB-INF/paginas/resultadoBuscaMedico.jsp";
	private String nomeDieta;
	List<Dieta> listaDietas = new ArrayList<Dieta>();
	
	@Override
	public Resolution view() {
		if(nomeDieta != null){
			IDietaDAO dietaDAO = new DietaDAO();
			listaDietas = dietaDAO.encontrarDietaPorNome(nomeDieta);
		}
		
		return new ForwardResolution(VIEW);
	}

	
	public String getNomeDieta() {
		return nomeDieta;
	}

	public void setNomeDieta(String nomeDieta) {
		this.nomeDieta = nomeDieta;
	}
	
	public List<Dieta> getDietas(){
		return this.listaDietas;
	}

}
