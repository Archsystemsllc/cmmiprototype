package com.archsystems.patterns.cor;

import com.archsystemsinc.exception.FileUploadException;
import com.archsystemsinc.logging.monitor.StageMonitor;
//import com.comcast.rasp.domain.TransferObject;

public interface Stage {
	
	//public Stage execute(TransferObject payload, StageMonitor monitor) throws RaspException;

	public TransferObject getPayload();

	public String getStageName();

	//Stage execute(TransferObject payload, StageMonitor monitor, String servletThreadId)throws FileUploadException;

	Stage execute(TransferObject payload,StageMonitor monitor) throws FileUploadException;

}
