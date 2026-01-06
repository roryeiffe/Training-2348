package org.example.data;

import org.example.entities.Pet;
import org.example.exceptions.PetNotFoundException;

import java.util.List;

// CRUD Methods
public interface PetDAO {
    // CREATE
    public Pet insert(Pet pet);

    // READ (2 different read methods):
    public Pet getById(int id);
    public List<Pet> getAll();

    // UPDATE
    public Pet update(Pet pet) throws PetNotFoundException, Exception;

    // DELETE:
    public boolean delete(int id);

    // Check if pet is adopted:
    public boolean isAdopted(int id) throws PetNotFoundException;

    // Adopt a pet (associate a pet record with a person's record using the foreign key)
    public boolean adopt(int personId, int petId);

    // Get Adopted Pets: Given a person's id, we want to return all corresponding pets:
    public List<Pet> getAdoptedPets(int personId);
}
