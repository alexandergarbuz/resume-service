package com.garbuz.resume.controller;


import java.io.ByteArrayOutputStream;
import java.io.IOException;

import org.springframework.stereotype.Component;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;
import org.xhtmlrenderer.pdf.ITextRenderer;

@Component
public class PdfConvertor {

    private final TemplateEngine templateEngine;

    public PdfConvertor(final TemplateEngine templateEngine) {
        this.templateEngine = templateEngine;
    }

    public byte[] generatePdf(final String templateName, final Context context) throws IOException {
        String renderedHtmlContent = templateEngine.process(templateName, context);

        ByteArrayOutputStream outputStream = new ByteArrayOutputStream();

        // Initialize ITextRenderer
        ITextRenderer renderer = new ITextRenderer();
        renderer.setDocumentFromString(renderedHtmlContent);
        renderer.layout();
        renderer.createPDF(outputStream, true); // Enable PDF/A-1 mode if needed

        renderer.finishPDF();
        return outputStream.toByteArray();
    }
}

