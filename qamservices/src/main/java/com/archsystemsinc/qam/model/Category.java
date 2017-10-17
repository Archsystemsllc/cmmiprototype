/**
 * 
 */
package com.archsystemsinc.qam.model;

import javax.persistence.Entity;
import javax.persistence.Table;

/**
 * @author PrakashTotta
 *
 */
@Entity
@Table(name = "CATEGORY")
public class Category {
	private Long id;
	private String categoryName;
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
	
	
}
