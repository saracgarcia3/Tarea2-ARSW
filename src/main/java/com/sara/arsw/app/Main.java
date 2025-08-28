package com.sara.arsw.app;

import com.sara.arsw.collections.DoublyLinkedList;
import com.sara.arsw.io.DoubleFileReader;
import com.sara.arsw.service.Statistics;

import java.nio.file.Paths;

public class Main {
    public static void main(String[] args) throws Exception {
        DoublyLinkedList<Double> col1 = DoubleFileReader.readNumbers(Paths.get("src/test/resources/col1.txt"));
        double media1 = Statistics.mean(col1);
        double desv1 = Statistics.sampleStdDev(col1);

        System.out.println("=== Columna 1 ===");
        System.out.println("Cantidad de datos: " + col1.size());
        System.out.println("Media: " + media1);
        System.out.println("Desviación estándar: " + desv1);

        DoublyLinkedList<Double> col2 = DoubleFileReader.readNumbers(Paths.get("src/test/resources/col2.txt"));
        double media2 = Statistics.mean(col2);
        double desv2 = Statistics.sampleStdDev(col2);

        System.out.println("\n=== Columna 2 ===");
        System.out.println("Cantidad de datos: " + col2.size());
        System.out.println("Media: " + media2);
        System.out.println("Desviación estándar: " + desv2);
    }
}


