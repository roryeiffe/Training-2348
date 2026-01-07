package org.example.data;

import org.example.entities.Pet;
import org.example.exceptions.PetNotFoundException;
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
        String sql = "insert into pet(id, name, species, food, owner_id) values (default, ?, ?, ?, 1)";

        try {
            // to get the generated id value, we have to pass in a flag:
            PreparedStatement preparedStatement = connection.prepareStatement(sql, Statement.RETURN_GENERATED_KEYS);

            // fill in the parameters:
            preparedStatement.setString(1, pet.getName());
            preparedStatement.setString(2, pet.getSpecies());
            preparedStatement.setString(3, pet.getFood());

            // use executeUpdate() for insert, update, delete:
            int count = preparedStatement.executeUpdate();

            // if exactly 1 row was updated, we know this insertion was successful:
            if(count == 1) {
                // we want to return the full pet object (with the generated id)
                ResultSet resultSet = preparedStatement.getGeneratedKeys();

                // increment the resultSet so it points to the generated value
                resultSet.next();

                // can extract the id:
                int generatedId = resultSet.getInt(1);

                // set the corresponding pet object's id field:
                pet.setId(generatedId);
            }

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return pet;
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
    public boolean isAdopted(int id) throws PetNotFoundException {
        String sql = "SELECT * FROM pet WHERE id = ?";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            // execute or send the query to the database
            ResultSet resultSet = preparedStatement.executeQuery();

            // we can check if a valid result exists in this ResultSet:
            if(resultSet.next()) {
                int owner_id = resultSet.getInt("owner_id");
                if (owner_id == 1) return false;
                else return true;
            }
            else {
                throw new PetNotFoundException();

            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        throw new PetNotFoundException();
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
    public Pet update(Pet pet) throws PetNotFoundException, Exception {
        String sql = "UPDATE pet set name=?, species=?, food=? WHERE id=?;";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);

            preparedStatement.setString(1, pet.getName());
            preparedStatement.setString(2, pet.getSpecies());
            preparedStatement.setString(3, pet.getFood());
            preparedStatement.setInt(4, pet.getId());

            int count = preparedStatement.executeUpdate();

            if(count == 1) {
                return pet;
            }
            else if (count == 0) {
                throw new PetNotFoundException();
            }
            else {
                throw new Exception();
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return null;
    }

    @Override
    public boolean delete(int id) {
        String sql = "DELETE FROM pet WHERE id =?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);

            int count = preparedStatement.executeUpdate();

            if(count == 1) {
                return true;
            }
            else {
                return false;
            }
        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        // If we reach this, that means that some exception was thrown, so we return false since the delete didn't happen
        return false;
    }

    @Override
    public boolean adopt(int personId, int petId) {
        String sql = "UPDATE pet SET owner_id = ? WHERE id = ?;";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, personId);
            preparedStatement.setInt(2, petId);
            int count = preparedStatement.executeUpdate();

            if(count == 1) return true;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }

    // For this method to work, we need the following procedure defined in our database:
    /*
    -- Stored Procedure - perform some actions, like adopting a pet:
    create or replace procedure adopt(new_owner_id integer, pet_id integer)
    language plpgsql
    as $$
    declare -- in this block, we can define our variables
    p_current_owner_id integer;
    begin
	-- first, we want to find the pet's owner and store it in the variable we created:
            -- the WHERE condition finds the correct pet
	-- on the SELECT side, we're taking the owner_id and storing "into" the p_current_owner_id
    select owner_id into p_current_owner_id from pet where id = pet_id;

	-- now that we have the current owner id, we can check if the pet is already adopted:
            if p_current_owner_id = 1 then -- if the pet is stil at the shelter, we adopt, otherwise
    update pet set owner_id = new_owner_id where id = pet_id;
    end if;
    end;
    $$;
    */
    @Override
    public boolean adoptProcedure(int personId, int petId) {
        String sql = "call adopt(?, ?);";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, personId);
            preparedStatement.setInt(2, petId);
            int count = preparedStatement.executeUpdate();

            // count might be innacurate because count typically returns the number of rows that were affected
            // but our procedure isn't returning anything so, -1 is just an indication that we don't know the number of rows that were updated
            System.out.println("Count: " + count);
            return true;

        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }
        return false;
    }



    @Override
    public List<Pet> getAdoptedPets(int personId) {
        String sql = "SELECT * FROM pet WHERE owner_id = ?;";
        List<Pet> adoptedPets = new ArrayList<>();

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, personId);
            ResultSet resultSet = preparedStatement.executeQuery();

            while(resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String species = resultSet.getString("species");
                String food = resultSet.getString("food");

                Pet pet = new Pet(id, name, species, food);
                adoptedPets.add(pet);
            }


        } catch (SQLException sqlException) {
            sqlException.printStackTrace();
        }

        return adoptedPets;
    }
}
