package com.easybooking.bookingservice.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;
import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "Order")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "quantity")
    private Long quantity;

    @Column(name = "placed_at")
    private LocalDate placedAt;

    @Column(name = "customer_id")
    private Customer customerId;

    @Column(name = "event_id")
    private Event eventId;
}
