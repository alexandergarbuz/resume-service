package com.garbuz.resume.controller;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.thymeleaf.context.Context;

import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.service.ResumeService;

@Controller
public class PdfController {

	@Autowired
    private PdfConvertor pdfConvertor;
	@Autowired
    private ResumeService resumeService;

    @GetMapping("/download-resume-pdf")
    public void downloadResumePdf(@RequestParam("resumeId") Long resumeId, HttpServletResponse response) throws IOException {
        Resume resume = this.resumeService.findResume(resumeId);

        Context context = new Context();
        context.setVariable("resume", resume);
        context.setVariable(UIConstants.DEFAULT_TEMPLATE, UIConstants.RESUME_FRAGMENT);

        byte[] pdfContent = pdfConvertor.generatePdf("resumePage", context);

        response.setContentType("application/pdf");
        response.setHeader("Content-Disposition", "attachment; filename=resume.pdf");
        response.getOutputStream().write(pdfContent);
        response.getOutputStream().flush();
    }
}
