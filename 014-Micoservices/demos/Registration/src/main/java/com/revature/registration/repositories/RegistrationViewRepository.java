package com.revature.registration.repositories;

import com.revature.registration.models.RegistrationView;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
// Derived Queries: https://docs.spring.io/spring-data/jpa/reference/jpa/query-methods.html
@Repository
public interface RegistrationViewRepository extends JpaRepository<RegistrationView, Long> {
    // find registration view objects based on user id and order them from most recent to least recent
    List<RegistrationView> findByUserIdOrderByCreatedAtDesc(Long userId);
    List<RegistrationView> findByWorkshopIdOrderByCreatedAtDesc(Long workshopId);
    // return the top 20 registrations order by creation time, in other words the 20 most recently created registrations
    List<RegistrationView> findTop20ByOrderByCreatedAtDesc();
}
