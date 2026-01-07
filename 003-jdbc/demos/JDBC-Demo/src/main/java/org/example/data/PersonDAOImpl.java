package org.example.data;

import org.example.entities.Person;
import org.example.util.ConnectionFactory;

import java.sql.*;

public class PersonDAOImpl implements PersonDAO {

    Connection connection;

    public PersonDAOImpl() {
        connection = ConnectionFactory.getConnection();
    }


    @Override
    public Person insert(Person person) {
        String sql = "insert into person values(default, ?, ?);";

        try {

            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            preparedStatement.setString(1, person.getName());
            preparedStatement.setString(2, person.getPassword());

            int count = preparedStatement.executeUpdate();

            if(count == 1) {
                ResultSet resultSet = preparedStatement.getGeneratedKeys();
                resultSet.next();
                int generatedId = resultSet.getInt(1);

                person.setId(generatedId);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
        return person;

    }

    @Override
    public Person getByName(String name) {
        String sql = "SELECT * FROM person WHERE name=?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, name);
            ResultSet resultSet = preparedStatement.executeQuery();

            if(resultSet.next()) {
                // retrieve everything from the db:
                int id = resultSet.getInt("id");
                String nameDB = resultSet.getString("name");
                String password = resultSet.getString("password");
                Person person = new Person(id, nameDB, password);
                return person;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return null;
    }
}
