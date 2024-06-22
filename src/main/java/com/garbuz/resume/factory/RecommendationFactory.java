package com.garbuz.resume.factory;

import java.util.ArrayList;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Component;

import com.garbuz.resume.entity.Recommendation;
import com.garbuz.resume.entity.Resume;
import com.garbuz.resume.repository.RecommendationDao;

@Component
public class RecommendationFactory {

	private static final Logger LOG = LoggerFactory.getLogger(RecommendationFactory.class);
	
	private RecommendationDao dao;
	
	public RecommendationFactory(final RecommendationDao dao) {
		this.dao = dao;
	}
	
	public List<Recommendation> createDefaultRecommendations(final Resume resume) {
		
		List<Recommendation> recommendations = new ArrayList<>();
		
		recommendations.add(dao.saveAndFlush(new Recommendation(
			resume,
			"Erick Hallick",
			"Executive VP of Operations @ CPM Healthgrades",
			"Managed Alexander directly",
			"One of the most desirable characteristics in an employee is someone who takes complete ownership of the problem they are working on. It is very rare to find, but Alex had this in spades. I don't think a week went by without Alex knocking on my door with a new idea on how to improve the work we were doing and our company. Alex was asked to implement most of his ideas immediately and he made significant improvements to the processes and project management around our CRM database build projects. Communication and transparency with clients improved dramatically and I received several compliments regarding the improvements. When I declined to implement one of Alex's ideas he accepted my decision without issue. He was a joy to work with. I would hire Alex again without reservation."
		)));
		recommendations.add(this.dao.saveAndFlush(new Recommendation(
			resume,
			"Aditya Prakash",
			"Project Manager @ American Family Insurance",
			"Worked with Alexander on the same team",
			"Alex is focused and has a strategic approach to project management, which resulted in success deliverables assigned as part of the App migration program. Alex had shown responsiveness for the projects that he is responsible from end to end. During the App migration, program implementation I had pleasure to collaborate around agile principles, scrum framework including best project practices to ensure success of each other deliverables. He had shown great technical acumen that the project team members ran brainstorming ideas with him around challenges and blockers. Alex showed great people skills on how to motivate people or dial back when great necessary to make sure that project is completed on time. Alex would be great asset to any team."
		)));
		recommendations.add(this.dao.saveAndFlush(new Recommendation(
			resume,
			"Jeff Fletcher",
			"Sr. Database Developer @ CPM Healthgrades",
			"Reported directly to Alexander",
			"Alex is one of the best managers I have had the pleasure to work for. He truly believes it is his responsibility to look out for his team and to remove obstacles so that they may succeed, as well as ensure that objectives are accomplished. When I started with CPM there was an environmental issue that was affecting my performance, and while Alex could not eliminate the issue he did come up with ways to mitigate it and he followed up to see if there was an improvement. Alex lead the expansion of the development team, doubling its size; and he also created a project management team. Through all of this, Alex kept a sense of humor and helped everyone on the teams manage heavy workloads and tight deadlines. I've enjoyed working for Alex and look forward to more opportunities to do so."
		)));
		recommendations.forEach(recommendation -> {
			Recommendation ref = dao.saveAndFlush(recommendation);
			LOG.info("Saved {}", ref);
		});
		return recommendations;
	}
	
	
}
