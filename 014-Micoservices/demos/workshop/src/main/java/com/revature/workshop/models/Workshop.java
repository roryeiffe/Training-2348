package com.revature.workshop.models;

import jakarta.persistence.*;

import java.time.Instant;

@Entity
public class Workshop {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private int capacity;
    private int seatsTaken;

    private Instant startsAt;

    @Version // taken from persistence library
    private Long version;
    /**
     * Helps to ensure workshops aren't overbooked especially if we have a lot of requests coming in
     * Internally, keeps track version, let changes happen, if we find that the version has changed by the time we try to make the update to the row, then an exception is thrown
     */


    public Workshop() {
    }

    public Workshop(String title, int capacity, Instant startsAt) {
        this.title = title;
        this.capacity = capacity;
        this.seatsTaken = 0; // assume we're starting with no participants
        this.startsAt = startsAt;
    }

    // Some helper methods to determine if we have available seats left, etc.
    public boolean hasAvailableSeat() {
        return this.seatsTaken < this.capacity;
    }

    public void takeSeat() {
        // throw an exception to indicate if there isn't a seat available
        if(!hasAvailableSeat()) throw new IllegalStateException("No seats available");
        else this.seatsTaken ++;
    }

    public void releaseSeat() {
        // If workshop is not empty, decrement the seatsTaken
        if(this.seatsTaken > 0) this.seatsTaken --;
    }




    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public int getSeatsTaken() {
        return seatsTaken;
    }

    public void setSeatsTaken(int seatsTaken) {
        this.seatsTaken = seatsTaken;
    }

    public Instant getStartsAt() {
        return startsAt;
    }

    public void setStartsAt(Instant startsAt) {
        this.startsAt = startsAt;
    }

    @Override
    public String toString() {
        return "Workshop{" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", capacity=" + capacity +
                ", seatsTaken=" + seatsTaken +
                ", startsAt=" + startsAt +
                '}';
    }
}
