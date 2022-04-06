package com.capgemini.demo;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class CapgeminiServiceApplication {

	static final Logger log = LoggerFactory
			.getLogger(CapgeminiServiceApplication.class);

	public static void main(String[] args) {
		log.info("Before Starting application");
		SpringApplication.run(CapgeminiServiceApplication.class, args);
		log.info("Application is started");
	}

}
