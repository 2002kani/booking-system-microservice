package com.easybooking.orderservice.service;

import com.easybooking.bookingservice.event.BookingEvent;

public interface OrderService {
    void orderEvent(BookingEvent event);
}
