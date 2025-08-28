package com.sara.arsw.service;

import java.util.List;

public final class Statistics {
    private Statistics(){}

    /** Media aritmética */
    public static double mean(List<Double> xs) {
        if (xs.isEmpty()) throw new IllegalArgumentException("Lista vacía");
        double sum = 0.0;
        for (Double d : xs) sum += d;
        return sum / xs.size();
    }

    /** Desviación estándar muestral (n-1) */
    public static double sampleStdDev(List<Double> xs) {
        int n = xs.size();
        if (n < 2) throw new IllegalArgumentException("Se requieren al menos 2 datos");
        double mu = mean(xs);
        double acc = 0.0;
        for (Double d : xs) {
            double diff = d - mu;
            acc += diff * diff;
        }
        return Math.sqrt(acc / (n - 1));
    }
}
