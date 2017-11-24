/**
 * 
 */
package com.archsystemsinc.qam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

/**
 * @author Prakash T
 *
 */
@Entity
@Table(name = "SOCIAL_MEDEIA")
public class SocialMedia {
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "healthCommunity"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(unique = true, nullable = false)
	private Long id;
	@Column(name = "Facebook")
	private String facebook;
	@Column(name = "Twitter")
	private String twitter;
	@Column(name = "Youtube")
	private String youtube;
	@Column(name = "Website")
	private String website;
	
	@OneToOne
	@PrimaryKeyJoinColumn
	private HealthCommunity healthCommunity;

	public SocialMedia() {

	}

	public SocialMedia(HealthCommunity healthCommunity) {
		this.healthCommunity = healthCommunity;
		healthCommunity.setSocialMedia(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getFacebook() {
		return facebook;
	}

	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}

	public String getTwitter() {
		return twitter;
	}

	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}

	public String getYoutube() {
		return youtube;
	}

	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}

	public String getWebsite() {
		return website;
	}

	public void setWebsite(String website) {
		this.website = website;
	}

}
