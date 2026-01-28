package com.revature.workshop.repositories;

import com.revature.workshop.models.Workshop;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository // stereotype annotation (other examples @Service and @Controller, these are all just more specific version of @Component)
public interface WorkshopRepository extends JpaRepository<Workshop, Long> {
}
