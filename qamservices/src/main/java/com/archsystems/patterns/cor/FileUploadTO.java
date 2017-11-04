package com.archsystems.patterns.cor;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.archsystemsinc.qam.model.HealthCommunity;
import com.archsystemsinc.qam.model.HealthDataTemplateConfig;

public class FileUploadTO extends TransferObject {
	long templateId;
	HealthDataTemplateConfig configData;
	MultipartFile uploadedFile;
	List<HealthCommunity> parsedData;
	List<HealthCommunity> savedData;
	
	
	@Override
	public String toString() {
		return "FileUploadTO [templateId=" + templateId + ", configData=" + configData + ", parsedData=" + parsedData
				+ ", savedData=" + savedData + "]";
	}
	public long getTemplateId() {
		return templateId;
	}
	public void setTemplateId(long templateId) {
		this.templateId = templateId;
	}
	public HealthDataTemplateConfig getConfigData() {
		return configData;
	}
	public void setConfigData(HealthDataTemplateConfig configData) {
		this.configData = configData;
	}
	public MultipartFile getUploadedFile() {
		return uploadedFile;
	}
	public void setUploadedFile(MultipartFile uploadedFile) {
		this.uploadedFile = uploadedFile;
	}
	public List<HealthCommunity> getParsedData() {
		return parsedData;
	}
	public void setParsedData(List<HealthCommunity> parsedData) {
		this.parsedData = parsedData;
	}
	public List<HealthCommunity> getSavedData() {
		return savedData;
	}
	public void setSavedData(List<HealthCommunity> savedData) {
		this.savedData = savedData;
	}
}
