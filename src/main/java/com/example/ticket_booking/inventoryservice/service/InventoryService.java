package com.example.ticket_booking.inventoryservice.service;

import com.example.ticket_booking.inventoryservice.dto.EventInventoryDto;

import java.util.List;

public interface InventoryService {
    List<EventInventoryDto> getAllEvents();
}
