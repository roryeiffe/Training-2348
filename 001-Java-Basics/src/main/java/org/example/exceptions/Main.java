package org.example.exceptions;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Arrays;

public class Main {

    //We set main to throw NotACookieException - but there's nowhere to throw it.
    //So your code will still fail! There should always be a try-catch at the end of a throws chain
    //It's common for a method to throw an Exception to be handled elsewhere, but it must end in a try/catch.
    public static void main(String[] args) throws NotACookieException{

        //Causing a StackOverflowError
        //causeStackOverflow();

        System.out.println("===============(Throwing some Unchecked AKA Runtime Exceptions)");

        //ArithmeticException - Something has gone wrong mathematically
        System.out.println("Trying to divide by zero");

        //1 of 2 ways to "handle" Exceptions - the try-catch block.
        //-You "try" to execute some logic, and "catch" any resulting Exceptions,
        //-Diverting the logic instead letting the app crash.
        try{
            int i = 5 / 0;
        } catch (ArithmeticException e){
            System.out.println("Arithmetic Exception! " + e.getMessage());
        }

        //ArrayIndexOutOfBoundsException - Trying to access an array index that doesn't exist
        System.out.println("Trying to access in invalid array index");

        int[] arr = {1, 2, 3, 4, 5, 6, 7, 8, 9, 10};

        //This time, we'll have a try-catch-finally block.
        //Finally is an optional block that lets you execute some code at the end of the try-catch. It always runs.
        try{
            System.out.println(arr[20]);
        } catch (NullPointerException e){
            System.out.println("This will not run - no NullPointerException was thrown.");
        } catch (ArrayIndexOutOfBoundsException e){
            //This one runs :)
            System.out.println("This Array index doesn't exist! " + e.getMessage());
        } catch (Exception e){
            System.out.println("This is common practice!" +
                    "a catch for a generic Exception at the end catches any " +
                    "unaccounted for exceptions. A good safety net");
        } finally {
            System.out.println(Arrays.toString(arr));
        }

        //Rule of thumb for catch blocks: Most specific to least specific

        System.out.println("====================(Checked Exceptions AKA Compile-Time Exceptions)");

        //Checked Exceptions are noticed by the compiler - you can't compile with an unhandled Checked Exception

        //throw new RuntimeException("The compiler will let me do this! It's a RuntimeException");

        //throw new Exception("The compile WON'T LET ME DO THIS! It's a Checked Exception");
        //throw new IOException("This is used when something related to Input/Output goes wrong");
        //throw new FileNotFoundException("This is a child of IOException - some file you're referencing doesn't exist");

        System.out.println("===================(Using our Custom Exception)");

        //Make some Food objects and a CookieEatingMonster object
        Food food1 = new Food("Steak", false);
        Food food2 = new Food("Snickerdoodle", true);
        CookieEatingMonster monster = new CookieEatingMonster();

        //Let's try to feed the monster!
        monster.eatCookieWithTryCatch(food1); //not a cookie
        monster.eatCookieWithTryCatch(food2); //is a cookie

        //Let's try to feed the monster via the throws method instead
        monster.eatCookieWithThrows(food1); //not a cookie AND the compiler complains


    } //end of main------

    //This method will call itself to cause a StackOverFlowError
    public static void causeStackOverflow(){
        System.out.println("StackOverflowError pending...");
        causeStackOverflow();
    }

}
