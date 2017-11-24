/**
 * 
 */
package com.archsystemsinc.qam.model;

import java.beans.Transient;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

/**
 * @author Prakash T
 *
 */
@Entity
@Table(name = "HEALTH_COMMUNITY")
public class HealthCommunity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@PrimaryKeyJoinColumn
	@Column(name = "id")
	private Long id;
	@Column(name = "TEMPLATE_ID")
	private Long templateId;
	@Column(name = "Name_Of_Initiative")
	private String nameOfInitiative;
	@Column(name = "Org_Name")
	private String orgName;
	@Column(name = "Notes")
	private String notes;
	//@JsonIgnore
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "healthCommunity")
	private Address address;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "healthCommunity")
	private SocialMedia socialMedia;
	
	@OneToOne(cascade = CascadeType.ALL, orphanRemoval = true, mappedBy = "healthCommunity")
	private Category category;
	
	@Column(name = "Msa_Name")
	private String msaName;
	@Column(name = "Unique_Id")
	private Long uniqueId;
	@Column(name = "Map_Display")
	private String mapDisplay;
	
	@Column(name = "status")
	private boolean status=true;
	
	
	
	public boolean isStatus() {
		return status;
	}
	public void setStatus(boolean status) {
		this.status = status;
	}
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	
	public Long getTemplateId() {
		return templateId;
	}
	public void setTemplateId(Long templateId) {
		this.templateId = templateId;
	}
	

	public String getNameOfInitiative() {
		return nameOfInitiative;
	}
	public void setNameOfInitiative(String nameOfInitiative) {
		this.nameOfInitiative = nameOfInitiative;
	}
	
	
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	
	
	public String getNotes() {
		return notes;
	}
	public void setNotes(String notes) {
		this.notes = notes;
	}
	
	public Address getAddress() {
		return address;
	}
	public void setAddress(Address address) {
		this.address = address;
	}
	
	public SocialMedia getSocialMedia() {
		return socialMedia;
	}
	public void setSocialMedia(SocialMedia socialMedia) {
		this.socialMedia = socialMedia;
	}
	
	public Category getCategory() {
		return category;
	}
	public void setCategory(Category category) {
		this.category = category;
	}
	
	public String getMsaName() {
		return msaName;
	}
	public void setMsaName(String msaName) {
		this.msaName = msaName;
	}
	
	
	public Long getUniqueId() {
		return uniqueId;
	}
	public void setUniqueId(Long uniqueId) {
		this.uniqueId = uniqueId;
	}
	
	
	public String getMapDisplay() {
		return mapDisplay;
	}
	public void setMapDisplay(String mapDisplay) {
		this.mapDisplay = mapDisplay;
	}
	
	
	
}
