package com.revature.demo.services;

import com.revature.demo.entities.Person;
import com.revature.demo.entities.Pet;
import com.revature.demo.exceptions.PasswordFailedException;
import com.revature.demo.exceptions.PersonNotFoundException;
import com.revature.demo.exceptions.PetNotFoundException;
import com.revature.demo.repositories.PersonRepository;
import com.revature.demo.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    @Autowired
    private PetRepository petRepository;

    public Person register(Person person) {
        person = personRepository.save(person);
        return person;
    }

    public Person login(String username, String password) throws PersonNotFoundException, PasswordFailedException{
        Person personDB = this.personRepository.findByName(username);
        if(personDB == null) throw new PersonNotFoundException();
        if(personDB.getPassword().equals(password)) return personDB;
        else throw new PasswordFailedException();
    }

    public Person adopt(Long personId, Long petId) throws PetNotFoundException, PersonNotFoundException {
        Optional<Pet> petOptional = petRepository.findById(petId);
        if(!petOptional.isPresent()) throw new PetNotFoundException();

        Optional<Person> personOptional = personRepository.findById(personId);
        if(!personOptional.isPresent()) throw new PersonNotFoundException();

        // If we update the person entity and persist those changes back to the db,
        // we'll see that the pet table will be updated to reflect this adoption
        Person person = personOptional.get();
        Pet pet = petOptional.get();

        // add the pet to the person's adoptedPets list
        person.getAdoptedPets().add(pet);
        System.out.println(person);

        // persist these changes and return the person
        person = personRepository.save(person);
        return person;
    }

    public List<Pet> getAdoptedPets(Long personId) {
        return this.petRepository.getAdoptedPets(personId);
    }




}
