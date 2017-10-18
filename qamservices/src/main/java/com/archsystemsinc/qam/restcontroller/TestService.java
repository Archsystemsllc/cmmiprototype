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

import com.archsystemsinc.qam.model.FileData;
import com.archsystemsinc.qam.model.TemplateConfigData;
import com.archsystemsinc.qam.model.TemplateData;
import com.archsystemsinc.qam.service.FileDataService;
import com.archsystemsinc.qam.utils.PoiUtils;
	
	/**
 * @author Prakash T
 *
 */
@RestController
@RequestMapping("api")
public class TestService {
	private static final Logger log = Logger.getLogger(TestService.class);
	
	@Autowired
	private FileDataService fileDataService;
	

	@RequestMapping(value = "/createTemplate", method = RequestMethod.POST)
	public List<TemplateData> createTemplate(@RequestParam(value="name", required=true) String name){
		log.debug("--> createTemplate");
		TemplateData data = new TemplateData();
		data.setName(name);
		fileDataService.createTemplate(data);
		log.debug("<-- createTemplate");
		return fileDataService.getAllTemplates();
	}
	
	@RequestMapping(value = "/listTemplates", method = RequestMethod.GET)
	public List<TemplateData> listTemplates(){
		return fileDataService.getAllTemplates();
	}
	
	@RequestMapping(value = "/createTemplateConfig", method = RequestMethod.POST)
	public List<TemplateConfigData> createTemplateConfig(TemplateConfigData data){
		log.debug("--> createTemplate"+data);
		fileDataService.createTemplateConfig(data);
		log.debug("<-- createTemplate");
		return fileDataService.listTemplateConfigs();
	}
	
	@RequestMapping(value = "/listTemplateConfigs", method = RequestMethod.GET)
	public List<TemplateConfigData> listTemplateConfigs(){
		return fileDataService.listTemplateConfigs();
	}
	
	
	@RequestMapping(value = "/uploadFileData/{templateId}", method = RequestMethod.POST)
	public List<FileData> uploadFileData(@PathVariable Long templateId, @RequestParam("file") MultipartFile uploadedFile){
		log.debug("--> uploadFileData:"+templateId);
		fileDataService.uploadFileData(templateId, uploadedFile);
		log.debug("<-- uploadFileData");
		return fileDataService.listFileData();
	}
	
	@RequestMapping(value = "/listFileData", method = RequestMethod.GET)
	public List<FileData> listFileData(){
		return fileDataService.listFileData();
	}
	
}
