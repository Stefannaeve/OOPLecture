#

## Lese fra fil

Å lagre personer fra en fil in til en database skjer i 2 steg som uavhening av hverandre.
Selve fil lesningen og database lagringen.

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
    public Person readPerson(){
        try {
            File textFile = new File("persons.txt");

            Scanner scanner = new Scanner(textFile);

            String firstName = scanner.nextLine();
            String lastName = scanner.nextLine();
            String address = scanner.nextLine();
            scanner.nextLine();

            return new Person(firstName, lastName, address);

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }
    }

```

Om vi skal utvide koden til å lese flere personer fra en fil må vi sette en loop i rundt dette

``` java
    public ArrayList<Person> readAllPersons(){
        ArrayList<Person> persons = new ArrayList<>();
        try {
            File textFile = new File("persons.txt");
            Scanner scanner = new Scanner(textFile);

            while(scanner.hasNext()){
                String firstName = scanner.nextLine();
                String lastName = scanner.nextLine();
                String address = scanner.nextLine();
                scanner.nextLine();

                Person person = new Person(firstName, lastName, address);
                persons.add(person);
            }

        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

        return persons;
    }
```
Eneste forskjellen mellom disse to eksemplene er at vi har en liste av person som vi lagrer personene og
vi legger til personen i listen etter å ha laget dem.
Og ikke minst at vi har en loop i rundt lesing av personer.

Vi bruker scanner.hasNext() for å sjekke om det er flere linjer igjen i filen å lese

Merk: Om filen ikke følger strukturen helt kan det hende at dette kan krasje.
Når vi leser 4 linjer etter hverandre så må det faktisk vare 4 linjer igjen i filen.


Når du har lest personer fra filen kan du lagre de i databasen.
Du lagrer dem på sammme måte som om du ikke har lest dem fra en fil

``` java
    private Connection getConnection(){
        try {
            // Lager connection
            // Om connection ikke fungerer (Feil passord etc) så blir det kastet en exception
            // vi ignorer den å lar bare programmet crashe. da å håndtere dette riktig er vanskelig
            return DriverManager.getConnection(URL, username, password);
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }



    public void addPerson(Person person){

        try {

            // Henter connection til databasen
            Connection connection = getConnection();

            // Lager spørringen som skal kjøres på databasen
            // ? er placeholder for verdier vi skal sett inn senere
            // Intellij vil markere det som SQL når du bruker den som SQL query
            String addPersonQuery = "INSERT INTO Persons(firstname, lastname, address) VALUES (?, ?, ?)";

            // Lager en preparedStatement fra stringen over
            PreparedStatement preparedStatement = connection.prepareStatement(addPersonQuery);

            // Her bytter vi ut ? med faktiske verdier
            // i motsetning til array så er første 1 og ikke 0
            // 1 == første ?
            // 2 == andre ?
            preparedStatement.setString(1,person.getFirstName());
            preparedStatement.setString(2,person.getLastName());
            preparedStatement.setString(3,person.getAddress());

            // Kjører statementen
            preparedStatement.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    
    public void addManyPersons(ArrayList<Person> persons){
        // Vi bare bruker samme metode for å legge til en person men vi kjører den i en forEach loop
        for (Person person : persons) {
            addPerson(person);
        }

    }
```

``` java
    public static void main(String[] args) {
        Database database = new Database();
        MyFileReader myFileReader = new MyFileReader();

        // Legge til en person fra filen
        Person personFromFile = myFileReader.readPerson();
        database.addPerson(personFromFile);


        // Legge til alle personer fra filen
        ArrayList<Person> persons = myFileReader.readAllPersons();
        database.addManyPersons(persons);
    }
```