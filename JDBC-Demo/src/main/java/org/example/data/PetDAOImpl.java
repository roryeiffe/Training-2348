package org.example.data;

import org.example.entities.Pet;
import org.example.util.ConnectionFactory;

import java.sql.*;

import java.util.ArrayList;
import java.util.List;

public class PetDAOImpl implements PetDAO{
    // set up a connection object so that we can interact with the db:
    Connection connection;

    public PetDAOImpl() {
        connection = ConnectionFactory.getConnection();
    }

    @Override
    public Pet insert(Pet pet) {
        return null;
    }

    // getting a pet by id:
    @Override
    public Pet getById(int id) {
        // set up SQL string
        // use ? as a placeholder for dynamic values:
        String sql = "SELECT * FROM pet WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            // set the field at index 1 (not 0-based so this is the first and only param) with the value that we pass in to this method
            preparedStatement.setInt(1, id);

            // execute or send the query to the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // we can check if a valid result exists in this ResultSet:
            if(resultSet.next()) {
                // now that the pointer is pointing to the first (and only) result, we can extract:
                int idDb = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String species = resultSet.getString("species");
                String food = resultSet.getString("food");

                // return the pet object:
                Pet pet = new Pet(idDb, name, species, food);
                return pet;
            }
            else {
                System.out.println("Something went wrong when retrieving the pet.");
                return null;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        // if we get here and nothing has been returned yet, we can return null:
        return null;
    }

    @Override
    public List<Pet> getAll() {
        List<Pet> pets = new ArrayList<>();

        String sql = "SELECT * FROM pet;";

        try {
            Statement statement = connection.createStatement();

            ResultSet resultSet = statement.executeQuery(sql);

            // note that we use a while loop to traverse the result set
            while(resultSet.next()) {
                // now that the pointer is pointing to the first (and only) result, we can extract:
                int idDb = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String species = resultSet.getString("species");
                String food = resultSet.getString("food");

                // return the pet object:
                Pet pet = new Pet(idDb, name, species, food);

                pets.add(pet);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
            return null;
        }
        return pets;
    }

    @Override
    public Pet update(Pet pet) {
        return null;
    }

    @Override
    public boolean delete(int id) {
        return false;
    }
}
