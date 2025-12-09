package com.example.ticket_booking.inventoryservice.dto;

import com.example.ticket_booking.inventoryservice.entity.Venue;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@Builder
public class EventInventoryDto {
    private String event;
    private Long capacity;
    private Venue venue;
}
