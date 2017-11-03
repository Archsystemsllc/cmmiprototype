package com.archsystems.patterns.cor;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

public class CollectorContext {
	
	private List<Integer> stageNames;
	
	private String raspRuleName;
	private String raspRuleId;
	private String sessionId;
	private String threadId;
	private String instanceId;
	private String allParamValues;
	private String raspHostName;
	private long raspSessionCreationTime;
	private String raspHostIp;
	private String raspServerRequestTime;
	private String raspUserName;
	private String remoteHost;
	private String raspLocalAddr;
	private int raspLocalPort;
	private String raspremoteAddr;
	private int raspRemotePort;
	private String raspRemoteUser;
	private String raspLocalName;
	private String raspServerName;
	private int raspServerPort;
	private String requestUri;
	private String raspRequestMethod;
	private String raspCustomerURI;
	private String raspAdrCustomeNumber;
	private String raspCustomerName;
	private String raspAppName;
	

	
	public CollectorContext(String threadId2,String sessionId2) {
		setSessionId(sessionId2);
		setThreadId(threadId2);
		setInstanceId(threadId2);//+sessionId2, need to get session in cut-point aspect
	}
	
	public void loadHttpInfo(HttpServletRequest req) {
		
		raspRuleName = "SQL_INJECTION";
		raspRuleId = "0001";

		raspHostName = req.getServerName();
		raspHostIp = req.getLocalAddr();  
		raspSessionCreationTime = req.getSession().getCreationTime();
		raspServerRequestTime = String.valueOf(new Date().getTime());
		
		if(req.getUserPrincipal()!=null)
			raspUserName = req.getUserPrincipal().getName();
		
		remoteHost = req.getRemoteHost();
		raspremoteAddr =req.getRemoteAddr();
		raspRemotePort = req.getRemotePort();
		raspRemoteUser = req.getRemoteUser();
		
		raspHostName = req.getLocalName();
		raspHostIp   = req.getLocalAddr();
		raspLocalAddr = req.getLocalAddr();
		raspLocalPort = req.getLocalPort();
		raspLocalName  = req.getLocalName();
		raspServerName = req.getServerName();
		raspServerPort = req.getServerPort();
		
		requestUri = req.getRequestURI();
		raspRequestMethod =req.getMethod();
		
		raspCustomerURI = "www.raspcustomer1.com";
		raspAdrCustomeNumber = "1234567890"; 
		raspCustomerName = "raspcustomer1";
		raspAppName = "raspBenchmarkApp";
		
	}
	
	public String getSessionId() {
		return sessionId;
	}
	public void setSessionId(String sessionId) {
		this.sessionId = sessionId;
	}
	public String getThreadId() {
		return threadId;
	}
	public void setThreadId(String threadId) {
		this.threadId = threadId;
	}
	public String getInstanceId() {
		return instanceId;
	}
	public void setInstanceId(String instanceId) {
		this.instanceId = instanceId;
	}

	public String getAllParamValues() {
		return allParamValues;
	}
	public void setAllParamValues(String allParamValues) {
		this.allParamValues = allParamValues;
	}

	public String getRaspHostName() {
		return raspHostName;
	}

	public void setRaspHostName(String raspHostName) {
		this.raspHostName = raspHostName;
	}

	public long getRaspSessionCreationTime() {
		return raspSessionCreationTime;
	}

	public void setRaspSessionCreationTime(long raspSessionCreationTime) {
		this.raspSessionCreationTime = raspSessionCreationTime;
	}

	public String getRaspHostIp() {
		return raspHostIp;
	}

	public void setRaspHostIp(String raspHostIp) {
		this.raspHostIp = raspHostIp;
	}

	public String getRaspServerRequestTime() {
		return raspServerRequestTime;
	}

	public void setRaspServerRequestTime(String raspServerRequestTime) {
		this.raspServerRequestTime = raspServerRequestTime;
	}

	public String getRaspUserName() {
		return raspUserName;
	}

	public void setRaspUserName(String raspUserName) {
		this.raspUserName = raspUserName;
	}

	public String getRemoteHost() {
		return remoteHost;
	}

	public void setRemoteHost(String remoteHost) {
		this.remoteHost = remoteHost;
	}

	public String getRaspLocalAddr() {
		return raspLocalAddr;
	}

	public void setRaspLocalAddr(String raspLocalAddr) {
		this.raspLocalAddr = raspLocalAddr;
	}

	public int getRaspLocalPort() {
		return raspLocalPort;
	}

	public void setRaspLocalPort(int raspLocalPort) {
		this.raspLocalPort = raspLocalPort;
	}

	public String getRaspremoteAddr() {
		return raspremoteAddr;
	}

	public void setRaspremoteAddr(String raspremoteAddr) {
		this.raspremoteAddr = raspremoteAddr;
	}

	public int getRaspRemotePort() {
		return raspRemotePort;
	}

	public void setRaspRemotePort(int raspRemotePort) {
		this.raspRemotePort = raspRemotePort;
	}

	public String getRaspRemoteUser() {
		return raspRemoteUser;
	}

	public void setRaspRemoteUser(String raspRemoteUser) {
		this.raspRemoteUser = raspRemoteUser;
	}

	public String getRaspLocalName() {
		return raspLocalName;
	}

	public void setRaspLocalName(String raspLocalName) {
		this.raspLocalName = raspLocalName;
	}

	public String getRaspServerName() {
		return raspServerName;
	}

	public void setRaspServerName(String raspServerName) {
		this.raspServerName = raspServerName;
	}

	public int getRaspServerPort() {
		return raspServerPort;
	}

	public void setRaspServerPort(int raspServerPort) {
		this.raspServerPort = raspServerPort;
	}

	public String getRequestUri() {
		return requestUri;
	}

	public void setRequestUri(String requestUri) {
		this.requestUri = requestUri;
	}

	public String getRaspRequestMethod() {
		return raspRequestMethod;
	}

	public void setRaspRequestMethod(String raspRequestMethod) {
		this.raspRequestMethod = raspRequestMethod;
	}

	public String getRaspCustomerURI() {
		return raspCustomerURI;
	}

	public void setRaspCustomerURI(String raspCustomerURI) {
		this.raspCustomerURI = raspCustomerURI;
	}

	public String getRaspAdrCustomeNumber() {
		return raspAdrCustomeNumber;
	}

	public void setRaspAdrCustomeNumber(String raspAdrCustomeNumber) {
		this.raspAdrCustomeNumber = raspAdrCustomeNumber;
	}

	public String getRaspCustomerName() {
		return raspCustomerName;
	}

	public void setRaspCustomerName(String raspCustomerName) {
		this.raspCustomerName = raspCustomerName;
	}

	public String getRaspAppName() {
		return raspAppName;
	}

	public void setRaspAppName(String raspAppName) {
		this.raspAppName = raspAppName;
	}

	public String getRaspRuleName() {
		return raspRuleName;
	}

	public void setRaspRuleName(String raspRuleName) {
		this.raspRuleName = raspRuleName;
	}

	public String getRaspRuleId() {
		return raspRuleId;
	}

	public void setRaspRuleId(String raspRuleId) {
		this.raspRuleId = raspRuleId;
	}

	public List<Integer> getStageNames() {
		return stageNames;
	}

	public void setStageNames(List<Integer> sl) {
		this.stageNames = sl;
	}




}
