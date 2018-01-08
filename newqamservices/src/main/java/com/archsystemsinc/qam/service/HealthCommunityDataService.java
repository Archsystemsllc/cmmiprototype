/**
 * 
 */
package com.archsystemsinc.qam.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.persistence.Entity;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.archsystems.patterns.cor.FileUploadCOR;
import com.archsystems.patterns.cor.FileUploadTO;
import com.archsystemsinc.exception.FileUploadException;
import com.archsystemsinc.qam.model.ConfigModel;
import com.archsystemsinc.qam.model.EmailAddress;
import com.archsystemsinc.qam.model.HealthCommunity;
import com.archsystemsinc.qam.model.HealthDataTemplateConfig;
import com.archsystemsinc.qam.model.Reporting;
import com.archsystemsinc.qam.model.TemplateData;
import com.archsystemsinc.qam.repository.EmailAddressRepository;
import com.archsystemsinc.qam.repository.HealthCommunityRepository;
import com.archsystemsinc.qam.repository.HealthDataTemplateConfigRepositoty;
import com.archsystemsinc.qam.repository.ReportingRepository;
import com.archsystemsinc.qam.repository.TemplateRepository;
import com.archsystemsinc.qam.service.domain.ServiceComposition;
import com.archsystemsinc.qam.service.domain.TplConfigFactory;
import com.archsystemsinc.qam.utils.PoiUtils;

/**
 * @author Prakash T
 *
 */
@Service
public class HealthCommunityDataService {
	private static final Logger log = Logger.getLogger(HealthCommunityDataService.class);	
	@Autowired
	private HealthCommunityRepository healthCommunityRepository; 
	
	@Autowired
	private FileUploadCOR fileUploadCOR;
	@Autowired
	private EmailAddressRepository emailAddressRepository;
	
	@Autowired
	HealthDataTemplateConfigRepositoty healthDataTemplateConfigRepositoty;
	
	@Autowired
	private ReportingRepository reportingRepository;
	
	@Autowired
	private TemplateRepository templateRepository;

	/**
	 * 
	 * @param data
	 */
	public ServiceComposition buildComposition(ConfigModel entity){
		ServiceComposition sc  = null;	
		new TplConfigFactory();
		sc = TplConfigFactory.buildComposition(entity);
		return sc;
	}
	
	@SuppressWarnings("unchecked")
	public ServiceComposition saveComposition(ServiceComposition data){
		@SuppressWarnings("rawtypes")
		JpaRepository repo =TplConfigFactory.getRepo(data);
		 //TODO: must parameterize
		repo.save(data.getModelObject());
		return data;		
	}	
	
	/**
	 * 
	 * @param data
	 */
	public ConfigModel createHealthTemplateConfig(ConfigModel data){
		//DO AN UPDATE IF THE CONFIG EXISTS OR CREATE IT IF NOT data.getId();	
		//HealthDataTemplateConfig data
		ServiceComposition sc = buildComposition(data);
		//long tid = data.getTemplateId();
		//ServiceComposition sc = buildComposition(tid);
		saveComposition(sc);
		return sc.getModelObject();
		//repo.
	/*	HealthDataTemplateConfig cfg = healthDataTemplateConfigRepositoty.findByTemplateId(tid);
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
			
			return healthDataTemplateConfigRepositoty.save(cfg);
		}else {	
			return healthDataTemplateConfigRepositoty.save(data);
		}*/
	}
	

	/**
	 * 
	 * @return
	 */
	public List<TemplateData> listTemplates(){
		return templateRepository.findAll();
	}
	
	/**
	 * 
	 * @return
	 */
	public List<HealthDataTemplateConfig> listHealthTemplateConfigs(){
		return healthDataTemplateConfigRepositoty.findAll();
	}
	
	

	/**
	 * 
	 * @param templateId
	 * @param uploadedFile
	 */
	public List<HealthCommunity> uploadHealthData(Long templateId, MultipartFile uploadedFile) {
		//log.debug("fileUploadCOR::"+fileUploadCOR);
		fileUploadCOR.initialize();
		FileUploadTO fto = new FileUploadTO();
		fto.setTemplateId(templateId);
		fto.setFileName(uploadedFile.getOriginalFilename());
		fto.setUploadedFile(uploadedFile);
		try {
			fto = (FileUploadTO) fileUploadCOR.executeChain(fto);
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		//log.debug("fto:"+fto);
		return fto.getSavedData();
	}



	/**
	 * 
	 * @return
	 */
	public List<HealthCommunity> listHealthData() {
		List<HealthCommunity> data = healthCommunityRepository.findAll();
		if(!data.isEmpty()) {
			Map<Long,HealthDataTemplateConfig> healthDataTemplateConfigMap = new HashMap<Long,HealthDataTemplateConfig>();
			HealthDataTemplateConfig tempConf = null;
			for(HealthCommunity hc:data) {
				if(healthDataTemplateConfigMap.containsKey(hc.getTemplateId())) {
					tempConf = healthDataTemplateConfigMap.get(hc.getTemplateId());
				}else {
					tempConf = healthDataTemplateConfigRepositoty.findByTemplateId(hc.getTemplateId());
					healthDataTemplateConfigMap.put(hc.getTemplateId(), tempConf);
				}
				if(tempConf != null) {
					PoiUtils.updateHealthDataWithMergedColData(hc, tempConf);
				}				
			}			
			
		}
		return data;
	}

	/**
	 * 
	 * @param emailId
	 * @return
	 */
	public EmailAddress registerUserByEmail(String emailId) {
		EmailAddress emailAddress = emailAddressRepository.findByEmailId(emailId);
		if(emailAddress == null || emailAddress.getId() == null) {
			emailAddress = new EmailAddress();
			emailAddress.setEmailId(emailId);
			emailAddressRepository.save(emailAddress);
		}
		
		return emailAddress;
	}


	/**
	 * 
	 * @return
	 */
	public List<Reporting> reporting() {
		return reportingRepository.findAll();
	}
	
	
}
