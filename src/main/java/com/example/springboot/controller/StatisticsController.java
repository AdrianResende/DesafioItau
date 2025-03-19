package com.example.springboot.controller;


import com.example.springboot.dto.StatisticsResponse;
import com.example.springboot.service.TransactionService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.DoubleSummaryStatistics;

@RestController
@RequestMapping("/statistics")
public class StatisticsController {

    private final TransactionService transactionService;

    public StatisticsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    @GetMapping
    public ResponseEntity<StatisticsResponse> getStatistics() {

        DoubleSummaryStatistics stats = transactionService.getStatistics();
        return ResponseEntity.ok(new StatisticsResponse(stats));
    }
}
