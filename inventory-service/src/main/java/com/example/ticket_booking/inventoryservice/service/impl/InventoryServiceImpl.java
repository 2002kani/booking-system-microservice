package com.example.ticket_booking.inventoryservice.service.impl;

import com.example.ticket_booking.inventoryservice.dto.EventInventoryDto;
import com.example.ticket_booking.inventoryservice.dto.VenueInventoryDto;
import com.example.ticket_booking.inventoryservice.entity.Event;
import com.example.ticket_booking.inventoryservice.entity.Venue;
import com.example.ticket_booking.inventoryservice.exception.ResourceNotFoundException;
import com.example.ticket_booking.inventoryservice.repository.EventRepository;
import com.example.ticket_booking.inventoryservice.repository.VenueRepository;
import com.example.ticket_booking.inventoryservice.service.InventoryService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@AllArgsConstructor
@Service
@Slf4j
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

    @Override
    public VenueInventoryDto getVenueInformation(final Long venueId) {
        Venue venue = venueRepository.findById(venueId)
                .orElseThrow(() -> new ResourceNotFoundException(("Venue with id " + venueId + " not found")));
        return VenueInventoryDto.builder()
                .venueId(venue.getId())
                .venueName(venue.getName())
                .totalCapacity(venue.getTotalCapacity()).build();
    }

    @Override
    public EventInventoryDto getEventInventory(final Long eventId) {
        Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException(("Event with id " + eventId + " not found")));

        return EventInventoryDto.builder()
                .eventId(event.getId())
                .event(event.getName())
                .capacity(event.getLeftCapacity())
                .venue(event.getVenue())
                .ticketPrice(event.getTicketPrice())
                .build();
    }

    @Override
    public void updateEventCapacity(Long eventId, Long ticketsBooked) {
        final Event event = eventRepository.findById(eventId)
                .orElseThrow(() -> new ResourceNotFoundException(("Event with id " + eventId + " not found")));

        event.setLeftCapacity(event.getLeftCapacity() - ticketsBooked);
        eventRepository.saveAndFlush(event);
        log.info("Updated event capacity for event with id: {} with tickets booked: {}", eventId, ticketsBooked);
    }
}
