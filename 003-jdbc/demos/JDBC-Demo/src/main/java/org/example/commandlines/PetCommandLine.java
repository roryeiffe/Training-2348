package org.example.commandlines;

import org.example.entities.Pet;
import org.example.exceptions.PetNotFoundException;
import org.example.services.PetService;

import java.util.List;
import java.util.Scanner;

public class PetCommandLine {
    public static void main(String[] args) {
        Scanner scannerInt = new Scanner(System.in);
        Scanner scannerString = new Scanner(System.in);

        PetService petService = new PetService();

        boolean loop = true;

        int petId;
        String name;
        String species;
        String food;

        while (loop) {
            printOptions();
            int choice = scannerInt.nextInt();

            switch (choice) {
                case 1:
                    System.out.println("Name => ");
                    name = scannerString.nextLine();
                    System.out.println("Species => ");
                    species = scannerString.nextLine();
                    System.out.println("Food => ");
                    food = scannerString.nextLine();
                    Pet pet = petService.insert(new Pet(name, species, food));
                    System.out.println("Your pet is " + pet);
                    break;
                case 2:
                    System.out.println("Pet id => ");
                    petId = scannerInt.nextInt();
                    try {
                        System.out.println(petService.getById(petId));
                    } catch (PetNotFoundException petNotFoundException) {
                        System.out.println("The pet with id: " + petId + " was not found.");
                    }
                    break;
                case 3:
                    List<Pet> pets = petService.getAll();
                    for( Pet pet2: pets) {
                        System.out.println(pet2);
                    }
                    break;
                case 4:
                    System.out.println("Pet id => ");
                    petId = scannerInt.nextInt();
                    System.out.println("Name => ");
                    name = scannerString.nextLine();
                    System.out.println("Species => ");
                    species = scannerString.nextLine();
                    System.out.println("Food => ");
                    food = scannerString.nextLine();
                    pet = new Pet(petId, name, species, food);
                    try {
                        petService.update(pet);
                        System.out.println("Pet updated successfully.");
                    } catch (PetNotFoundException petNotFoundException) {
                        System.out.println("Wasn't able to update pet, pet not found.");
                    } catch (Exception exception) {
                        exception.printStackTrace();
                    }
                    break;
                case 5:
                    System.out.println("Pet id => ");
                    petId = scannerInt.nextInt();
                    boolean delete = petService.delete(petId);
                    if (delete) System.out.println("Pet was deleted successfully!");
                    else System.out.println("Something went wrong when deleting the pet.");
                    break;
                case 6:
                    loop = false;
                    break;
                default:
                    System.out.println("Default case");

            }
        }


    }

    public static void printOptions() {
        System.out.println("What would you like to choose?");
        System.out.println("1 - Insert Pet");
        System.out.println("2 - Get Pet By Id");
        System.out.println("3 - Get All Pets");
        System.out.println("4 - Update Pet");
        System.out.println("5 - Delete Pet");
        System.out.println("6 - Quit");
        System.out.print("=> ");
    }
}
