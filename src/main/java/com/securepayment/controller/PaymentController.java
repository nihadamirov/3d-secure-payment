package com.securepayment.controller;

import com.securepayment.dto.PaymentDTO;
import com.securepayment.service.PaymentService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/payments")
@RequiredArgsConstructor
@Slf4j
public class PaymentController {

    private final PaymentService paymentService;

    @PostMapping("/process")
    public ResponseEntity<PaymentDTO> processPayment(@RequestParam Long customerId,
                                                     @RequestParam Long cardId,
                                                     @RequestBody PaymentDTO paymentDTO) {
        log.info("Processing payment for customer: {} and card: {} ", customerId, cardId);
        PaymentDTO processedPayment = paymentService.processPayment(customerId, cardId, paymentDTO);
        return new ResponseEntity<>(processedPayment, HttpStatus.CREATED);
    }
}
