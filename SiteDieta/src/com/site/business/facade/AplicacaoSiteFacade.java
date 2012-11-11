package com.site.business.facade;

import java.util.List;
import java.util.Map;

import com.site.business.CadastroMedicoBusiness;
import com.site.business.bean.CadastroMedicoBean;
import com.site.business.estatisticas.FabricaGeradorEstatisticas;
import com.site.business.estatisticas.IGeradorEstatisticas;
import com.site.model.CadastroMedico;

public class AplicacaoSiteFacade implements IAplicacaoSiteFacade {

	@Override
	public Map<String, Object> cadastrarMedico(CadastroMedicoBean bean) {
		CadastroMedicoBusiness business = new CadastroMedicoBusiness();
		Map<String, Object> dadosResposta = business.salvarRegistroMedico(bean);

		return dadosResposta;
	}

	@Override
	public void publicarDieta() {}

	@Override
	public List<CadastroMedico> visualizarCadastrosPendentes() {
		CadastroMedicoBusiness business = new CadastroMedicoBusiness();
		return business.visualizarCadastrosPendentes();
	}

	@Override
	public boolean confirmarCadastro(Long idCadastro) {
		CadastroMedicoBusiness cadastroMedicoBusiness = new CadastroMedicoBusiness();
		return cadastroMedicoBusiness.confirmarCadastro(idCadastro);
	}

	@Override
	public boolean rejeitarCadastro(Long idCadastro) {
		CadastroMedicoBusiness cadastroMedicoBusiness = new CadastroMedicoBusiness();
		return cadastroMedicoBusiness.rejeitarCadastro(idCadastro);
	}

	@Override
	public String gerarEstatisticas(String tipoGerador) {
		FabricaGeradorEstatisticas fabrica = new FabricaGeradorEstatisticas();
		IGeradorEstatisticas gerador = fabrica.getGerador(tipoGerador);
		return gerador.gerar();
	}
}
