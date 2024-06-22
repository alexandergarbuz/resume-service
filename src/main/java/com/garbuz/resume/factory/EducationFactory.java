package com.garbuz.resume.factory;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.garbuz.resume.entity.Education;
import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.repository.EducationDao;

@Component
public class EducationFactory {

	private static final Logger LOG = LoggerFactory.getLogger(EducationFactory.class);
	
	private EducationDao dao;
	
	public EducationFactory(final EducationDao dao) {
		this.dao = dao;
	}
	
	public List<Education> createDefaultSchools(final Resume resume) {
		final List<Education> schools = new ArrayList<>();
		schools.add(new Education("Cardinal Stritch University, Madison WI","Master of Business Administration",	LocalDate.of(2004, 12, 1),LocalDate.of(2006, 6, 1),"",resume));
		schools.add(new Education("Nizhny Novgorod State Architecture Academy, Nizhny Novgorod, Russia","Bachelor of Science in Civil Engineering and Managemen",LocalDate.of(1991, 9, 1),LocalDate.of(1996, 7, 1),"Graduated with honors (GPA 4.0)",resume));

		schools.forEach(school -> {
			
			dao.saveAndFlush(school);
			LOG.info("Saved {}", school);
			
		});
		return schools;	
	}
}
