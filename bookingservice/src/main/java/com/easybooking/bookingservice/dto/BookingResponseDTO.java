package com.easybooking.bookingservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingResponseDTO {
    private Long bookingId;
    private Long userId;
    private Long eventId;
    private Long ticketCount;
    private String ticketPrice;
}
