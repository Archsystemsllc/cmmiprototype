/**
 * 
 */
package com.archsystemsinc.qam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

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
		HealthDataTemplateConfig configData = healthDataTemplateConfigRepositoty.findOne(templateId);
		List<HealthCommunity> data = PoiUtils.parseHealthDataFile(uploadedFile, configData);	
		return healthCommunityRepository.save(data);
		
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
