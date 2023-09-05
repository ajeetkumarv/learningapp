package com.example.learningapp;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

@Component // without this @ConfigurationProperties won't work alone, if not this then put @Bean in AppConfig
@ConfigurationProperties
public class AppProps {
    @Value("${app.numberOfThreads}")
    private int numberOfThreads;
    @Value("${app.timeout}")
    private int timeout;

    @Override
    public String toString() {
        return "AppProps{" +
                "numberOfThreads=" + numberOfThreads +
                ", timeout=" + timeout +
                '}';
    }
}
