package com.garbuz.resume.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.garbuz.resume.entity.Job;
import com.garbuz.resume.entity.Reference;
import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.entity.SkillGroup;
import com.garbuz.resume.service.ResumeService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;

@RestController
@RequestMapping("/api/resume")
@Tag(name = "Resume Management System", description = "Operations pertaining to resumes in the Resume Management System")
public class ResumeWebServiceController {

    private static final Logger LOG = LoggerFactory.getLogger(ResumeWebServiceController.class);

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

    @Operation(summary = "View references by first and last name")
    @GetMapping("/references")
    public ResponseEntity<List<Reference>> showReferences(
            @RequestParam(name="firstName") String firstName,
            @RequestParam(name="lastName") final String lastName) {
        final List<Reference> references = this.resumeService.findReferencesByLastAndFirstName(lastName, firstName);
        return new ResponseEntity<>(references, HttpStatus.OK);
    }

    @Operation(summary = "View skills by resume ID")
    @GetMapping("/skills/{id}")
    public ResponseEntity<List<SkillGroup>> showSkills(@PathVariable(name="id", required = true) final String resumeId) {
        final List<SkillGroup> references = this.resumeService.findSkillsByResumeId(Long.valueOf(resumeId));
        return new ResponseEntity<>(references, HttpStatus.OK);
    }

    @Operation(summary = "View work history by first and last name")
    @GetMapping("/work-history/{lastName}/{firstName}")
    public ResponseEntity<List<Job>> showWorkHistory(
            @PathVariable(name="lastName", required = true) final String lastName,
            @PathVariable(name="firstName",required = true) final String firstName) {
        final List<Job> jobs = this.resumeService.findJobsByLastAndFirstName(lastName, firstName);
        return new ResponseEntity<>(jobs, HttpStatus.OK);
    }
}