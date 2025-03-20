package com.example.springboot.controller;


import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.example.springboot.service.TransactionService;
import com.example.springboot.dto.TransactionRequest;
import com.example.springboot.model.Transaction;
import org.springframework.http.HttpStatus;
import java.time.OffsetDateTime;


@RestController
@RequestMapping("/transaction")
public class TransactionController {

    // Injeção de dependência do serviço de transações
    private final TransactionService transactionService;

    // Construtor para injetar o serviço de transações
    public TransactionController(TransactionService transactionService) {
        this.transactionService = transactionService;
    }

    // Endpoint para criar uma nova transação
    @PostMapping
    public ResponseEntity<Void> createTransaction(@Valid @RequestBody TransactionRequest request) {
        // Verifica se a data/hora da transação é no futuro ou se o valor é menor ou igual a zero
        if(request.getDataHora().isAfter(OffsetDateTime.now()) || request.getValor() <= 0){
            // Retorna status 422 (Unprocessable Entity) se a validação falhar
            return ResponseEntity.unprocessableEntity().build();
        }

        // Adiciona a nova transação ao serviço
        transactionService.addTransaction(new Transaction(request.getValor(), request.getDataHora()));

        // Retorna status 201 (Created) se a transação for criada com sucesso
        return ResponseEntity.status(HttpStatus.CREATED).build();
    }

    // Endpoint para limpar todas as transações
    @DeleteMapping
    public ResponseEntity<Void> clearTransactions() {
        // Limpa todas as transações no serviço
        transactionService.clearTransactions();
        // Retorna status 200 (OK) após limpar as transações
        return ResponseEntity.ok().build();
    }
}
