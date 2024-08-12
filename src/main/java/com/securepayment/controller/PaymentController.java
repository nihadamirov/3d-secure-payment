package com.securepayment.controller;

import com.securepayment.dto.PaymentDTO;
import com.securepayment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/payments")
@RequiredArgsConstructor
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/process")
    public ResponseEntity<PaymentDTO> processPayment(@RequestParam Long customerId, @RequestParam Long cardId, @RequestBody PaymentDTO paymentDTO) {
        PaymentDTO processedPayment = paymentService.processPayment(customerId, cardId, paymentDTO);
        return new ResponseEntity<>(processedPayment, HttpStatus.CREATED);
    }
}
