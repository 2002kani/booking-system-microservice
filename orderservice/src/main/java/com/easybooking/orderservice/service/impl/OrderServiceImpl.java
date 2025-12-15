package com.easybooking.orderservice.service.impl;

import com.easybooking.bookingservice.event.BookingEvent;
import com.easybooking.orderservice.client.InventoryServiceClient;
import com.easybooking.orderservice.entity.Order;
import com.easybooking.orderservice.repository.OrderRepository;
import com.easybooking.orderservice.service.OrderService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

@RequiredArgsConstructor
@Service
@Slf4j
public class OrderServiceImpl implements OrderService {
    private final OrderRepository orderRepository;
    private final InventoryServiceClient inventoryServiceClient;

    @KafkaListener(topics = "booking", groupId = "order-service")
    @Override
    public void orderEvent(BookingEvent event) {
        log.info("Order Event received: {}", event);

        Order order = createOrder(event);
        orderRepository.saveAndFlush(order);

        inventoryServiceClient.updateInventory(order.getEventId(), order.getTicketCount());
        log.info("Order Event sent to inventory: {}, less tickets: {}", order.getEventId(), order.getTicketCount());
    }

    @Override
    public Order createOrder(BookingEvent event) {
        return Order.builder()
                .customerId(event.getUserId())
                .eventId(event.getEventId())
                .ticketCount(event.getTicketCount())
                .totalPrice(event.getTotalPrice())
                .build();
    }
}
