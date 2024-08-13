package com.securepayment.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;


@Entity
@Table(name = "CARD_DETAILS")
@Data
@NoArgsConstructor
public class CardDetails {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "card_details_seq_gen")
    @SequenceGenerator(name = "card_details_seq_gen", sequenceName = "CARD_DETAILS_SEQ", allocationSize = 1)
    private Long id;

    // Tokenized card number
    @Column(name = "card_number")
    private String cardNumber;

    @Column(name = "card_holder_name")
    private String cardHolderName;

    @Column(name = "expiry_month")
    private String expiryMonth;

    @Column(name = "expiry_year")
    private String expiryYear;

    @Column(name = "card_type")
    private String cardType;

    @OneToOne(mappedBy = "cardDetails")
    private Payment payment;

}
