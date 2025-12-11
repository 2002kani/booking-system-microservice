package com.example.ticket_booking.inventoryservice.dto;

import com.example.ticket_booking.inventoryservice.entity.Venue;
import lombok.*;

import java.math.BigDecimal;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EventInventoryDto {
    private Long eventId;
    private String event;
    private Long capacity;
    private Venue venue;
    private BigDecimal ticketPrice;
}
