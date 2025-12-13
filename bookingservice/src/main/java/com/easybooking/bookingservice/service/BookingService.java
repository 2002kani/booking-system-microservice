package com.easybooking.bookingservice.service;

import com.easybooking.bookingservice.dto.BookingRequestDTO;
import com.easybooking.bookingservice.dto.BookingResponseDTO;
import com.easybooking.bookingservice.dto.InventoryResponseDTO;
import com.easybooking.bookingservice.entity.Customer;
import com.easybooking.bookingservice.event.BookingEvent;

public interface BookingService {
    BookingResponseDTO createBooking(BookingRequestDTO request);
    BookingEvent createBookingEvent(BookingRequestDTO request, Customer customer, InventoryResponseDTO inventory);
}
