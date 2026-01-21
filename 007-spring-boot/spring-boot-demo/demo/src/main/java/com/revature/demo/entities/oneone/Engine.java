package com.revature.demo.entities.oneone;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// Engine is the inverse side of the relationship
// Meaning:
// Uses mappedBy
// Does NOT use @JoinColumn
@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
public class Engine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private int power;
    private String type;

    // when we specify mappedBy, we are saying that this relationship
    // is mapped by the "engine" field in the Car class
    @OneToOne(mappedBy = "engine")
    private Car car;
}
