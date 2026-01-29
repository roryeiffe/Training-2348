package com.revature.registration.repositories;

import com.revature.registration.models.RegistrationView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RegistrationViewRepository extends JpaRepository<RegistrationView, Long> {
}
