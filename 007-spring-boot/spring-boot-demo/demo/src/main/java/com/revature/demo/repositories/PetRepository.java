package com.revature.demo.repositories;


import com.revature.demo.entities.Pet;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

// Note that we are extending JpaRepository and specifying the
// entity type and the id type for this entity
@Repository // This annotation tells Spring that this repository interface should
// be mapped to a bean and it tells informs the developers what this interface is responsible for
public interface PetRepository extends JpaRepository<Pet, Long> {
}
