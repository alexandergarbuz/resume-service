package com.garbuz.resume.util;

import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.stereotype.Component;

@Component
@PropertySource("classpath:version.properties")
public class PropertiesReader {

    private final Environment environment;

    public PropertiesReader(Environment environment) {
        this.environment = environment;
    }

    public String getCommitSha() {
        return environment.getProperty("git.commit.sha");
    }
    public String getCommitComment() {
        return environment.getProperty("git.commit.message");
    }
}
