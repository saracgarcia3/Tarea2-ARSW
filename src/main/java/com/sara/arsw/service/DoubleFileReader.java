package com.sara.arsw.service;

import com.sara.arsw.collections.DoublyLinkedList;
import java.io.IOException;
import java.nio.file.*;
import java.util.stream.Stream;

public final class DoubleFileReader {
    private DoubleFileReader() {}

    public static DoublyLinkedList<Double> readNumbers(Path path) throws IOException {
        DoublyLinkedList<Double> list = new DoublyLinkedList<>();
        try (Stream<String> lines = Files.lines(path)) {
            lines.map(String::trim)
                 .filter(s -> !s.isEmpty())
                 .map(s -> s.replace(',', '.'))
                 .map(Double::parseDouble)
                 .forEach(list::add);
        }
        return list;
    }
}

