package com.archsystems.patterns.cor;

import java.io.File;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.archsystemsinc.exception.FileUploadException;
import com.archsystemsinc.qam.model.HealthCommunity;

public class FileCorTest {

	public static void main(String[] args) {
		FileCorTest fct = new FileCorTest();
		FileUploadCOR fcor = new FileUploadCOR();
		fcor.initialize();
		FileUploadTO fto = new FileUploadTO();
		//List<HealthCommunity> uploadHealthData(Long templateId, MultipartFile uploadedFile) {
		fto.setTemplateId(1);
		MultipartFile uploadedFile = null;//not mocking the file
		fto.setUploadedFile(uploadedFile);
		try {
			fcor.executeChain(fto);
		} catch (FileUploadException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
