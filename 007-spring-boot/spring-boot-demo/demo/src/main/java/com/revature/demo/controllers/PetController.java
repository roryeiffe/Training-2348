package com.revature.demo.controllers;

import com.revature.demo.entities.Pet;
import com.revature.demo.services.PetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

//@Controller // default stereotype for creating controllers
@RestController // Includes @Controller and @ResponseBody (indicates that we are returning
// responses/entities
public class PetController {
    @Autowired
    private PetService petService;

    // Set up our endpoints: CRUD
    // Create POST (POST is the HTTP method used for inserting data)
    @RequestMapping(value = "/pets", method = RequestMethod.POST)
    public Pet insert(@RequestBody Pet pet) {
        System.out.println(pet.toString());
        return this.petService.insert(pet);
    }

    // localhost:8081/pets/1
    // if we need to pass in a dynamic value, one option is to use Path Variable
    @RequestMapping(value = "/pets/{id}", method = RequestMethod.GET)
    // We specified how the path should look but we haven't told the method where to get
    // the id value
    public Pet getById(@PathVariable("id") Long id) {
        return this.petService.getById(id);
    }

    // Shortcut that we can use, direclty indicate that HTTP type:
    @GetMapping(value = "/pets")
    public List<Pet> getAll() {
        return this.petService.getAll();
    }

}
