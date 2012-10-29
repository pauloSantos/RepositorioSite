package com.site.web.action;

import net.sourceforge.stripes.action.ForwardResolution;
import net.sourceforge.stripes.action.Resolution;
import net.sourceforge.stripes.action.UrlBinding;


@UrlBinding("/action/estatisticas")
public class VisualizadorEstatisticasAction extends SiteActionBean{

	private static final String VIEW = "/WEB-INF/paginas/estatisticas.jsp";

	@Override
	public Resolution view() {
		return new ForwardResolution(VIEW);
	}
	

}
