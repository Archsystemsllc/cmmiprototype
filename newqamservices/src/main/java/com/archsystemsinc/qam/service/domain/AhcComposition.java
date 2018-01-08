package com.archsystemsinc.qam.service.domain;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import com.archsystemsinc.qam.model.ConfigModel;
import com.archsystemsinc.qam.model.HealthDataTemplateConfig;
import com.archsystemsinc.qam.repository.HealthDataTemplateConfigRepositoty;
import com.archsystemsinc.qam.repository.TemplateRepository;
@Component
public class AhcComposition implements ServiceComposition{
	public static final String  ahcName ="AHC Template";
	//@Autowired
	//private HealthDataTemplateConfigRepositoty healthDataTemplateConfigRepositoty;
	
	@Autowired
	private TemplateRepository templateRepository;
	
	@Autowired
	HealthDataTemplateConfigRepositoty healthDataTemplateConfigRepositoty;
	
	private HealthDataTemplateConfig modelObject=null;
	private long templateId;
	private String name;
	
	public void compose() {
		compose((HealthDataTemplateConfig) this.getModelObject());
	}
	public void compose(HealthDataTemplateConfig data) {
		//TODO: null check / code hardening
		
		

		HealthDataTemplateConfig cfg = healthDataTemplateConfigRepositoty.findByTemplateId(data.getTemplateId());
		if(cfg!=null) {
			cfg.setCategoryName(data.getCategoryName());
			cfg.setCity(data.getCity());
			cfg.setFacebook(data.getFacebook());
			cfg.setLocation(data.getLocation());
			cfg.setMapDisplay(data.getMapDisplay());
			cfg.setMergedCol1(data.getMergedCol1());
			cfg.setMsaName(data.getMsaName());
			cfg.setNameOfInitiative(data.getNameOfInitiative());
			cfg.setNotes(data.getNotes());
			cfg.setOrgName(data.getOrgName());
			cfg.setPhase1(data.getPhase1());
			cfg.setPhase2(data.getPhase2());
			cfg.setState(data.getState());
			cfg.setStateBase(data.getStateBase());
			cfg.setStreetAddress(data.getStreetAddress());
			cfg.setTemplateId(data.getTemplateId());
			cfg.setTwitter(data.getTwitter());
			cfg.setUniqueId(data.getUniqueId());
			cfg.setWebsite(data.getWebsite());
			cfg.setYoutube(data.getYoutube());
			setModelObject((ConfigModel) cfg);
		}else {
			setModelObject((ConfigModel) data);
		}

	}

	public ConfigModel getModelObject() {
		return  modelObject;
	}

	public void setModelObject(ConfigModel modelObject) {
		this.modelObject = (HealthDataTemplateConfig) modelObject;
	}

	@Override
	public long getTemplateId() {
		return templateId;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setTemplateId(long templateId) {
		this.templateId = templateId;
	}

	public void setName(String name) {
		this.name = name;
	}




}
