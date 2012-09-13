package com.site.web.action;

import net.sourceforge.stripes.action.ActionBeanContext;

public interface ActionBean {
	
	public void setContext(ActionBeanContext context);
	public ActionBeanContext getContext();
}
