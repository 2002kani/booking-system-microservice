package com.easybooking.bookingservice.service.impl;

import com.easybooking.bookingservice.client.InventoryServiceClient;
import com.easybooking.bookingservice.dto.BookingRequestDTO;
import com.easybooking.bookingservice.dto.BookingResponseDTO;
import com.easybooking.bookingservice.dto.InventoryResponseDTO;
import com.easybooking.bookingservice.entity.Customer;
import com.easybooking.bookingservice.repository.CustomerRepository;
import com.easybooking.bookingservice.service.BookingService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

@AllArgsConstructor
@Service
public class BookingServiceImpl implements BookingService {
    private CustomerRepository customerRepository;
    private InventoryServiceClient inventoryServiceClient;

    @Override
    public BookingResponseDTO createBooking(final BookingRequestDTO request){
        final Customer customer =  customerRepository.findById(request.getUserId()).orElse(null);

        if(customer == null){
            throw new RuntimeException("Customer not found");
        }

        final InventoryResponseDTO inventoryResponse = inventoryServiceClient.getInventory(request.getEventId());
        System.out.println("INVENTORY SERVICE RESPONSE: " + inventoryResponse);

        if(inventoryResponse.getCapacity() < request.getTicketCount()){
            throw new  RuntimeException("Not enough Tickets available");
        }

        return BookingResponseDTO.builder().build();
    }
}
