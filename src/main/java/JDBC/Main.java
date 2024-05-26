package JDBC;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Person person = new Person("amund", "Myrbostad", "Oslo");
        Database database = new Database();
        database.addPerson(person);

        MyFileReader myFileReader = new MyFileReader();

        Person personFromFile = myFileReader.readPerson();

        database.addPerson(personFromFile);


    }
}
