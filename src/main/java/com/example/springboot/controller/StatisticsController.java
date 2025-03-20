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

    // Injeção de dependência do serviço de transações
    private final TransactionService transactionService;


    // Construtor para injetar o serviço de transações
    public StatisticsController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // Endpoint para obter as estatísticas das transações
    @GetMapping
    public ResponseEntity<StatisticsResponse> getStatistics() {
        // Obtém as estatísticas das transações do serviço
        DoubleSummaryStatistics stats = transactionService.getStatistics();
        // Retorna as estatísticas encapsuladas em um objeto StatisticsResponse
        return ResponseEntity.ok(new StatisticsResponse(stats));
    }
}
