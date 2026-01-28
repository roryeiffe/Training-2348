package com.revature.workshop.dtos;

import java.time.Instant;

public record WorkshopResponse(Long id, String title, int capacity, int seatsTaken, Instant startsAt) {
}
