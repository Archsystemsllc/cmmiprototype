package com.archsystems.cmshealth;



import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.activation.MimetypesFileTypeMap;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;



@Controller
public class HomeController {
	@Autowired
	ServletContext servletContext;
	@RequestMapping("/ahcfile")
	public ModelAndView viewHome(HttpServletRequest request, HttpServletResponse response){
		
		response.setContentType("application/octet-stream");
		response.setHeader("Content-Disposition",
				"attachment;filename=Accountable_Health_Communities.xls");
		//Accountable_Health_Communities.xlsx
		//BPCI_Initiative.xlsx
		try {
			//File file = new File("downloadfilename.csv");
			//String abs = file.getAbsolutePath();
			//String can = file.getCanonicalPath();
			File rootDir = new File( servletContext.getRealPath("/resources/") );
			
			File dload = new File(rootDir+"/Accountable_Health_Communities.xls");
			
            String mimeType = new MimetypesFileTypeMap().getContentType(dload);

            if (mimeType == null) {
                // Set to binary type if MIME mapping not found
                mimeType = "application/octet-stream";
            }
			
			FileInputStream fileIn = new FileInputStream(dload);
			ServletOutputStream out = response.getOutputStream();
	
			byte[] outputByte = new byte[4096];
			//copy binary contect to output stream
			while(fileIn.read(outputByte, 0, 4096) != -1)
			{
				out.write(outputByte, 0, 4096);
			}
			fileIn.close();
			out.flush();
			out.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;		
		
	}

	@RequestMapping("/bpcifile")
	public ModelAndView bpcDload(HttpServletRequest request, HttpServletResponse response){
		
		
		response.setHeader("Content-Disposition",
				"attachment;filename=BPCI_Initiative.xls");
		//Accountable_Health_Communities.xlsx
		//BPCI_Initiative.xlsx
		try {
			//File file = new File("downloadfilename.csv");
			//String abs = file.getAbsolutePath();
			//String can = file.getCanonicalPath();
			File rootDir = new File( servletContext.getRealPath("/resources/") );
			
			File dload = new File(rootDir+"/BPCI_Initiative.xls");
			
            // Gets MIME type of the file
            String mimeType = new MimetypesFileTypeMap().getContentType(dload);

            if (mimeType == null) {
                // Set to binary type if MIME mapping not found
                mimeType = "application/octet-stream";
            }
            mimeType = "application/vnd.ms-excel";
            response.setContentType(mimeType);
			
			
			
			FileInputStream fileIn = new FileInputStream(dload);
			//InputStream in =
                  //  new ByteArrayInputStream(sb.toString().getBytes("UTF-8"));
			
			ServletOutputStream out = response.getOutputStream();
			int bsize=1024;
			byte[] outputByte = new byte[bsize];
			//copy binary contect to output stream
			while(fileIn.read(outputByte, 0, bsize) != -1)
			{
				out.write(outputByte, 0, bsize);
			}
			fileIn.close();
			out.flush();
			out.close();
		}catch(Exception e) {
			System.out.println(e);
		}
		return null;		
		
	}
	
	@RequestMapping("/")
	public ModelAndView viewHome(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("applications");
		return modelAndView;
	}
	
	@RequestMapping("/upload")
	public ModelAndView viewUpload(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("upload-file");
		return modelAndView;
	}
	
	
	@RequestMapping("/applications")
	public ModelAndView viewApplications(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("applications");
		return modelAndView;
	}
	
	@RequestMapping("/createtemplate")
	public ModelAndView listOfTemplate(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("create-template");
		return modelAndView;
	}

	//demonstration info page
	@RequestMapping("/demonstration")
	public ModelAndView demonstration(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("demonstration");
		return modelAndView;
	}
	
	@RequestMapping("/reports")
	public ModelAndView report(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("reports");
		return modelAndView;
	}
	
	
	@RequestMapping("/downloads")
	public ModelAndView download(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("downloads");
		return modelAndView;
	}
	



}