package com.site.business;

import java.util.List;

import com.site.model.Dieta;
import com.site.model.Usuario;

public interface IGerenciadorDietasBusiness {
	
	List<Dieta> getDieta(Usuario usuario);
}
