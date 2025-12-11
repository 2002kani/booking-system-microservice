package com.easybooking.bookingservice.service.impl;

import com.easybooking.bookingservice.dto.BookingRequestDTO;
import com.easybooking.bookingservice.dto.BookingResponseDTO;
import com.easybooking.bookingservice.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BookingServiceImpl implements BookingService {
    private BookingRepository bookingRepository;

    @Override
    public BookingResponseDTO createBooking(BookingRequestDTO request){
        return new BookingResponseDTO();
    }
}
