package JDBC;

import java.util.ArrayList;
import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Person person = new Person("amund", "Myrbostad", "Oslo");
        Database database = new Database();
        database.addPerson(person);

        MyFileReader myFileReader = new MyFileReader();

        // Legge til en person fra filen
//        Person personFromFile = myFileReader.readPerson();
//        database.addPerson(personFromFile);


        // Legge til alle personer fra filen
        ArrayList<Person> persons = myFileReader.readAllPersons();
        database.addManyPersons(persons);

    }
}
