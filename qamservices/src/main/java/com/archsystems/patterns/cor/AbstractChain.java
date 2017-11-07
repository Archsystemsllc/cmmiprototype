package com.archsystems.patterns.cor;

import com.archsystemsinc.exception.FileUploadException;
import com.archsystemsinc.logging.monitor.StageMonitor;


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
	 * Manage the COR execution including when to exit and error handling
	 * @throws FileUploadException 
	 */	
	abstract public TransferObject executeChain(TransferObject inParams) throws FileUploadException;
	
	/**
	 * While exeuting COR pass in the data payload to continue
	 * to add information and pass the monitor for debug and performance
	 * logging / reporting.
	 * @return 
	 * @throws FileUploadException 
	 */
	abstract public Stage pop(TransferObject payload, StageMonitor mon) throws FileUploadException;


}
