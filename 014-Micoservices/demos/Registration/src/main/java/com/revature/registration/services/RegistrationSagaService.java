package com.revature.registration.services;

import com.revature.registration.cqrs.RegistrationProjector;
import com.revature.registration.dtos.SeatRequest;
import com.revature.registration.enums.RegistrationStatus;
import com.revature.registration.feign.WorkshopClient;
import com.revature.registration.models.Registration;
import com.revature.registration.repositories.RegistrationRepository;
import org.springframework.stereotype.Service;

@Service
public class RegistrationSagaService  {
    private RegistrationRepository registrationRepository;
    // used to map Registration objects to RegistrationView objects
    private RegistrationProjector registrationProjector;
    // Used to make requests to the other service via Feign
    private WorkshopClient workshopClient;

    public RegistrationSagaService (RegistrationRepository registrationRepository, RegistrationProjector registrationProjector, WorkshopClient workshopClient) {
        this.registrationRepository = registrationRepository;
        this.registrationProjector = registrationProjector;
        this.workshopClient = workshopClient;
    }

    public Registration register(Long userId, Long workshopId) {
        // Save the registration to the repo (we'll be running this command no matter what so if, down the line, the registration fails for any reason (such as workshop being too full), we will need to take compensating actions to undo those changes
        Registration registration = new Registration(userId, workshopId, RegistrationStatus.PENDING);
        registration = registrationRepository.save(registration);
        // Update the RegistrationView repo using the projector:
        registrationProjector.upsert(registration);

        try {
            // Now that we have a pending registration, we can try to actually reserve the seat, using Feign:
            workshopClient.reserve(workshopId, new SeatRequest(registration.getId()));

            try {
                workshopClient.confirm(workshopId, new SeatRequest(registration.getId()));
                // Assuming this executed properly, haven't gone to the catch block yet
                registration.setStatus(RegistrationStatus.CONFIRMED);
                registrationRepository.save(registration);
                registrationProjector.upsert(registration);
                return registration;
            } catch(Exception confirmFailure) {
                // If something went wrong with the confirm operation, we need to release the seat (Compensating Action)
                workshopClient.release(workshopId, new SeatRequest(registration.getId()));
                // set status to FAILED:
                registration.setStatus(RegistrationStatus.FAILED);
                registrationRepository.save(registration);
                registrationProjector.upsert(registration);
                // Throw the same exception because we still want to convey that something went wrong
                throw confirmFailure;
            }
        } catch(Exception reserveFailure) {
            registration.setStatus(RegistrationStatus.REJECTED);
            registrationRepository.save(registration);
            registrationProjector.upsert(registration);
            throw reserveFailure;
        }

    }

    public Registration cancel(Long registrationId) {
        Registration registration = registrationRepository.findById(registrationId).orElseThrow(() -> new IllegalArgumentException("Registration not Found"));

        // Check if registration is confirmed because we only want to cancel registrations that are already confirmed
        if(registration.getStatus() != RegistrationStatus.CONFIRMED) {
            throw new IllegalStateException("Only CONFIRMED registrations can be cancelled");
        }

        workshopClient.release(registration.getWorkshopId(), new SeatRequest(registrationId));

        registration.setStatus(RegistrationStatus.CANCELLED);
        registrationRepository.save(registration);
        registrationProjector.upsert(registration);
        return registration;
    }



}

