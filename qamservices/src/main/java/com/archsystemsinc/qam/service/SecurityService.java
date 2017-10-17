package com.archsystemsinc.qam.service;

/**
 * This is the Service interface for Spring Security for Login.
 */
public interface SecurityService {

	String findLoggedInUsername();

	void autologin(String username, String password);

}
