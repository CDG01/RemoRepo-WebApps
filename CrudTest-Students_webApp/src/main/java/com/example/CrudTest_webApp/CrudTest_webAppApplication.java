package com.example.CrudTest_webApp;

import org.modelmapper.ModelMapper;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Profile;

@SpringBootApplication
public class CrudTest_webAppApplication {

	// l'array di argomenti che sono passati al metodo main sono i parametri del comando per far partire (più precisamente, tradurre il bytecode) il file jar dal terminale
	public static void main(String[] args) {
		SpringApplication.run(CrudTest_webAppApplication.class, args);
	}

	@Bean
	public ModelMapper createModelMapper(){
		return new ModelMapper();
	}

}
