package com.site.web;

import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.site.business.bean.CadastroMedicoBean;
import com.site.business.enums.RespostaCadastro;
import com.site.business.facade.IAplicacaoSiteFacade;
import com.site.business.facade.AplicacaoSiteFacade;

public class CadastroMedico extends HttpServlet{

	private static final String PAGINA_ERRO = "WEB-INF/paginas/erroCadastroMedico.jsp";
	private static final String RESPOSTA = "resposta";
	private static final long serialVersionUID = -577634426915076752L;
	private static final String DADOS_VALIDOS = "dadosValidos";

	@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		IAplicacaoSiteFacade facade = new AplicacaoSiteFacade();
		CadastroMedicoBean bean = criarCadastroMedicoBean(request);
		Map<String, Object> respostaCadastro = facade.cadastrarMedico(bean);

		produzirResposta(request, response, respostaCadastro);
	}

	private void produzirResposta(HttpServletRequest request, HttpServletResponse response, Map<String, Object> respostaCadastro) throws ServletException, IOException {
		CadastroMedicoBean dadosValidos = (CadastroMedicoBean) respostaCadastro.get(DADOS_VALIDOS);
		RespostaCadastro resposta = (RespostaCadastro) respostaCadastro.get(RESPOSTA);
		if (RespostaCadastro.SUCESSO.equals(resposta)) {
			String mensagem = RespostaCadastro.SUCESSO.getMensagem();
			List<String> listaMensagens = dadosValidos.getListaMensagens();
			listaMensagens.add(mensagem);
			request.setAttribute("parametroResposta", dadosValidos);
			RequestDispatcher view  = request.getRequestDispatcher("WEB-INF/paginas/paginaSucessoCadastro.jsp");
			view.forward(request, response);
		}else{
			request.setAttribute("parametroResposta", dadosValidos);
			RequestDispatcher view  = request.getRequestDispatcher(PAGINA_ERRO);
			view.forward(request, response);
		}
	}
	
	private CadastroMedicoBean criarCadastroMedicoBean(HttpServletRequest request) {
		CadastroMedicoBean bean = new CadastroMedicoBean();
		bean.setNomeMedico(request.getParameter("nome_medico"));  
		bean.setCpfMedico(request.getParameter("cpf_medico"));
		bean.setNumeroRegistroMedico(request.getParameter("registro_medico"));
		bean.setTipoRegistroMedico(request.getParameter("tipo_identificacao"));
		bean.setLoginMedico(request.getParameter("login_medico"));
		bean.setSenhaMedico(request.getParameter("senha_medico"));
		bean.setConfirmacaoSenhaMedico(request.getParameter("confirmacao_senha"));
		/* Campos não obrigatórios*/
		bean.setEnderecoConsultorio(request.getParameter("endereco_clinica"));
		bean.setNumeroConsultorio(request.getParameter("numero_clinica"));
		bean.setBairroConsultorio(request.getParameter("bairro_clinica"));
		bean.setCidadeConsultorio(request.getParameter("cidade_clinica"));
		bean.setEstadoConsultorio(request.getParameter("estado_clinica"));
		bean.setCnpjConsultorio(request.getParameter("cnpj_clinica"));

		return bean;
	}
}
