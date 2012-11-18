package com.site.business.estatisticas;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.google.gson.Gson;
import com.site.business.enums.Genero;
import com.site.business.enums.StatusDieta;
import com.site.dao.DownloadDietaDAO;
import com.site.dao.IDownloadDietaDAO;
import com.site.utilitarios.Coluna;

public class GeradorEstatisticasDietasFinalizadasPorGenero implements IGeradorEstatisticas{

	@Override
	public String gerar() {
		Gson gson = new Gson();

		Coluna coluna1 = new Coluna();
		coluna1.setLabel("Genero");
		coluna1.setType("string");

		Coluna coluna2 = new Coluna();
		coluna2.setLabel("Finalizadas");
		coluna2.setType("number");

		IDownloadDietaDAO downloadDietaDAO = new DownloadDietaDAO();

		double porcentagemHomens = downloadDietaDAO.contarDownloadsPorGeneroEStatus(Genero.M, StatusDieta.FEITA);
		double porcentagemMulheres = downloadDietaDAO.contarDownloadsPorGeneroEStatus(Genero.F, StatusDieta.FEITA);

		List<Map<String, Object>> cols = criarColunas(coluna1, coluna2);
		List<Map<String, Object>> rows = criarLinhasDietasFinalizadasPorGenero(porcentagemHomens, porcentagemMulheres);

		Map<String, Object> table = criarTabela(cols, rows);

		return gson.toJson(table); 
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

	private List<Map<String, Object>> criarLinhasDietasFinalizadasPorGenero(double porcentagemHomes, double porcentagemMulheres) {
		Map<String, Object> parameters = new HashMap<String, Object>();
		parameters.put("v", "Homens");

		Map<String, Object> parameters2 = new HashMap<String, Object>();
		parameters2.put("v", porcentagemHomes);

		List<Map<String, Object>> arrayList = new ArrayList<Map<String, Object>>();
		arrayList.add(parameters);
		arrayList.add(parameters2);



		Map<String, Object> parameters3 = new HashMap<String, Object>();
		parameters3.put("v", "Mulheres");

		Map<String, Object> parameters4 = new HashMap<String, Object>();
		parameters4.put("v", porcentagemMulheres);

		List<Map<String, Object>> arrayList2 = new ArrayList<Map<String, Object>>();
		arrayList2.add(parameters3);
		arrayList2.add(parameters4);


		return criarLinhas(arrayList, arrayList2);
	}

	private List<Map<String, Object>> criarLinhas(List<Map<String, Object>>... lista) {
		List<Map<String, Object>> linhas = new ArrayList<Map<String, Object>>();
		for (List<Map<String, Object>> listaMapas : lista) {
			Map<String, Object> linha = new HashMap<String, Object>();
			linha.put("c", listaMapas);
			linhas.add(linha);
		}
		return linhas;
	}

}
