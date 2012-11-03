package com.site.business.estatisticas;

import java.util.HashMap;
import java.util.Map;

public class FabricaGeradorEstatisticas {

	private static final String DOWNLOADS_IDADE = "downloadsIdade";
	private static final String FINALIZADAS_GENERO = "finalizadasGenero";
	private static final String DOWNLOAD_GENERO = "downloadsGenero";
	private static final String FINALIZADAS_IDADE = "finalizadasIdade";
	private static Map<String, Object> listaObjetos = new HashMap<String, Object>();
	
	
	static{
		listaObjetos.put(DOWNLOAD_GENERO, new GeradorEstatisticasDownloadsPorGenero());
		listaObjetos.put(FINALIZADAS_GENERO, new GeradorEstatisticasDietasFinalizadasPorGenero());
		listaObjetos.put(DOWNLOADS_IDADE, new GeradorEstatisticasDownloadsPorIdade());
		listaObjetos.put(FINALIZADAS_IDADE, new GeradorEstatisticasDietasFinalizadasPorIdade());
	}
	
	public IGeradorEstatisticas getGerador(String tipoGerador){
		return (IGeradorEstatisticas) listaObjetos.get(tipoGerador);
	}
}
