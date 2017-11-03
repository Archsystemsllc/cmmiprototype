package com.archsystems.patterns.cor;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.LinkedList;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.archsystemsinc.exception.ExceptionUtils;
import com.archsystemsinc.exception.FileUploadException;
import com.archsystemsinc.logging.monitor.StageMonitor;
/*import com.comcast.rasp.domain.StackMessage;
import com.comcast.rasp.domain.TransferObject;
import com.comcast.rasp.exception.ExceptionUtils;
import com.comcast.rasp.exception.RaspException;*/
/*
 * The Collector COR initializes a Singleton (or accesses it if it exists already)
 *  and inserts a Visitor for managing messages during this session. The Visitor
 *   contains a StackMessage for collecting information on the stack executions
 *   for this request.
 */
public class FileUploadCOR extends AbstractChain {
	
	private static Logger logger = LoggerFactory.getLogger(FileUploadCOR.class);

	private FileUploadTO payload;
	private Deque<Stage> stack = new ArrayDeque<>();
	private StageMonitor monitor = new StageMonitor();
//	CollectorContext cctx;

	public FileUploadCOR() {
	}
	
//	public FileUploadCOR(CollectorContext cctx2) {
	//	setCctx(cctx2);
	//}

	@Override
	public void initialize() {
		
		

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
	public Stage pop(TransferObject payload, StageMonitor mon, String servletThreadId) throws FileUploadException{
		Stage stage = stack.pop();
		
		monitor.startStage(stage.getStageName());
		try{
			stage.execute(payload, monitor, servletThreadId);
		}catch(Exception e){
			//e.printStackTrace();
			monitor.stopStage(stage.getStageName(), StageMonitor.FAILED, e.getMessage()  );
			logger.error(monitor.reportStage(stage.getStageName()));
			logger.error(ExceptionUtils.getStackTrace(e));
			throw new FileUploadException(e.getMessage());
		}
		

		return stage;
	}

	public FileUploadTO executeChain() throws FileUploadException {
		// Indicate not to use the map 
		executeChain("0");
		return payload;
	}
	
	@Override
	public TransferObject executeChain( String servletThreadId) throws FileUploadException{
		Stage previous;
		while(!stack.isEmpty()){
			try {
				previous = pop(payload,monitor,servletThreadId);

				payload = (FileUploadTO) previous.getPayload();
			} catch (FileUploadException e) {
				
				logger.error(ExceptionUtils.getStackTrace(e));
				//TODO: Core has failed and must send message and attempt recovery based on error type
			}
		}
		//logger.debug(monitor.toString());
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
