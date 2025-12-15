package com.easybooking.orderservice.service;

import com.easybooking.bookingservice.event.BookingEvent;
import com.easybooking.orderservice.entity.Order;

public interface OrderService {
    void orderEvent(BookingEvent event);
    Order createOrder(BookingEvent event);
}
