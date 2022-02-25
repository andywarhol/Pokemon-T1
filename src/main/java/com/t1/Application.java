package com.t1;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication(exclude = {
        org.springframework.boot.autoconfigure.security.servlet.SecurityAutoConfiguration.class}
        )
@ComponentScan({"com.t1.controller", "com.t1.service"})
@EntityScan("com.t1.entity")
@EnableJpaRepositories("com.t1.repository")
public class Application {

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
		
	
	}

}
