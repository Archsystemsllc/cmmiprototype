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
 * @author PrakashTotta
 *
 */
@Entity
@Table(name = "CATEGORY")
public class Category {
	@GenericGenerator(name = "generator", strategy = "foreign", parameters = @Parameter(name = "property", value = "healthCommunity"))
	@Id
	@GeneratedValue(generator = "generator")
	@Column(unique = true, nullable = false)
	private Long id;
	@Column(name = "Category_Name")
	private String categoryName;

	@OneToOne
	@PrimaryKeyJoinColumn
	private HealthCommunity healthCommunity;

	public Category() {

	}

	public Category(HealthCommunity healthCommunity) {
		this.healthCommunity = healthCommunity;
		healthCommunity.setCategory(this);
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getCategoryName() {
		return categoryName;
	}

	public void setCategoryName(String categoryName) {
		this.categoryName = categoryName;
	}

	@Override
	public String toString() {
		return "Category [id=" + id + ", categoryName=" + categoryName + "]";
	}

}
