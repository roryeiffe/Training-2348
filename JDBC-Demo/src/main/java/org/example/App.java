package org.example;

import org.example.data.PersonDAO;
import org.example.data.PersonDAOImpl;
import org.example.data.PetDAO;
import org.example.data.PetDAOImpl;
import org.example.entities.Person;
import org.example.entities.Pet;
import org.example.services.PersonService;
import org.example.services.PetService;
import org.example.util.ConnectionFactory;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ConnectionFactory.getConnection();

        PetDAO petDAO = new PetDAOImpl();
        PersonDAO personDAO = new PersonDAOImpl();

//        Pet pet = petDAO.getById(1);
//        System.out.println(pet);
//
//        System.out.println(petDAO.getAll());
//
//        Pet pet2 = new Pet("Gollum from Java", "Cat", "Chicken");
//
//        petDAO.insert(pet2);
//
//        System.out.println("Pet after insertion: " + pet2);
//
//        // make an edit to the Java object:
//        pet2.setFood("cat food.");
//        pet2 = petDAO.update(pet2);
//        System.out.println(pet2);
//
//        System.out.println(petDAO.delete(4));
//
//
//        // People:
//        Person person = new Person("Velma", "ilovescoob");
//
//        person = personDAO.insert(person);
//
//        System.out.println(person);
//
//        Person person2 = personDAO.getByName("Shaggy");
//
//        System.out.println(person2);


//        System.out.println(petDAO.adopt(2, 14));
//        System.out.println(petDAO.adopt(2, 1));
//        System.out.println(petDAO.adopt(2, 5));
//
//        System.out.println(petDAO.adopt(3, 2));
//        System.out.println(petDAO.adopt(3, 3));
//
//        System.out.println(petDAO.getAdoptedPets(2));
//        System.out.println(petDAO.getAdoptedPets(3));

        PetService petService = new PetService();

        petService.insert(new Pet("Smeagol", "cat", "cat food"));

        PersonService personService = new PersonService();
        personService.adopt("Velma", 6);
        System.out.println(personService.getAdoptedPets("Velma"));


    }
}
