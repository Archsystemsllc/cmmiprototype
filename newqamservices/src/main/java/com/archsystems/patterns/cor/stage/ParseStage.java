package com.archsystems.patterns.cor.stage;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Component;

import com.archsystems.patterns.cor.FileUploadTO;
import com.archsystems.patterns.cor.Stage;
import com.archsystems.patterns.cor.TransferObject;
import com.archsystemsinc.exception.FileUploadException;
import com.archsystemsinc.logging.monitor.StageMonitor;
import com.archsystemsinc.qam.model.HealthCommunity;
import com.archsystemsinc.qam.utils.PoiUtils;
@Component
public class ParseStage implements Stage {
	private static final Logger log = Logger.getLogger(ParseStage.class);	
	private FileUploadTO payload;
	
	@Override
	public TransferObject getPayload() {		
		return payload;
	}
	
	public void setPayload(FileUploadTO payload) {
		this.payload=payload;
	}

	@Override
	public String getStageName() {		
		return"Parse Stage";
	}

	@Override
	public Stage execute(TransferObject payloadLocal, StageMonitor monitor)
			throws FileUploadException {
		log.debug("--> execute");
		try {
			this.payload = (FileUploadTO) payloadLocal;
			if(payload.getConfigData() != null) {
				List<HealthCommunity> data = PoiUtils.parseHealthDataFile
						(payload.getUploadedFile(), payload.getConfigData(),monitor);
				payload.setParsedData(data);	

				monitor.appendMessage(this.getStageName(), "Parsed file data file name, count: "+
						payload.getUploadedFile().getName()+", "+data.size());
			}else {
				monitor.appendMessage(this.getStageName(), "No Config found, not parsing file");
			}
			
		}catch(Exception e) {
			e.printStackTrace();
			monitor.appendMessage(this.getStageName(), ", Failed to parse the file.");
			this.payload.setMessage(this.getStageName()+", Failed to parse the file.");
			this.payload.setStatus("ERROR");
			throw new FileUploadException(e.getMessage());
		}		
		log.debug("<-- execute");
		return this;
	}

}
