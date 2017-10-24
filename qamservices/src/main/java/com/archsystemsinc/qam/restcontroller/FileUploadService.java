/**
 * 
 */
package com.archsystemsinc.qam.restcontroller;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.archsystemsinc.qam.model.HealthCommunity;
import com.archsystemsinc.qam.model.HealthDataTemplateConfig;
import com.archsystemsinc.qam.service.HealthCommunityDataService;

/**
 * @author Prakash T
 *
 */
@RestController
@RequestMapping("api")
public class FileUploadService {
	private static final Logger log = Logger.getLogger(FileUploadService.class);
	
	@Autowired
	private HealthCommunityDataService healthCommunityDataService;
	
	
	
	@RequestMapping(value = "/createHealthDataTemplateConfig", method = RequestMethod.POST)
	public List<HealthDataTemplateConfig> createHealthDataTemplateConfig(HealthDataTemplateConfig data){
		log.debug("--> createTemplate"+data);
		healthCommunityDataService.createHealthTemplateConfig(data);
		log.debug("<-- createTemplate");
		return healthCommunityDataService.listHealthTemplateConfigs();
	}
	
	@RequestMapping(value = "/listHealthDataTemplateConfigs", method = RequestMethod.GET)
	public List<HealthDataTemplateConfig> listHealthDataTemplateConfigs(){
		return healthCommunityDataService.listHealthTemplateConfigs();
	}
	
	
	@RequestMapping(value = "/uploadHealthData/{templateId}", method = RequestMethod.POST)
	public List<HealthCommunity> uploadHealthData(@PathVariable Long templateId, @RequestParam("file") MultipartFile uploadedFile){
		log.debug("--> uploadFileData:"+templateId);
		healthCommunityDataService.uploadHealthData(templateId, uploadedFile);
		log.debug("<-- uploadFileData");
		return healthCommunityDataService.listHealthData();
	}
	
	@RequestMapping(value = "/listHealthData", method = RequestMethod.GET)
	public List<HealthCommunity> listHealthData(){
		return healthCommunityDataService.listHealthData();
	}
	

	}
