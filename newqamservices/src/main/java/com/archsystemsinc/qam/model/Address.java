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
@Table(name = "ADDRESS")
public class Address {

	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "healthCommunity"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(unique = true, nullable = false)
	private Long id;
	@Column(name = "Location")
	private String location;

	@Column(name = "Street_Address")
	private String streetAddress;
	@Column(name = "City")
	private String city;
	@Column(name = "State")
	private String state;
	@Column(name = "State_Base")
	private String stateBase;
	@Column(name = "Phase1")
	private String phase1;
	@Column(name = "Phase2")
	private String phase2;

	@OneToOne
	@PrimaryKeyJoinColumn
	private HealthCommunity healthCommunity;

	public Address() {

	}

	public Address(HealthCommunity healthCommunity) {
		this.healthCommunity = healthCommunity;
		healthCommunity.setAddress(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public String getStreetAddress() {
		return streetAddress;
	}

	public void setStreetAddress(String streetAddress) {
		this.streetAddress = streetAddress;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getStateBase() {
		return stateBase;
	}

	public void setStateBase(String stateBase) {
		this.stateBase = stateBase;
	}

	public String getPhase1() {
		return phase1;
	}

	public void setPhase1(String phase1) {
		this.phase1 = phase1;
	}

	public String getPhase2() {
		return phase2;
	}

	public void setPhase2(String phase2) {
		this.phase2 = phase2;
	}

	@Override
	public String toString() {
		return "Address [id=" + id + ", location=" + location + ", streetAddress=" + streetAddress + ", city=" + city
				+ ", state=" + state + ", stateBase=" + stateBase + ", phase1=" + phase1 + ", phase2=" + phase2 + "]";
	}

}
