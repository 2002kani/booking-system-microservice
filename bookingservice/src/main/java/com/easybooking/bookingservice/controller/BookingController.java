package com.easybooking.bookingservice.controller;

import com.easybooking.bookingservice.dto.BookingRequestDTO;
import com.easybooking.bookingservice.dto.BookingResponseDTO;
import com.easybooking.bookingservice.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@AllArgsConstructor
@RestController
@RequestMapping("/api/v1")
public class BookingController {

    private BookingService bookingService;

    @PostMapping(consumes = "application/json", produces = "application/json", path = "/booking")
    public BookingResponseDTO createBooking(@RequestBody BookingRequestDTO request){
        return bookingService.createBooking(request);
    }
}
