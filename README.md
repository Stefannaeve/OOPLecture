#

## FileReader

Når du skal lese en fil og lagre den i databasen er det viktig å finne strukturen på dataen i filen
i Persons.txt så er strukturen
``` txt
firstname
lastname
address
---
firstname
lastname
address
---
```
Når du skal lese 1 person ut av filen kan det se noe slikt ut.

siden strukturen på filen skal være låst vet vi alltid at første linje skal være firstName
samme med lastname skal vare linje nr 2 og adress linje 3. og helt til slutt en seperator linje

``` java
    File file = new File("persons.txt");
    Scanner scanner = new Scanner(file);
    
    String firstName = scanner.nextLine();
    String lastName = scanner.nextLine();
    String address = scanner.nextLine();
    
    // For å hoppe over "---" linjen
    scanner.nextLine();
    
    Person person = new Person(firstName, lastName, address);
```

Om vi skal utvide koden til å lese flere personer fra en fil må vi sette en loop i rundt dette

``` java
    File file = new File("persons.txt");
    Scanner scanner = new Scanner(file);
    ArrayList<Person> personList = new ArrayList();
    while(scanner.hasNext()){
    
        String firstName = scanner.nextLine();
        String lastName = scanner.nextLine();
        String address = scanner.nextLine();
        
        // For å hoppe over "---" linjen
        scanner.nextLine();
        
        Person person = new Person(firstName, lastName, address);
        
        personList.add(person);
    }
```
Eneste forskjellen mellom disse to eksemplene er at vi har en liste av person som vi lagrer personene og
vi legger til personen i listen etter å ha laget dem.
Og ikke minst at vi har en loop i rundt lesing av personer.

Vi bruker scanner.hasNext() for å sjekke om det er flere linjer igjen i filen å lese

Merk: Om filen ikke følger strukturen helt kan det hende at dette kan krasje.
Når vi leser 4 linjer etter hverandre så må det faktisk vare 4 linjer igjen i filen.