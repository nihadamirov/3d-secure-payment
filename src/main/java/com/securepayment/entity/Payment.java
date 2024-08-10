package com.securepayment.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDateTime;

@Entity
@Table(name = "PAYMENTS")
@Data
public class Payment {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @Column(name = "payment_id", nullable = false)
    private String paymentId;

    @Column(name = "currency", nullable = false)
    private String currency;

    @Column(name = "amount", nullable = false)
    private Double amount;

    @Column(name = "status", nullable = false)
    private String status;

    @Column(name = "payment_method", nullable = false)
    private String paymentMethod;

    @Column(name = "three_d_secure_required", nullable = false)
    private boolean threeDSecureRequired;

    @Column(name = "three_d_secure_status", nullable = false)
    private String threeDSecureStatus;

    @Column(name = "creat_at", nullable = false)
    private LocalDateTime createdAt;

    @Column(name = "update_at", nullable = false)
    private LocalDateTime updatedAt;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "customer_id", nullable = false)
    private Customer customer;
}
