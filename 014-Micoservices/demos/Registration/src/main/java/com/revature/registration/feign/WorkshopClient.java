package com.revature.registration.feign;

import com.revature.registration.dtos.SeatRequest;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;

@FeignClient(
        name = "workshop-service", // represents the name of the service that we want to send requests
        // the name was configured in application.yml spring.application.name
        url = "${workshop.service.url}" // point to the url specified in the .yml file
        // Once we add consul later, we should be able to locate the service by the name alone so we can remove the url
)
public interface WorkshopClient {


    @PostMapping("/internal/workshops/{id}/reserve")
    void reserve(@PathVariable("id") Long workshopId, @RequestBody SeatRequest req);

    @PostMapping("/internal/workshops/{id}/confirm")
    void confirm(@PathVariable("id") Long workshopId, @RequestBody SeatRequest req);

    @PostMapping("/internal/workshops/{id}/release")
    void release(@PathVariable("id") Long workshopId, @RequestBody SeatRequest req);

}
