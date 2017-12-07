package com.archsystems.patterns.cor;

import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.archsystemsinc.qam.model.HealthCommunity;
import com.archsystemsinc.qam.model.HealthDataTemplateConfig;
import com.archsystemsinc.qam.model.Reporting;

public class FileUploadTO extends TransferObject {
	long templateId;
	String fileName;
	String status;
	String message;
	HealthDataTemplateConfig configData;
	MultipartFile uploadedFile;
	List<HealthCommunity> parsedData;
	List<HealthCommunity> savedData;
	Reporting reporting;
	
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
	public Reporting getReporting() {
		return reporting;
	}
	public void setReporting(Reporting reporting) {
		this.reporting = reporting;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FileUploadTO [templateId=");
		builder.append(templateId);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", status=");
		builder.append(status);
		builder.append(", message=");
		builder.append(message);
		builder.append(", configData=");
		builder.append(configData);
		builder.append(", uploadedFile=");
		builder.append(uploadedFile);
		builder.append(", parsedData=");
		builder.append(parsedData);
		builder.append(", savedData=");
		builder.append(savedData);
		builder.append(", reporting=");
		builder.append(reporting);
		builder.append("]");
		return builder.toString();
	}

}
