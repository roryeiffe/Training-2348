package com.revature.registration.models;

import com.revature.registration.enums.RegistrationStatus;
import jakarta.persistence.*;

import java.time.Instant;

/**
 * Used for writing
 */
@Entity
public class Registration {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Long userId;
    private Long workshopId;

    @Enumerated(EnumType.STRING)
    private RegistrationStatus status;

    private Instant createdAt;
    private Instant updatedAt;

    public Registration() {

    }

    public Registration(Long userId, Long workshopId, RegistrationStatus status) {
        this.userId = userId;
        this.workshopId = workshopId;
        this.status = status;
        this.createdAt = Instant.now();
        this.updatedAt = Instant.now();
    }

    @PreUpdate // Whenever we update this entity, run this method which updates the updatedAt field
    public void touch() {
        this.updatedAt = Instant.now();
    }

    public Long getId() {
        return id;
    }

    public Long getUserId() {
        return userId;
    }

    public Long getWorkshopId() {
        return workshopId;
    }

    public RegistrationStatus getStatus() {
        return status;
    }

    public Instant getCreatedAt() {
        return createdAt;
    }

    public Instant getUpdatedAt() {
        return updatedAt;
    }

    // Just one setter method for Status:
    public void setStatus(RegistrationStatus status) {
        this.status = status;
        this.updatedAt = Instant.now();
    }
}
