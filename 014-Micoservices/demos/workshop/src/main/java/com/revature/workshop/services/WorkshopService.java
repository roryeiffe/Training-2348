package com.revature.workshop.services;

import com.revature.workshop.dtos.WorkshopResponse;
import com.revature.workshop.models.Workshop;
import com.revature.workshop.repositories.WorkshopRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.Instant;
import java.util.List;

@Service
public class WorkshopService {
//    @Autowired // Spring handle the instantiation of this repository
    private WorkshopRepository workshopRepository;

    // If we pass in the WorkshopRepository in the constructor, Spring will automatically wire in an instance
    // This works specifically because this class only has one constructor and there is only one matching bean for the WorkshopRepository
    public WorkshopService(WorkshopRepository repo) {
        this.workshopRepository = repo;
    }

    // Create and Read methods
    public List<Workshop> getAll() {
        return workshopRepository.findAll();
    }
    public Workshop create(String title, int capacity, Instant startsAt) {
        return workshopRepository.save(new Workshop(title, capacity, startsAt));
    }

    // Seat Management:
    // These methods will be useful for our registration service
    @Transactional
    public void reserveSeat(Long workshopId) {
        Workshop workshop = workshopRepository.findById(workshopId)
                .orElseThrow(() -> new IllegalArgumentException("Workshop not found"));
        workshop.takeSeat();
//        workshopRepository.save(workshop); // We can include this to explicitly update the db but at this point, the workshop
        // is in the persistent state so should be synced up automatically
    }

    @Transactional
    public void releaseSeat(Long workshopId) {
        Workshop workshop = workshopRepository.findById(workshopId)
                .orElseThrow(() -> new IllegalArgumentException("Workshop not found"));
        workshop.releaseSeat();
    }

    @Transactional
    public void confirmSeat(Long workshopId) {
        // simple implementation, check if the workshop id is valid
        workshopRepository.findById(workshopId)
                .orElseThrow(() -> new IllegalArgumentException("Workshop not found"));
    }

}
