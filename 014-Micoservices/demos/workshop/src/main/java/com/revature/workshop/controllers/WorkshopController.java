package com.revature.workshop.controllers;

import com.revature.workshop.dtos.CreateWorkshopRequest;
import com.revature.workshop.dtos.WorkshopResponse;
import com.revature.workshop.models.Workshop;
import com.revature.workshop.services.WorkshopService;
import org.hibernate.jdbc.Work;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.stream.Collectors;

@RequestMapping("/workshops") // provides a prefix for all the paths defined in this controller
@RestController // Combines 2 annotations @Controller and @ResponseBody
// @Controller is a stereotype annotation
// @ResponseBody indicates that we are returning data as opposed to view
public class WorkshopController {
    private WorkshopService workshopService;

    public WorkshopController(WorkshopService workshopService) {
        this.workshopService = workshopService;
    }

    @GetMapping // We don't specify the path because of the class-level @RequestMapping annotation
    public List<WorkshopResponse> list() {
        List<Workshop> workshops = workshopService.getAll();
        // Here, we convert our Workshop list to a stream
        // The map function creates a WorkshopResponse object based on the Workshop
        // .collect is a terminal operation that takes all of the data from the stream and converts it to a collection, list in this case
        List<WorkshopResponse> workshopResponses = workshops.stream().map(w -> new WorkshopResponse(w.getId(), w.getTitle(), w.getCapacity(), w.getSeatsTaken(), w.getStartsAt())).collect(Collectors.toList());
        return workshopResponses;
    }

    @RequestMapping(method = RequestMethod.POST)
    // equivalent to @PostMapping
    public WorkshopResponse create(@RequestBody CreateWorkshopRequest request) {
        Workshop workshop = workshopService.create(request.title(), request.capacity(), request.startsAt());
        return new WorkshopResponse(workshop.getId(), workshop.getTitle(), workshop.getCapacity(), workshop.getSeatsTaken(), workshop.getStartsAt());

    }


}
