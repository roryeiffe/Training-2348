package org.example.commandlines;

import org.example.entities.Person;
import org.example.entities.Pet;
import org.example.exceptions.PasswordIncorrectException;
import org.example.exceptions.PetAlreadyAdoptedException;
import org.example.exceptions.PetNotFoundException;
import org.example.services.PersonService;
import org.example.services.PetService;

import java.util.List;
import java.util.Scanner;

public class PersonCommandLine {
    public static void main(String[] args) {
        Scanner scannerString = new Scanner(System.in);
        Scanner scannerInt = new Scanner(System.in);

        PersonService personService = new PersonService();
        PetService petService = new PetService();

        boolean loop = true;
        int choice;

        int personId;
        int petId;
        String name;
        String password;

        // used to store the currently logged in person:
        Person person = null;

        while(loop) {
            printOptions();
            choice = scannerInt.nextInt();
            switch(choice) {
                case 1:
                    System.out.println("Name => ");
                    name = scannerString.nextLine();
                    System.out.println("Password => ");
                    password = scannerString.nextLine();
                    person = new Person (name, password);
                    person = personService.register(person);
                    break;
                case 2:
                    System.out.println("Name => ");
                    name = scannerString.nextLine();
                    System.out.println("Password => ");
                    password = scannerString.nextLine();
                    try {
                        person = personService.login(name, password);
                        System.out.println("Login successful!");
                    } catch (PasswordIncorrectException e) {
                        System.out.println("Password is incorrect!");
                    }
                    break;
                case 3:
                    if (person == null) {
                        System.out.println("Must be logged in to adopt");
                        break;
                    }
                    System.out.println("Adopt");
                    for(Pet pet_: petService.getAll()) {
                        System.out.println(pet_);
                    }
                    System.out.println("Which pet would you like to adopt (Enter id) =>");
                    petId = scannerInt.nextInt();
                    try {
                        personService.adopt(person.getName(), petId);
                        System.out.println("Pet adopted successfully!");
                    } catch (PetNotFoundException e) {
                        System.out.println("Pet does not exist!");
                    } catch (PetAlreadyAdoptedException e) {
                        System.out.println("Pet is already adopted.");
                    }
                    break;
                case 4:
                    if (person == null) {
                        System.out.println("Must be logged in to view adopted pets");
                        break;
                    }
                    List<Pet> pets = personService.getAdoptedPets(person.getName());
                    for(Pet pet2: pets) {
                        System.out.println(pet2);
                    }
                    break;
                case 5:
                    loop = false;
                    break;
            }


        }

    }

    public static void printOptions() {
        System.out.println("What would you like to do?");
        System.out.println("1 - Register");
        System.out.println("2 - Login");
        System.out.println("3 - Adopt");
        System.out.println("4 - View Adopted Pets");
        System.out.println("5 - Quit");
    }
}
