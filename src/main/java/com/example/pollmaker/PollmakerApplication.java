package com.example.pollmaker;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.data.mongodb.config.EnableMongoAuditing;
import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;

@SpringBootApplication
@EnableMongoAuditing //for @CreatedDate annotation
@EnableWebSecurity
@EnableMongoRepositories
public class PollmakerApplication {

	public static void main(String[] args) {
		SpringApplication.run(PollmakerApplication.class, args);
	}

}
