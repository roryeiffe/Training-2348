package com.revature.demo.repositories;


import com.revature.demo.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

// Note that we are extending JpaRepository and specifying the
// entity type and the id type for this entity
@Repository // This annotation tells Spring that this repository interface should
// be mapped to a bean and it tells informs the developers what this interface is responsible for
public interface PetRepository extends JpaRepository<Pet, Long> {

    public List<Pet> findByName(String name);

    public List<Pet> findBySpecies(String species);

    @Query(value = "SELECT * FROM pet WHERE person_fk = ?1", nativeQuery = true)
    public List<Pet> getAdoptedPets(Long owner_id);

}
