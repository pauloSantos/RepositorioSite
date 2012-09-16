package com.site.web.action;

import java.util.ArrayList;
import java.util.List;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;

import com.site.model.Alimento;
import com.site.model.Refeicao;

@UrlBinding("/action/publicacao/dieta")
public class PublicacaoDietaAction extends SiteActionBean {
	
	private List<String> nomeAlimentos;
	
	private List<Integer> quantidade;
	
	private List<String> listaUnidadeDeMedida;
	
	
	@ValidateNestedProperties({
		@Validate(field="horarioRefeicao", required=true, on="salvar")
	})
	private Refeicao refeicao =  new Refeicao();
	
	private static final String VIEW = "/WEB-INF/paginas/publicacaoDietas.jsp";

	@Override
	public Resolution view(){
		return new ForwardResolution(VIEW);
	}
	
	public Resolution salvar(){
		List<Alimento> listaAlimentos = new ArrayList<Alimento>();
		for (int i = 0; i < nomeAlimentos.size(); i++) {
			String nomeAlimento = nomeAlimentos.get(i);
			int quantidadeAlimento = quantidade.get(i);
			String unidadeDeMedida = listaUnidadeDeMedida.get(i);
			Alimento alimento = new Alimento(nomeAlimento, quantidadeAlimento, unidadeDeMedida);
			listaAlimentos.add(alimento);
		}
		getRefeicao().setListaAlimentos(listaAlimentos);
		
		return new RedirectResolution(PublicacaoDietaAction.class);
	}

	public List<String> getNomeAlimentos() {
		return nomeAlimentos;
	}

	public void setNomeAlimentos(List<String> nomeAlimentos) {
		this.nomeAlimentos = nomeAlimentos;
	}

	public List<Integer> getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(List<Integer> quantidade) {
		this.quantidade = quantidade;
	}

	public List<String> getListaUnidadeDeMedida() {
		return listaUnidadeDeMedida;
	}

	public void setListaUnidadeDeMedida(List<String> listaUnidadeDeMedida) {
		this.listaUnidadeDeMedida = listaUnidadeDeMedida;
	}

	public Refeicao getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(Refeicao refeicao) {
		this.refeicao = refeicao;
	}
}
