package com.example.learningapp;

import com.example.learningapp.carexample.model.Car;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * discussion on proxyBeanMethods at: https://youlearncode.com/configuration-in-spring-boot/
 */
@Configuration
public class AppConfig {
    private static final Logger logger = LoggerFactory.getLogger(AppConfig.class);

    /**
     * @Bean is used to create non code base classes
     * @Component is used for codebase classes
     */
    @Bean(name = {"RoyalCar", "KingsCar"}, autowireCandidate = true, initMethod = "buildCar", destroyMethod = "scrapCar")
    public Car getCar() {
        return new Car();
    }
}
