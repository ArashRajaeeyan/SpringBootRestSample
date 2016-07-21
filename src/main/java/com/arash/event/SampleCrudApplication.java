package com.arash.event;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.orm.jpa.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

/**
 * Starting point to setup application with SpringBoot
 * 
 * @author Arash Rajaeeyan
 *
 */
//@PropertySource("classpath:db-config.properties")
@SpringBootApplication
@EntityScan("com.arash.event.entity")
@EnableJpaRepositories("com.arash.event")
public class SampleCrudApplication {

	public static void main(String[] args) {
		SpringApplication.run(SampleCrudApplication.class, args);
	}
}
