package JDBC;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

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

    public void updatePerson(String newFirstName,  int id){
        try {
            Connection connection = getConnection();
            String updateQuery = "update persons set firstName = ? where id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(updateQuery);

            preparedStatement.setString(1, newFirstName);
            preparedStatement.setInt(2, id);


            preparedStatement.executeUpdate();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }





    public Person retrievePersonById(int id){
        try {
            Connection connection = getConnection();
            String personQuery = "SELECT * FROM Persons WHERE Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(personQuery);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            // Siden vi tar by Id forventer vi bare 1 Person
            if (resultSet.next()){
                String firstNameFromDatabase = resultSet.getString("firstName");
                String lastNameFromDatabase = resultSet.getString("lastName");
                String addressFromDatabase = resultSet.getString("address");
                int personIdFromDatabase = resultSet.getInt("Id");
                return new Person(personIdFromDatabase, firstNameFromDatabase, lastNameFromDatabase, addressFromDatabase);
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return null;
    }


    public List<Person> retrievePersonByFirstName(String firstName){
        List<Person> personList = new ArrayList<>();


        try {
            Connection connection = getConnection();
            String personQuery = "SELECT * FROM Persons WHERE FirstName = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(personQuery);

            preparedStatement.setString(1, firstName);

            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()){
                String firstNameFromDatabase = resultSet.getString("firstName");
                String lastNameFromDatabase = resultSet.getString("lastName");
                String addressFromDatabase = resultSet.getString("address");
                int personIdFromDatabase = resultSet.getInt("Id");
                personList.add( new Person(personIdFromDatabase, firstNameFromDatabase, lastNameFromDatabase, addressFromDatabase));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }


        return personList;
    }

    /***
     * En mer korrekt måtte å gjøre dette på. om den ikke finner en person så returner vi ikke null men heller et tomt optional
     * @param id
     * @return Optinal av person
     */
    public Optional<Person> retrievePersonByIdImproved(int id){
        try {
            Connection connection = getConnection();
            String personQuery = "SELECT * FROM Persons WHERE Id = ?";
            PreparedStatement preparedStatement = connection.prepareStatement(personQuery);

            preparedStatement.setInt(1, id);

            ResultSet resultSet = preparedStatement.executeQuery();
            // Siden vi tar by Id forventer vi bare 1 Person
            if (resultSet.next()){
                String firstName = resultSet.getString("firstName");
                String lastName = resultSet.getString("lastName");
                String address = resultSet.getString("address");
                int personId = resultSet.getInt("Id");

                return Optional.of(new Person(personId, firstName, lastName, address));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return Optional.empty();
    }

    public void addPersonImproved(Person person){
        try {

            // Henter connection til databasen
            Connection connection = getConnection();

            // Lager spørringen som skal kjøres på databasen
            // ? er placeholder for verdier vi skal sett inn senere
            // Intellij vil markere det som SQL når du bruker den som SQL query
            String addPersonQuery = "INSERT INTO Persons(firstname, lastname, address) VALUES (?, ?, ?)";

            // Lager en preparedStatement fra stringen over
            // Vi sier at den skal gi oss genererte keys (id) tilbake
            PreparedStatement preparedStatement = connection.prepareStatement(addPersonQuery, PreparedStatement.RETURN_GENERATED_KEYS);

            // Her bytter vi ut ? med faktiske verdier
            // i motsetning til array så er første 1 og ikke 0
            // 1 == første ?
            // 2 == andre ?
            preparedStatement.setString(1,person.getFirstName());
            preparedStatement.setString(2,person.getLastName());
            preparedStatement.setString(3,person.getAddress());

            // Kjører statementen
            int rowsaffected = preparedStatement.executeUpdate();

            // oppdaterer Id på person som ble lagt til
            if(rowsaffected > 0){
                ResultSet generatedKeys = preparedStatement.getGeneratedKeys();
                if (generatedKeys.next()) {
                    int insertId = generatedKeys.getInt(1);
                    person.setId(insertId);
                }
            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
}
