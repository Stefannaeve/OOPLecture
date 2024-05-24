package JDBC;

import java.util.Optional;

public class Main {

    public static void main(String[] args) {
        Person person = new Person("amund", "Myrbostad", "Oslo");
        Database database = new Database();
        database.addPerson(person);
//        System.out.println(database.retrievePersonById(1));
//        for (Person person1 : database.retrievePersonByFirstName("amund")) {
//            System.out.println(person1);
//        }

        System.out.println(database.retrievePersonById(5));

        database.updatePerson("stefan", 5);

        System.out.println(database.retrievePersonById(5));


    }
}
