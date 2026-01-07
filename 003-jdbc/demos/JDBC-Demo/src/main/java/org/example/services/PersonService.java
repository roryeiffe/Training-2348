package org.example.services;

import org.example.data.PersonDAO;
import org.example.data.PersonDAOImpl;
import org.example.data.PetDAO;
import org.example.data.PetDAOImpl;
import org.example.entities.Person;
import org.example.entities.Pet;
import org.example.exceptions.PasswordIncorrectException;
import org.example.exceptions.PetAlreadyAdoptedException;
import org.example.exceptions.PetNotFoundException;

import java.util.ArrayList;
import java.util.List;

public class PersonService {
    private PersonDAO personDAO;
    private PetDAO petDAO;

    public PersonService() {
        this.personDAO = new PersonDAOImpl();
        this.petDAO = new PetDAOImpl();
    }

    // When we register, we just want to insert the entity to the table:
    public Person register(Person person) {
        return this.personDAO.insert(person);
    }

    public Person login(String name, String password) throws PasswordIncorrectException {
        Person personDB = this.personDAO.getByName(name);

        if (personDB.getPassword().equals(password)) {
            return personDB;
        }
        else {
            throw new PasswordIncorrectException();
        }
    }

    // adopt
    public boolean adopt(String personName, int petID) throws PetNotFoundException, PetAlreadyAdoptedException {
        if (petDAO.isAdopted(petID)) {
            throw new PetAlreadyAdoptedException();
        }
        Person person = personDAO.getByName(personName);
        if (person == null) {
            System.out.println("Person's name is invalid.");
            return false;
        }
        return this.petDAO.adoptProcedure(person.getId(), petID);
    }

    // getAdoptedPets
    public List<Pet> getAdoptedPets(String personName) {
        Person person = this.personDAO.getByName(personName);
        if (person == null) {
            System.out.println("Person's name is invalid.");
            return new ArrayList<>();
        }
        return this.petDAO.getAdoptedPets(person.getId());
    }
}
