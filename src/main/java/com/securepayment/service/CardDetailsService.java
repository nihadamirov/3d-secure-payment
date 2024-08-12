package com.securepayment.service;

import com.securepayment.dto.CardDetailsDTO;
import com.securepayment.entity.CardDetails;
import com.securepayment.exception.ResourceNotFoundException;
import com.securepayment.repository.CardDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CardDetailsService {

    private final CardDetailsRepository cardDetailsRepository;
    private final ModelMapper modelMapper;


    public CardDetails convertToEntity(CardDetailsDTO cardDetailsDTO) {
        return modelMapper.map(cardDetailsDTO, CardDetails.class);
    }

    public CardDetailsDTO convertToDto(CardDetails cardDetails) {
        return modelMapper.map(cardDetails, CardDetailsDTO.class);
    }

    public CardDetailsDTO getCardDetailsById(Long id) {
        CardDetails cardDetails = cardDetailsRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("CardDetails not found with id: " + id));
        return convertToDto(cardDetails);
    }

    public CardDetailsDTO createCardDetails(CardDetailsDTO cardDetailsDTO) {
        CardDetails cardDetails = convertToEntity(cardDetailsDTO);
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

    


}
