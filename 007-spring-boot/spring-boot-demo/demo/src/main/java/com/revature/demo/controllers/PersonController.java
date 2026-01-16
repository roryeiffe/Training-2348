package com.revature.demo.controllers;

import com.revature.demo.dto.LoginDTO;
import com.revature.demo.entities.Person;
import com.revature.demo.entities.Pet;
import com.revature.demo.exceptions.PasswordFailedException;
import com.revature.demo.exceptions.PersonNotFoundException;
import com.revature.demo.exceptions.PetNotFoundException;
import com.revature.demo.services.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin(origins = "*")
@RestController
public class PersonController {
    @Autowired
    private PersonService personService;

    @PostMapping("/register")
    public ResponseEntity<Person> register(@RequestBody Person person) {
        person = this.personService.register(person);
        return new ResponseEntity<>(person, HttpStatus.CREATED);
    }

    // For login, we use a POST request, even though we aren't creating a Person
    // Typically, a login operation would create a session to keep track of who is logged in
    // for our use case, we also need to pass the username/password through the body
    // because these are sensitive fields
    @PostMapping("/login")
    public ResponseEntity<Person> login(@RequestBody LoginDTO loginDTO) throws PasswordFailedException, PersonNotFoundException {
        Person person = this.personService.login(loginDTO.getUsername(), loginDTO.getPassword());
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    // According to REST rules, we pluralize collections of objects
    // We also ids to specify specific records
    // We typically don't include verbs in the path names because
    // the HTTP verb is usually indicative of what the operation is doing
    // localhost:8081/persons/1/pets/1
    @PutMapping("/persons/{personId}/pets/{petId}")
    public ResponseEntity<Person> adopt(@PathVariable("personId") Long personId, @PathVariable("petId") Long petId) throws PetNotFoundException, PersonNotFoundException {
        Person person = this.personService.adopt(personId, petId);
        return new ResponseEntity<>(person, HttpStatus.OK);
    }

    // This method takes a personId from the path and then returns all pets that were
    // adopted by that person
    @GetMapping("/persons/{personId}/pets")
    public ResponseEntity<List<Pet>> getAdopted(@PathVariable("personId") Long personId) {
        List<Pet> pets = this.personService.getAdoptedPets(personId);
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }
}
