package com.archsystemsinc.qam.utils;

import java.io.Serializable;
import java.util.List;

import com.archsystemsinc.qam.model.HealthCommunity;

public class HealthCommunityData implements Serializable{
	private List<HealthCommunity> listOfHealthCommunity;
	private int initialFileSize;
	public List<HealthCommunity> getlistOfHealthCommunity() {
		return listOfHealthCommunity;
	}
	public void setlistOfHealthCommunity(List<HealthCommunity> listOfHealthCommunity) {
		this.listOfHealthCommunity = listOfHealthCommunity;
	}
	public int getInitialFileSize() {
		return initialFileSize;
	}
	public void setInitialFileSize(int initialFileSize) {
		this.initialFileSize = initialFileSize;
	}

}
