package JDBC;

import com.mysql.cj.xdevapi.PreparableStatement;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class Database {

    // Url til database serveren
    // <protocol>://<Adresse>:<Port><Database>
    // Protocol her er jdbc:mysql
    // localhost == egen maskin
    // 3306 standard port for mysql
    // bios = navnet på databasen
    private final String URL = "jdbc:mysql://localhost:3306/bios";
    private final String username = "root";
    private final String password = "root";

    public Connection getConnection(){
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

        // Henter connection til databasen
        Connection connection = getConnection();

        // Lager spørringen som skal kjøres på databasen
        // ? er placeholder for verdier vi skal sett inn senere
        // Intellij vil markere det som SQL når du bruker den som SQL query
        String addPersonQuery = "INSERT INTO Persons(firstname, lastname, address) VALUES (?, ?, ?)";
        try {

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
}
