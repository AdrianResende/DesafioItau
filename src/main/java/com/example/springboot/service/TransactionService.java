package com.example.springboot.service;


import com.example.springboot.model.Transaction;
import org.springframework.stereotype.Service;
import java.time.OffsetDateTime;
import java.util.DoubleSummaryStatistics;
import java.util.Queue;
import java.util.concurrent.ConcurrentLinkedQueue;


@Service
public class TransactionService {

    // Fila concorrente para armazenar transações
    private final Queue<Transaction> transactions = new ConcurrentLinkedQueue<>();

    // Método para adicionar uma nova transação à fila
    public void addTransaction(Transaction transaction) {
        transactions.add(transaction);
    }

    // Método para limpar todas as transações da fila
    public void clearTransactions() {
        transactions.clear();
    }

    // Método para obter estatísticas das transações
    public DoubleSummaryStatistics getStatistics() {
        OffsetDateTime now = OffsetDateTime.now();
        // Calcula estatísticas das transações nos últimos 60 segundos
        return transactions.stream()
                .filter(transaction -> transaction.getDataHora().isAfter(now.minusSeconds(60)))
                .mapToDouble(Transaction::getValor)
                .summaryStatistics();
    }
}
