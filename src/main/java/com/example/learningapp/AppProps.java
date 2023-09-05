package com.example.learningapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Profile;
import org.springframework.stereotype.Component;

@Component // without this @ConfigurationProperties won't work alone, if not this then put @Bean in AppConfig
@ConfigurationProperties
@Profile("!prod") // works in all profiles except prod link: https://youlearncode.com/spring-boot-profiles/
public class AppProps {
    @Value("${app.numberOfThreads}")
    private int numberOfThreads;
    @Value("${app.timeout}")
    private int timeout;

    @Value("${spring.profiles.active}") //note that I've not put this in application.properties
    private String activeProfile;

    @Override
    public String toString() {
        return "AppProps{" +
                "numberOfThreads=" + numberOfThreads +
                ", timeout=" + timeout +
                ", profile=" + activeProfile +
                '}';
    }
}
