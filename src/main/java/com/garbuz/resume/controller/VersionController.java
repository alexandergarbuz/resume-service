package com.garbuz.resume.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

	
@Controller
public class VersionController {
	private static final Logger LOG = LoggerFactory.getLogger(VersionController.class);
	
    @Value("${git.commit.id}")
    private String gitCommitId;
    
    
	@GetMapping("/version")
	public ModelAndView showVersion() {
		LOG.info("Show version {}", gitCommitId);
		ModelAndView mv = new ModelAndView();
		String viewName = "resumePage";
		mv.setViewName(viewName);
		mv.getModel().put(UIConstants.DEFAULT_TEMPLATE, UIConstants.VERSION_FRAGMENT);

		mv.addObject("gitCommitId", gitCommitId);

		return mv;
	}
}
