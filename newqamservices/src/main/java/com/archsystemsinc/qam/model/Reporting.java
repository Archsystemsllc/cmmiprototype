/**
 * 
 */
package com.archsystemsinc.qam.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import com.archsystemsinc.qam.utils.DateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

/**
 * @author Prakash T
 *
 */
@Entity
@Table(name = "REPORTING")
public class Reporting {

	private Long id;
	private String fileName;
	private String templateName;
	
	private String status;
	private String message;
	@JsonSerialize(using=DateSerializer.class)
	private Date processedDate;
	
	
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("Reporting [id=");
		builder.append(id);
		builder.append(", fileName=");
		builder.append(fileName);
		builder.append(", templateName=");
		builder.append(templateName);
		builder.append(", status=");
		builder.append(status);
		builder.append(", message=");
		builder.append(message);
		builder.append(", processedDate=");
		builder.append(processedDate);
		builder.append("]");
		return builder.toString();
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Column(name = "File_Name")
	public String getFileName() {
		return fileName;
	}

	public void setFileName(String fileName) {
		this.fileName = fileName;
	}

	@Column(name = "Template_Name")
	public String getTemplateName() {
		return templateName;
	}

	public void setTemplateName(String templateName) {
		this.templateName = templateName;
	}

	@Column(name = "Status")
	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	@Column(name = "Message")
	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	@Column(name = "Processed_Date")
	public Date getProcessedDate() {
		return processedDate;
	}

	public void setProcessedDate(Date processedDate) {
		this.processedDate = processedDate;
	}

}
