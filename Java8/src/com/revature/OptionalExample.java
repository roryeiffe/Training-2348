package com.revature;

import java.util.Optional;

public class OptionalExample {
    public static void main(String[] args) {
        // make an empty array:
        String [] words = new String[10];

        // when we create the optional, we are passing in a potentially null value
        Optional<String> optional = Optional.ofNullable(words[3]);
        // Give an explicit value that is not null:
        optional = Optional.ofNullable("cat");

        if(optional.isPresent()) {
            System.out.println(optional.get());
        }
        else {
            System.out.println("the value is null!");
        }
    }
}
