package com.securepayment.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class PaymentDTO {
    private Long id;
    private String paymentId;
    private Double amount;
    private String currency;
    private String status;
    private String paymentMethod;

}
