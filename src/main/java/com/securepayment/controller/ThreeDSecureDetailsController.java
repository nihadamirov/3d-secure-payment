package com.securepayment.controller;

import com.securepayment.service.ThreeDSecureDetailsService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class ThreeDSecureDetailsController {

    private final ThreeDSecureDetailsService threeDSecureDetailsService;
}
