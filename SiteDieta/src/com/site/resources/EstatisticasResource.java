package com.site.resources;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.google.gson.Gson;
import com.site.utilitarios.Coluna;


@Path("/estatisticas")
public class EstatisticasResource {

	
	@Context
	UriInfo uriInfo;
	
	@Context
	Request request;
	
	@GET
	@Path("teste")
	@Produces(MediaType.APPLICATION_JSON)
	public String respondAsReady(){
		return "Demo service is ready";
	}
	
    @GET
    @Path("/downloads/genero")
    @Produces(MediaType.APPLICATION_JSON)
    public String getDownloadsPorGenero() {
        Gson gson = new Gson();
        
        Coluna coluna = new Coluna();
    	coluna.setLabel("Genero");
    	coluna.setType("string");
    	
    	Coluna coluna2 = new Coluna();
    	coluna2.setLabel("Porcentagem");
    	coluna2.setType("number");
    	
    	
    	List<Map<String, Object>> cols = createCols(coluna, coluna2);
        List<Map<String, Object>> rows = createLinhas();
        
        Map<String, Object> table = new HashMap<String, Object>();
        table.put("cols", cols);
        table.put("rows", rows);
        
 
        return gson.toJson(table); 
    }
    
    @GET
    @Path("/dietas/completas")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPorcentagemCompletos() {
    	Gson gson = new Gson();
    	
    	
    	Coluna coluna1 = new Coluna();
    	coluna1.setLabel("Genero");
    	coluna1.setType("string");
    	
    	Coluna coluna2 = new Coluna();
    	coluna2.setLabel("Porcentagem dietas finalizadas");
    	coluna2.setType("number");
    	
    	
    	List<Map<String, Object>> cols = createCols(coluna1, coluna2);
    	List<Map<String, Object>> rows = createLinhas();
    	
    	Map<String, Object> table = new HashMap<String, Object>();
    	table.put("cols", cols);
    	table.put("rows", rows);
    	
    	
    	return gson.toJson(table); 
    }

    private List<Map<String, Object>> createCols(Coluna... colunas) {
    	List<Map<String, Object>> definicaoColunas = new ArrayList<Map<String, Object>>();
    	
    	for (Coluna coluna : colunas) {
    		Map<String, Object> parameters = new HashMap<String, Object>();
    		parameters.put("label", coluna.getLabel());
    		parameters.put("type", coluna.getType());
    		definicaoColunas.add(parameters);
		}
		return definicaoColunas;
	}
    
    private List<Map<String, Object>> createLinhas() {
		Map<String, Object> parameters = new HashMap<String, Object>();
        parameters.put("v", "Masculino");
        
        Map<String, Object> parameters2 = new HashMap<String, Object>();
        parameters2.put("v", 35);
        
        List<Map<String, Object>> arrayList = new ArrayList<Map<String, Object>>();
        arrayList.add(parameters);
        arrayList.add(parameters2);
        
        
        Map<String, Object> linha = new HashMap<String, Object>();
        linha.put("c", arrayList);
        
        Map<String, Object> parameters3 = new HashMap<String, Object>();
        parameters3.put("v", "Feminino");
        
        Map<String, Object> parameters4 = new HashMap<String, Object>();
        parameters4.put("v", 65);
        
        List<Map<String, Object>> arrayList2 = new ArrayList<Map<String, Object>>();
        arrayList2.add(parameters3);
        arrayList2.add(parameters4);
        
        
        Map<String, Object> linha2 = new HashMap<String, Object>();
        linha2.put("c", arrayList2);
        
        List<Map<String, Object>> linhas = new ArrayList<Map<String, Object>>();
        linhas.add(linha);
        linhas.add(linha2);
        
		return linhas;
	}
}
