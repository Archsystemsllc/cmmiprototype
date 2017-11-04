package com.archsystems.patterns.cor.stage;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.archsystems.patterns.cor.FileUploadTO;
import com.archsystems.patterns.cor.Stage;
import com.archsystems.patterns.cor.TransferObject;
import com.archsystemsinc.exception.FileUploadException;
import com.archsystemsinc.logging.monitor.StageMonitor;
import com.archsystemsinc.qam.model.HealthCommunity;
import com.archsystemsinc.qam.repository.HealthCommunityRepository;

public class SaveStage implements Stage{
	@Autowired
	private HealthCommunityRepository healthCommunityRepository; 
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
		return"Save Stage";
	}
	
	@Override
	public Stage execute(TransferObject payloadLocal, StageMonitor monitor) throws FileUploadException {
		try {
			this.payload = (FileUploadTO) payloadLocal;
			List<HealthCommunity> savedData = healthCommunityRepository.save(payload.getParsedData());
			payload.setSavedData(savedData);
			monitor.appendMessage(this.getStageName(), "Saved data for file, count: "+
					payload.getUploadedFile().getName()+"' "+payload.getParsedData().size());
		}catch(Exception e) {
			monitor.appendMessage(this.getStageName(), "Failed saving file data.");
			throw new FileUploadException(e.getMessage());
		}
		return this;
	}

}
