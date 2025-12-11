package com.easybooking.bookingservice.dto;

import lombok.*;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class BookingRequestDTO {
    private Long userID;
    private Long eventId;
    private Long ticketCount;
}
