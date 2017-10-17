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
import com.archsystemsinc.qam.repository.FileDataRepository;
import com.archsystemsinc.qam.repository.TemplateConfigRepository;
import com.archsystemsinc.qam.repository.TemplateRepository;
import com.archsystemsinc.qam.utils.PoiUtils;

/**
 * @author Prakash
 *
 */
@RestController
@RequestMapping("api")
public class TestService {
	private static final Logger log = Logger.getLogger(TestService.class);
	
	@Autowired
	private FileDataRepository fileDataRepository;
	
	@Autowired
	private TemplateRepository templateRepository;
	
	@Autowired
	private TemplateConfigRepository templateConfigRepository;
	

	@RequestMapping(value = "/createTemplate", method = RequestMethod.POST)
	public List<TemplateData> createTemplate(@RequestParam(value="name", required=true) String name){
		log.debug("--> createTemplate"+templateRepository);
		TemplateData data = new TemplateData();
		data.setName(name);
		templateRepository.save(data);
		log.debug("<-- createTemplate");
		return templateRepository.findAll();
	}
	
	@RequestMapping(value = "/listTemplates", method = RequestMethod.GET)
	public List<TemplateData> listTemplates(){
		return templateRepository.findAll();
	}
	
	@RequestMapping(value = "/createTemplateConfig", method = RequestMethod.POST)
	public List<TemplateConfigData> createTemplateConfig(TemplateConfigData data){
		log.debug("--> createTemplate"+data);
		templateConfigRepository.save(data);
		log.debug("<-- createTemplate");
		return templateConfigRepository.findAll();
	}
	
	@RequestMapping(value = "/listTemplateConfigs", method = RequestMethod.GET)
	public List<TemplateConfigData> listTemplateConfigs(){
		return templateConfigRepository.findAll();
	}
	
	@RequestMapping(value = "/uploadFile", method = RequestMethod.POST)
	public List<FileData> uploadFile(@RequestParam(value="templateId", required=true) Long templateId, FileData data){
		log.debug("--> uploadFile"+fileDataRepository);
		fileDataRepository.save(data);
		log.debug("<-- uploadFile");
		return fileDataRepository.findAll();
	}
	
	
	@RequestMapping(value = "/uploadFileData/{templateId}", method = RequestMethod.POST)
	public List<FileData> uploadFileData(@PathVariable Long templateId, @RequestParam("file") MultipartFile uploadedFile){
		log.debug("--> uploadFileData:"+templateId);
		TemplateConfigData configData = templateConfigRepository.findOne(templateId);
		List<FileData> data = PoiUtils.parseFile(uploadedFile, configData);
		log.debug("data::"+data);
		fileDataRepository.save(data);
		log.debug("<-- uploadFileData");
		return fileDataRepository.findAll();
	}
	
	@RequestMapping(value = "/listFileData", method = RequestMethod.GET)
	public List<FileData> listFileData(){
		return fileDataRepository.findAll();
	}
	
}
