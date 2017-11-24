package com.archsystems.patterns.cor.stage;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.archsystems.patterns.cor.FileUploadTO;
import com.archsystems.patterns.cor.Stage;
import com.archsystems.patterns.cor.TransferObject;
import com.archsystemsinc.exception.FileUploadException;
import com.archsystemsinc.logging.monitor.StageMonitor;
import com.archsystemsinc.qam.model.HealthDataTemplateConfig;
import com.archsystemsinc.qam.repository.HealthDataTemplateConfigRepositoty;

@Component
public class ConfigStage implements Stage {
	private static final Logger log = Logger.getLogger(ConfigStage.class);

	@Autowired
	HealthDataTemplateConfigRepositoty healthDataTemplateConfigRepositoty;
	
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
		return"Configuration Stage";
	}

	@Override
	public Stage execute(TransferObject payloadLocal,StageMonitor stageMonitor)
			throws FileUploadException {
		log.debug("--> execute:"+payloadLocal);
		try {	
				setPayload((FileUploadTO)payloadLocal);
				HealthDataTemplateConfig configData =
						healthDataTemplateConfigRepositoty.findOne(payload.getTemplateId());
				payload.setConfigData(configData);
			
				stageMonitor.appendMessage(this.getStageName(),
						"Found configData for template: "+payload.getTemplateId());
				
		}catch(Exception e) {
			e.printStackTrace();
			stageMonitor.appendMessage(this.getStageName(),
					"Failed loading configData for template: "+payload.getTemplateId());
			throw new FileUploadException(e.getMessage());
		}
		log.debug("<-- execute");
		
		return this;
	}

}
