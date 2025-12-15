package com.easybooking.orderservice.service.impl;

import com.easybooking.bookingservice.event.BookingEvent;
import com.easybooking.orderservice.service.OrderService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@Service
@Slf4j
public class OrderServiceImpl implements OrderService {

    @KafkaListener(topics = "booking", groupId = "order-service")
    @Override
    public void orderEvent(BookingEvent event) {
        log.info("Order Event received: {}", event);
    }
}
