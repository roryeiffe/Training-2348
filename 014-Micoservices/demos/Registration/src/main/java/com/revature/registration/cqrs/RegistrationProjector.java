package com.revature.registration.cqrs;

import com.revature.registration.models.Registration;
import com.revature.registration.models.RegistrationView;
import com.revature.registration.repositories.RegistrationViewRepository;
import org.springframework.stereotype.Component;

@Component
public class RegistrationProjector {
    private RegistrationViewRepository registrationViewRepository;

    public RegistrationProjector(RegistrationViewRepository registrationViewRepository) {
        this.registrationViewRepository = registrationViewRepository;
    }

    // We will call this whenever we are inserting/updating Registration to make sure they stay in sync
    public void upsert(Registration registration) {
        // Create an instance of RegistrationView with the same properties:
        RegistrationView registrationView = new RegistrationView(
                registration.getId(),
                registration.getUserId(),
                registration.getWorkshopId(),
                registration.getStatus(),
                registration.getCreatedAt(),
                registration.getUpdatedAt()
        );
        // save to repo
        registrationViewRepository.save(registrationView);
    }

}
