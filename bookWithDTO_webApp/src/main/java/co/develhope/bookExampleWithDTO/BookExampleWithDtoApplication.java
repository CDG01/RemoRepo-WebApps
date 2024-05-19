package co.develhope.bookExampleWithDTO;

/* CONSEGNA
Api per archiviare libri in una mappa java
il programmma ha:
- InMemoryBookDTO, l'oggetto che entra e esce dall'applicazione, mentre comunica con il client, attraverso i controllers
- BookEntity, l'oggeto che entra e esce dall'applicazione, mentre comunica con il database o il un altro metodo di archiviazione, attraverso il InBookMemoryDAO
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookExampleWithDtoApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookExampleWithDtoApplication.class, args);
	}

}
