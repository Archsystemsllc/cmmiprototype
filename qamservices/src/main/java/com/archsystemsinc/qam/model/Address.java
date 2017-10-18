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
//@Table(name = "ADDRESS")
public class Address {
	private Long id;
	private String location;
	private String streetAddress;
	private String city;
	private String state;
	private String stateBase;
	private String phase1;
	private String phase2;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	
	@Column(name = "Location")
	public String getLocation() {
		return location;
	}
	public void setLocation(String location) {
		this.location = location;
	}
	
	@Column(name = "Street_Address")
	public String getStreetAddress() {
		return streetAddress;
	}
	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}
	
	@Column(name = "City")
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	
	@Column(name = "State")
	public String getState() {
		return state;
	}
	public void setState(String state) {
		this.state = state;
	}
	
	@Column(name = "State_Base")
	public String getStateBase() {
		return stateBase;
	}
	public void setStateBase(String stateBase) {
		this.stateBase = stateBase;
	}
	
	@Column(name = "Phase1")
	public String getPhase1() {
		return phase1;
	}
	public void setPhase1(String phase1) {
		this.phase1 = phase1;
	}
	
	@Column(name = "Phase2")
	public String getPhase2() {
		return phase2;
	}
	public void setPhase2(String phase2) {
		this.phase2 = phase2;
	}
	
	
}
