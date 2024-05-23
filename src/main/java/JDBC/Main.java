package JDBC;

public class Main {

    public static void main(String[] args) {
        Person person = new Person("amund", "Myrbostad", "Oslo");
        Database database = new Database();
        database.addPerson(person);
    }
}
