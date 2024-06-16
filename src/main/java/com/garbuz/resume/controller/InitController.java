package com.garbuz.resume.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.service.ResumeService;


@Controller
@RequestMapping("/init")
public class InitController {
	
	@Autowired
	private ResumeService resumeService;
	
	@GetMapping("/data")
	public ModelAndView showResume() {
		Long resumeId = 1L;
		
		Resume resume = this.resumeService.findResume(resumeId);
		if(resume == null) {
			resume = resumeService.initializeData();
		}
		ModelAndView mv = new ModelAndView();
		String viewName = "resumePage";
		mv.setViewName(viewName);
		mv.addObject("resume", resume);		
		mv.getModel().put(UIConstants.DEFAULT_TEMPLATE, UIConstants.RESUME_PAGE);
		return mv;
	}
	

}
