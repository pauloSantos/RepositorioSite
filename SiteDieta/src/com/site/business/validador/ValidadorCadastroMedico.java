package com.site.business.validador;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.site.business.bean.CadastroMedicoBean;
import com.site.business.enums.RespostaCadastro;
import com.site.dao.UsuarioDAO;
import com.site.model.Usuario;

public class ValidadorCadastroMedico {

	private static final String VAZIO = "";
	private static final String PATTERN_ESPACO_EM_BRANCO_DUPLO = "\\s{2,}";
	private static final String PATTERN_ESPACO_EM_BRANCO = "\\s";
	private static final String ESPACO_EM_BRANCO_UNICO = " ";

	public CadastroMedicoBean validarCadastroMedico(CadastroMedicoBean bean){
		CadastroMedicoBean dadosValidos = new CadastroMedicoBean();
		ArrayList<String> listaMensagens = new ArrayList<String>();
		dadosValidos.setListaMensagens(listaMensagens);
		validaNome(bean, dadosValidos);
		validaCPF(bean, dadosValidos);
		validaRegistroProfissional(bean, dadosValidos);
		validaTipoDeRegistro(bean, dadosValidos);
		validaLoginMedico(bean, dadosValidos);
		validaSenhaMedico(bean, dadosValidos);
		setDadosNaoObrigatorios(bean, dadosValidos);

		return dadosValidos;
	}

	private void setDadosNaoObrigatorios(CadastroMedicoBean bean, CadastroMedicoBean dadosValidos) {
		dadosValidos.setEnderecoConsultorio(bean.getEnderecoConsultorio());
		dadosValidos.setNumeroConsultorio(bean.getNumeroConsultorio());
		dadosValidos.setBairroConsultorio(bean.getBairroConsultorio());
		dadosValidos.setCidadeConsultorio(bean.getCidadeConsultorio());
		dadosValidos.setEstadoConsultorio(bean.getEstadoConsultorio());
		dadosValidos.setCnpjConsultorio(bean.getCnpjConsultorio());
	}

	private void validaNome(CadastroMedicoBean bean, CadastroMedicoBean dadosValidos) {
		String nomeMedico = bean.getNomeMedico();
		if(nomeMedico != null && !nomeMedico.equals(VAZIO)){
			formataNome(bean, dadosValidos);
		}else{
			List<String> listaMensagens = dadosValidos.getListaMensagens();
			listaMensagens.add(RespostaCadastro.NOME_INVALIDO.getMensagem());
		}
	}

	private void validaTipoDeRegistro(CadastroMedicoBean bean, CadastroMedicoBean dadosValidos) {
		String tipoRegistroMedico = bean.getTipoRegistroMedico();
		if (! (tipoRegistroMedico.equals("CRM")|| tipoRegistroMedico.equals("CRN"))) {
			List<String> listaMensagens = dadosValidos.getListaMensagens();
			listaMensagens.add(RespostaCadastro.TIPO_REGISTRO_INVALIDO.getMensagem());
		}else{
			dadosValidos.setTipoRegistroMedico(tipoRegistroMedico);
		}
	}

	private void formataNome(CadastroMedicoBean bean, CadastroMedicoBean dadosValidos) {
		String nomeMedico = bean.getNomeMedico();
		Pattern padrao = Pattern.compile(PATTERN_ESPACO_EM_BRANCO_DUPLO);
		Matcher matcher = padrao.matcher(nomeMedico);
		String nomeFormatado = matcher.replaceAll(ESPACO_EM_BRANCO_UNICO).trim();
		dadosValidos.setNomeMedico(nomeFormatado);
	}

	private void validaCPF(CadastroMedicoBean bean, CadastroMedicoBean dadosValidos) {
		String cpfMedico = bean.getCpfMedico();
		try{
			Long.parseLong(cpfMedico);
			if (cpfMedico.length()== 11){
				dadosValidos.setCpfMedico(cpfMedico);
			}else{
				List<String> listaMensagens = dadosValidos.getListaMensagens();
				listaMensagens.add(RespostaCadastro.CPF_INVALIDO.getMensagem());
				dadosValidos.setListaMensagens(listaMensagens);
			}
		}catch(NumberFormatException e){
			List<String> listaMensagens = dadosValidos.getListaMensagens();
			listaMensagens.add(RespostaCadastro.CPF_INVALIDO.getMensagem());
			dadosValidos.setListaMensagens(listaMensagens);
		}
	}

	private void validaRegistroProfissional(CadastroMedicoBean bean, CadastroMedicoBean dadosValidos) {
		String numeroRegistroMedico = bean.getNumeroRegistroMedico();
		try{
			Long.parseLong(numeroRegistroMedico);
			dadosValidos.setNumeroRegistroMedico(numeroRegistroMedico);
		}catch(NumberFormatException e){
			List<String> listaMensagens = dadosValidos.getListaMensagens();
			listaMensagens.add(RespostaCadastro.REGISTRO_PROFISSIONAL_INVALIDO.getMensagem());
			dadosValidos.setListaMensagens(listaMensagens);
		}
	}

	private void validaLoginMedico(CadastroMedicoBean bean, CadastroMedicoBean dadosValidos) {
		String loginMedico = bean.getLoginMedico();
		if(loginMedico != null && !loginMedico.equals(VAZIO)){
			if(isLoginAindaNaoExiste(loginMedico)){
				Pattern padrao = Pattern.compile(PATTERN_ESPACO_EM_BRANCO);
				Matcher matcher = padrao.matcher(loginMedico);
				
				if(!matcher.find()){
					dadosValidos.setLoginMedico(loginMedico);
				}else{
					List<String> listaMensagens = dadosValidos.getListaMensagens();
					listaMensagens.add(RespostaCadastro.LOGIN_INVALIDO.getMensagem());
				}
			}else{
				List<String> listaMensagens = dadosValidos.getListaMensagens();
				listaMensagens.add(RespostaCadastro.LOGIN_JA_EXISTE.getMensagem());
			}

		}else{
			List<String> listaMensagens = dadosValidos.getListaMensagens();
			listaMensagens.add(RespostaCadastro.LOGIN_INVALIDO.getMensagem());
		}
	}

	private boolean isLoginAindaNaoExiste(String loginMedico) {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = usuarioDAO.encontrarUsuario(loginMedico);
		
		return usuario == null;
	}

	private void validaSenhaMedico(CadastroMedicoBean bean, CadastroMedicoBean dadosValidos) {
		String senhaMedico = bean.getSenhaMedico();
		if(senhaMedico != null && !senhaMedico.equals(VAZIO)){
			Pattern padrao = Pattern.compile(PATTERN_ESPACO_EM_BRANCO);
			Matcher matcher = padrao.matcher(senhaMedico);
			if(!matcher.find()){
				String confirmacaoSenhaMedico = bean.getConfirmacaoSenhaMedico();
				if(senhaMedico.equals(confirmacaoSenhaMedico)){
					dadosValidos.setSenhaMedico(senhaMedico);
				}else{
					List<String> listaMensagens = dadosValidos.getListaMensagens();
					listaMensagens.add(RespostaCadastro.SENHA_NAO_CONFIRMADA.getMensagem());
				}
			}else{
				List<String> listaMensagens = dadosValidos.getListaMensagens();
				listaMensagens.add(RespostaCadastro.SENHA_INVALIDA.getMensagem());
			}

		}else{
			List<String> listaMensagens = dadosValidos.getListaMensagens();
			listaMensagens.add(RespostaCadastro.SENHA_INVALIDA.getMensagem());
		}
	}
}
