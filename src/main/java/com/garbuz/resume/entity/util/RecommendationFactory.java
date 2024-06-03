package com.garbuz.resume.entity.util;

import com.garbuz.resume.entity.Recommendation;

public class RecommendationFactory {

	private RecommendationFactory() {}
	
	public final static Recommendation createDefault() {
		Recommendation r = new Recommendation();
		r.setAuthor("Erick Hallick");
		r.setAuthorTitle("VP of Operations");
		r.setRelationship("Manager");
		r.setText("Alex is Great");
		return r;
	}
	public final static Recommendation create(
			String author, String authorTitle, String relationship, String text
			) {
		Recommendation r = new Recommendation();
		r.setAuthor(author);
		r.setAuthorTitle(authorTitle);
		r.setRelationship(relationship);
		r.setText(text);
		return r;
	}
}
