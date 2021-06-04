package com.database.database;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaAuditing;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import java.util.Collections;


@RestController
@SpringBootApplication
@EnableJpaAuditing
public class DatabaseApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(DatabaseApplication.class);
		app.setDefaultProperties(Collections.singletonMap("server.port", "8081"));
		app.run(args);
	}

	@GetMapping("/hello")
	public String greeting() {
		return "Hello World";
	}

}
