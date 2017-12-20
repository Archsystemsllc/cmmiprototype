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
@Table(name = "HEALTH_DATA_TEMPLATE_CONFIG")
public class HealthDataTemplateConfig {
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
	private Long phase2;
	private Long facebook;
	private Long twitter;
	private Long youtube;
	private Long website;
	private Long categoryName;
	private Long msaName;
	private Long uniqueId;
	private Long mapDisplay;
	
	private String mergedCol1;
/*	private String mergedCol2;
	private String mergedCol3;
	private String mergedCol4;
	private String mergedCol5;*/
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
	@Column(name = "PHASE2")
	public Long getPhase2() {
		return phase2;
	}
	public void setPhase2(Long phase2) {
		this.phase2 = phase2;
	}
	
	@Column(name = "FACEBOOK")
	public Long getFacebook() {
		return facebook;
	}
	public void setFacebook(Long facebook) {
		this.facebook = facebook;
	}
	
	@Column(name = "TWITTER")
	public Long getTwitter() {
		return twitter;
	}
	public void setTwitter(Long twitter) {
		this.twitter = twitter;
	}
	
	@Column(name = "YOUTUBE")
	public Long getYoutube() {
		return youtube;
	}
	public void setYoutube(Long youtube) {
		this.youtube = youtube;
	}
	
	@Column(name = "WEBSITE")
	public Long getWebsite() {
		return website;
	}
	public void setWebsite(Long website) {
		this.website = website;
	}
	@Column(name = "CATEGORY_NAME")
	public Long getCategoryName() {
		return categoryName;
	}
	public void setCategoryName(Long categoryName) {
		this.categoryName = categoryName;
	}
	@Column(name = "MSA_NAME")
	public Long getMsaName() {
		return msaName;
	}
	public void setMsaName(Long msaName) {
		this.msaName = msaName;
	}
	@Column(name = "UNIQUE_ID")
	public Long getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(Long uniqueId) {
		this.uniqueId = uniqueId;
	}
	@Column(name = "MAP_DISPLAY")
	public Long getMapDisplay() {
		return mapDisplay;
	}
	public void setMapDisplay(Long mapDisplay) {
		this.mapDisplay = mapDisplay;
	}
	
	
	@Column(name = "MERGED_COL1")
	public String getMergedCol1() {
		return mergedCol1;
	}
	public void setMergedCol1(String mergedCol1) {
		this.mergedCol1 = mergedCol1;
	}
	
	/*@Column(name = "MERGED_COL2")
	public String getMergedCol2() {
		return mergedCol2;
	}
	public void setMergedCol2(String mergedCol2) {
		this.mergedCol2 = mergedCol2;
	}
	
	@Column(name = "MERGED_COL3")
	public String getMergedCol3() {
		return mergedCol3;
	}
	public void setMergedCol3(String mergedCol3) {
		this.mergedCol3 = mergedCol3;
	}
	
	@Column(name = "MERGED_COL4")
	public String getMergedCol4() {
		return mergedCol4;
	}
	public void setMergedCol4(String mergedCol4) {
		this.mergedCol4 = mergedCol4;
	}
	
	@Column(name = "MERGED_COL5")
	public String getMergedCol5() {
		return mergedCol5;
	}
	public void setMergedCol5(String mergedCol5) {
		this.mergedCol5 = mergedCol5;
	}*/
}