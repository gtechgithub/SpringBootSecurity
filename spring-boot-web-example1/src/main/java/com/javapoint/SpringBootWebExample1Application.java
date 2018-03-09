package com.javapoint;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.ImportResource;

@SpringBootApplication
@ImportResource("classpath:/SpringSecurity/spring-security.xml")
public class SpringBootWebExample1Application {

	public static void main(String[] args) {
		System.out.println("hello spring web security");
		SpringApplication.run(SpringBootWebExample1Application.class, args);
	}
}
