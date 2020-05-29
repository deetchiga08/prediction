package com.briller.Config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import javax.annotation.PostConstruct;

/**
 * @profile has dev , if it is a prod server , replace it with prod profile name . and also the system out to confirm that.
 * In intellij, load the environment variable as spring.profiles.active=dev for prod replace it by prod profile name.
 */
@Profile("dev")
@Configuration
public class javaConfig {

    @PostConstruct
    public void test(){
        System.out.println("loaded dev environment");
    }


}
