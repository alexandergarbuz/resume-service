package com.garbuz.resume.controller;


import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import com.itextpdf.html2pdf.HtmlConverter;

@Component
public class PdfConvertor {

    private final TemplateEngine templateEngine;

    public PdfConvertor(final TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public byte[] generatePdf(final String templateName, final Context context) throws IOException {
        String htmlContent = templateEngine.process(templateName, context);
        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
        HtmlConverter.convertToPdf(htmlContent, outputStream);
        return outputStream.toByteArray();
    }
}

