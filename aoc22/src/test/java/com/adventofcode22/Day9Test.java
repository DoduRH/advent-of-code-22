package com.adventofcode22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class Day9Test {
    /**
     * Rigorous Test.
     */
    @Test
    void testStar1() {
        Integer answer = Day9.solution("/Day9Test.txt");

        assertEquals(13, answer);
    }

    @Test
    void testStar2() {
        Integer answer = Day9.solution("/Day9Test2.txt", 10);

        assertEquals(36, answer);
    }
}
