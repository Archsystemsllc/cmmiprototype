/**
 * 
 */
package com.archsystemsinc.qam.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

/**
 * @author Prakash T
 *
 */
//@Entity
//@Table(name = "SOCIAL_MEDEIA")
public class SocialMedia {
	private Long id;
	private String facebook;
	private String twitter;
	private String youtube;
	private String website;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "Facebook")
	public String getFacebook() {
		return facebook;
	}
	public void setFacebook(String facebook) {
		this.facebook = facebook;
	}
	
	@Column(name = "Twitter")
	public String getTwitter() {
		return twitter;
	}
	public void setTwitter(String twitter) {
		this.twitter = twitter;
	}
	@Column(name = "Youtube")
	public String getYoutube() {
		return youtube;
	}
	public void setYoutube(String youtube) {
		this.youtube = youtube;
	}
	
	@Column(name = "Website")
	public String getWebsite() {
		return website;
	}
	public void setWebsite(String website) {
		this.website = website;
	}
	
	
}
