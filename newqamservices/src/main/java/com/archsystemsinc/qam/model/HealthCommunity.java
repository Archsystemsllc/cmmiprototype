/**
 * 
 */
package com.archsystemsinc.qam.model;

import java.util.Date;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Transient;

import com.archsystemsinc.qam.utils.DateSerializer;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;

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
	@Column(name = "MergedCol1")
	private String mergedCol1;
	@Column(name = "Map_Display")
	private String mapDisplay;
	@JsonSerialize(using=DateSerializer.class)
	private Date processedDate;

//NameofInitiative		Notes	Location 1	Street Address	City	State	State Based	Phase 1	Phase 2	Facebook	Twitter	Youtube	Website	Category	MSA_Name	Unique ID	Map Display
	
	@Override
	public String toString() {
		StringBuilder builder = new StringBuilder();
		builder.append("HealthCommunity [id=");
		builder.append(id);
		builder.append(", NameofInitiative=");
		builder.append(getNameOfInitiative());
		builder.append(", OrganizationName=");
		builder.append(orgName);
		builder.append(", Location=");
		builder.append(address.getLocation());
		builder.append(", StreetAddress=");
		builder.append(address.getStreetAddress());
		builder.append(", City=");
		builder.append(address.getCity());
		builder.append(", State=");
		builder.append(address.getState());				
		builder.append(", StateBase=");
		builder.append(address.getStateBase());	
		builder.append(", UniqueId=");
		builder.append(mergedCol1);			
		builder.append(", processedDate=");
		builder.append(processedDate);
		builder.append("]");
		return builder.toString();
	}
	
	public String getMergedCol1() {
		return mergedCol1;
	}
	public void setMergedCol1(String mergedCol1) {
		this.mergedCol1 = mergedCol1;
	}


	
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
	
	
	public String getMapDisplay() {
		return mapDisplay;
	}
	public void setMapDisplay(String mapDisplay) {
		this.mapDisplay = mapDisplay;
	}
	
	@Column(name = "ProcessedDate")
	public Date getProcessed_Date() {
		return processedDate;
	}

	public void setProcessedDate(Date processedDate) {
		this.processedDate = processedDate;
	}
	
	
}
