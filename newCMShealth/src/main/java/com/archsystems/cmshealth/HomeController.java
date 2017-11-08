package com.archsystems.cmshealth;



import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;


@Controller
public class HomeController {
	

	@RequestMapping("/")
	public ModelAndView viewMyPage(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("upload-file");
		return modelAndView;
	}
	
	@RequestMapping("/createtemplate")
	public ModelAndView listOfTemplate(){
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.setViewName("create-template");
		return modelAndView;
	}

	


}