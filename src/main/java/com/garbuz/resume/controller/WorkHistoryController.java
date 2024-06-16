package com.garbuz.resume.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.garbuz.resume.entity.Job;
import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.service.ResumeService;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/work-history")
public class WorkHistoryController {

	private static final Logger LOG = LoggerFactory.getLogger(WorkHistoryController.class);
	@Autowired
	private RestTemplateBuilder restTemplateBuilder;
	@Autowired
	private ResumeService resumeService;
	
	@GetMapping("/show/{id}")
	public ModelAndView showWorkHistory(@PathVariable(name="id", required = true) final String id, HttpServletRequest r) {
		LOG.info("Show history for resumeId={}", id);
		Long resumeId = Long.valueOf(id);

	
		Resume resume = this.resumeService.findResume(resumeId);
		final String lastName = resume.getLastName();
		final String firstName = resume.getFirstName();
		
		RestTemplate restTemplate = this.restTemplateBuilder.build();
		
		
		String protocol = StringUtils.containsIgnoreCase(r.getProtocol(), "https") ? "https" : "http";
		String serverName = r.getServerName();
		int serverPort = r.getServerPort();
		String contextPath = r.getContextPath();
		final String endPoint = protocol + "://" + serverName + ":" + serverPort + contextPath + "/api/resume/work-history/{lastName}/{firstName}";
		LOG.info("PROTOCOL {}", protocol);
		LOG.info("Server {}", serverName);
		LOG.info("Port {}", serverPort);
		LOG.info("PATH {}", contextPath);
		LOG.info("Endpoint {}", endPoint);
		@SuppressWarnings("unchecked")
		List<Job> jobs = (List<Job>)restTemplate.getForObject(endPoint, ArrayList.class, lastName, firstName);
		

		
		ModelAndView mv = new ModelAndView();
		String viewName = "resumePage";
		mv.setViewName(viewName);
		mv.getModel().put(UIConstants.DEFAULT_TEMPLATE, UIConstants.WORK_HISTORY_PAGE);
		mv.addObject("jobs", jobs);
		
		LOG.info("Displaying {} jobs", CollectionUtils.size(jobs));
		return mv;
	}
}
