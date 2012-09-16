package com.site.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Message;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SimpleMessage;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidateNestedProperties;
import net.sourceforge.stripes.validation.ValidationError;
import net.sourceforge.stripes.validation.ValidationErrors;
import net.sourceforge.stripes.validation.ValidationMethod;

import com.site.model.Alimento;
import com.site.model.Refeicao;
import com.site.web.enums.Mensagens;
import com.site.web.enums.PublicacaoDietaChaves;
import com.site.web.exception.ChaveNaoEncontradaException;

@UrlBinding("/action/publicacao/dieta")
public class PublicacaoDietaAction extends SiteActionBean {

	private Map<String, String> nomeAlimentos;

	private Map<String, Integer> quantidade;

	private Map<String, String> listaUnidadeDeMedida;


	@ValidateNestedProperties({
		@Validate(field="horarioRefeicao", required=true, label="Horario", on="salvar")
	})
	private Refeicao refeicao =  new Refeicao();

	private static final String VIEW = "/WEB-INF/paginas/publicacaoDietas.jsp";

	@Override
	public Resolution view(){
		return new ForwardResolution(VIEW);
	}

	public Resolution salvar() throws ChaveNaoEncontradaException{
		List<Alimento> listaAlimentos = new ArrayList<Alimento>();
		PublicacaoDietaChaves[] listaChaves = PublicacaoDietaChaves.values();
		for (PublicacaoDietaChaves chaveAlimento : listaChaves) {
			String nomeAlimento = nomeAlimentos.get(chaveAlimento.getChave());
			if (nomeAlimento != null) {
				Integer quantidadeAlimento = quantidade.get(chaveAlimento.getChave());
				String unidadeDeMedida = listaUnidadeDeMedida.get(chaveAlimento.getChave());
				Alimento alimento = new Alimento(nomeAlimento, quantidadeAlimento, unidadeDeMedida);
				listaAlimentos.add(alimento);
			}
		}

		if(listaAlimentos.isEmpty()){
			throw new ChaveNaoEncontradaException();
		}
		getRefeicao().setListaAlimentos(listaAlimentos);
		Message message = new SimpleMessage(Mensagens.SUCESSO.getMensagem());
		getContext().getMessages().add(message);

		return new RedirectResolution(PublicacaoDietaAction.class);
	}

	@ValidationMethod(on="salvar")
	public void validarCampos(ValidationErrors errors){
		if(nomeAlimentos == null){
			ValidationError error = new SimpleError(Mensagens.ALIMENTO_OBRIGATORIO.getMensagem());
			errors.add("nomeAlimentos" , error );
		}

		if (quantidade == null) {
			ValidationError error = new SimpleError(Mensagens.QUANTIDADE_OBRIGATORIA.getMensagem());
			errors.add("quantidade" , error );
		}

		if (listaUnidadeDeMedida == null || listaUnidadeDeMedida.equals("")) {
			ValidationError error = new SimpleError(Mensagens.UNIDADE_DE_MEDIDA_OBRIGATORIA.getMensagem());
			errors.add("listaUnidadeDeMedida" , error );
		}
	}

	public Map<String, String> getNomeAlimentos() {
		return nomeAlimentos;
	}

	public void setNomeAlimentos(Map<String, String> nomeAlimentos) {
		this.nomeAlimentos = nomeAlimentos;
	}

	public Map<String, Integer> getQuantidade() {
		return quantidade;
	}

	public void setQuantidade(Map<String, Integer> quantidade) {
		this.quantidade = quantidade;
	}

	public Map<String, String> getListaUnidadeDeMedida() {
		return listaUnidadeDeMedida;
	}

	public void setListaUnidadeDeMedida(Map<String, String> listaUnidadeDeMedida) {
		this.listaUnidadeDeMedida = listaUnidadeDeMedida;
	}

	public Refeicao getRefeicao() {
		return refeicao;
	}

	public void setRefeicao(Refeicao refeicao) {
		this.refeicao = refeicao;
	}
}
