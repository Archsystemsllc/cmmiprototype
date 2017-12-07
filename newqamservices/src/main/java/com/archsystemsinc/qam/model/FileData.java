package com.archsystemsinc.qam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 */

@Entity
@Table(name = "FILE_DATA")
public class FileData {
	private Long id;
	private Long templateId;
	private String columnA;
	private String columnB;
	private String columnC;
	private Long columnD;
	private String columnE;
	private String columnF;
	private Long columnG;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}
	@Column(name = "TEMPLATE_ID")
	public Long getTemplateId() {
		return templateId;
	}

	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}

	@Column(name = "COLUMN_A")
	public String getColumnA() {
		return columnA;
	}

	public void setColumnA(String columnA) {
		this.columnA = columnA;
	}

	@Column(name = "COLUMN_B")
	public String getColumnB() {
		return columnB;
	}

	public void setColumnB(String columnB) {
		this.columnB = columnB;
	}

	@Column(name = "COLUMN_C")
	public String getColumnC() {
		return columnC;
	}

	public void setColumnC(String columnC) {
		this.columnC = columnC;
	}
	@Column(name = "COLUMN_D")
	public Long getColumnD() {
		return columnD;
	}

	public void setColumnD(Long columnD) {
		this.columnD = columnD;
	}

	@Column(name = "COLUMN_E")
	public String getColumnE() {
		return columnE;
	}

	public void setColumnE(String columnE) {
		this.columnE = columnE;
	}
	@Column(name = "COLUMN_F")
	public String getColumnF() {
		return columnF;
	}

	public void setColumnF(String columnF) {
		this.columnF = columnF;
	}

	@Column(name = "COLUMN_G")
	public Long getColumnG() {
		return columnG;
	}

	public void setColumnG(Long columnG) {
		this.columnG = columnG;
	}

	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("FileData [id=").append(id).append(", templateId=")
				.append(templateId).append(", columnA=").append(columnA)
				.append(", columnB=").append(columnB).append(", columnC=")
				.append(columnC).append(", columnD=").append(columnD)
				.append(", columnE=").append(columnE).append(", columnF=")
				.append(columnF).append(", columnG=").append(columnG)
				.append("]");
		return builder.toString();
	}
	
	
}