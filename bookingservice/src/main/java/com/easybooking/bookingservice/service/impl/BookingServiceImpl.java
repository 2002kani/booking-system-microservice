package com.easybooking.bookingservice.service.impl;

import com.easybooking.bookingservice.client.InventoryServiceClient;
import com.easybooking.bookingservice.dto.BookingRequestDTO;
import com.easybooking.bookingservice.dto.BookingResponseDTO;
import com.easybooking.bookingservice.dto.InventoryResponseDTO;
import com.easybooking.bookingservice.entity.Customer;
import com.easybooking.bookingservice.event.BookingEvent;
import com.easybooking.bookingservice.repository.CustomerRepository;
import com.easybooking.bookingservice.service.BookingService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;

@AllArgsConstructor
@Slf4j
@Service
public class BookingServiceImpl implements BookingService {
    private CustomerRepository customerRepository;
    private InventoryServiceClient inventoryServiceClient;
    private KafkaTemplate<String, BookingEvent> kafkaTemplate;

    @Override
    public BookingResponseDTO createBooking(final BookingRequestDTO request){
        final Customer customer =  customerRepository.findById(request.getUserId()).orElse(null);

        if(customer == null){
            throw new RuntimeException("Customer not found");
        }

        final InventoryResponseDTO inventoryResponse = inventoryServiceClient.getInventory(request.getEventId());
        log.info("INVENTORY SERVICE RESPONSE: " + inventoryResponse);

        if(inventoryResponse.getCapacity() < request.getTicketCount()){
            throw new  RuntimeException("Not enough Tickets available");
        }

        final BookingEvent bookingEvent = createBookingEvent(request, customer, inventoryResponse);
        kafkaTemplate.send("booking", bookingEvent);
        log.info("Booking sent to Kafka: {}", bookingEvent);

        return BookingResponseDTO.builder()
                .userId(bookingEvent.getUserId())
                .eventId(bookingEvent.getEventId())
                .ticketCount(bookingEvent.getTicketCount())
                .totalPrice(bookingEvent.getTotalPrice())
                .build();
    }

    @Override
    public BookingEvent createBookingEvent(BookingRequestDTO request,
                                           Customer customer,
                                           InventoryResponseDTO inventory) {
        return BookingEvent.builder()
                .userId(customer.getId())
                .eventId(request.getEventId())
                .ticketCount(request.getTicketCount())
                .totalPrice(inventory.getTicketPrice().multiply(BigDecimal.valueOf(request.getTicketCount())))
                .build();
    }
}
