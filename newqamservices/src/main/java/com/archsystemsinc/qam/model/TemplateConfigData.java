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
@Table(name = "TEMPLATE_CONFIG")
public class TemplateConfigData {
	private Long id;
	private Long templateId;
	
	private Long columnA;
	private Long columnB;
	private Long columnC;
	private Long columnD;
	private Long columnE;
	private Long columnF;
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
	public Long getColumnA() {
		return columnA;
	}

	public void setColumnA(Long columnA) {
		this.columnA = columnA;
	}
	@Column(name = "COLUMN_B")
	public Long getColumnB() {
		return columnB;
	}

	public void setColumnB(Long columnB) {
		this.columnB = columnB;
	}
	@Column(name = "COLUMN_C")
	public Long getColumnC() {
		return columnC;
	}

	public void setColumnC(Long columnC) {
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
	public Long getColumnE() {
		return columnE;
	}

	public void setColumnE(Long columnE) {
		this.columnE = columnE;
	}
	@Column(name = "COLUMN_F")
	public Long getColumnF() {
		return columnF;
	}

	public void setColumnF(Long columnF) {
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
		builder.append("TemplateConfigData [id=").append(id)
				.append(", templateId=").append(templateId)
				.append(", columnA=").append(columnA).append(", columnB=")
				.append(columnB).append(", columnC=").append(columnC)
				.append(", columnD=").append(columnD).append(", columnE=")
				.append(columnE).append(", columnF=").append(columnF)
				.append(", columnG=").append(columnG).append("]");
		return builder.toString();
	}


}