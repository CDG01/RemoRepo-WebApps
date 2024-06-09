# RestController

@RestController è un'annotazione di Spring che combina @Controller e @ResponseBody.
Indica che questa classe è un controller che gestisce richieste HTTP e che i metodi di 
questa classe restituiscono direttamente dati JSON o XML.

Quando un metodo di un controller annotato con `@RestController` restituisce un oggetto, Spring si occupa automaticamente della conversione di quell'oggetto in un formato appropriato per la risposta HTTP in base all'intestazione `Accept` della richiesta.

Di solito, se il client richiede JSON, Spring converte automaticamente l'oggetto restituito in un formato JSON utilizzando un convertitore JSON come Jackson. Se il client richiede XML, Spring converte l'oggetto in formato XML.

Ecco un esempio:

```java
import org.springframework.web.bind.annotation.*;

@RestController
public class UserController {

    @GetMapping("/user")
    public User getUser() {
        User user = new User("John", "Doe");
        return user;
    }
}
```

Se un client fa una richiesta GET a `/user` e specifica `Accept: application/json` nell'intestazione della richiesta, Spring converte automaticamente l'oggetto `User` restituito in formato JSON. Se il client specifica `Accept: application/xml`, Spring converte l'oggetto in formato XML.