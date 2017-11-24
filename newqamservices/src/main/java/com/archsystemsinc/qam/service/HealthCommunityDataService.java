/**
 * 
 */
package com.archsystemsinc.qam.service;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.archsystems.patterns.cor.FileUploadCOR;
import com.archsystems.patterns.cor.FileUploadTO;
import com.archsystemsinc.exception.FileUploadException;
import com.archsystemsinc.qam.model.EmailAddress;
import com.archsystemsinc.qam.model.HealthCommunity;
import com.archsystemsinc.qam.model.HealthDataTemplateConfig;
import com.archsystemsinc.qam.repository.EmailAddressRepository;
import com.archsystemsinc.qam.repository.HealthCommunityRepository;
import com.archsystemsinc.qam.repository.HealthDataTemplateConfigRepositoty;
import com.archsystemsinc.qam.utils.HealthCommunityData;

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
	
	//@Autowired
	
	HealthCommunityData healthCommunityData;
	
	/**
	 * 
	 * @param data
	 */
	public HealthDataTemplateConfig createHealthTemplateConfig(HealthDataTemplateConfig data){
		return healthDataTemplateConfigRepositoty.save(data);
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
	public HealthCommunityData uploadHealthData(Long templateId, MultipartFile uploadedFile) {
		//log.debug("fileUploadCOR::"+fileUploadCOR);
		fileUploadCOR.initialize();
		FileUploadTO fto = new FileUploadTO();
		fto.setTemplateId(templateId);
		fto.setUploadedFile(uploadedFile);
		try {
			fto = (FileUploadTO) fileUploadCOR.executeChain(fto);
			healthCommunityData = new HealthCommunityData();
			healthCommunityData.setlistOfHealthCommunity(fto.getSavedData());
			healthCommunityData.setInitialFileSize(fto.getFileRows());
			
		} catch (FileUploadException e) {
			e.printStackTrace();
		}
		//log.debug("fto:"+fto);
		return healthCommunityData;
	}

	
	/**
	 * 
	 * @return
	 */
	public List<HealthCommunity> listHealthData() {
		return healthCommunityRepository.findAll();
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
	
	
}
