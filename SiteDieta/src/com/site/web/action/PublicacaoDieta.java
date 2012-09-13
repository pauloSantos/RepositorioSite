package com.site.web.action;

import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;

@UrlBinding("/action/publicacao/dieta")
public class PublicacaoDieta extends SiteActionBean {

	
	private static final String VIEW = "/WEB-INF/paginas/publicacaoDietas.jsp";

	@DefaultHandler
	public Resolution view(){
		return new ForwardResolution(VIEW);
	}
}
