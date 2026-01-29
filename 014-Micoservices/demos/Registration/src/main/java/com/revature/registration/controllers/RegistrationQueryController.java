package com.revature.registration.controllers;

import com.revature.registration.models.RegistrationView;
import com.revature.registration.repositories.RegistrationViewRepository;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/registrations/view")
public class RegistrationQueryController {

    // Typically, we would utilize a service
    private RegistrationViewRepository registrationViewRepository;

    public RegistrationQueryController(RegistrationViewRepository registrationViewRepository) {
        this.registrationViewRepository = registrationViewRepository;
    }

    @GetMapping("/by-user/{userId}")
    public List<RegistrationView> byUser(@PathVariable("userId") Long userId) {
        return registrationViewRepository.findByUserIdOrderByCreatedAtDesc(userId);
    }

    @GetMapping("by-workshop/{workshopId}")
    public List<RegistrationView> byWorkshop(@PathVariable("workshopId") Long workshopId) {
        return registrationViewRepository.findByWorkshopIdOrderByCreatedAtDesc(workshopId);
    }

    @GetMapping("/recent")
    public List<RegistrationView> recent() {
        return registrationViewRepository.findTop20ByOrderByCreatedAtDesc();
    }



}
