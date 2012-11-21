package com.site.business.estatisticas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.site.business.enums.StatusDieta;
import com.site.dao.DownloadDietaDAO;
import com.site.utilitarios.Coluna;

public class GeradorEstatisticasDietasFinalizadasPorIdade implements IGeradorEstatisticas{

	@Override
	public String gerar() {
		Gson gson = new Gson();

		Coluna coluna1 = new Coluna();
		coluna1.setLabel("Faixa Etaria");
		coluna1.setType("string");

		Coluna coluna2 = new Coluna();
		coluna2.setLabel("Downloads");
		coluna2.setType("number");
		
		List<Map<String, Object>> colunas = criarColunas(coluna1, coluna2);
		
		DownloadDietaDAO downloadDietaDAO = new DownloadDietaDAO();
		
		double porcentagemCriancas = downloadDietaDAO.contarDownloadPorFaixaEtariaEStatus(1, 11, StatusDieta.FEITA);
		double porcentagemAdolescentes = downloadDietaDAO.contarDownloadPorFaixaEtariaEStatus(12, 18, StatusDieta.FEITA);
		double porcentagemAdultos = downloadDietaDAO.contarDownloadPorFaixaEtariaEStatus(19, 40, StatusDieta.FEITA);
		double porcentagemIdosos = downloadDietaDAO.contarDownloadPorFaixaEtariaEStatus(41, 200, StatusDieta.FEITA);
		
		List<Map<String, Object>> linhas = criarLinhas(porcentagemCriancas, porcentagemAdolescentes, porcentagemAdultos, porcentagemIdosos);

		Map<String, Object> tabela = criarTabela(colunas, linhas);

		downloadDietaDAO.getEntityManager().getEntityManagerFactory().close();
		
		return gson.toJson(tabela); 
	}

	private Map<String, Object> criarTabela(List<Map<String, Object>> cols, List<Map<String, Object>> rows) {
		Map<String, Object> table = new HashMap<String, Object>();
		table.put("cols", cols);
		table.put("rows", rows);
		return table;
	}
	
	private List<Map<String, Object>> criarColunas(Coluna... colunas) {
		List<Map<String, Object>> definicaoColunas = new ArrayList<Map<String, Object>>();

		for (Coluna coluna : colunas) {
			Map<String, Object> parameters = new HashMap<String, Object>();
			parameters.put("label", coluna.getLabel());
			parameters.put("type", coluna.getType());
			definicaoColunas.add(parameters);
		}
		return definicaoColunas;
	}
	
	@SuppressWarnings("unchecked")
	private List<Map<String, Object>> criarLinhas(double porcentagemCriancas, double porcentagemAdolescentes, double porcentagemAdultos, double porcentagemIdosos){
		
		List<Map<String, Object>> listaParametrosCriancas = criarListaParametros("1-11 anos", porcentagemCriancas);
		
		List<Map<String, Object>> listaParametrosAdolescentes = criarListaParametros("12-18 anos", porcentagemAdolescentes);
		
		List<Map<String, Object>> listaParametrosAdultos = criarListaParametros("18-40 anos", porcentagemAdultos);
		
		List<Map<String, Object>> listaParametrosIdosos = criarListaParametros("Acima de 40 anos", porcentagemIdosos);
		
		return criarListaLinhas(listaParametrosCriancas, listaParametrosAdolescentes, listaParametrosAdultos, listaParametrosIdosos);
	}

	private List<Map<String, Object>> criarListaParametros(String parametroIdade, double porcentagemIdosos) {
		Map<String, Object> parametroIdadeIdosos = new HashMap<String, Object>();
		parametroIdadeIdosos.put("v", parametroIdade);
		
		Map<String, Object> parametroPorcentagemIdosos = new HashMap<String, Object>();
		parametroPorcentagemIdosos.put("v", porcentagemIdosos);
		
		List<Map<String, Object>> listaParametrosIdosos = new ArrayList<Map<String, Object>>();
		listaParametrosIdosos.add(parametroIdadeIdosos);
		listaParametrosIdosos.add(parametroPorcentagemIdosos);
		return listaParametrosIdosos;
	}
	
	@SuppressWarnings("unchecked")
	private List<Map<String, Object>> criarListaLinhas(List<Map<String, Object>>... lista) {
		List<Map<String, Object>> linhas = new ArrayList<Map<String, Object>>();
		for (List<Map<String, Object>> listaMapas : lista) {
			Map<String, Object> linha = new HashMap<String, Object>();
			linha.put("c", listaMapas);
			linhas.add(linha);
		}
		return linhas;
	}
}
