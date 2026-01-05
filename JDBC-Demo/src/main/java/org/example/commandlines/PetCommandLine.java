package org.example.commandlines;

import org.example.data.PetDAO;
import org.example.data.PetDAOImpl;

import java.util.Scanner;

public class PetCommandLine {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        PetDAO petDAO = new PetDAOImpl();

        int choice = scanner.nextInt();

        switch (choice) {
            case 1:
                System.out.println("Case 1");

        }
    }
}
