package com.archsystems.patterns.cor.stage;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.archsystems.patterns.cor.FileUploadTO;
import com.archsystems.patterns.cor.Stage;
import com.archsystems.patterns.cor.TransferObject;
import com.archsystemsinc.exception.FileUploadException;
import com.archsystemsinc.logging.monitor.StageMonitor;
import com.archsystemsinc.qam.model.HealthCommunity;
import com.archsystemsinc.qam.repository.HealthCommunityRepository;
import com.archsystemsinc.qam.utils.PoiUtils;

@Component
public class SaveStage implements Stage{
	
	private static final Logger log = Logger.getLogger(SaveStage.class);
	
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
		log.debug("--> execute");
		try {
			this.payload = (FileUploadTO) payloadLocal;
				if(payload.getParsedData() != null &&  !payload.getParsedData().isEmpty()) {
					List<HealthCommunity> savedData = healthCommunityRepository.save(payload.getParsedData());
					PoiUtils.updateHealthDataWithMergedColData(savedData, this.payload.getConfigData());
					payload.setSavedData(savedData);
					monitor.appendMessage(this.getStageName(), "Saved data for file, count: "+
							payload.getUploadedFile().getName()+"' "+payload.getParsedData().size());
			
				}else {
					monitor.appendMessage(this.getStageName(), "No data to save!!");
				}
			}catch(Exception e) {
			e.printStackTrace();
			monitor.appendMessage(this.getStageName(), ", Failed to save file data.");
			this.payload.setMessage(this.getStageName()+", Failed to save file.");
			this.payload.setStatus("ERROR");
			throw new FileUploadException(e.getMessage());
		}
		log.debug("<-- execute");
		return this;
	}

}
