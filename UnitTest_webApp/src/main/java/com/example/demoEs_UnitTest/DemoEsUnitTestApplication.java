package com.example.demoEs_UnitTest;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class DemoEsUnitTestApplication {

	public static void main(String[] args) {
		SpringApplication.run(DemoEsUnitTestApplication.class, args);
	}

	@Bean
	public ModelMapper createModelMapper(){
		return new ModelMapper();
	}

}
