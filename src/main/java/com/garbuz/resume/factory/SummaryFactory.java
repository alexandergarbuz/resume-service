package com.garbuz.resume.factory;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.entity.Summary;
import com.garbuz.resume.repository.SummaryDao;

@Component
public class SummaryFactory {

	private static final Logger LOG = LoggerFactory.getLogger(SummaryFactory.class);
	
	private SummaryDao dao;
	
	public SummaryFactory(final SummaryDao dao) {
		this.dao = dao;
	}
	
	public Summary createDefaultSummarys(final Resume resume) {
		Summary summary = dao.saveAndFlush(new Summary(
				resume,
				"Looking for leadership position in a technology driven organization where I can utilize my problem solving, mentoring and communication skills.",
				"Senior IT professional with more than 25 years of combined software development, leadership and management experience in insurance, healthcare, telecommunications, and e-commerce industries"
				));
		LOG.info("Created {}", summary);
		return summary;
	}
	
	
}
