package com.garbuz.resume.controller;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.time.ZonedDateTime;
import java.time.format.DateTimeFormatter;

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
	private static final DateTimeFormatter OUTPUT_FORMATER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss a");
	private static final DateTimeFormatter INPUT_FORMATER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    @Autowired
    private PropertiesReader propertyReader;
    
	@GetMapping("/version")
	public ModelAndView showVersion() {
		final String version = propertyReader.getProperty("git.commit.sha");
		final String lastComment = propertyReader.getProperty("git.commit.message");
		final String branch = propertyReader.getProperty("git.branch");
		final String timestampUTC = propertyReader.getProperty("build.timestamp");
		
        LocalDateTime localDateTime = LocalDateTime.parse(timestampUTC, INPUT_FORMATER);
        ZonedDateTime utcZonedDateTime = localDateTime.atZone(ZoneId.of("UTC"));
        ZonedDateTime cstZonedDateTime = utcZonedDateTime.withZoneSameInstant(ZoneId.of("America/Chicago"));
	    String timestampCST = cstZonedDateTime.format(OUTPUT_FORMATER);

		
		LOG.info("Version {}", version);
		LOG.info("Last comment {}", lastComment);
		LOG.info("Branch {}", branch);
		LOG.info("Time {}", timestampCST);

		ModelAndView mv = new ModelAndView();
		String viewName = "resumePage";
		mv.setViewName(viewName);
		mv.getModel().put(UIConstants.DEFAULT_TEMPLATE, UIConstants.VERSION_FRAGMENT);

		mv.addObject("version", version);
		mv.addObject("comment", lastComment);
		mv.addObject("branch", branch);
		mv.addObject("timestamp", timestampCST);

		return mv;
	}
}
