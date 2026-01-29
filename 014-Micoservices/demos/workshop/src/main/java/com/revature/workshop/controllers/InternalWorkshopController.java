package com.revature.workshop.controllers;

import com.revature.workshop.services.WorkshopService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * This controller encapsulates the logic that we want our other service to
 * be able to access (reserving a seat, releasing, confirming) via Feign
 * There's nothing "special" about this controller. But we should make note of
 * the endpoints we set up because these will be used to call this service from the
 * Registration Service
 * Flow:
 * Client make a request to registration service
 * The Feign client will then call the endpoints in this controller
 * We will have to set up the logic to return the response back to the client
 */
@RestController
@RequestMapping("internal/workshops") // "internal" meaning that this particular endpoint should be used internally
// Meaning that we don't want clients to access these directly (this will be done via the Feign client on the Registration side
public class InternalWorkshopController {
    private WorkshopService workshopService;

    public InternalWorkshopController(WorkshopService workshopService) {
        this.workshopService = workshopService;
    }

    @PostMapping("/{id}/reserve")
    public void reserve(@PathVariable("id")Long id) {
        workshopService.reserveSeat(id);
    }

    @PostMapping("/{id}/confirm")
    public void confirm(@PathVariable("id") Long id) {
        workshopService.confirmSeat(id);
    }

    @PostMapping("/{id}/release")
    public void release(@PathVariable("id") Long id) {
        workshopService.releaseSeat(id);
    }


}
