package com.example.springboot.dto;

import java.util.DoubleSummaryStatistics;

public class StatisticsResponse {
    private long count;
    private double sum;
    private double avg;
    private double max;
    private double min;

    // Construtor que inicializa os campos com as estatísticas fornecidas
    public StatisticsResponse(DoubleSummaryStatistics stats){
        this.count = stats.getCount();
        this.sum = stats.getSum();
        this.avg = stats.getAverage();
        this.max = stats.getMax();
        this.min = stats.getMin();
    }

    // Getter para o campo count (contagem)
    public long getCount() {
        return count;
    }

    // Getter para o campo avg (média)
    public double getAvg() {
        return avg;
    }

    // Getter para o campo max (máximo)
    public double getMax() {
        return max;
    }

    // Getter para o campo min (mínimo)
    public double getMin() {
        return min;
    }

    // Getter para o campo sum (soma)
    public double getSum() {
        return sum;
    }
}
