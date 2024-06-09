package co.develhope.bookexample;

/* CONSEGNA
Api per archiviare libri
due possibili metodi di archiviazione:
- attraverso InMemoryBookDAO archiviamo in una mappa java
- attraverso JPABookDAO archiviamo in un db
il programmma usa il metodo di archiviazione annotato con @Primary
 */

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BookexampleApplication {

	public static void main(String[] args) {
		SpringApplication.run(BookexampleApplication.class, args);
	}

}
