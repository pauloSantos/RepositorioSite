package com.site.dao;

import javax.persistence.Query;

import com.site.business.enums.Genero;
import com.site.business.enums.StatusDieta;
import com.site.model.DownloadDieta;

public class DownloadDietaDAO extends PrincipalDAO implements IDownloadDietaDAO {

	
	private static final String IDADE_FINAL = "idadeFinal";
	private static final String IDADE_INICIAL = "idadeInicial";
	private static final String GENERO = "genero";
	private static final String STATUS = "status";
	
	private static final String CONTAR_TOTAL_DOWNLOADS =
			"select count(*) from "  + DownloadDieta.class.getName();
	
	private static final String CONTAR_DOWNLOADS_POR_GENERO =
			"select count(*) from "  + DownloadDieta.class.getName() + 
			" where generoUsuario =:" + GENERO;


	private static final String CONTAR_DOWNLOADS_POR_GENERO_E_STATUS =
			"select count(*) from " + DownloadDieta.class.getName() +
			" where generoUsuario =:" + GENERO + 
			" and statusDieta =:" + STATUS;
	
	private static final String CONTAR_DOWNLOADS_POR_FAIXA_ETARIA =
			"select count(*) from " + DownloadDieta.class.getName() +
			" where idadeUsuario >=:" + IDADE_INICIAL +
			" and idadeUsuario <=:" + IDADE_FINAL;
	
	private static final String CONTAR_DOWNLOADS_POR_FAIXA_ETARIA_E_STATUS =
			"select count(*) from " + DownloadDieta.class.getName() +
			" where idadeUsuario >=:" + IDADE_INICIAL +
			" and idadeUsuario <=:" + IDADE_FINAL +
			" and statusDieta =:" + STATUS;
	

	public DownloadDietaDAO(){
		super();
	}

	@Override
	public Long contarTotalDownloads() {
		Query query = getEntityManager().createQuery(CONTAR_TOTAL_DOWNLOADS);
		return (Long) query.getSingleResult();
	}

	@Override
	public Long contarDownloadsPorGenero(Genero genero) {
		Query query = getEntityManager().createQuery(CONTAR_DOWNLOADS_POR_GENERO);
		query.setParameter(GENERO, genero);
		return (Long) query.getSingleResult();
	}

	@Override
	public Long contarDownloadsPorGeneroEStatus(Genero genero, StatusDieta status) {
		Query query = getEntityManager().createQuery(CONTAR_DOWNLOADS_POR_GENERO_E_STATUS);
		query.setParameter(GENERO, genero);
		query.setParameter(STATUS, status);
		return (Long) query.getSingleResult();
		
	}
	
	public Long contarDownloadPorFaixaEtaria(Integer idadeInicial, Integer idadeFinal){
		Query query = getEntityManager().createQuery(CONTAR_DOWNLOADS_POR_FAIXA_ETARIA);
		query.setParameter(IDADE_INICIAL, idadeInicial);
		query.setParameter(IDADE_FINAL, idadeFinal);
		return (Long) query.getSingleResult();
	}
	
	public Long contarDownloadPorFaixaEtariaEStatus(Integer idadeInicial, Integer idadeFinal, StatusDieta status){
		Query query = getEntityManager().createQuery(CONTAR_DOWNLOADS_POR_FAIXA_ETARIA_E_STATUS);
		query.setParameter(IDADE_INICIAL, idadeInicial);
		query.setParameter(IDADE_FINAL, idadeFinal);
		query.setParameter(STATUS, status);
		return (Long) query.getSingleResult();
	}
}
