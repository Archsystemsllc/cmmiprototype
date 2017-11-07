package com.archsystemsinc.logging.monitor;

import java.util.Date;
import java.util.LinkedHashMap;
//import org.apache.log4j.Logger;
//import org.apache.logging.log4j.Logger;

public class StageMonitor extends Monitor{
	//private static final Logger LOG = Logger.getLogger( StageMonitor.class );
	//States
	public static final String START="START";
	public static final String STOP="STOP";	
	public static final String FAILED="FAILED";
	private String currentStage = "";

	LinkedHashMap <String, Message>messages = new LinkedHashMap<String, Message>();
	
	class Message
	{
		public String state;
		public String stage;
		public String message;
		public long start=0;
		public long stop=0;
		public Date startDate;
		public Date endDate;
		
		//Message(){}

		Message(String stage){
			start();
			this.stage=stage;
		}		
		
		Message(String stage1,String state1){
			start();
			this.stage=stage1;
			this.state=state1;
		}
		
		Message(String stage1,String state1,String message1){
			start();
			this.stage=stage1;
			this.state=state1;
			this.message=message1;
		}
		
		public String toString() {

		    StringBuilder result = new StringBuilder();
		    result.append("\n\n--- Monitoring Stage log report: "+stage+" --- ");
		    result.append("\nStatus: "+state);
		    result.append("\nMessage: "+message);
		    result.append("\nStart DDD MM YYYY HH MM SS mmm: "+startDate);
		    result.append("\nStart millis: "+start);
		   // result.append("\n--- Monitoring stage: "+stage +" - "+state+" ---\n ");
		    if(stop>0){
		    	result.append("\nEnd DDD MM YYYY HH MM SS mmm: "+endDate);
		    	result.append("\nEnd millis: "+stop);
		    	result.append("\nstop - start (Duration in millis)  = "+(stop - start));
		    	result.append("\n--- Monitoring stage: "+stage +" report completed. ---\n");
		    }
		    return result.toString();
		}
	  
		public void start(){
		  start=System.currentTimeMillis();
		  startDate=new Date(start);
		}
		public void stop(){
		  stop=System.currentTimeMillis();
		  endDate=new Date(stop);
		}

		public void setState(String state2) {
			this.state=state2;
			
		}

		public void setStage(String stage) {
			this.stage = stage;
		}

		public void setMessage(String message) {
			this.message = message;
		}

		public void appendMessage(String message1) {
			this.message+="\n"+message1;
			
		}

		public String getState() {
			return this.state;
		}

	}///End Inner Class
	
	public void startStage(String stage){
		this.setCurrentStage(stage);
		messages.put(stage, new Message(stage,START,""));
	}
	
	public void appendMessage(String stage_l,String message1){
		Message message = messages.get(stage_l);
		if(message!=null)
			message.appendMessage(message1);
	}
	
	public void stopStage(String stage2, String state_l, String message1) {
		Message message = messages.get(stage2);
		message.setState(state_l);
		if(message!=null){
			message.appendMessage(message1);
			 message.stop();	
		}
	}
	
	public String getStateForStage(String stage2){
		Message message = messages.get(stage2);
		return message.getState();
	}

	public String toString() {
		  StringBuilder result = new StringBuilder();
			for(String key : messages.keySet()){
				Message message = (Message)messages.get(key);
				result.append(message.toString());
				result.append("\n");
			}
		  return result.toString();
	}	
	
	public String reportStage(String stage){
		try{
		return messages.get(stage).toString();
		}catch(Exception e){
			return "Warning - stage: "+ stage+"not found.";
		}
	}

	public String getCurrentStage() {
		return currentStage;
	}

	public void setCurrentStage(String currentStage) {
		this.currentStage = currentStage;
	}
	
}
