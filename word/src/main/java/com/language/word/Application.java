package com.language.word;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@EnableAutoConfiguration
@SpringBootApplication
public class Application {
    private static Logger log = LoggerFactory.getLogger(Application.class);
    /**
     * Main Start
     */
    public static void main(String[] args) {
        ApplicationContext ctx = SpringApplication.run(Application.class, args);
        String [] activeProfiles = ctx.getEnvironment().getActiveProfiles();
        for(String profile : activeProfiles){
            log.info("Spring boot使用的配置为:{}",profile);
        }
    }

}
