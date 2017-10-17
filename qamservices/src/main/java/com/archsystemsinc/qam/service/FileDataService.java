/**
 * 
 */
package com.archsystemsinc.qam.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.archsystemsinc.qam.model.FileData;
import com.archsystemsinc.qam.model.TemplateConfigData;
import com.archsystemsinc.qam.model.TemplateData;
import com.archsystemsinc.qam.repository.FileDataRepository;
import com.archsystemsinc.qam.repository.TemplateConfigRepository;
import com.archsystemsinc.qam.repository.TemplateRepository;
import com.archsystemsinc.qam.utils.PoiUtils;

/**
 * @author Prakash T
 *
 */
@Service
@Transactional
public class FileDataService {

	@Autowired
	private FileDataRepository fileDataRepository;
	
	@Autowired
	private TemplateRepository templateRepository;
	
	@Autowired
	private TemplateConfigRepository templateConfigRepository;
	
	public void createTemplate(TemplateData data){
		templateRepository.save(data);
	}
	
	public List<TemplateData> getAllTemplates(){
		return templateRepository.findAll();
	}
	
	public void createTemplateConfig(TemplateConfigData data){
		templateConfigRepository.save(data);
	}
	
	public List<TemplateConfigData> listTemplateConfigs(){
		return templateConfigRepository.findAll();
	}
	
	public void uploadFileData(Long templateId, MultipartFile uploadedFile){
		TemplateConfigData configData = templateConfigRepository.findOne(templateId);
		List<FileData> data = PoiUtils.parseFile(uploadedFile, configData);		
		fileDataRepository.save(data);
	}

	public List<FileData> listFileData() {
		return fileDataRepository.findAll();
	}
}
