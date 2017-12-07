package com.archsystems.patterns.cor.stage;

import java.util.Date;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.archsystems.patterns.cor.FileUploadTO;
import com.archsystems.patterns.cor.Stage;
import com.archsystems.patterns.cor.TransferObject;
import com.archsystemsinc.exception.FileUploadException;
import com.archsystemsinc.logging.monitor.StageMonitor;
import com.archsystemsinc.qam.model.Reporting;
import com.archsystemsinc.qam.model.TemplateData;
import com.archsystemsinc.qam.repository.ReportingRepository;
import com.archsystemsinc.qam.repository.TemplateRepository;

@Component
public class ReportingStage implements Stage{
	
	private static final Logger log = Logger.getLogger(ReportingStage.class);
	
	@Autowired
	private TemplateRepository templateRepository; 
	
	@Autowired
	private ReportingRepository reportingRepository; 
	
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
		return"Reporting Stage";
	}
	
	@Override
	public Stage execute(TransferObject payloadLocal, StageMonitor monitor) throws FileUploadException {
		log.debug("--> execute");
		Reporting reporting = new Reporting();

		reporting.setProcessedDate(new Date());

		try {
			this.payload = (FileUploadTO) payloadLocal;
			reporting.setFileName(this.payload.getFileName());
			if(this.payload.getConfigData() != null) {
				TemplateData template = templateRepository.findOne(this.payload.getConfigData().getTemplateId());
				reporting.setTemplateName(template.getName());
				
			}
			if(this.payload.getStatus() == null) {
				this.payload.setMessage("File upload Completed!");
				this.payload.setStatus("SUCCESS");				
			}
			monitor.appendMessage(this.getStageName(), "Completed");
		}catch(Exception e) {
			e.printStackTrace();
			monitor.appendMessage(this.getStageName(), "Reporting Failed.");
			this.payload.setMessage(this.getStageName()+" Reporting Failed.");
			this.payload.setStatus("ERROR");
			throw new FileUploadException(e.getMessage());
		}finally {
			reporting.setMessage(this.payload.getMessage());
			reporting.setStatus(this.payload.getStatus());
			log.debug("reporting:"+reporting);
			reportingRepository.save(reporting);
		}
		log.debug("<-- execute");
		return this;
	}

}
