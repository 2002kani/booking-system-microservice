package com.example.ticket_booking.inventoryservice.controller;

import com.example.ticket_booking.inventoryservice.dto.EventInventoryDto;
import com.example.ticket_booking.inventoryservice.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class InventoryController {
    private InventoryService inventoryService;

    @GetMapping("/inventory/events")
    public @ResponseBody List<EventInventoryDto> getAllInventoryEvents(){
        return inventoryService.getAllEvents();
    }
}
