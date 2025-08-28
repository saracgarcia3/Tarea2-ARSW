package com.sara.arsw;

import com.sara.arsw.collections.DoublyLinkedList;
import com.sara.arsw.io.DoubleFileReader;
import com.sara.arsw.service.Statistics;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.nio.file.Paths;

public class StatisticsTest {

    @Test
    void testColumn1() throws Exception {
        DoublyLinkedList<Double> xs =
            DoubleFileReader.readNumbers(Paths.get("src/test/resources/col1.txt"));
        assertEquals(550.6, Statistics.mean(xs), 0.1);
        assertEquals(572.03, Statistics.sampleStdDev(xs), 0.1);
    }

    @Test
    void testColumn2() throws Exception {
        DoublyLinkedList<Double> xs =
            DoubleFileReader.readNumbers(Paths.get("src/test/resources/col2.txt"));
        assertEquals(60.32, Statistics.mean(xs), 0.1);
        assertEquals(62.26, Statistics.sampleStdDev(xs), 0.1);
    }
}
