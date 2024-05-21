package co.develhope.bookExampleWithDTO;

/* CONSEGNA
Api per archiviare libri in una mappa java
il programmma ha:
- InMemoryBookDTO: l'oggetto che entra e esce dall'applicazione, quando comunica con il client, attraverso i controllers
- BookEntity: l'oggeto che entra e esce dall'applicazione, quando comunica con il database o il un altro metodo di archiviazione, attraverso il InBookMemoryDAO
- BookDao: la classe che gestisce il salvataggio, la rimozione e la modifica dei dati nello storage
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookExampleWithDtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookExampleWithDtoApplication.class, args);
	}

}
