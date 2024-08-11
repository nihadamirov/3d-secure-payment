package com.securepayment.dto;

import java.time.LocalDateTime;

public record TransactionLogDTO(
        Long id,
        String transactionId,
        String status,
        String message,
        LocalDateTime timestamp,
        Long paymentId
        ) {
}
