package com.adventofcode22;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

public class Day5Test {
    @Test
    void testStar1() {
        String answer = Day5.solution("/Day5Test.txt");

        assertEquals("CMZ", answer);
    }

    @Test
    void testStar2() {
        String answer = Day5.solution2("/Day5Test.txt");

        assertEquals("MCD", answer);
    }
}
