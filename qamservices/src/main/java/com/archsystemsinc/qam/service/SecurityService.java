package com.archsystemsinc.qam.service;

/**
 * This is the Service interface for Spring Security for Login.
 * 
 * @author Murugaraj Kandaswamy
 * @since 6/19/2017
 * 
 */
public interface SecurityService {

	String findLoggedInUsername();

	void autologin(String username, String password);

}
