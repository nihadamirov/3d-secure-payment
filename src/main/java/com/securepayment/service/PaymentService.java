package com.securepayment.service;

import com.securepayment.dto.PaymentDTO;
import com.securepayment.entity.CardDetails;
import com.securepayment.entity.Customer;
import com.securepayment.entity.Payment;
import com.securepayment.exception.ResourceNotFoundException;
import com.securepayment.repository.CardDetailsRepository;
import com.securepayment.repository.CustomerRepository;
import com.securepayment.repository.PaymentRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

import java.time.LocalDateTime;

@Service
@RequiredArgsConstructor
public class PaymentService {

    private final PaymentRepository paymentRepository;
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;
    private final CardDetailsRepository cardDetailsRepository;


    public PaymentDTO processPayment(Long customerId, Long cardId, PaymentDTO paymentDTO) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id " + customerId));

        CardDetails cardDetails = cardDetailsRepository.findById(cardId)
                .orElseThrow(() -> new ResourceNotFoundException("Card details not found with id " + cardId));

        Payment payment = modelMapper.map(paymentDTO, Payment.class);
        payment.setCustomer(customer);
        payment.setPaymentMethod(cardDetails.getCardType());
        payment.setCreatedAt(LocalDateTime.now());
        payment.setUpdatedAt(LocalDateTime.now());

        payment = paymentRepository.save(payment);

        cardDetails.setPayment(payment);
        cardDetailsRepository.save(cardDetails);

        return modelMapper.map(payment, PaymentDTO.class);
    }
}
