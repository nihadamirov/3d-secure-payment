package com.securepayment.controller;

import com.securepayment.service.CardDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class CardDetailsController {

    private final CardDetailsService cardDetailsService;
}
