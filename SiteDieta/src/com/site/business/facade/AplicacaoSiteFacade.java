package com.site.business.facade;

import java.util.List;
import java.util.Map;

import com.site.business.bean.CadastroMedicoBean;
import com.site.model.CadastroMedico;

public interface AplicacaoSiteFacade {

	
	Map<String, Object> cadastrarMedico(CadastroMedicoBean bean);
	void publicarDieta();
	List<CadastroMedico> visualizarCadastrosPendentes();
	void atualizarStatusCadastroMedico(String idCadastro, String opcaoEscolhida);
}
