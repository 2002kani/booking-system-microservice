package com.example.ticket_booking.inventoryservice.repository;

import com.example.ticket_booking.inventoryservice.entity.Event;
import org.springframework.data.jpa.repository.JpaRepository;

public interface EventRepository extends JpaRepository<Event, Long> {
}
