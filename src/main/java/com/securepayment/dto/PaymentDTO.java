package com.securepayment.dto;

public record PaymentDTO(
        Long id,
        String paymentId,
        Double amount,
        String currency,
        String status,
        String paymentMethod,
        boolean threeDSecureRequired,
        String threeDSecur
) {
}
