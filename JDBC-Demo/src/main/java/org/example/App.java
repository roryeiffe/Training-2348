package org.example;

import org.example.data.PetDAO;
import org.example.data.PetDAOImpl;
import org.example.entities.Pet;
import org.example.util.ConnectionFactory;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        ConnectionFactory.getConnection();

        PetDAO petDAO = new PetDAOImpl();

        Pet pet = petDAO.getById(1);
        System.out.println(pet);

        System.out.println(petDAO.getAll());
    }
}
