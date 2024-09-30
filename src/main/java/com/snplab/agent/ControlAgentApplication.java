package com.snplab.agent;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.ConfigurationPropertiesScan;

@ConfigurationPropertiesScan
@SpringBootApplication
public class ControlAgentApplication {

	public static void main(String[] args) {
		SpringApplication.run(ControlAgentApplication.class, args);
	}

}
