package org.example.exceptions;

//This is a CUSTOM EXCEPTION. If Java's built-in Exceptions don't suit your needs...
//Simply make your own by extending whatever Exception fits your needs
//In this case, I have no specific needs, I just need this Class to be an Exception
public class NotACookieException extends Exception{

    //Most of the time, our custom Exceptions just need one constructor
    //This constructor usually takes a String message to provide feedback
    public NotACookieException(String message){
        super(message); //super()? This calls the parent class's constructor
    }


}
