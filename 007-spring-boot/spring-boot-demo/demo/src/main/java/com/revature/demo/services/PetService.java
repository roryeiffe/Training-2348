package com.revature.demo.services;

import com.revature.demo.entities.Person;
import com.revature.demo.entities.Pet;
import com.revature.demo.exceptions.PetNotFoundException;
import com.revature.demo.repositories.PetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PetService {

    // as we know, autowired automatically injects the dependency
    // into the field
    // All we are doing is declaring the type of bean we want
    // Spring will handle the creation of the bean for us so it can be used
    // in our code
    // This will NOT work if our PetRepository does not have (@Component or @Repository)
    @Autowired
    PetRepository petRepository;

    // Service methods are pretty concise here, no extra business logic
    public Pet insert(Pet pet) {
        // Because of the @Autowired annotation, we know that
        // Spring will have given us a valid instance that adheres
        // to the petRepository interface
        return this.petRepository.save(pet);
    }

    public Pet getById(Long id) throws PetNotFoundException {
        Optional<Pet> petOptional = petRepository.findById(id);
        if(petOptional.isPresent()) return petOptional.get();
        else throw new PetNotFoundException();
    }

    public List<Pet> getAll() {
        return this.petRepository.findAll();
    }

    public Pet update(Pet pet) throws PetNotFoundException {
        // check if the pet exists before updating:
        if (!this.petRepository.existsById(pet.getId())) {
            throw new PetNotFoundException();
        }
       pet = this.petRepository.save(pet);
       return pet;
    }

    public void delete(Long id) throws PetNotFoundException {
        // check if the pet exists before updating:
        if (!this.petRepository.existsById(id)) {
            throw new PetNotFoundException();
        }
        this.petRepository.deleteById(id);
    }

    public Person getOwner(Long id) {
        Pet pet = this.petRepository.findById(id).orElseThrow();
        Person owner = pet.getOwner();
        return owner;
    }

}
