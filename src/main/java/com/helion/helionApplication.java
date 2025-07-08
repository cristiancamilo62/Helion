package com.helion;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringBootApplication
@EnableJpaRepositories(basePackages = "com.helion.infrastructure.repositories")
@EntityScan(basePackages = "com.helion.infrastructure.entities")
public class helionApplication {

	public static void main(String[] args) {
		SpringApplication.run(helionApplication.class, args);
	}

}
