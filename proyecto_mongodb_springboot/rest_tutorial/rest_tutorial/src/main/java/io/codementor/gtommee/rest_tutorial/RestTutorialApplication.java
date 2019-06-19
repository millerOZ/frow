package io.codementor.gtommee.rest_tutorial;

import java.util.Collections;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class RestTutorialApplication {

	public static void main(String[] args) {
		SpringApplication app = new SpringApplication(RestTutorialApplication.class);
		app.setDefaultProperties(Collections
		.singletonMap("server.port","8083"));
		app.run(args);
	}

}
