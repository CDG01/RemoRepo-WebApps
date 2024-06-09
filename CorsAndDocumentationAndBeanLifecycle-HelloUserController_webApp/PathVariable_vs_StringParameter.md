## PathVariable vs Query String

### PathVariable:

- I parametri di PathVariable sono parte dell'URL stesso.
- Vengono utilizzati per identificare risorse specifiche nell'URL.
- Sono utilizzati principalmente quando si desidera accedere a risorse specifiche o identificabili da un percorso nell'URL.
- Sono particolarmente utili quando si lavora con API RESTful e si desidera specificare l'identificatore di una risorsa all'interno dell'URL.
- Solitamente vengono utilizzati per passare dati che identificano una risorsa nel percorso dell'URL.

Esempio di PathVariable:
```
GET /api/users/{userId}
```
In questo caso, `{userId}` è un esempio di PathVariable che rappresenta l'identificatore univoco di un utente.

### Query String:

- I parametri della Query String vengono aggiunti alla fine dell'URL dopo il simbolo "?", in coppia chiave-valore separati da "&".
- Vengono utilizzati per passare dati opzionali o parametri di ricerca ai server.
- Sono utilizzati quando si desidera filtrare, ordinare o passare parametri opzionali a una richiesta.
- Solitamente vengono utilizzati per passare dati che modificano l'output della richiesta in qualche modo.

Esempio di Query String:
```
GET /api/products?category=electronics&sortBy=price
```
In questo caso, `category` e `sortBy` sono esempi di parametri della Query String che specificano la categoria dei prodotti da recuperare e il modo in cui devono essere ordinati.

In sintesi, si utilizza PathVariable quando si desidera identificare specificamente una risorsa nel percorso dell'URL, mentre si utilizza la Query String quando si desidera passare dati opzionali o parametri di ricerca ai server.