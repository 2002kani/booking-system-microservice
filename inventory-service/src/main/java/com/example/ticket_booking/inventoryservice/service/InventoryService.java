package com.example.ticket_booking.inventoryservice.service;

import com.example.ticket_booking.inventoryservice.dto.EventInventoryDto;
import com.example.ticket_booking.inventoryservice.dto.VenueInventoryDto;

import java.util.List;

public interface InventoryService {
    List<EventInventoryDto> getAllEvents();
    VenueInventoryDto getVenueInformation(Long venueId);
    EventInventoryDto getEventInventory(Long id);
    void  updateEventCapacity(Long eventId, Long ticketsBooked);
}
