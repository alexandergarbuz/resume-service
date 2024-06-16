package com.garbuz.resume.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
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
	
	
	@GetMapping("/show/{id}")
	public ModelAndView showResume(@PathVariable(name="id", required = true) final String id) {
		LOG.info("Show resume request for resumeId={}", id);
		Long resumeId = Long.valueOf(id);
		ModelAndView mv = new ModelAndView();
		String viewName = "resumePage";
		mv.setViewName(viewName);
		mv.getModel().put(UIConstants.DEFAULT_TEMPLATE, UIConstants.RESUME_PAGE);
		
		Resume resume = this.resumeService.findResume(resumeId);
		mv.addObject("resume", resume);
		LOG.info("Displaying {}", resume);
		return mv;
	}
}
