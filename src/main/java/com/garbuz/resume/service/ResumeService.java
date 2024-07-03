package com.garbuz.resume.service;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.collections4.CollectionUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.garbuz.resume.entity.Education;
import com.garbuz.resume.entity.Job;
import com.garbuz.resume.entity.Recommendation;
import com.garbuz.resume.entity.Reference;
import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.entity.SkillGroup;
import com.garbuz.resume.factory.CertificationFactory;
import com.garbuz.resume.factory.EducationFactory;
import com.garbuz.resume.factory.JobFactory;
import com.garbuz.resume.factory.RecommendationFactory;
import com.garbuz.resume.factory.ReferenceFactory;
import com.garbuz.resume.factory.ResumeFactory;
import com.garbuz.resume.factory.SkillFactory;
import com.garbuz.resume.repository.EducationDao;
import com.garbuz.resume.repository.JobDao;
import com.garbuz.resume.repository.RecommendationDao;
import com.garbuz.resume.repository.ReferenceDao;
import com.garbuz.resume.repository.ResumeDao;
import com.garbuz.resume.repository.SkillGroupDao;

@Service
public class ResumeService {
	
	private final static Logger LOG = LoggerFactory.getLogger(ResumeService.class);
	@Autowired
	private ResumeDao resumeDao;
	@Autowired
	private EducationDao educationDao;
	@Autowired
	private ReferenceDao referenceDao;
	@Autowired
	private RecommendationDao recommendationDao;
	@Autowired
	private JobDao jobDao;
	@Autowired
	private SkillGroupDao skillGroupDao;
	@Autowired
	private ResumeFactory resumeFactory;
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
	public List<Resume> findAllResumes() {
		LOG.info("Loading all resmes");
		List<Resume> resumes = resumeDao.findAll();
		LOG.info("Loaded {} resumes", CollectionUtils.size(resumes));
		return resumes;
	}
	public Resume saveOrCreateNew(final Resume resumeToSave) {
		LOG.info("Saving {}", resumeToSave);
		final Resume savedResume = this.resumeDao.saveAndFlush(resumeToSave);
		LOG.info("Saved {} ", savedResume);
		return savedResume;
	}
	public void remove(final Long id) {
		LOG.info("Removing resume for {}", id);
		Resume resumeToDelete = resumeDao.getReferenceById(id);
		//this.resumeDao.deleteById(id);
		//this.resumeDao.flush();
		LOG.info("Removed resume {} ", id);		
	}
	public List<Education> findEducationsByLastAndFirstName(final String lastName, final String firstName) {
		LOG.info("Loading for {} {}", lastName, firstName);
		List<Education> educations = this.educationDao.findByResume_LastNameAndResume_FirstName(lastName, firstName);
		LOG.info("Loaded {} Education", CollectionUtils.size(educations));
		return educations;
	}	
	public List<Recommendation> findRecommendationsByLastAndFirstName(final String lastName, final String firstName) {
		LOG.info("Loading for {} {}", lastName, firstName);
		List<Recommendation> recommendations = this.recommendationDao.findByResume_LastNameAndResume_FirstName(lastName, firstName);
		LOG.info("Loaded {} recommendations", CollectionUtils.size(recommendations));
		return recommendations;
	}
	public List<Reference> findReferencesByLastAndFirstName(final String lastName, final String firstName) {
		LOG.info("Loading for {} {}", lastName, firstName);
		List<Reference> references = this.referenceDao.findByResume_LastNameAndResume_FirstName(lastName, firstName);
		LOG.info("Loaded {} references", CollectionUtils.size(references));
		return references;
	}
	public List<Job> findJobsByLastAndFirstName(final String lastName, final String firstName) {
		LOG.info("Loading for {} {}", lastName, firstName);
		List<Job> jobs = jobDao.findByResume_LastNameAndResume_FirstName(lastName, firstName);
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

		LOG.info("Generating data");
		
		Resume resume = resumeFactory.createDefaultResume();
		resume.setSkills(skillFactory.createDefaulsSkills(resume));
		resume.setJobs(jobFactory.createDefaultJobs(resume));
		resume.setEducations(educationFactory.createDefaultSchools(resume));
		resume.setCertifications(certificationFactory.createDefaultCertifications(resume));
		resume.setRecommendations(recommendationFactory.createDefaultRecommendations(resume));
		resume.setReferences(referenceFactory.createDefaultReferences(resume));
		
		LOG.info("Data generation complete");
		
		return resume;
	}
	public List<Resume> generateAdditionalData(int numberOfResumesToGenerate) {

		LOG.info("Generating additional data");
		List<Resume> additionalData = new ArrayList<>();
		
		for (int i = 0; i < numberOfResumesToGenerate; i++) {
			Resume template = resumeFactory.createTemplateResume();
			template.setSkills(skillFactory.createDefaulsSkills(template));
			template.setJobs(jobFactory.createDefaultJobs(template));
			template.setEducations(educationFactory.createDefaultSchools(template));
			template.setCertifications(certificationFactory.createDefaultCertifications(template));
			template.setRecommendations(recommendationFactory.createDefaultRecommendations(template));
			template.setReferences(referenceFactory.createDefaultReferences(template));
			additionalData.add(template);
		}
		
		LOG.info("Additional data generation complete");
		
		return additionalData;
	}
}
