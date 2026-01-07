package org.example.util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.ResourceBundle;

// Creating and returning a connection to our database
// We're using the Factory design pattern as well as the Singleton design pattern to return
// a single instance of the connection object whenever we need it
public class ConnectionFactory {

    // static - this should be scoped to the class
    // private - because the logic for managing the Singleton is contained within this class
        // we don't want external classes to be able to directly modify the connection
    private static Connection connection = null;

    // Make a private constructor so that Java doesn't create a default public constructor
    // Although we normally want our constructors to be public, we can get away this because
        // later on we'll see that we have static methods to interact with this class
    private ConnectionFactory() {

    }

    // this static method is responsible for
    // creating the connection if it is the first time we're requesting it
    // or if the connection is already created, just return that instance
    public static Connection getConnection() {
        // first, check if the connection exists:
        if(connection == null) {
            System.out.println("Creating connection.");
            try {
                // set up a resource bundle to read the credentials:
                ResourceBundle bundle = ResourceBundle.getBundle("DbConfig");

                String url = bundle.getString("url");
                String user = bundle.getString("user");
                String password = bundle.getString("password");
                // first, set up the connection:
                connection = DriverManager.getConnection(url, user, password);
            } catch (SQLException sqlException) {
                sqlException.printStackTrace();
            }
        }
        // either way, return the connection object
        return connection;

    }

}
