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

import com.archsystemsinc.qam.model.EmailAddress;
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

	/**
	 * 
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/createHealthDataTemplateConfig", method = RequestMethod.POST)
	public HealthDataTemplateConfig createHealthDataTemplateConfig(HealthDataTemplateConfig data) {
		log.debug("--> createTemplate" + data);
		return healthCommunityDataService.createHealthTemplateConfig(data);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listHealthDataTemplateConfigs", method = RequestMethod.GET)
	public List<HealthDataTemplateConfig> listHealthDataTemplateConfigs() {
		return healthCommunityDataService.listHealthTemplateConfigs();
	}

	/**
	 * 
	 * @param templateId
	 * @param uploadedFile
	 * @return
	 */
	@RequestMapping(value = "/uploadHealthData/{templateId}", method = RequestMethod.POST)
	public List<HealthCommunity> uploadHealthData(@PathVariable Long templateId,
			@RequestParam("file") MultipartFile uploadedFile) {
		log.debug("--> uploadFileData:" + templateId);
		return healthCommunityDataService.uploadHealthData(templateId, uploadedFile);
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listHealthData", method = RequestMethod.GET)
	public List<HealthCommunity> listHealthData() {
		return healthCommunityDataService.listHealthData();
	}

	/**
	 * 
	 * @param emailId
	 * @return
	 */
	@RequestMapping(value = "/registerUserByEmail", method = RequestMethod.POST)
	public EmailAddress registerUserByEmail(@RequestParam("emailId") String emailId) {
		return healthCommunityDataService.registerUserByEmail(emailId);
	}

}
