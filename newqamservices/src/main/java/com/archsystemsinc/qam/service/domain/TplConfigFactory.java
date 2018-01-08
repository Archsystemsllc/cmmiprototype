package com.archsystemsinc.qam.service.domain;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Component;

import com.archsystemsinc.qam.model.BpciTemplateConfig;
import com.archsystemsinc.qam.model.ConfigModel;
import com.archsystemsinc.qam.model.HealthDataTemplateConfig;
import com.archsystemsinc.qam.model.TemplateData;
import com.archsystemsinc.qam.repository.BpciConfigRepository;
import com.archsystemsinc.qam.repository.HealthDataTemplateConfigRepositoty;
import com.archsystemsinc.qam.repository.TemplateRepository;
@Component
public class TplConfigFactory {
	//@Autowired
	private static TemplateRepository templateRepository_s;
	
	@Autowired
	private TemplateRepository templateRepository;
	@Autowired
	private AhcComposition ahcComp;
	private static AhcComposition ahcComp_s;
	@Autowired
	private BpciComposition bpciComp;
	private static BpciComposition bpciComp_s;
	@Autowired
	private HealthDataTemplateConfigRepositoty healthDataTemplateConfigRepositoty;
	private static HealthDataTemplateConfigRepositoty healthDataTemplateConfigRepositoty_s;
	@Autowired
	private BpciConfigRepository bpciConfigRepository;
	private static BpciConfigRepository bpciConfigRepository_s;
	  @PostConstruct
	    public void init() {
		  TplConfigFactory.templateRepository_s = templateRepository;
		  TplConfigFactory.ahcComp_s=ahcComp;
		  TplConfigFactory.bpciComp_s=bpciComp;
		  TplConfigFactory.healthDataTemplateConfigRepositoty_s=healthDataTemplateConfigRepositoty;
		  TplConfigFactory.bpciConfigRepository_s=bpciConfigRepository;
	    }

	//private static final String  ahcName ="AHC Template";
	//private static final String  bpciName ="BPCI Template";
 

	
	
	
	public static ServiceComposition buildComposition(ConfigModel data) {
		HealthDataTemplateConfig ahcModel=null;
		BpciTemplateConfig bpciModel=null;
		long templateId=0;
		
		if(data instanceof HealthDataTemplateConfig) {
			ahcModel=(HealthDataTemplateConfig) data;
			templateId=ahcModel.getTemplateId();
		}else if(data instanceof BpciTemplateConfig) {
			bpciModel=(BpciTemplateConfig) data;
			templateId=bpciModel.getTemplateId();
		}

		ServiceComposition serviceComp = null;
		

		TemplateData td = templateRepository_s.findOne(templateId);
		//TODO: check null
		String name = td.getName();
		
        switch (name) {
	        case AhcComposition.ahcName:  
	        	serviceComp = ahcComp_s;//new AhcComposition();
	        	serviceComp.setName(AhcComposition.ahcName);
	        	serviceComp.setModelObject((ConfigModel) ahcModel);
	        	serviceComp.compose();
	            break;
	        case BpciComposition.bpciName:  
	        	serviceComp = bpciComp_s;//new BpciComposition();
	        	serviceComp.setName(BpciComposition.bpciName);
	        	serviceComp.setModelObject((ConfigModel) bpciModel);
	        	serviceComp.compose();
	            break;
	        default: 
	        	//throw error
	        	break; 
        }       	
		return serviceComp;
	}
	
	public static JpaRepository getRepo(ServiceComposition serviceComp) {
		HealthDataTemplateConfig ahcTc;
		BpciTemplateConfig bpciTc;
		JpaRepository repo=null;

		//TemplateData td = templateRepository_s.findOne(serviceComp.getTemplateId());
		//TODO: check null
		String name = serviceComp.getName();
		
        switch (name) {
	        case AhcComposition.ahcName:  
	        	repo = healthDataTemplateConfigRepositoty_s;
	            break;
	        case BpciComposition.bpciName:  
	        	repo =  bpciConfigRepository_s;
	            break;
	        default: 
	        	//throw error
	        	break; 
        }   
        return repo;
	}
}
