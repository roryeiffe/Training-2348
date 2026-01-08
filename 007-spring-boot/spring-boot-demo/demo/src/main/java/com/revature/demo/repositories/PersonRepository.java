package com.revature.demo.repositories;

import com.revature.demo.entities.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Long> {

    // find a person record by their name:
    public Person findByName(String name);
}
