package com.revature.demo.entities;

import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;


@Entity
public class Person {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique=true, nullable=false)
    private String name;
    private String password;

    // set up person-pet relationship, person can adopt many pets:
    @OneToMany(targetEntity=Pet.class, cascade=CascadeType.ALL)
    @JoinColumn(name="person_fk", referencedColumnName = "id")
    @JsonManagedReference // will serialize this when sending from controller
    private List<Pet> adoptedPets;


    public Person(Long id, String name, String password, List<Pet> adoptedPets) {
        this.id = id;
        this.name = name;
        this.password = password;
        this.adoptedPets = adoptedPets;
    }

    public Person() {
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public List<Pet> getAdoptedPets() {
        return adoptedPets;
    }

    public void setAdoptedPets(List<Pet> adoptedPets) {
        this.adoptedPets = adoptedPets;
    }

    @Override
    public String toString() {
        return "Person{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", password='" + password + '\'' +
                ", adoptedPets=" + adoptedPets +
                '}';
    }
}
