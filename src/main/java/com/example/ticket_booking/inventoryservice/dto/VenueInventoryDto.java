package com.example.ticket_booking.inventoryservice.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VenueInventoryDto {
    private Long venueId;
    private String venueName;
    private Long totalCapacity;
}
