package com.garbuz.resume.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;
import com.garbuz.resume.util.PropertiesReader;

	
@Controller
public class VersionController {
	private static final Logger LOG = LoggerFactory.getLogger(VersionController.class);
	
    @Autowired
    private PropertiesReader propertyReader;
    
    
	@GetMapping("/version")
	public ModelAndView showVersion() {
		String gitCommitSha = this.propertyReader.getCommitSha();
		String gitCommitComment = this.propertyReader.getCommitComment();		
		LOG.info("Show version {}", gitCommitSha);
		LOG.info("Show versioncomment {}", gitCommitComment);
		ModelAndView mv = new ModelAndView();
		String viewName = "resumePage";
		mv.setViewName(viewName);
		mv.getModel().put(UIConstants.DEFAULT_TEMPLATE, UIConstants.VERSION_FRAGMENT);

		mv.addObject("gitCommitSha", gitCommitSha);
		mv.addObject("gitCommitComment", gitCommitComment);

		return mv;
	}
}
