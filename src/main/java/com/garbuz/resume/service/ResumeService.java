package com.garbuz.resume.service;

import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garbuz.resume.entity.Job;
import com.garbuz.resume.entity.Reference;
import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.entity.SkillGroup;
import com.garbuz.resume.factory.CertificationFactory;
import com.garbuz.resume.factory.ContactInformationFactory;
import com.garbuz.resume.factory.EducationFactory;
import com.garbuz.resume.factory.JobFactory;
import com.garbuz.resume.factory.RecommendationFactory;
import com.garbuz.resume.factory.ReferenceFactory;
import com.garbuz.resume.factory.ResumeFactory;
import com.garbuz.resume.factory.SkillFactory;
import com.garbuz.resume.factory.SummaryFactory;
import com.garbuz.resume.repository.JobDao;
import com.garbuz.resume.repository.ReferenceDao;
import com.garbuz.resume.repository.ResumeDao;
import com.garbuz.resume.repository.SkillGroupDao;

@Service
public class ResumeService {
	
	private final static Logger LOG = LoggerFactory.getLogger(ResumeService.class);
	@Autowired
	private ResumeDao resumeDao;
	@Autowired
	private ReferenceDao referenceDao;
	@Autowired
	private JobDao jobDao;
	@Autowired
	private SkillGroupDao skillGroupDao;
	@Autowired
	private ResumeFactory resumeFactory;
	@Autowired
	private SummaryFactory summaryFactory;
	@Autowired
	private ContactInformationFactory contactInformationFactory;
	@Autowired
	private CertificationFactory certificationFactory;
	
	@Autowired
	private ReferenceFactory referenceFactory;
	@Autowired
	private EducationFactory educationFactory;
	@Autowired
	private RecommendationFactory recommendationFactory;
	@Autowired
	private SkillFactory skillFactory;
	@Autowired
	private JobFactory jobFactory;
	

	public Resume findResume(final Long id) {
		LOG.info("Loading resume for {}", id);
		Resume r = this.resumeDao.getReferenceById(id);
		LOG.info("Loaded {} ", r);
		return r;
	}
	public Resume saveOrCreateNew(final Resume resumeToSave) {
		LOG.info("Saving {}", resumeToSave);
		final Resume savedResume = this.resumeDao.saveAndFlush(resumeToSave);
		LOG.info("Saved {} ", savedResume);
		return savedResume;
	}
	
	public List<Reference> findReferencesByLastAndFirstName(final String lastName, final String firstName) {
		LOG.debug("Loading for {} {}", lastName, firstName);
		List<Reference> references = this.referenceDao.findByResume_FirstNameAndResume_LastName(lastName, firstName);
		LOG.info("Loaded {} references", CollectionUtils.size(references));
		return references;
	}
	public List<Job> findJobsByLastAndFirstName(final String lastName, final String firstName) {
		LOG.debug("Loading for {} {}", lastName, firstName);
		List<Job> jobs = jobDao.findByResume_FirstNameAndResume_LastName(lastName, firstName);
		LOG.info("Loaded {} jobs", CollectionUtils.size(jobs));
		return jobs;
	}
	public List<SkillGroup> findSkillsByResumeId(final Long resumeId) {
		LOG.info("Loading skills for resumeId={}", resumeId);
		
		List<SkillGroup> skills = this.skillGroupDao.findByResumeId(resumeId);
		
		LOG.info("Loaded {} skills", CollectionUtils.size(skills));
		return skills;
	}	

	public Resume initializeData() {
		Resume resume = null;
		long resumeCount = resumeDao.count();
		
		if(resumeCount == 0) {
			resume = generateData();
		} else {
			resume = resumeDao.findFirstByOrderByIdAsc();
		}
		return resume;
	}
	public Resume generateData() {

		Resume resume = resumeFactory.createDefaultResume();
		resume.setContactInformation(contactInformationFactory.createDefaultContactInformations(resume));
		resume.setSummary(summaryFactory.createDefaultSummarys(resume));
		resume.setSkills(skillFactory.createDefaulsSkills(resume));
		resume.setJobs(jobFactory.createDefaultJobs(resume));
		resume.setEducations(educationFactory.createDefaultSchools(resume));
		resume.setCertifications(certificationFactory.createDefaultCertifications(resume));
		resume.setRecommendations(recommendationFactory.createDefaultRecommendations(resume));
		resume.setReferences(referenceFactory.createDefaultReferences(resume));
		return resume;
	}
}
