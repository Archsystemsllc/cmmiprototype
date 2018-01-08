package com.archsystemsinc.qam.service.domain;

import com.archsystemsinc.qam.model.ConfigModel;

public interface ServiceComposition {

	public long getTemplateId();

	public String getName();

	public ConfigModel getModelObject();
	
	public void setModelObject(ConfigModel model);

	public void compose();

	public void setName(String ahcname);

}
