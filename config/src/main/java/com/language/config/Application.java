package com.language.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
@EnableAutoConfiguration
public class Application {
    private static Logger log = LoggerFactory.getLogger(Application.class);
    /**
     * Main Start
     */
    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);

    }

}
