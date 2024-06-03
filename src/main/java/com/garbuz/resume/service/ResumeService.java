package com.garbuz.resume.service;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
import org.springframework.stereotype.Service;

import com.garbuz.resume.entity.ContactInformation;
import com.garbuz.resume.entity.Recommendation;
import com.garbuz.resume.entity.Reference;
import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.entity.Summary;
import com.garbuz.resume.entity.util.RecommendationFactory;
import com.garbuz.resume.repository.ContactInformationDao;
import com.garbuz.resume.repository.RecommendationDao;
import com.garbuz.resume.repository.ReferenceDao;
import com.garbuz.resume.repository.ResumeDao;
import com.garbuz.resume.repository.SummaryDao;

@Service
public class ResumeService {
	
	private final static Logger LOG = LoggerFactory.getLogger(ResumeService.class);
	@Autowired
	private ResumeDao resumeDao;
	@Autowired
	private RecommendationDao recommendationDao;
	@Autowired
	private ReferenceDao referenceDao;
	@Autowired
	private ContactInformationDao contactInformationDao;
	@Autowired
	private SummaryDao summaryDao;

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
	public Resume initializeData() {
		Resume resume = new Resume();
		resume.setFirstName("Alexander");
		resume.setLastName("Garbuz");
		resume = saveOrCreateNew(resume);
		
		Summary summary = new Summary();
		summary.setObjective("Looking for Java Back End developer position");
		summary.setSummary("Senior IT professional with more than 25 years of combined software development, leadership and management experience in insurance, healthcare, telecommunications, and e-commerce industries");
		summary.setResume(resume);
		summaryDao.save(summary);
		
		ContactInformation ci = new ContactInformation();
		ci.setAddress("405 Burnt Sienna Dr.");
		ci.setCity("Middleton");
		ci.setZip("53562");
		ci.setState("WI");
		ci.setEmail("alexander.garbuz@gmail.com");
		ci.setPhone("608-628-2448");
		ci.setResume(resume);
		ci = saveOrCreateNew(ci);
		
		
		Reference referense1 = new Reference(resume, "Erick Hallick", "erick@hallick.com", "555-555-5555", "Executive VP of Operations @ CPM Healthgrades");
		Reference referense2 = new Reference(resume, "Aditya Prakash", "Aditya@Prakash.com", "111-111-2222", "Project Manager @ American Family Insurance");
		Reference referense3 = new Reference(resume, "Jeff Fletcher", "Jeff@Fletcher.com", "666-333-4444", "Sr. Database Developer @ CPM Healthgrades");
		this.referenceDao.save(referense1);
		this.referenceDao.save(referense2);
		this.referenceDao.save(referense3);
		
		List<Recommendation> recommendations = new ArrayList<>();
		Recommendation r1 = RecommendationFactory.create(
		"Erick Hallick",
		"Executive VP of Operations @ CPM Healthgrades",
		"Managed Alexander directly",
		"One of the most desirable characteristics in an employee is someone who takes complete ownership of the problem they are working on. It is very rare to find, but Alex had this in spades. I don't think a week went by without Alex knocking on my door with a new idea on how to improve the work we were doing and our company. Alex was asked to implement most of his ideas immediately and he made significant improvements to the processes and project management around our CRM database build projects. Communication and transparency with clients improved dramatically and I received several compliments regarding the improvements. When I declined to implement one of Alex's ideas he accepted my decision without issue. He was a joy to work with. I would hire Alex again without reservation"
		);
		r1.setResume(resume);
		Recommendation r2 = RecommendationFactory.create(
		"Aditya Prakash",
		"Project Manager @ American Family Insurance",
		"Worked with Alexander on the same team",
		"Alex is focused and has a strategic approach to project management, which resulted in success deliverables assigned as part of the App migration program. Alex had shown responsiveness for the projects that he is responsible from end to end. During the App migration, program implementation I had pleasure to collaborate around agile principles, scrum framework including best project practices to ensure success of each other deliverables. He had shown great technical acumen that the project team members ran brainstorming ideas with him around challenges and blockers. Alex showed great people skills on how to motivate people or dial back when great necessary to make sure that project is completed on time. Alex would be great asset to any team."
		);
		r2.setResume(resume);
		Recommendation r3 = RecommendationFactory.create(
		"Jeff Fletcher",
		"Sr. Database Developer @ CPM Healthgrades",
		"Reported directly to Alexander",
		"Alex is one of the best managers I have had the pleasure to work for. He truly believes it is his responsibility to look out for his team and to remove obstacles so that they may succeed, as well as ensure that objectives are accomplished. When I started with CPM there was an environmental issue that was affecting my performance, and while Alex could not eliminate the issue he did come up with ways to mitigate it and he followed up to see if there was an improvement. Alex lead the expansion of the development team, doubling its size; and he also created a project management team. Through all of this, Alex kept a sense of humor and helped everyone on the teams manage heavy workloads and tight deadlines. I've enjoyed working for Alex and look forward to more opportunities to do so."
		);
		r3.setResume(resume);
		
		recommendations.add(saveOrCreateNew(r1));
		recommendations.add(saveOrCreateNew(r2));
		recommendations.add(saveOrCreateNew(r3));
		
		resume = findResume(resume.getId());
		return resume;
	}
	
}
