package com.securepayment.service;

import com.securepayment.repository.ThreeDSecureDetailsRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class ThreeDSecureDetailsService {

    private final ThreeDSecureDetailsRepository threeDSecureDetailsRepository;

}
