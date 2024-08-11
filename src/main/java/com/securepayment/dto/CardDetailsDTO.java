package com.securepayment.dto;

public record CardDetailsDTO(
        Long id,
        String cardNumber,
        String cardHolderName,
        String expiryMonth,
        String expiryYear,
        String cardType
        ) {
}
