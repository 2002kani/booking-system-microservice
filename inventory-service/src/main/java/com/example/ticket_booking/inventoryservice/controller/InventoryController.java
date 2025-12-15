package com.example.ticket_booking.inventoryservice.controller;

import com.example.ticket_booking.inventoryservice.dto.EventInventoryDto;
import com.example.ticket_booking.inventoryservice.dto.VenueInventoryDto;
import com.example.ticket_booking.inventoryservice.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class InventoryController {
    private InventoryService inventoryService;

    @GetMapping("/inventory/events")
    public @ResponseBody List<EventInventoryDto> inventoryGetAllEvents(){
        return inventoryService.getAllEvents();
    }

    @GetMapping("/inventory/venue/{venueId}")
    public @ResponseBody VenueInventoryDto inventoryGetVenueById(@PathVariable("venueId") Long venueId){
        return inventoryService.getVenueInformation(venueId);
    }

    @GetMapping("/inventory/event/{event_id}")
    public ResponseEntity<EventInventoryDto> inventoryForEvent(@PathVariable("event_id") Long eventId){
        EventInventoryDto event = inventoryService.getEventInventory(eventId);
        return ResponseEntity.ok(event);
    }

    @PutMapping("/inventory/event/{eventId}/capacity/{capacity}")
    public ResponseEntity<Void> updateEventCapacity(@PathVariable("eventId") Long eventId, @PathVariable("capacity") Long ticketsBooked){
        inventoryService.updateEventCapacity(eventId, ticketsBooked);
        return ResponseEntity.ok().build();
    }
}
