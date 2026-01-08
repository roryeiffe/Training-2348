package com.revature.demo.entities;

import jakarta.persistence.*;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


// We know that this entity should be persisted to a database:
// There are some exceptions we can include to specify how we map this entity to a relation
// Object-Relational Mapping
@Entity(name="pet") // specify the name of the table in the db
public class Pet {
    @Id // specifies PK for this field
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id") // specify that this field is mapped to a column in the table:
    private Long id;
    @Column(name = "pet_name")
    private String name;
    @Column(name = "species")
    private String species;
    @Column(name = "food")
    private String food;

    public Pet(Long id, String name, String species, String food) {
        this.id = id;
        this.name = name;
        this.species = species;
        this.food = food;
    }

    public Pet() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSpecies() {
        return species;
    }

    public void setSpecies(String species) {
        this.species = species;
    }

    public String getFood() {
        return food;
    }

    public void setFood(String food) {
        this.food = food;
    }

    @Override
    public String toString() {
        return "Pet{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", species='" + species + '\'' +
                ", food='" + food + '\'' +
                '}';
    }
}
