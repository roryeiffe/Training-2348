package org.example.data;

import org.example.entities.Person;

public interface PersonDAO {
    public Person insert(Person person);
    // because name is unique, we can write a method to fetch by name
    public Person getByName(String name);
}
