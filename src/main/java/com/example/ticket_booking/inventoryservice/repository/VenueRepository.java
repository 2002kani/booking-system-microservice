package com.example.ticket_booking.inventoryservice.repository;

import com.example.ticket_booking.inventoryservice.entity.Venue;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VenueRepository extends JpaRepository<Venue,Long> {
}
