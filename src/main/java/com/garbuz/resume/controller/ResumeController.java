package com.garbuz.resume.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.service.ResumeService;

@Controller
@RequestMapping("/resume")
public class ResumeController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ResumeController.class);

	@Autowired
	private ResumeService resumeService;
	
	
	@GetMapping("/show")
	public ModelAndView showResume() {
		ModelAndView mv = new ModelAndView();
		String viewName = "resumePage";
		mv.setViewName(viewName);
		Long resumeId = 1L;
		
		Resume resume = this.resumeService.findResume(resumeId);
		if(resume == null) {
			resume = resumeService.initializeData();
		}
		mv.addObject("resume", resume);
		
		return mv;
	}
}
