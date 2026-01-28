package com.revature.workshop;

import com.revature.workshop.dtos.CreateWorkshopRequest;

import java.time.Instant;

public class App {
    public static void main(String[] args) {
        CreateWorkshopRequest createWorkshopRequest = new CreateWorkshopRequest("Learning Spring", 20, Instant.now());
        System.out.println(createWorkshopRequest);
        System.out.println(createWorkshopRequest.capacity());
        System.out.println(createWorkshopRequest.startsAt());
    }
}
