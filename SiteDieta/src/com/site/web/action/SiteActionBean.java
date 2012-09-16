package com.site.web.action;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;
import net.sourceforge.stripes.action.DefaultHandler;
import net.sourceforge.stripes.action.Resolution;

public abstract class SiteActionBean implements ActionBean{

	private ActionBeanContext context;

	@DefaultHandler
	public abstract Resolution view();
	
	public ActionBeanContext getContext() {
		return context;
	}

	public void setContext(ActionBeanContext context) {
		this.context = context;
	}
}
