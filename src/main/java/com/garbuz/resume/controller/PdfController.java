package com.garbuz.resume.controller;

import java.io.IOException;

import jakarta.servlet.http.HttpServletResponse;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.context.Context;

import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.service.ResumeService;

@Controller
public class PdfController {

	private static final Logger LOG = LoggerFactory.getLogger(PdfController.class);
	
	@Autowired
    private PdfConvertor pdfConvertor;
	@Autowired
    private ResumeService resumeService;

    @GetMapping("/download-resume-pdf")
    public void downloadResumePdf(@RequestParam("resumeId") Long resumeId, HttpServletResponse response) throws IOException {
        Resume resume = this.resumeService.findResume(resumeId);
        
        LOG.debug("Found {}" ,resume);
        LOG.debug("Found {}", resume.getSkills());
        

        Context context = new Context();
        context.setVariable("resume", resume);

        byte[] pdfContent = pdfConvertor.generatePdf("resumePagePdf", context);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=" + resume.getFirstName() + "-" + resume.getLastName() +  "-Resume.pdf");
        response.getOutputStream().write(pdfContent);
        response.getOutputStream().flush();
    }
}
