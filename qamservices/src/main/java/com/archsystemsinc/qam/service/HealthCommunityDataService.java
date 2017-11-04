/**
 * 
 */
package com.archsystemsinc.qam.service;

import java.util.List;

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
import com.archsystemsinc.qam.utils.PoiUtils;

/**
 * @author Prakash T
 *
 */
@Service
public class HealthCommunityDataService {
	
	@Autowired
	private HealthCommunityRepository healthCommunityRepository; 
	
	@Autowired
	private EmailAddressRepository emailAddressRepository;
	
	@Autowired
	HealthDataTemplateConfigRepositoty healthDataTemplateConfigRepositoty;
	
	
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
	public List<HealthCommunity> uploadHealthData(Long templateId, MultipartFile uploadedFile) {
		//HealthDataTemplateConfig configData = healthDataTemplateConfigRepositoty.findOne(templateId);
		//List<HealthCommunity> data = PoiUtils.parseHealthDataFile(uploadedFile, configData);	
		//return healthCommunityRepository.save(data);
		FileUploadCOR fcor = new FileUploadCOR();
		fcor.initialize();
		FileUploadTO fto = new FileUploadTO();
		//List<HealthCommunity> uploadHealthData(Long templateId, MultipartFile uploadedFile) {
		fto.setTemplateId(templateId);
		fto.setUploadedFile(uploadedFile);
		try {
			fcor.executeChain(fto);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//TODO: Define service interface to report error
		return fto.getSavedData();
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
