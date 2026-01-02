package org.example.exceptions;

//This Class represents a monster that only eats cookies. A cookie monster if you will
//It will have two methods that take in a Food object and throw an Exception if it's not a cookie
public class CookieEatingMonster {

    //This method takes in a Food object and uses try/catch to handle Exceptions
    public void eatCookieWithTryCatch(Food food){
        try{
            System.out.println("Trying to eat the " + food.name);
            if(food.isCookie){
                System.out.println("I love to eat cookies :)");
            } else{
                //remember "throw" is the keyword that creates Exceptions
                throw new NotACookieException("I don't eat " + food.name + " :(");
            }
        } catch(NotACookieException e){
            System.out.println("NotACookieException caught! " + e.getMessage());
            //printStackTrace() can be useful - it prints the stack trace
            //stack traces shows info like the path, line number, and type of exception
            e.printStackTrace();
        }
    }


    //This method takes in a Food object and uses throws to pass the Exception handling to the method that called it
    public void eatCookieWithThrows(Food food) throws NotACookieException {

        if(food.isCookie){
            System.out.println("I still love cookies. Thank you for the Cookie.");
        } else {
            throw new NotACookieException("I still don't eat " + food.name + " >:(");
        }

    }

}
