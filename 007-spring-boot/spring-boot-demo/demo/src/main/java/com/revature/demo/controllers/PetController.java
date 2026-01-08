package com.revature.demo.controllers;

import com.revature.demo.entities.Pet;
import com.revature.demo.exceptions.PetNotFoundException;
import com.revature.demo.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller // default stereotype for creating controllers
@RestController // Includes @Controller and @ResponseBody (indicates that we are returning
// responses/entities
@RequestMapping("/pets") // this will act as a prefix for all of the
// paths for the requests that we set up in this class:
public class PetController {
    @Autowired
    private PetService petService;

    // Set up our endpoints: CRUD
    // Create POST (POST is the HTTP method used for inserting data)
//    @RequestMapping(value = "/pets", method = RequestMethod.POST)
    @PostMapping
    // We use the @RequestBody annotation to map the request body from the request
    // to the parameter of this method
    public ResponseEntity<Pet> insert(@RequestBody Pet pet) {
        pet = this.petService.insert(pet);
        // construct a response entity, configure the entity to be sent and the
        // status code
        return new ResponseEntity<>(pet, HttpStatus.CREATED);
    }

    // localhost:8081/pets/1
    // if we need to pass in a dynamic value, one option is to use Path Variable
//    @RequestMapping(value = "/pets/{id}", method = RequestMethod.GET)
    @GetMapping("/{id}")
    // We specified how the path should look but we haven't told the method where to get
    // the id value
    public ResponseEntity<Pet> getById(@PathVariable("id") Long id) throws PetNotFoundException {
        Pet pet = this.petService.getById(id);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    // Shortcut that we can use, directly indicate that HTTP type:
    @GetMapping
    public ResponseEntity<List<Pet>> getAll() {
        List<Pet> pets = this.petService.getAll();
        return new ResponseEntity<>(pets, HttpStatus.OK);
    }

    @PutMapping
    public ResponseEntity<Pet> update(@RequestBody Pet pet) throws PetNotFoundException {
        pet = this.petService.update(pet);
        return new ResponseEntity<>(pet, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> delete(@PathVariable("id") Long id) throws PetNotFoundException {
        this.petService.delete(id);
        return new ResponseEntity<>("Pet was deleted!", HttpStatus.OK);
    }

}
