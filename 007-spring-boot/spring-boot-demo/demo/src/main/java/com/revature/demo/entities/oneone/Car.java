package com.revature.demo.entities.oneone;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Car is the owning side of this relationship
// Meaning it has the @JoinColumn annotation
// Does not use mappedBy
// Is responsible for updating the foreign key column
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Car {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String make;
    private String model;
    @OneToOne
    // will create a column in the Car table called "engine_id" which references
    // the primary key in the engine table
    // We specify unique = true to ensure that exactly 1 engine
    // can be mapped to this car (This is essential to making a 1-to-1 relationship
    // otherwise, we could keep inserting entries into the
    // car table that reference the same engine id
    @JoinColumn(name = "engine_id", unique = true)
    private Engine engine;
}
