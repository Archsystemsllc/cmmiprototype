/**
 * 
 */
package com.archsystemsinc.qam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 * @author Prakash T
 *
 */
@Entity
@Table(name = "HEALTH_COMMUNITY")
public class HealthCommunity {
	private Long id;
	private Long templateId;
	private String nameOfInitiative;
	private String orgName;
	private String notes;
	private Long addressId;
	private Long socialMediaId;
	private Long categoryId;
	private String msaName;
	private Long uniqueId;
	private String mapDisplay;
	
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
	
	@Column(name = "Name_Of_Initiative")
	public String getNameOfInitiative() {
		return nameOfInitiative;
	}
	public void setNameOfInitiative(String nameOfInitiative) {
		this.nameOfInitiative = nameOfInitiative;
	}
	
	@Column(name = "Org_Name")
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	@Column(name = "Notes")
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	@OneToOne
	@Column(name = "Address_Id")
	public Long getAddressId() {
		return addressId;
	}
	public void setAddressId(Long addressId) {
		this.addressId = addressId;
	}
	
	@OneToOne
	@Column(name = "Social_Media_Id")
	public Long getSocialMediaId() {
		return socialMediaId;
	}
	public void setSocialMediaId(Long socialMediaId) {
		this.socialMediaId = socialMediaId;
	}
	
	@OneToOne
	@Column(name = "Category_Id")
	public Long getCategoryId() {
		return categoryId;
	}
	public void setCategoryId(Long categoryId) {
		this.categoryId = categoryId;
	}
	
	@Column(name = "Msa_Name")
	public String getMsaName() {
		return msaName;
	}
	public void setMsaName(String msaName) {
		this.msaName = msaName;
	}
	
	@Column(name = "Unique_Id")
	public Long getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(Long uniqueId) {
		this.uniqueId = uniqueId;
	}
	
	@Column(name = "Map_Display")
	public String getMapDisplay() {
		return mapDisplay;
	}
	public void setMapDisplay(String mapDisplay) {
		this.mapDisplay = mapDisplay;
	}
	
	
}
