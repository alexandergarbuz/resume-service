package com.garbuz.resume.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.service.ResumeService;

@Controller
@RequestMapping("/api/resume")
public class ResumeWebServiceController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ResumeWebServiceController.class);

	@Autowired
	private ResumeService resumeService;
	
	
	@GetMapping("/show")
	public ResponseEntity<Resume> showResume() {
		Long resumeId = 1L;
		
		Resume resume = this.resumeService.findResume(resumeId);
		return new ResponseEntity<Resume>(resume, HttpStatus.OK);
	}
}
