package com.site.business.facade;

import java.util.List;
import java.util.Map;

import com.site.business.bean.CadastroMedicoBean;
import com.site.model.CadastroMedico;

public interface IAplicacaoSiteFacade {

	
	Map<String, Object> cadastrarMedico(CadastroMedicoBean bean);
	void publicarDieta();
	List<CadastroMedico> visualizarCadastrosPendentes();
	public boolean confirmarCadastro(Long idCadastro);
	public boolean rejeitarCadastro(Long idCadastro);
	String gerarEstatisticas(String tipoGerador);
}
