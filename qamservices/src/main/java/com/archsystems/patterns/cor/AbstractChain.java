package com.archsystems.patterns.cor;

import com.archsystemsinc.exception.FileUploadException;
import com.archsystemsinc.logging.monitor.StageMonitor;
//import com.comcast.rasp.domain.TransferObject;
//import com.comcast.rasp.exception.RaspException;

public abstract class  AbstractChain {

	/**
	 * Load stages into this COR. Read initialization parameters.
	 */
	abstract public void initialize();
	/**
	 * Push stages into a LIFO stack.
	 */
	abstract public void push(Stage stageIn);
	/**
	 * While exeuting COR pass in the data payload to continue
	 * to add information and pass the monitor for debug and performance
	 * logging / reporting.
	 * @return 
	 * @throws FileUploadException 
	 */
	abstract public Stage pop(TransferObject payload,
			StageMonitor mon, String servletThreadId) throws FileUploadException;
	/**
	 * Manage the COR execution including when to exit and error handling
	 * @throws FileUploadException 
	 */
	abstract public TransferObject executeChain(String servletThreadId) throws FileUploadException;


}
