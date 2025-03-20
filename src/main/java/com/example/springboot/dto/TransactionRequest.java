package com.example.springboot.dto;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotNull;
import com.fasterxml.jackson.annotation.JsonFormat;

import java.time.OffsetDateTime;

public class TransactionRequest {

    // O valor da transação, não pode ser nulo
    @NotNull
    private Double valor;

    // A data e hora da transação, não pode ser nula
    // O formato é especificado para corresponder ao formato JSON esperado
    @NotNull
    @JsonFormat(pattern = "yyyy-MM-dd'T'HH:mm:ss.SSSXXX")
    private OffsetDateTime dataHora;

    // Getter para o valor da transação
    public Double getValor() {
        return valor;
    }

    // Getter para a data e hora da transação
    public OffsetDateTime getDataHora() {
        return dataHora;
    }
}