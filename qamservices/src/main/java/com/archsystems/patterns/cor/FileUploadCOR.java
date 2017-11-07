package com.archsystems.patterns.cor;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.archsystems.patterns.cor.stage.ConfigStage;
import com.archsystems.patterns.cor.stage.ParseStage;
import com.archsystems.patterns.cor.stage.SaveStage;
import com.archsystemsinc.exception.ExceptionUtils;
import com.archsystemsinc.exception.FileUploadException;
import com.archsystemsinc.logging.monitor.StageMonitor;
/*
 * The Collector COR initializes a Singleton (or accesses it if it exists already)
 *  and inserts a Visitor for managing messages during this session. The Visitor
 *   contains a StackMessage for collecting information on the stack executions
 *   for this request.
 */
@Service
public class FileUploadCOR extends AbstractChain {
	private static final Logger logger = Logger.getLogger(FileUploadCOR.class);	
	private FileUploadTO payload;
	private Deque<Stage> stack = new ArrayDeque<>();
	private StageMonitor monitor = new StageMonitor();

	@Autowired
	private ConfigStage configStage;
	@Autowired
	private ParseStage parseStage;
	
	@Autowired
	private SaveStage saveStage;
	
	
	//	CollectorContext cctx;

	public FileUploadCOR() {
	}
	
//	public FileUploadCOR(CollectorContext cctx2) {
	//	setCctx(cctx2);
	//}

	@Override
	public void initialize() {		
		push(saveStage);
		push(parseStage);
		push(configStage);
	}
	

	public void pushStages(StageList stageList){
		LinkedList<Stage> stages = stageList.getStageList();
		stages.forEach(stage->push(stage));
	}

	@Override
	public void push(Stage stageIn) {
		stack.push(stageIn);
	}

	@Override
	public Stage pop(TransferObject payload, StageMonitor mon) throws FileUploadException{
		Stage stage = stack.pop();
		
		monitor.startStage(stage.getStageName());
		logger.debug("payload::"+payload);
		try{
			stage.execute(payload, monitor);
		}catch(Exception e){
			//e.printStackTrace();
			monitor.stopStage(stage.getStageName(), StageMonitor.FAILED, e.getMessage()  );
			logger.error(monitor.reportStage(stage.getStageName()));
			logger.error(ExceptionUtils.getStackTrace(e));
			throw new FileUploadException(e.getMessage());
		}
		monitor.stopStage(stage.getStageName(), StageMonitor.STOP, "Stage completed");
		logger.info(monitor.reportStage(stage.getStageName()));
		return stage;
	}


	
	@Override
	public TransferObject executeChain( TransferObject inParams) throws FileUploadException{
		Stage previous;
		try {
			payload = (FileUploadTO)inParams;
			while(!stack.isEmpty()){
				try {
					previous = pop(payload,monitor);
	
					payload = (FileUploadTO) previous.getPayload();
				} catch (FileUploadException e) {
					monitor.appendMessage("Main COR execution", "failed executing a stage.");
					logger.error(ExceptionUtils.getStackTrace(e));
					//TODO: Core has failed and must send message and attempt recovery based on error type
					logger.error(monitor.toString());
				}
			}
		}catch(Exception e) {
			logger.error(ExceptionUtils.getStackTrace(e));
			monitor.appendMessage("Main COR execution", "failed in the outer try block.");
			//TODO: Core has failed and must send message and attempt recovery based on error type
			logger.error(monitor.toString());
		}
//		logger.info(monitor.toString());
		return payload;
	}
/*	public CollectorContext getCctx() {
		return cctx;
	}
	public void setCctx(CollectorContext cctx) {
		this.cctx = cctx;
	}*/

	public FileUploadTO getPayload() {
		return payload;
	}

	public void setPayload(FileUploadTO payload) {
		this.payload = payload;
	}



}
