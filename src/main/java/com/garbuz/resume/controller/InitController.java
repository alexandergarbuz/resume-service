package com.garbuz.resume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.garbuz.resume.service.ResumeService;


@Controller
@RequestMapping("/init")
public class InitController {
	
	@Autowired
	private ResumeService resumeService;
	
	@GetMapping("/defaultData")
	public ModelAndView initDefaultData() {
		resumeService.initializeData();
		return new ModelAndView(UIConstants.REDIRECT_SHOW_ALL);
	}
	@GetMapping("/additionalData")
	public ModelAndView initAdditionalData() {
		resumeService.generateAdditionalData(5);
		return new ModelAndView(UIConstants.REDIRECT_SHOW_ALL);
	}	

}
