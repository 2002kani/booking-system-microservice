package com.easybooking.bookingservice.dto;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class InventoryResponseDTO {
    private Long eventId;
    private String event;
    private Long capacity;
    private VenueResponse venue;
    private BigDecimal ticketPrice;
}
