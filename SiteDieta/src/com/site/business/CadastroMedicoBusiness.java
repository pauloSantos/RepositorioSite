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
				cadastroMedicoDAO.inserir(cadastroMedico);
				usuarioDAO.inserir(usuario);
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

	public boolean confirmarCadastro(Long idCadastro){
		CadastroMedicoDAO dao = new CadastroMedicoDAO();
		CadastroMedico cadastroMedico = dao.encontrarCadastroMedicoPorId(idCadastro);
		cadastroMedico.setStatusMedico(StatusMedico.CONFIRMADO);
		try {
			dao.atualizar(cadastroMedico);
			return true;
		} catch (Exception e) {
			System.out.println(e.getStackTrace());
			return false;
		}
	}
	
	public boolean rejeitarCadastro(Long idCadastro){
		CadastroMedicoDAO cadastroMedicoDAO = new CadastroMedicoDAO();
		CadastroMedico cadastroMedico = cadastroMedicoDAO.encontrarCadastroMedicoPorId(idCadastro);
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		
		try {
			usuarioDAO.deletarUsuario(cadastroMedico);
			cadastroMedicoDAO.deletarCadastro(idCadastro);
			return true;
		} catch (Exception e) {
			System.out.println(e.getMessage());
			return false;
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
