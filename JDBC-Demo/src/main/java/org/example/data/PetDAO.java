package org.example.data;

import org.example.entities.Pet;

import java.util.List;

// CRUD Methods
public interface PetDAO {
    // CREATE
    public Pet insert(Pet pet);

    // READ (2 different read methods):
    public Pet getById(int id);
    public List<Pet> getAll();

    // UPDATE
    public Pet update(Pet pet);

    // DELETE:
    public boolean delete(int id);
}
