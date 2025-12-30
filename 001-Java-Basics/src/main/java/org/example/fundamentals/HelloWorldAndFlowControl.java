package org.example.fundamentals;

import java.util.Date;
import java.util.InputMismatchException;
import java.util.Scanner;

public class HelloWorldAndFlowControl {
    public static void main(String[] args) {
//        System.out.println("Hello World");
//        primitiveDemo();
//        flowControl();
        switchStatements();


    }

    public static void switchStatements() {
        boolean menuBoolean = true;
        // continually running
        while(menuBoolean) {
            // switch statements let us check conditions on a single variable with some slightly different syntax:
            System.out.println("Please select your option:");
            System.out.println("1. Get Today's Date");
            System.out.println("2. See Menu Options.");
            System.out.println("3. Go to the Upside-Down");
            System.out.println("4. Quit.");

            // To read in user input, we need an instance of the scanner class
            Scanner scanner = new Scanner(System.in);

            System.out.print("=> ");
//            String userChoiceString = scanner.nextLine();
//            System.out.println(userChoiceString);

            // convert the string to an integer:
            // ensure that value passed in is an integer
//            int userChoice = Integer.valueOf(userChoiceString);

            // try blocks let us test out code that could throw exceptions and provide a route to take if said exception is thrown
            int userChoice;
            try {
               userChoice = scanner.nextInt();
               // if Java detects that we can't convert the value to an integer, this catch block will triger
                // which will allow the program to keep running while giving us feedback:
            } catch(InputMismatchException e) {
                System.out.println("Please enter a number");
                // go to the next iteration of the loop  (skipping the switch statement)
                continue;
            }

//         we pass in the variable that we want to evaluate
            switch(userChoice) {
                case 1:
                    // instantiating an object:
                    Date current_date = new Date();
                    System.out.println(current_date);
                    break;
                case 2:
                    System.out.println("Hamburgers, Pizza, Steak");
                    // without this break statement, if this case triggers, then the subsequence cases will trigger until we reach a break
                    break;
                case 3:
                    System.out.println("Good luck and watch out for Demogorgons.");
                    break;
                case 4:
                    menuBoolean = false;
                    break;
                default:
                    System.out.println("Please pick an option from 1-3");
                    break;
            }
        }


//        if(userChoice == 1)
//            System.out.println("12-29-2025");
//        }
//        else if (userChoice == 2) {
//            System.out.println("Hamburgers, Pizza, Steak");
//        }
    }

    public static void flowControl() {
        // if statements and else statements
        int age = 17;

        int requirement = 18;

        if( age >= requirement ) {
            System.out.println("You can vote!");
        }
        else if(age == 17) {
            System.out.println("You cannot vote. Wait one more year.");
        }
        else {
            System.out.println("You cannot vote.");
        }

        // loops:
        age = 20;
        while(age < 16) {
            System.out.println("You cannot drive yet. Your age is currently: " + age);
            // aging by one year:
            age ++;
        }
        System.out.println("You can now drive!");

        int counter = 8;
        // always going to have the block of code execute at least once:
        do {
            System.out.println("Counter is : " + counter);
            counter ++;
        } while (counter < 10);

        // simple for loop that counts to 14:
        for (int i = 0; i < 15; i ++ ){
            System.out.println("Printing i: " + i);
        }



    }

    public static void primitiveDemo() {
        System.out.println("This is the primitive demo.");
        int grade = 99;
        char c = 'r';
        boolean b = true;
        b = false;
        double d = 3.14;

        System.out.println("Your grade is: " + grade);

        System.out.print("Character: " + c);

        System.out.println(d);
    }

//    public static void helper() {
//        System.out.println("Helper");
//    }
}
