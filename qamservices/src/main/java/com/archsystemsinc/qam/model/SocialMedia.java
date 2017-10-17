/**
 * 
 */
package com.archsystemsinc.qam.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author Prakash T
 *
 */
@Entity
@Table(name = "SOCIAL_MEDEIA")
public class SocialMedia {
	private Long id;
	private String facebook;
	private String twitter;
	private String youtube;
	private String website;
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
