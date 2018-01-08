/**
 * 
 */
package com.archsystemsinc.qam.restcontroller;

import java.util.Iterator;
import java.util.List;

import javax.persistence.Entity;
import javax.servlet.http.HttpServletRequest;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.multipart.MultipartHttpServletRequest;

import com.archsystemsinc.qam.model.BpciTemplateConfig;
import com.archsystemsinc.qam.model.ConfigModel;
import com.archsystemsinc.qam.model.EmailAddress;
import com.archsystemsinc.qam.model.HealthCommunity;
import com.archsystemsinc.qam.model.HealthDataTemplateConfig;
import com.archsystemsinc.qam.model.Reporting;
import com.archsystemsinc.qam.model.TemplateData;
import com.archsystemsinc.qam.service.HealthCommunityDataService;
import com.archsystemsinc.qam.service.domain.ServiceComposition;

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
	public ConfigModel createHealthDataTemplateConfig(HealthDataTemplateConfig data) {
		log.debug("--> createTemplate" + data);
		//ServiceComposition sc = healthCommunityDataService.buildComposition(data.getTemplateId());
		//HealthDataTemplateConfig change to entity if it works
		ConfigModel ent=null;
		try {
			ent = healthCommunityDataService.createHealthTemplateConfig((ConfigModel) data);
		}catch(Exception e) {
			log.error(e);
		}
		return ent;
	}
	
	/**
	 * Because BPCI is a perfect subset we can use the one method. The TODO is to change the client data
	 * to pure JSON so this can be generalized to one method.
	 * @param data
	 * @return
	 */
	@RequestMapping(value = "/createBpciTemplateConfig", method = RequestMethod.POST)
	public HealthDataTemplateConfig createBpciTemplateConfig(BpciTemplateConfig data) {
		log.debug("--> createTemplate" + data);
		//return healthCommunityDataService.createHealthTemplateConfig(data);
		return  null;//NOT USED
	}

	/**
	 * 
	 * @return
	 */
	@RequestMapping(value = "/listTemplates", method = RequestMethod.GET)
	public List<TemplateData> listTemplates() {
		return healthCommunityDataService.listTemplates();
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
	 * @return
	 */
	@RequestMapping(value = "/reporting", method = RequestMethod.GET)
	public List<Reporting> reporting() {
		return healthCommunityDataService.reporting();
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
