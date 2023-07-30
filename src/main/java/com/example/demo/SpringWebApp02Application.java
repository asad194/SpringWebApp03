package com.example.demo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.data.jdbc.JdbcRepositoriesAutoConfiguration;
import org.springframework.boot.autoconfigure.jdbc.JdbcTemplateAutoConfiguration;

@SpringBootApplication(exclude = {JdbcRepositoriesAutoConfiguration.class, JdbcTemplateAutoConfiguration.class})
public class SpringWebApp02Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringWebApp02Application.class, args);
	}

}
