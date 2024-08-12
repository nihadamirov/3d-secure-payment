package com.securepayment.controller;

import com.securepayment.dto.CardDetailsDTO;
import com.securepayment.service.CardDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/card-details")
@RequiredArgsConstructor
public class CardDetailsController {

    private final CardDetailsService cardDetailsService;


    @PostMapping("/{customerId}")
    public ResponseEntity<CardDetailsDTO> createCardDetails(@PathVariable Long customerId, @RequestBody CardDetailsDTO cardDetailsDTO) {
        CardDetailsDTO createdCardDetails = cardDetailsService.createCardDetails(customerId, cardDetailsDTO);
        return new ResponseEntity<>(createdCardDetails, HttpStatus.CREATED);
    }

    @PatchMapping("/{id}")
    public ResponseEntity<CardDetailsDTO> updateCardDetails(@PathVariable Long id, @RequestBody CardDetailsDTO cardDetailsDTO) {
        CardDetailsDTO updatedCardDetails = cardDetailsService.updateCardDetails(id, cardDetailsDTO);
        return new ResponseEntity<>(updatedCardDetails, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<CardDetailsDTO> getCardDetailsById(@PathVariable Long id) {
        CardDetailsDTO cardDetailsDTO = cardDetailsService.getCardDetailsById(id);
        return new ResponseEntity<>(cardDetailsDTO, HttpStatus.OK);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCardDetails(@PathVariable Long id) {
        cardDetailsService.deletedCardDetails(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }
}
