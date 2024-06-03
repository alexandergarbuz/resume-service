package com.garbuz.resume.service;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.garbuz.resume.entity.ContactInformation;
import com.garbuz.resume.entity.Recommendation;
import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.repository.ContactInformationDao;
import com.garbuz.resume.repository.RecommendationDao;
import com.garbuz.resume.repository.ResumeDao;

@Service
public class ResumeService {
	
	private final static Logger LOG = LoggerFactory.getLogger(ResumeService.class);
	@Autowired
	private ResumeDao resumeDao;
	@Autowired
	private RecommendationDao recommendationDao;
	@Autowired
	private ContactInformationDao contactInformationDao;

	public Resume findResume(final Long id) {
		LOG.info("Loading resume for {}", id);
		Resume r = null;
		if(this.resumeDao.existsById(id)) {
			r = this.resumeDao.getReferenceById(id);
			ContactInformation ci = this.contactInformationDao.findByResume(r);
			r.setContactInformation(ci);
			List<Recommendation> recommendations = this.recommendationDao.findByResume(r);
			r.setRecommendations(recommendations);
		}
		LOG.info("Loaded resume {} ", r);
		return r;
	}
	public List<Recommendation> findByResume(final Resume resume) {
		LOG.info("Loading recommendations for resume {}", resume);
		List<Recommendation> recommendations = this.recommendationDao.findByResume(resume);
		LOG.info("Found {} recommendations {}", recommendations.size(), recommendations);
		return recommendations;
	}

	public ContactInformation findContactInformationByResume(final Resume resume) {
		LOG.info("Loading contact information for resume {}", resume);
		ContactInformation ci = this.contactInformationDao.findByResume(resume);
		LOG.info("Loaded contact information {}", ci);
		return ci;
	}
	public Resume saveOrCreateNew(final Resume resumeToSave) {
		LOG.info("Saving {}", resumeToSave);
		final Resume savedResume = this.resumeDao.save(resumeToSave);
		LOG.info("Saved {} ", savedResume);
		return savedResume;
	}
	public ContactInformation saveOrCreateNew(final ContactInformation ci) {
		LOG.info("Saving {}", ci);
		final ContactInformation savedContactInformation = this.contactInformationDao.save(ci);
		LOG.info("Saved {}", savedContactInformation);
		return savedContactInformation;
	}
	public Recommendation saveOrCreateNew(final Recommendation recommendationToSave) {
		LOG.info("Saving {}", recommendationToSave);
		final Recommendation savedRecommendation = this.recommendationDao.save(recommendationToSave);
		LOG.info("Saved {}", savedRecommendation); 
		return savedRecommendation;
		
	}
	
}
