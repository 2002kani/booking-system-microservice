package com.example.ticket_booking.inventoryservice.controller;

import com.example.ticket_booking.inventoryservice.dto.EventInventoryDto;
import com.example.ticket_booking.inventoryservice.dto.VenueInventoryDto;
import com.example.ticket_booking.inventoryservice.service.InventoryService;
import lombok.AllArgsConstructor;
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
}
