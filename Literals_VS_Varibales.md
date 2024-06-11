**Evitare i Numeri Magici**  
*Di Jeff Nuss - 25 ottobre 2019*

source: [https://www.pluralsight.com/tech-blog/avoiding-magic-numbers/](https://www.pluralsight.com/tech-blog/avoiding-magic-numbers/)

I numeri magici sono un anti-pattern e dovrebbero essere generalmente evitati. Ma cosa intendo con numeri magici? Mi riferisco all'uso di numeri direttamente nel codice invece di utilizzare costanti con nome. Questo può applicarsi anche ad altri tipi di dati e letterali, specialmente stringhe. Perché sono negativi? Inibiscono la leggibilità e la possibilità di refactoring.

### Leggibilità

Uno dei principali vantaggi dell'eliminazione dei numeri magici è che aumenta la leggibilità e rende il codice più auto-documentante. Permette di concentrarsi sul significato del numero piuttosto che sul numero stesso. Inoltre, l'uso di un numero magico oscura l'intento o il significato di quel numero e può non essere chiaro.

Consideriamo questo esempio di codice in Swift:

```swift
func haveICaughtThemAll(numberCaught: Int) -> Bool {
    return numberCaught == 151
}

func howManyMoreDoIHaveToCatch(numberCaught: Int) -> Int {
    return 151 - numberCaught
}
```

Potrebbe non essere immediatamente chiaro cosa significhi il numero magico 151 o perché sia stato scelto, specialmente se non si è familiari con il dominio del problema (Pokémon). Estraendo il 151 in una costante con nome, il codice diventa più leggibile e non è necessario ragionare (o peggio, indovinare) sul significato del numero 151.

```swift
let totalPokemon = 151

func haveICaughtThemAll(numberCaught: Int) -> Bool {
    return numberCaught == totalPokemon
}

func howManyMoreDoIHaveToCatch(numberCaught: Int) -> Int {
    return totalPokemon - numberCaught
}
```

### Refactorability

Un altro grande vantaggio dell'evitare i numeri magici è che rende il codice più facile da refactorare e meno soggetto a bug. Questo aiuta a mantenere il principio DRY: "Ogni pezzo di conoscenza deve avere una rappresentazione unica, inequivocabile e autorevole all'interno di un sistema."

Ritorniamo all'esempio sopra.

```swift
let totalPokemon = 151

func haveICaughtThemAll(numberCaught: Int) -> Bool {
    return numberCaught == totalPokemon
}

func howManyMoreDoIHaveToCatch(numberCaught: Int) -> Int {
    return totalPokemon - numberCaught
}
```

Se il valore di `totalPokemon` cambia (spoiler: cambierà), ora è necessario cambiarlo solo in un posto. Nell'esempio originale, si dovrebbero trovare tutte le istanze del numero 151 e sostituirle. Questo potrebbe non essere così difficile in questo esempio, ma in un codice reale, gli usi di questo numero magico potrebbero non essere vicini tra loro e si potrebbe dimenticare di fare un trova e sostituisci su tutto il codice o potrebbe non sembrare necessario farlo. Inoltre, cosa succede se c'è un'altra istanza del numero 151 nel codice, ma quella rappresenta il numero massimo di punti vita che un Pokémon può avere? Se si fa semplicemente un trova e sostituisci su tutto il codice, si cambierà quel 151 erroneamente. Utilizzando una costante per `totalPokemon`, ora si ha una "rappresentazione unica, inequivocabile e autorevole" di questo pezzo di conoscenza nel sistema. Ora, quando qualcuno decide che 151 non è più sufficiente, bisogna cambiare solo quel pezzo di conoscenza in un posto, prevenendo bug in tutto il sistema.

### Nomi e Valori Duplicati

Mentre si rimuovono i numeri magici dal codice e li si sostituisce con costanti nominate, assicurarsi che la costante aumenti effettivamente la leggibilità. Fare questo:

```swift
let seven = 7
```

non è utile. Non dà alcuna informazione aggiuntiva su quale conoscenza rappresenta il 7. Questo porta a considerare un altro caso:

```swift
let startingNumberOfCards = 7
let maxNumberOfPlayers = 7
```

Anche se 7 è il valore di entrambe queste costanti, rappresenta conoscenze diverse in contesti diversi e quindi sono appropriate due costanti nominate diverse.

### Eccezioni

Come per la maggior parte delle "regole" nella programmazione, ci sono eccezioni.

0, 1 e null/nil sono solitamente sicuri da usare da soli. Ad esempio:

```swift
array.count == 0
array[i + 1]
middleName == nil
firstName == ""
```

In base al contesto in cui questi letterali sono usati, il significato è chiaro. In effetti, il significato potrebbe essere oscurato se si usasse una costante con nome. Se il primo esempio fosse `array.count == emptyArrayCount`, questo suggerirebbe che si consideri un array "vuoto" se ha qualche numero di elementi diverso da 0. Se questo è effettivamente il caso, allora una costante con nome potrebbe essere appropriata. Tuttavia, se si ha `let emptyArrayAmount = 0`, probabilmente confonderebbe chi legge il codice.

Le stringhe usate per il logging o il tracing sono anche un'eccezione; infatti, spesso è preferibile mantenerle come letterali. Il principio generale è questo: se il significato di un letterale è chiaro dal contesto e non cambierà in futuro, probabilmente è ok usarlo. Tuttavia, questo porta a una zona grigia.

### Zona Grigia

Ecco una domanda: si dovrebbe usare una costante come `let secondsPerMinute = 60`? Questo valore non cambierà a breve, quindi la preoccupazione per il refactoring è minore. Direi che dipende dal contesto. In molti contesti, `secondsPerMinute` rimuoverà qualsiasi ambiguità su cosa significhi il numero magico 60. Ad esempio, 60 significa secondi per minuto o minuti per ora? Tuttavia, se l'unico utilizzo di `secondsPerMinute` è in un calcolo per il numero di secondi in una giornata lavorativa, allora qualcosa come

```swift
let hoursInTheWorkday = 8
let secondsInTheWorkday = hoursInTheWorkday * 60 * 60
```

è probabilmente più leggibile di

```swift
let hoursInTheWorkday = 8
let minutesPerHour = 60
let secondsPerMinute = 60
let secondsInTheWorkday = hoursInTheWorkday * minutesPerHour * secondsPerMinute
```

specialmente se non si usa `secondsPerMinute` in nessun altro posto. Nota che ci affidiamo anche al fatto che 60 secondi/minuto e 60 minuti/ora siano pezzi di conoscenza abbastanza universali. Qualcosa come `radiansPerDegree` nel seguente codice potrebbe essere più appropriato perché non è una costante così conosciuta:

```swift
let radiansPerDegree = 0.0174533
let radiansInACircle = 360 * radiansPerDegree
```

Inoltre, specificare costanti matematiche come questa o altre come pi (π) garantisce coerenza nei calcoli in tutto il codice. Non si vorrebbe 3.14159 in un posto e 3.14 in un altro, specialmente se si scrive codice per un razzo o un altro dominio dove è importante un'elevata precisione.

### Conclusione

Sebbene evitare i numeri magici sia un concetto semplice, aumenterà la leggibilità e la possibilità di refactoring del codice, migliorandone la pulizia. Mentre questo post fornisce alcune linee guida, sopra ogni cosa, sii pragmatico e ricorda che il contesto conta. Sebbene i numeri magici debbano essere evitati, non eliminarli dogmaticamente dal codice senza un po' di riflessione.

**Categorie:** tecnico  
**Tag:** swift, codice pulito
