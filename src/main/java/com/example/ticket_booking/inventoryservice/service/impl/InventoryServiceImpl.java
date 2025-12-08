package com.example.ticket_booking.inventoryservice.service.impl;

import com.example.ticket_booking.inventoryservice.dto.EventInventoryDto;
import com.example.ticket_booking.inventoryservice.entity.Event;
import com.example.ticket_booking.inventoryservice.repository.EventRepository;
import com.example.ticket_booking.inventoryservice.repository.VenueRepository;
import com.example.ticket_booking.inventoryservice.service.InventoryService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
public class InventoryServiceImpl implements InventoryService {
    private EventRepository eventRepository;
    private VenueRepository venueRepository;

    @Override
    public List<EventInventoryDto> getAllEvents(){
        List<Event> events = eventRepository.findAll();
        return events.stream().map(event -> EventInventoryDto.builder()
                .event(event.getName())
                .capacity(event.getLeftCapacity())
                .venue(event.getVenue())
                .build()).collect(Collectors.toList());
    }
}
