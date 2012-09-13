package com.site.business;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.site.business.bean.CadastroMedicoBean;
import com.site.business.enums.RespostaCadastro;
import com.site.business.enums.StatusMedico;
import com.site.business.enums.TipoUsuario;
import com.site.business.validador.ValidadorCadastroMedico;
import com.site.dao.CadastroMedicoDAO;
import com.site.dao.UsuarioDAO;
import com.site.model.CadastroMedico;
import com.site.model.Usuario;

public class CadastroMedicoBusiness {

	private static final String REJEITAR = "rejeitar";
	private static final String CONFIRMAR = "confirmar";
	private static final String RESPOSTA = "resposta";
	private static final String DADOS_VALIDOS = "dadosValidos";

	public List<CadastroMedico> visualizarCadastrosPendentes(){
		CadastroMedicoDAO cadastroMedicoDAO = new CadastroMedicoDAO();
		return cadastroMedicoDAO.procurarCadastroMedicoPorStatus(StatusMedico.PENDENTE);
	}

	public Map<String, Object> salvarRegistroMedico(CadastroMedicoBean bean){
		RespostaCadastro textoResposta = null;
		Map<String, Object> dadosResposta = new HashMap<String, Object>();
		ValidadorCadastroMedico validador = new ValidadorCadastroMedico();
		CadastroMedicoBean dadosValidados = validador.validarCadastroMedico(bean);

		try{
			if(isDadosObrigatoriosValidos(dadosValidados)){
				CadastroMedicoDAO cadastroMedicoDAO = new CadastroMedicoDAO();
				UsuarioDAO usuarioDAO = new UsuarioDAO();
				CadastroMedico cadastroMedico = criarCadastroMedico(bean);
				Usuario usuario = criarUsuario(bean, cadastroMedico);
				cadastroMedicoDAO.insert(cadastroMedico);
				usuarioDAO.insert(usuario);
				textoResposta = RespostaCadastro.SUCESSO;

			}else{
				textoResposta = RespostaCadastro.ERRO;
			}

			dadosResposta.put(DADOS_VALIDOS, dadosValidados);
			dadosResposta.put(RESPOSTA, textoResposta);
			return dadosResposta;

		}catch(Exception e){
			textoResposta = RespostaCadastro.ERRO;
			dadosResposta.put(DADOS_VALIDOS, dadosValidados);
			dadosResposta.put(RESPOSTA, textoResposta);
			return dadosResposta;

		}
	}

	public void atualizarCadastrosMedico(String idCadastro, String opcaoEscolhida){
		CadastroMedicoDAO dao = new CadastroMedicoDAO();
		CadastroMedico cadastroMedico = dao.encontrarCadastroMedicoPorId(Long.parseLong(idCadastro));
		if (opcaoEscolhida.equalsIgnoreCase(CONFIRMAR)) {
			cadastroMedico.setStatusMedico(StatusMedico.CONFIRMADO);
			dao.update(cadastroMedico);

		}else if(opcaoEscolhida.equalsIgnoreCase(REJEITAR)){
			//TODO deletar cadastro
		}
	}

	private boolean isDadosObrigatoriosValidos(CadastroMedicoBean dadosValidados) {
		return dadosValidados.getListaMensagens().isEmpty();
	}

	private Usuario criarUsuario(CadastroMedicoBean bean, CadastroMedico cadastroMedico) {
		Usuario usuario = new Usuario();
		usuario.setLogin(bean.getLoginMedico());
		usuario.setSenha(bean.getSenhaMedico());
		usuario.setTipoUsuario(TipoUsuario.MEDICO);
		usuario.setCadastroMedico(cadastroMedico);
		return usuario;
	}

	private CadastroMedico criarCadastroMedico(CadastroMedicoBean bean) {
		CadastroMedico model = new CadastroMedico();
		model.setNomeMedico(bean.getNomeMedico());  
		model.setCpfMedico(bean.getCpfMedico());
		model.setNumeroRegistroMedico(bean.getNumeroRegistroMedico());
		model.setTipoRegistroMedico(bean.getTipoRegistroMedico());
		/* Campos não obrigatórios*/
		model.setEnderecoConsultorio(bean.getEnderecoConsultorio());
		model.setNumeroConsultorio(bean.getNumeroConsultorio());
		model.setBairroConsultorio(bean.getBairroConsultorio());
		model.setCidadeConsultorio(bean.getCidadeConsultorio());
		model.setEstadoConsultorio(bean.getEstadoConsultorio());
		model.setCnpjConsultorio(bean.getCnpjConsultorio());
		model.setStatusMedico(StatusMedico.PENDENTE);
		return model;
	}
}
