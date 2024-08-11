package com.securepayment.dto;

public record ThreeDSecureDetailsDTO(
        Long id,
        String authenticationStatus,
        String eci,
        String cavv,
        String xid,
        Long paymentId
        ) {
}
