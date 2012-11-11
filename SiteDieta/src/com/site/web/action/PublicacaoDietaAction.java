package com.site.web.action;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Message;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SimpleMessage;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.Validate;
import net.sourceforge.stripes.validation.ValidationError;
import net.sourceforge.stripes.validation.ValidationErrors;
import net.sourceforge.stripes.validation.ValidationMethod;

import com.site.business.IPublicacaoDieta;
import com.site.business.PublicacaoDietaBusiness;
import com.site.dao.DietaDAO;
import com.site.model.Dieta;
import com.site.model.Usuario;
import com.site.web.enums.Mensagens;
import com.site.web.enums.PublicacaoDietaChaves;
import com.site.web.exception.ChaveNaoEncontradaException;

@UrlBinding("/action/publicacao/dieta")
public class PublicacaoDietaAction extends SiteActionBean {

	private Dieta dieta;

	private Map<String, String> nomeAlimentos;

	private Map<String, Integer> quantidade;

	private Map<String, String> listaUnidadeDeMedida;


	@Validate(required=true, on="salvar")
	private String horarioRefeicaoManha;

	@Validate(required=true, on="salvar")
	private String horarioRefeicaoTarde;


	@Validate(required=true, on="salvar")
	private String horarioRefeicaoNoite;


	private static final String VIEW = "/WEB-INF/paginas/publicacaoDietas.jsp";

	@Override
	public Resolution view(){
		return new ForwardResolution(VIEW);
	}

	public Resolution salvar() throws ChaveNaoEncontradaException{
		Usuario usuario = (Usuario) getContext().getRequest().getSession().getAttribute("usuario");
		dieta.setMedico(usuario.getCadastroMedico());

		IPublicacaoDieta business = new PublicacaoDietaBusiness();
		boolean resposta = business.criarDieta(dieta, nomeAlimentos, quantidade, listaUnidadeDeMedida, horarioRefeicaoManha, horarioRefeicaoTarde, horarioRefeicaoNoite);

		if(resposta == true){
			Message message = new SimpleMessage(Mensagens.SUCESSO_CADASTRO_DIETA.getMensagem());
			getContext().getMessages().add(message);
			return new RedirectResolution(PublicacaoDietaAction.class);
		}else{
			ValidationError error = new SimpleError(Mensagens.ERRO_PUBLICACAO_DIETA.getMensagem());
			ValidationErrors errors = new ValidationErrors();
			errors.add("nomeAlimentos", error );
			getContext().setValidationErrors(errors);
			return new ForwardResolution(PublicacaoDietaAction.class);
		}
	}

	@ValidationMethod(on="salvar")
	public void validarCampos(ValidationErrors errors){
		if(nomeAlimentos == null){
			ValidationError error = new SimpleError(Mensagens.ALIMENTO_OBRIGATORIO.getMensagem());
			errors.add("nomeAlimentos" , error );
		}else if(! isAlimentosObrigatoriosPreenchidos()){
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
		
		if(isDietaJaExiste()){
			ValidationError error = new SimpleError(Mensagens.DIETA_JA_EXISTENTE.getMensagem());
			errors.add("dieta" , error );
		}
		
		
	}

	private boolean isDietaJaExiste(){
		DietaDAO dietaDAO = new DietaDAO();
		Dieta dietaEncontrada = dietaDAO.encontrarDietaPorNomeExato(dieta.getNomeDieta());
		
		return dietaEncontrada != null;
	}
	private boolean isAlimentosObrigatoriosPreenchidos() {
		PublicacaoDietaChaves[] listaChaves = PublicacaoDietaChaves.values();
		List<PublicacaoDietaChaves> chavesManha = getChavesPeriodo(listaChaves, "Manha");
		List<PublicacaoDietaChaves> chavesTarde = getChavesPeriodo(listaChaves, "Tarde");
		List<PublicacaoDietaChaves> chavesNoite = getChavesPeriodo(listaChaves, "Noite");
		boolean verificadorManha = false;
		boolean verificadorTarde = false;
		boolean verificadorNoite = false;

		for (PublicacaoDietaChaves chaveManha : chavesManha) {
			String nomeAlimento = nomeAlimentos.get(chaveManha.getChave());
			if(nomeAlimento != null){
				verificadorManha = true;
			}
		}

		for (PublicacaoDietaChaves chaveTarde : chavesTarde) {
			String nomeAlimento = nomeAlimentos.get(chaveTarde.getChave());
			if(nomeAlimento != null){
				verificadorTarde = true;
			}

		}

		for (PublicacaoDietaChaves chaveNoite : chavesNoite) {
			String nomeAlimento = nomeAlimentos.get(chaveNoite.getChave());
			if(nomeAlimento != null){
				verificadorNoite = true;
			}

		}

		return verificadorManha && verificadorTarde && verificadorNoite ;
	}

	public Dieta getDieta() {
		return dieta;
	}

	public void setDieta(Dieta dieta) {
		this.dieta = dieta;
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

	public String getHorarioRefeicaoManha() {
		return horarioRefeicaoManha;
	}

	public void setHorarioRefeicaoManha(String horarioRefeicaoManha) {
		this.horarioRefeicaoManha = horarioRefeicaoManha;
	}

	public String getHorarioRefeicaoTarde() {
		return horarioRefeicaoTarde;
	}

	public void setHorarioRefeicaoTarde(String horarioRefeicaoTarde) {
		this.horarioRefeicaoTarde = horarioRefeicaoTarde;
	}

	public String getHorarioRefeicaoNoite() {
		return horarioRefeicaoNoite;
	}

	public void setHorarioRefeicaoNoite(String horarioRefeicaoNoite) {
		this.horarioRefeicaoNoite = horarioRefeicaoNoite;
	}

	private List<PublicacaoDietaChaves> getChavesPeriodo(PublicacaoDietaChaves[] listaChaves,String periodo) {
		List<PublicacaoDietaChaves> listaChavesPeriodo = new ArrayList<PublicacaoDietaChaves>();
		Pattern padrao = Pattern.compile(periodo);
		for (PublicacaoDietaChaves chave : listaChaves) {
			Matcher matcher = padrao.matcher(chave.getChave());
			if(matcher.find()){
				listaChavesPeriodo.add(chave);
			}
		}
		return listaChavesPeriodo;
	}
}
