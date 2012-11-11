package com.site.webservice;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Context;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Request;
import javax.ws.rs.core.UriInfo;

import com.site.business.facade.IAplicacaoSiteFacade;
import com.site.business.facade.AplicacaoSiteFacade;



@Path("/estatisticas")
public class EstatisticasWebService {

	IAplicacaoSiteFacade fachada = new AplicacaoSiteFacade();
	
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
    	return fachada.gerarEstatisticas("downloadsGenero");
    }
    
    @GET
    @Path("/dietas/completas/genero")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPorcentagemCompletosPorGenero() {
    	return fachada.gerarEstatisticas("finalizadasGenero");
    }
    
    @GET
    @Path("/downloads/idade")
    @Produces(MediaType.APPLICATION_JSON)
    public String getDownloadsPorIdade() {
    	return fachada.gerarEstatisticas("downloadsIdade");
    }
    
    @GET
    @Path("/dietas/completas/idade")
    @Produces(MediaType.APPLICATION_JSON)
    public String getPorcentagemCompletosPorIdade() {
    	return fachada.gerarEstatisticas("finalizadasIdade");
    }
}