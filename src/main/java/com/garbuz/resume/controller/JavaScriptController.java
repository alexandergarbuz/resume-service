package com.garbuz.resume.controller;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.model.LoginDTO;
import com.garbuz.resume.service.ResumeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import jakarta.servlet.http.Cookie;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

@RestController
@RequestMapping("/api/js")
@Tag(name = "Java Script Testing Controller", description = "Operations pertaining to testing plain JS")
@CrossOrigin(origins = "*", methods = { RequestMethod.GET, RequestMethod.POST, RequestMethod.PUT, RequestMethod.DELETE })
public class JavaScriptController {
    private static final Logger LOG = LoggerFactory.getLogger(JavaScriptController.class);

    @Autowired
    private ResumeService resumeService;

    @Operation(summary = "View a resume by ID")
    @GetMapping("/show/{id}")
    public ResponseEntity<Resume> showResume(@PathVariable(name="id", required = true) final String id) {
        Long resumeId = Long.valueOf(id);
        Resume resume = this.resumeService.findResume(resumeId);
        LOG.debug("Showing resume for {}", resumeId);
        return new ResponseEntity<>(resume, HttpStatus.OK);
    }
    
    @Operation(summary = "View all resumes")
	@GetMapping("/showAll")
	public ResponseEntity<List<Resume>> showAll() {
		LOG.debug("Show all resumes");
		List<Resume> resumes = this.resumeService.findAllResumes();
		LOG.info("Displaying {} resumes", CollectionUtils.size(resumes));
		return new ResponseEntity<>(resumes, HttpStatus.OK);
	}
    
    @Operation(summary = "Loging in user")
    @PostMapping("/login")
    public ResponseEntity<LoginDTO> login(@RequestBody LoginDTO dto, HttpServletRequest request, HttpServletResponse response) {
    	LOG.debug("Logging in {}", dto);
    	final String token = request.getSession().getId().substring(0, 4) + "AGARB";
    	final Cookie cookie = new Cookie("auth-token", token);
    	if(StringUtils.equalsIgnoreCase("alexander.garbuz@gmail.com",dto.getEmail()) && StringUtils.equalsIgnoreCase("pass", dto.getPassword())) {
    		dto.setName("Alex Garbuz");
        	dto.setToken(token);
        	dto.setLoggedin(true);
        	dto.setPassword("*****");
        	
        	//setting cookie for one week because why not?
            cookie.setMaxAge(7 * 24 * 60 * 60); 
    	} else {
    		dto.setName("");
    		dto.setError("Invalid credentials");
        	dto.setToken("Invaid token");
        	dto.setLoggedin(false);
        	dto.setPassword("*****");
        	
        	//setting expiration time to 0 to remove the cookit
        	cookie.setMaxAge(0);
    	}
        cookie.setPath("/");
        response.addCookie(cookie);

        return new ResponseEntity<>(dto, HttpStatus.OK);
    }
}
