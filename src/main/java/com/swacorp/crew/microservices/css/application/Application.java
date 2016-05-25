package com.swacorp.crew.microservices.css.application;

import java.io.IOException;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ImportResource;
import org.springframework.data.gemfire.repository.config.EnableGemfireRepositories;

//allows srping to configure runtime project
@EnableAutoConfiguration
@SpringBootApplication
//gemfire source package
@EnableGemfireRepositories(basePackages = "com.swacorp.crew.microservices.css.repository")
@ComponentScan(basePackages = {"com.swacorp.crew.microservices.css.service","com.swacorp.crew.microservices.css.api"})
//allows to read configuration from external gemfire
@ImportResource("integration.xml")
public class Application {
  
    public static void main(String[] args) throws IOException {
        SpringApplication application = new SpringApplication(Application.class);
        application.setWebEnvironment(true);
        application.run(args);
    }
}
