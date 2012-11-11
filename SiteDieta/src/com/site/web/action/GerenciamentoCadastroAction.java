package com.site.web.action;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Message;
import net.sourceforge.stripes.action.RedirectResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.SimpleMessage;
import net.sourceforge.stripes.action.UrlBinding;
import net.sourceforge.stripes.validation.SimpleError;
import net.sourceforge.stripes.validation.ValidationError;
import net.sourceforge.stripes.validation.ValidationErrors;

import com.site.business.facade.IAplicacaoSiteFacade;
import com.site.business.facade.AplicacaoSiteFacade;
import com.site.web.enums.Mensagens;

@UrlBinding("/action/admin/gerenciamento/cadastros")
public class GerenciamentoCadastroAction extends SiteActionBean {

	private Long cadastroEscolhido;
	private static final String VIEW = "/WEB-INF/paginas/gerenciamentoCadastro.jsp";
			
	@Override
	public Resolution view() {
		return new ForwardResolution(VIEW);
	}

	public Resolution confirmar(){
		IAplicacaoSiteFacade facade = new AplicacaoSiteFacade();
		boolean cadastroConfirmado = facade.confirmarCadastro(getCadastroEscolhido());
		
		if(cadastroConfirmado){
			Message message = new SimpleMessage(Mensagens.SUCESSO_CONFIRMACAO_CADASTRO.getMensagem());
			getContext().getMessages().add(message);
			return new RedirectResolution(GerenciamentoCadastroAction.class);
		}else{
			ValidationError error = new SimpleError(Mensagens.ERRO_CONFIRMACAO_CADASTRO.getMensagem());
			ValidationErrors errors = new ValidationErrors();
			errors.add("cadastroEscolhido", error );
			getContext().setValidationErrors(errors);
			
			return new ForwardResolution(GerenciamentoCadastroAction.class);
		}
	} 
	
	public Resolution rejeitar(){
		IAplicacaoSiteFacade facade = new AplicacaoSiteFacade();
		boolean cadastroRejeitado = facade.rejeitarCadastro(getCadastroEscolhido());
		
		if(cadastroRejeitado){
			Message message = new SimpleMessage(Mensagens.SUCESSO_REJEICAO_CADASTRO.getMensagem());
			getContext().getMessages().add(message);
			return new RedirectResolution(GerenciamentoCadastroAction.class);
		}else{
			ValidationError error = new SimpleError(Mensagens.ERRO_REJEICAO_CADASTRO.getMensagem());
			ValidationErrors errors = new ValidationErrors();
			errors.add("cadastroEscolhido", error );
			getContext().setValidationErrors(errors);
			
			return new ForwardResolution(GerenciamentoCadastroAction.class);
		}
	} 
	
	public Long getCadastroEscolhido() {
		return cadastroEscolhido;
	}

	public void setCadastroEscolhido(Long cadastroEscolhido) {
		this.cadastroEscolhido = cadastroEscolhido;
	}

}
