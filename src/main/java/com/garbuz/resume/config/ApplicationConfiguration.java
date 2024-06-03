package com.garbuz.resume.config;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties("application")
public class ApplicationConfiguration {
	private String applicationName;

	public String getApplicationName() {
		return applicationName;
	}

	public void setApplicationName(String name) {
		this.applicationName = name;
	}
}
