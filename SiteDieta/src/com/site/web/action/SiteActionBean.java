package com.site.web.action;

import net.sourceforge.stripes.action.ActionBean;
import net.sourceforge.stripes.action.ActionBeanContext;

public class SiteActionBean implements ActionBean{

	private ActionBeanContext context;

	public ActionBeanContext getContext() {
		return context;
	}

	public void setContext(ActionBeanContext context) {
		this.context = context;
	}
}
