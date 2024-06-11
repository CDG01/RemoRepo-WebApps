# EXERCISE:

write a Spring Boot application with the necessary dependencies that:
- has a basic controller that returns the sum of 2 random integers
- runs on:
  - port 7070 with profile prod
  - port 4000 with profile test
  - port 5000 in all the other cases
- the version is 0.0.6

- create the .war using the command package and launch it using the command line, using the 2 prod and test profiles.

- create the .jar (before you must change pom.xml) using the command package and launch it using intellij, using the 
  2 prod and test profiles and setting create the .war using the command package and launch it using the command line, 
  using the 2 prod and test profiles (you must add  add the VM option: -Dspring.profiles.active=prod)



### Terminali in cui il Comando Funziona

1. **Prompt dei Comandi di Windows (cmd)**:
   - Sintassi:
     ```cmd
     java -jar -Dspring.profiles.active=prod target/deploy-0.0.6.war
     ```

2. **Terminali Unix/Linux (Bash, Zsh, etc.)**:
   - Sintassi:
     ```bash
     java -jar -Dspring.profiles.active=prod target/deploy-0.0.6.war
     ```

3. **Windows PowerShell**:
   - In PowerShell, l'uso delle proprietà di sistema JVM tramite `-D` può causare problemi, e si preferisce spesso usare l'approccio Spring Boot con `--`.
   - Sintassi corretta per PowerShell:
     ```powershell
     java -jar target/deploy-0.0.6.war --spring.profiles.active=prod
     ```

### Esempi di Comandi nei Terminali Specifici

#### Prompt dei Comandi di Windows (cmd)
1. Apri il prompt dei comandi.
2. Naviga alla directory contenente il file `demo-0.0.6.war`:
   ```cmd
   cd D:\SSD\Courses\Devhelope\LocalRepo-MatteoSolinas\target
   ```
3. Esegui il comando:
   ```cmd
   java -jar -Dspring.profiles.active=prod demo-0.0.6.war
   ```

#### Terminali Unix/Linux (Bash, Zsh, GitBash)
1. Apri il terminale.
2. Naviga alla directory contenente il file `demo-0.0.6.war`:
   ```bash
   cd /path/to/LocalRepo-MatteoSolinas/target
   ```
3. Esegui il comando:
   ```bash
   java -jar -Dspring.profiles.active=prod demo-0.0.6.war
   ```

#### Windows PowerShell
1. Apri PowerShell.
2. Naviga alla directory contenente il file `demo-0.0.6.war`:
   ```powershell
   cd D:\SSD\Courses\Devhelope\LocalRepo-MatteoSolinas\target
   ```
3. Esegui il comando:
   ```powershell
   java -jar demo-0.0.6.war --spring.profiles.active=prod
   ```

### Considerazioni Finali
- **Usare il comando `-Dspring.profiles.active=prod`**: Questo è specificamente per impostare proprietà di sistema JVM. Funziona bene in cmd e terminali Unix/Linux.
- **Usare il comando `--spring.profiles.active=prod`**: Questo è specifico per le applicazioni Spring Boot e si consiglia di usarlo in PowerShell per evitare problemi di parsing dei parametri.



