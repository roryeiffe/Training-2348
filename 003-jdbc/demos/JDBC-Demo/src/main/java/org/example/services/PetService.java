package org.example.services;

import org.example.data.PetDAO;
import org.example.data.PetDAOImpl;
import org.example.entities.Pet;
import org.example.exceptions.PetNotFoundException;

import java.util.List;

public class PetService {
    // we create a field here that stores the DAO instance
    private PetDAO petDAO;


    // TODO: Create a DAO Factory:
    public PetService() {
        this.petDAO = new PetDAOImpl();
    }

    // The purpose of this method is to just call the corresponding DAO method and returning the result:
    public Pet insert(Pet pet) {
        return this.petDAO.insert(pet);
    }

    public Pet getById(int id) throws PetNotFoundException {
        Pet pet = this.petDAO.getById(id);
        if (pet == null) throw new PetNotFoundException();
        else return pet;
    }

    public List<Pet> getAll() {
        return this.petDAO.getAll();
    }

    public Pet update(Pet pet) throws PetNotFoundException, Exception{
        return this.petDAO.update(pet);
    }

    public boolean delete(int id) {
        // Check if the pet exists:
        Pet pet = this.petDAO.getById(id);
        if(pet == null) {
            System.out.println("Pet does not exist so can't be deleted.");
            return false;
        }
        return this.petDAO.delete(id);
    }
}
