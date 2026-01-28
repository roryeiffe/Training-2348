package com.revature.workshop.dtos;

import java.time.Instant;

// Records are used to store immutable data and eliminate boiler-plate
// We must specify the fields and a lot is created under the hood:
// equals, hashCode, toString, constructor, getters
public record CreateWorkshopRequest(String title, int capacity, Instant startsAt) {
}
