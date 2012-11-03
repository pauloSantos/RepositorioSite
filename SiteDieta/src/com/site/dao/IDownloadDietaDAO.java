package com.site.dao;

import com.site.business.enums.Genero;
import com.site.business.enums.StatusDieta;

public interface IDownloadDietaDAO {

	
	Long contarTotalDownloads();
	
	Long contarDownloadsPorGenero(Genero genero);
	
	Long contarDownloadsPorGeneroEStatus(Genero genero, StatusDieta status);
}
