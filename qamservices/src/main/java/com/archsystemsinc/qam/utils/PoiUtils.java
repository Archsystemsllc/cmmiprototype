/**
 * 
 */
package com.archsystemsinc.qam.utils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.log4j.Logger;
import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.openxml4j.exceptions.InvalidFormatException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.web.multipart.MultipartFile;

import com.archsystemsinc.qam.model.FileData;
import com.archsystemsinc.qam.model.TemplateConfigData;

/**
 * @author Prakash T
 *
 */
public class PoiUtils {

	private static final Logger log = Logger.getLogger(PoiUtils.class);
	
	public static List<FileData> parseFile(MultipartFile uploadedFile, TemplateConfigData configData){
		log.debug("--> parseFile");
		List<FileData> dataList = new ArrayList<FileData>();
		Workbook providersFileWorkbook = null;
		try {
			providersFileWorkbook = WorkbookFactory.create(uploadedFile.getInputStream());
			Sheet providersFileSheet = providersFileWorkbook.getSheetAt(0);
			Iterator<Row> providersFileRowIterator = providersFileSheet.rowIterator();
            int providersFileRowCount = providersFileSheet.getPhysicalNumberOfRows();
			int totalNumberOfRows = providersFileRowCount - 1;
			log.debug("totalNumberOfRows::"+totalNumberOfRows);
			FileData data = null;
			while (providersFileRowIterator.hasNext()){
				Row providersFileRow = (Row) providersFileRowIterator.next();
				
				if (providersFileRow.getRowNum() > 0 && providersFileRow.getRowNum() <= providersFileRowCount){
					data = new FileData();
					data.setTemplateId(configData.getTemplateId());
					log.debug("ROW - " + providersFileRow.getRowNum());
					Iterator<Cell> iterator = providersFileRow.cellIterator();
					while (iterator.hasNext()) {
						Cell hssfCell = (Cell) iterator.next();
						int cellIndex = hssfCell.getColumnIndex();
						
						
						 updateFileData(cellIndex, hssfCell, data, configData);
					}
					dataList.add(data);
				}
			}
		} catch (EncryptedDocumentException | InvalidFormatException
				| IOException e) {
			
			e.printStackTrace();
		}
		
		log.debug("<-- parseFile");
		return dataList;
	}
	
	private static void updateFileData(int cellIndex, Cell cellData,FileData data, TemplateConfigData configData ){
		//log.debug("cellIndex::"+cellIndex);
		//log.debug("configData::"+configData);
		if(configData.getColumnA() != null && configData.getColumnA() == cellIndex){
			data.setColumnA(cellData.getStringCellValue());
		}else if(configData.getColumnB() !=null && configData.getColumnB() == cellIndex){
			data.setColumnB(cellData.getStringCellValue());
		}else if(configData.getColumnC() != null && configData.getColumnC() == cellIndex){
			data.setColumnC(cellData.getStringCellValue());
		}else if(configData.getColumnD() != null && configData.getColumnD() == cellIndex){
			data.setColumnD(new Double(cellData.getNumericCellValue()).longValue());
		}else if(configData.getColumnE() !=null && configData.getColumnE() == cellIndex){
			data.setColumnE(cellData.getStringCellValue());
		}else if(configData.getColumnF() !=null && configData.getColumnF() == cellIndex){
			data.setColumnF(cellData.getStringCellValue());
		}else if(configData.getColumnG() !=null && configData.getColumnG() == cellIndex){
			data.setColumnG(new Double(cellData.getNumericCellValue()).longValue());
		}
	}
}
