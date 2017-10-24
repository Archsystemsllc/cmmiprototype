/**
 * 
 */
package com.archsystemsinc.qam.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.archsystemsinc.qam.model.FileData;
import com.archsystemsinc.qam.model.HealthCommunity;
import com.archsystemsinc.qam.model.HealthDataTemplateConfig;
import com.archsystemsinc.qam.model.TemplateConfigData;
import com.archsystemsinc.qam.repository.AddressRepository;
import com.archsystemsinc.qam.repository.CategoryRepository;
import com.archsystemsinc.qam.repository.HealthCommunityRepository;
import com.archsystemsinc.qam.repository.HealthDataTemplateConfigRepositoty;
import com.archsystemsinc.qam.repository.SocialMediaRepository;
import com.archsystemsinc.qam.repository.TemplateConfigRepository;
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
	private AddressRepository addressRepository;
	
	@Autowired
	private CategoryRepository categoryRepository;
	
	@Autowired
	private SocialMediaRepository socialMediaRepository;
	
	@Autowired
	private TemplateConfigRepository templateConfigRepository;
	
	@Autowired
	HealthDataTemplateConfigRepositoty healthDataTemplateConfigRepositoty;
	public void createHealthTemplateConfig(HealthDataTemplateConfig data){
		healthDataTemplateConfigRepositoty.save(data);
	}
	
	
	public List<HealthDataTemplateConfig> listHealthTemplateConfigs(){
		return healthDataTemplateConfigRepositoty.findAll();
	}
	
	


	public void uploadHealthData(Long templateId, MultipartFile uploadedFile) {
		HealthDataTemplateConfig configData = healthDataTemplateConfigRepositoty.findOne(templateId);
		List<HealthCommunity> data = PoiUtils.parseHealthDataFile(uploadedFile, configData);	
		healthCommunityRepository.save(data);
		
	}


	public List<HealthCommunity> listHealthData() {
		return healthCommunityRepository.findAll();
	}

	
	
}
