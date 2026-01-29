package com.revature.registration.models;

import com.revature.registration.enums.RegistrationStatus;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Id;

import java.time.Instant;

/**
 * Will be used to encapsulate the data when we are querying for registration objects
 * This class will encapsulate the "view" version of registration, including all the fields we would want to see when we read this data from the database
 */
@Entity
public class RegistrationView {

    @Id
    private Long registrationId;

    private Long userId;
    private Long workshopId;

    @Enumerated(EnumType.STRING)
    private RegistrationStatus status;

    private Instant createdAt;
    private Instant updatedAt;

    public RegistrationView() {}


    public RegistrationView(Long registrationId, Long userId, Long workshopId, RegistrationStatus status, Instant createdAt, Instant updatedAt) {
        this.registrationId = registrationId;
        this.userId = userId;
        this.workshopId = workshopId;
        this.status = status;
        this.createdAt = createdAt;
        this.updatedAt = updatedAt;
    }

    public Long getRegistrationId() {
        return registrationId;
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

    // Modifiable Properties:
    public void setStatus(RegistrationStatus status) {
        this.status = status;
    }

    public void setUpdatedAt(Instant updatedAt) {
        this.updatedAt = updatedAt;
    }


}
