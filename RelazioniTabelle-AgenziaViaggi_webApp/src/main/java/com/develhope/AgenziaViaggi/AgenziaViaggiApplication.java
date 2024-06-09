package com.develhope.AgenziaViaggi;

/* CONSEGNA:
Applicaizone per gestire prenotazione viaggi.
Ogni user può prenotare un ordine e un ordine è un contiene i vari places che verranno visitati in quel viaggio.
Relazione molti a molti tra Order e Place
Relazione uno a molti tra User e Order
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class AgenziaViaggiApplication {

	public static void main(String[] args) {
		SpringApplication.run(AgenziaViaggiApplication.class, args);
	}

}
