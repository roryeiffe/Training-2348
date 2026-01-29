package com.revature.registration.controllers;

import com.revature.registration.dtos.RegisterRequest;
import com.revature.registration.dtos.RegistrationResponse;
import com.revature.registration.models.Registration;
import com.revature.registration.services.RegistrationSagaService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/registrations")
public class RegistrationCommandController {
    private RegistrationSagaService registrationSagaService;

    public RegistrationCommandController (RegistrationSagaService registrationSagaService) {
        this.registrationSagaService = registrationSagaService;
    }

    @PostMapping
    public ResponseEntity<RegistrationResponse> register(@RequestBody RegisterRequest registerRequest) {
        Registration registration = registrationSagaService.register(registerRequest.userId(), registerRequest.workshopId());
        // convert to RegistrationResponse
        RegistrationResponse registrationResponse = toResponse(registration);
        return new ResponseEntity<>(registrationResponse, HttpStatus.CREATED);
    }

    @PostMapping("/{id}/cancel")
    public ResponseEntity<RegistrationResponse> cancel(@PathVariable Long id) {
        Registration registration = registrationSagaService.cancel(id);
        RegistrationResponse registrationResponse = toResponse(registration);
        return new ResponseEntity<>(registrationResponse, HttpStatus.OK);
    }

    private RegistrationResponse toResponse(Registration registration) {
        return new RegistrationResponse(
                registration.getId(),
                registration.getUserId(),
                registration.getWorkshopId(),
                registration.getStatus(),
                registration.getCreatedAt(),
                registration.getUpdatedAt()
        );
    }
}
