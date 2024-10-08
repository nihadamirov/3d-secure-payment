package com.securepayment.service;

import com.securepayment.dto.CardDetailsDTO;
import com.securepayment.entity.CardDetails;
import com.securepayment.entity.Customer;
import com.securepayment.exception.ResourceNotFoundException;
import com.securepayment.repository.CardDetailsRepository;
import com.securepayment.repository.CustomerRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardDetailsService {

    private final CardDetailsRepository cardDetailsRepository;
    private final ModelMapper modelMapper;
    private final CustomerRepository customerRepository;


    public CardDetails convertToEntity(CardDetailsDTO cardDetailsDTO) {
        CardDetails cardDetails = new CardDetails();
        cardDetails.setId(cardDetailsDTO.id());
        cardDetails.setCardNumber(cardDetailsDTO.cardNumber());
        cardDetails.setCardHolderName(cardDetailsDTO.cardHolderName());
        cardDetails.setExpiryMonth(cardDetailsDTO.expiryMonth());
        cardDetails.setExpiryYear(cardDetailsDTO.expiryYear());
        cardDetails.setCardType(cardDetailsDTO.cardType());
        return cardDetails;
    }

    public CardDetailsDTO convertToDto(CardDetails cardDetails) {
        return new CardDetailsDTO(
                cardDetails.getId(),
                cardDetails.getCardNumber(),
                cardDetails.getCardHolderName(),
                cardDetails.getExpiryMonth(),
                cardDetails.getExpiryYear(),
                cardDetails.getCardType()
        );
    }


    public CardDetailsDTO getCardDetailsById(Long id) {
        CardDetails cardDetails = cardDetailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CardDetails not found with id: " + id));
        return convertToDto(cardDetails);
    }

    public CardDetailsDTO createCardDetails(Long customerId, CardDetailsDTO cardDetailsDTO) {
        Customer customer = customerRepository.findById(customerId)
                .orElseThrow(() -> new ResourceNotFoundException("Customer not found with id: " + customerId));

        CardDetails cardDetails = convertToEntity(cardDetailsDTO);
        cardDetails.setPayment(null);
        CardDetails saveCardDetails = cardDetailsRepository.save(cardDetails);
        return convertToDto(saveCardDetails);
    }

    public CardDetailsDTO updateCardDetails(Long id, CardDetailsDTO cardDetailsDTO) {
        CardDetails exitingCardDetails = cardDetailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CardDetails not found with id: " + id));

        modelMapper.map(cardDetailsDTO, exitingCardDetails);
        CardDetails updateCardDetails = cardDetailsRepository.save(exitingCardDetails);
        return convertToDto(updateCardDetails);
    }

    public void deletedCardDetails(Long id) {
        CardDetails cardDetails = cardDetailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CardDetails not found with id: " + id));

        cardDetailsRepository.delete(cardDetails);

    }
}
