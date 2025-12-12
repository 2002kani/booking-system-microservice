package com.easybooking.bookingservice.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingRequestDTO {
    private Long userId;
    private Long eventId;
    private Long ticketCount;
}
