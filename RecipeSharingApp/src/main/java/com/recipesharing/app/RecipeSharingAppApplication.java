package com.recipesharing.app;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;

@SpringBootApplication
@ComponentScan("com.recipesharing.app")
public class RecipeSharingAppApplication {

	public static void main(String[] args) {
		SpringApplication.run(RecipeSharingAppApplication.class, args);
	}
}
