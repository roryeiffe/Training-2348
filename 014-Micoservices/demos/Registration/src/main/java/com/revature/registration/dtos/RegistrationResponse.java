package com.revature.registration.dtos;

import com.revature.registration.enums.RegistrationStatus;

import java.time.Instant;

/**
 * This DTO will be returned when we execute write operations such as register/cancel
 */
public record RegistrationResponse(Long id, Long userId, Long workshopId, RegistrationStatus status, Instant createdAt, Instant updatedAt) {
}
