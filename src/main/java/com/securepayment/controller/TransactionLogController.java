package com.securepayment.controller;

import com.securepayment.service.TransactionLogService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class TransactionLogController {

    private final TransactionLogService transactionLogService;
}
