package com.easybooking.bookingservice.dto;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VenueResponse {
    private Long id;
    private String name;
    private Long totalCapacity;
    private String address;
}
