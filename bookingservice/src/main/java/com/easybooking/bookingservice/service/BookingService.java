package com.easybooking.bookingservice.service;

import com.easybooking.bookingservice.dto.BookingRequestDTO;
import com.easybooking.bookingservice.dto.BookingResponseDTO;

public interface BookingService {
    BookingResponseDTO createBooking(BookingRequestDTO request);
}
