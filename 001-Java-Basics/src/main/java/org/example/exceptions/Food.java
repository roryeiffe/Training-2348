package org.example.exceptions;

//Food is a Model Class - we're going to use it to "model" food items.
//We typically make objects out of Model Classes.

public class Food {

    public String name;
    public boolean isCookie;

    //all-args constructor so we can make food objects with values we provide
    public Food (String name, boolean isCookie){
        this.name = name;
        this.isCookie = isCookie;
    }

}