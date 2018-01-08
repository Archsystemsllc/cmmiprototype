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
@Table(name = "BPCI_TEMPLATE_CONFIG")
public class BpciTemplateConfig extends ConfigModel{
	private Long id;
	private Long templateId;

	private Long nameOfInitiative;
	private Long orgName;
	private Long notes;
	private Long location;
	private Long streetAddress;
	private Long city;
	private Long state;
	private Long stateBase;
	private Long phase1;
	
	private String mergedCol1;

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
	
	@Column(name = "NAME_INITIATIVE")
	public Long getNameOfInitiative() {
		return nameOfInitiative;
	}
	public void setNameOfInitiative(Long nameOfInitiative) {
		this.nameOfInitiative = nameOfInitiative;
	}
	@Column(name = "ORG_NAME")
	public Long getOrgName() {
		return orgName;
	}
	public void setOrgName(Long orgName) {
		this.orgName = orgName;
	}
	@Column(name = "NOTES")
	public Long getNotes() {
		return notes;
	}
	public void setNotes(Long notes) {
		this.notes = notes;
	}
	@Column(name = "LOCATION")
	public Long getLocation() {
		return location;
	}
	public void setLocation(Long location) {
		this.location = location;
	}
	@Column(name = "STREET_ADDRESS")
	public Long getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(Long streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	@Column(name = "CITY")
	public Long getCity() {
		return city;
	}
	public void setCity(Long city) {
		this.city = city;
	}
	
	@Column(name = "STATE")
	public Long getState() {
		return state;
	}
	public void setState(Long state) {
		this.state = state;
	}
	@Column(name = "STATE_BASE")
	public Long getStateBase() {
		return stateBase;
	}
	public void setStateBase(Long stateBase) {
		this.stateBase = stateBase;
	}
	@Column(name = "PHASE1")
	public Long getPhase1() {
		return phase1;
	}
	public void setPhase1(Long phase1) {
		this.phase1 = phase1;
	}
		
	@Column(name = "MERGED_COL1")
	public String getMergedCol1() {
		return mergedCol1;
	}
	public void setMergedCol1(String mergedCol1) {
		this.mergedCol1 = mergedCol1;
	}
	

}