package com.archsystems.patterns.cor.stage;

import java.util.List;

import com.archsystems.patterns.cor.FileUploadTO;
import com.archsystems.patterns.cor.Stage;
import com.archsystems.patterns.cor.TransferObject;
import com.archsystemsinc.exception.FileUploadException;
import com.archsystemsinc.logging.monitor.StageMonitor;
import com.archsystemsinc.qam.model.HealthCommunity;
import com.archsystemsinc.qam.utils.PoiUtils;

public class ParseStage implements Stage {
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
		
		try {
			this.payload = (FileUploadTO) payloadLocal;
			List<HealthCommunity> data = PoiUtils.parseHealthDataFile
					(payload.getUploadedFile(), payload.getConfigData(),monitor);
			payload.setParsedData(data);
			monitor.appendMessage(this.getStageName(), "Parsed file data file name, count: "+
					payload.getUploadedFile().getName()+", "+data.size());
		}catch(Exception e) {
			monitor.appendMessage(this.getStageName(), "Failed parsing a file.");
			throw new FileUploadException(e.getMessage());
		}		
		return this;
	}

}
