package com.securepayment.entity;

import jakarta.persistence.*;
import lombok.Data;


@Entity
@Table(name = "CARD_DETAILS")
@Data
public class CardDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Tokenized card number
    @Column(name = "card_number", nullable = false)
    private String cardNumber;

    @Column(name = "card_holder_name", nullable = false)
    private String cardHolderName;

    @Column(name = "expiry_month", nullable = false)
    private String expiryMonth;

    @Column(name = "expiry_year", nullable = false)
    private String expiryYear;

    @Column(name = "card_type")
    private String cardType;

    @OneToOne(mappedBy = "cardDetails")
    private Payment payment;

}
