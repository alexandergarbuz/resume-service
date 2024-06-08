package com.garbuz.resume.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.garbuz.resume.entity.Job;
import com.garbuz.resume.entity.Reference;
import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.entity.SkillGroup;
import com.garbuz.resume.service.ResumeService;

@Controller
@RequestMapping("/api/resume")
public class ResumeWebServiceController {
	
	private static final Logger LOG = LoggerFactory.getLogger(ResumeWebServiceController.class);

	@Autowired
	private ResumeService resumeService;
	
	
	@GetMapping("/show/{id}")
	public ResponseEntity<Resume> showResume(@PathVariable(name="id", required = true) final String id) {
		Long resumeId = Long.valueOf(id);
		
		Resume resume = this.resumeService.findResume(resumeId);
		return new ResponseEntity<Resume>(resume, HttpStatus.OK);
	}
	
	@GetMapping("/references")
	public ResponseEntity<List<Reference>> showReferences(@RequestParam(name="firstName") String firstName, @RequestParam(name="lastName") final String lastName) {
		final List<Reference> references = this.resumeService.findReferencesByLastAndFirstName(lastName, firstName);
		return new ResponseEntity<List<Reference>>(references, HttpStatus.OK);
	}
	
	
	@GetMapping("/skills/{id}")
	public ResponseEntity<List<SkillGroup>> showSkills(@PathVariable(name="id", required = true) final String resumeId) {
		final List<SkillGroup> references = this.resumeService.findSkillsByResumeId(Long.valueOf(resumeId));
		return new ResponseEntity<List<SkillGroup>>(references, HttpStatus.OK);
	}
	
	@GetMapping("/work-history/{lastName}/{firstName}")
	public ResponseEntity<List<Job>> showWorkHistory(@PathVariable(name="lastName", required = true) final String lastName, @PathVariable(name="firstName",required = true) final String firstName) {
		final List<Job> jobs = this.resumeService.findJobsByLastAndFirstName(lastName, firstName);
		return new ResponseEntity<List<Job>>(jobs, HttpStatus.OK);
	}
}
