package com.archsystemsinc.qam.service.domain;

import javax.persistence.Entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.archsystemsinc.qam.model.BpciTemplateConfig;
import com.archsystemsinc.qam.model.ConfigModel;
import com.archsystemsinc.qam.model.HealthDataTemplateConfig;
import com.archsystemsinc.qam.repository.BpciConfigRepository;
@Component
public class BpciComposition implements ServiceComposition{

	public static final String  bpciName ="BPCI Template";	
	@Autowired
	BpciConfigRepository bpciConfigRepository;	
	private BpciTemplateConfig modelObject=null;
	private long templateId;
	private String name;
	
	@Override
	public void compose() {
		compose((BpciTemplateConfig) this.getModelObject());
		
	}
	public void compose(BpciTemplateConfig data) {
		//TODO: null check / code hardening
	
		BpciTemplateConfig cfg = bpciConfigRepository.findByTemplateId(data.getTemplateId());
		if(cfg!=null) {
			cfg.setCity(data.getCity());
			cfg.setLocation(data.getLocation());
			cfg.setMergedCol1(data.getMergedCol1());
			cfg.setNameOfInitiative(data.getNameOfInitiative());
			cfg.setNotes(data.getNotes());
			cfg.setOrgName(data.getOrgName());
			cfg.setPhase1(data.getPhase1());
			cfg.setState(data.getState());
			cfg.setStateBase(data.getStateBase());
			cfg.setStreetAddress(data.getStreetAddress());
			cfg.setTemplateId(data.getTemplateId());
			setModelObject((ConfigModel) cfg);
		}else {
			setModelObject((ConfigModel) data);
		}

	}
	
	public void compose(HealthDataTemplateConfig data) {
		//TODO: null check / code hardening
	
		BpciTemplateConfig cfg = bpciConfigRepository.findByTemplateId(data.getTemplateId());
		
		if(cfg==null) {cfg = new BpciTemplateConfig();}
			
			cfg.setCity(data.getCity());
			cfg.setLocation(data.getLocation());
			cfg.setMergedCol1(data.getMergedCol1());
			cfg.setNameOfInitiative(data.getNameOfInitiative());
			cfg.setNotes(data.getNotes());
			cfg.setOrgName(data.getOrgName());
			cfg.setPhase1(data.getPhase1());
			cfg.setState(data.getState());
			cfg.setStateBase(data.getStateBase());
			cfg.setStreetAddress(data.getStreetAddress());
			cfg.setTemplateId(data.getTemplateId());
			setModelObject((ConfigModel) cfg);
		
	}

	public ConfigModel getModelObject() {
		return  modelObject;
	}

	public void setModelObject(ConfigModel modelObject) {
		this.modelObject = (BpciTemplateConfig) modelObject;
	}

	public long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(long templateId) {
		this.templateId = templateId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}




}
