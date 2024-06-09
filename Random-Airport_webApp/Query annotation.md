L'annotazione `@Query` in Spring Data JPA è utilizzata per definire query personalizzate direttamente nei metodi del repository. Può essere utilizzata per scrivere sia query JPQL (Java Persistence Query Language) sia query SQL native. Vediamo nel dettaglio come funziona e a cosa serve.

### Funzionamento di `@Query`

#### 1. Definizione della Query

L'annotazione `@Query` consente di specificare una query personalizzata. Questa può essere una query JPQL o una query SQL nativa. Nel tuo caso, hai utilizzato una query SQL nativa:

```java
@Query(value = "SELECT * FROM flights ORDER BY from_airport", nativeQuery = true)
Page<Flight> getFlightPaged(Pageable pageable);
```

- **value**: contiene la stringa della query da eseguire.
- **nativeQuery**: se impostato su `true`, indica che la query è una query SQL nativa. Se omesso o impostato su `false`, la query sarà interpretata come JPQL.

#### 2. Supporto alla Paginazione

Il metodo `getFlightPaged(Pageable pageable)` utilizza l'interfaccia `Pageable` per supportare la paginazione dei risultati. Questo permette di ottenere solo una porzione dei dati totali, basata sui parametri di paginazione forniti (pagina corrente, dimensione della pagina, ordinamento).

### Esempio di Utilizzo di `@Query`

#### Query JPQL

```java
@Query("SELECT f FROM Flight f WHERE f.status = :status")
List<Flight> findByStatus(@Param("status") Flight.Status status);
```

#### Query SQL Nativa

```java
@Query(value = "SELECT * FROM flights WHERE status = ?1", nativeQuery = true)
List<Flight> findByStatusNative(String status);
```

### A Cosa Serve l'Annotazione `@Query`

1. **Query Personalizzate**: Permette di scrivere query che non possono essere espresse facilmente utilizzando i metodi di query derivati di Spring Data JPA.
   
2. **Ottimizzazione delle Performance**: Può essere utilizzata per scrivere query ottimizzate per casi d'uso specifici, migliorando le performance rispetto a query generate automaticamente.

3. **Flessibilità**: Consente di utilizzare SQL nativo per sfruttare funzionalità specifiche del database che non sono supportate da JPQL.

### Dettagli dell'Esempio Fornito

```java
@Query(value = "SELECT * FROM flights ORDER BY from_airport", nativeQuery = true)
Page<Flight> getFlightPaged(Pageable pageable);
```

- **Query**: `"SELECT * FROM flights ORDER BY from_airport"` è una query SQL nativa che seleziona tutte le colonne dalla tabella `flights` e ordina i risultati per la colonna `from_airport`.
- **Paginazione**: Il metodo ritorna un oggetto `Page<Flight>`, che contiene una sottolista di `Flight` basata sui parametri di paginazione forniti. L'interfaccia `Pageable` permette di specificare il numero di pagina, la dimensione della pagina e l'ordinamento.

### Esempio di Chiamata

```java
Pageable pageable = PageRequest.of(0, 10, Sort.by("fromAirport").ascending());
Page<Flight> flightsPage = flightRepository.getFlightPaged(pageable);
```

In questo esempio:
- `PageRequest.of(0, 10, Sort.by("fromAirport").ascending())` crea un oggetto `Pageable` che richiede la prima pagina di 10 elementi ordinati per `fromAirport` in ordine crescente.
- `flightRepository.getFlightPaged(pageable)` esegue la query e restituisce una pagina di risultati.

### Conclusione

L'annotazione `@Query` in Spring Data JPA è uno strumento potente per definire query personalizzate. Fornisce flessibilità nella scrittura di query complesse e ottimizzate, sia utilizzando JPQL che SQL nativo, e può essere combinata con il supporto alla paginazione per gestire efficientemente grandi set di dati.