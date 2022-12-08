package com.adventofcode22;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

/**
 * Unit test for simple App.
 */
class Day8Test {
    /**
     * Rigorous Test.
     */
    @Test
    void testStar1() {
        Integer answer = Day8.solution("/Day8Test.txt");

        assertEquals(21, answer);
    }

    @Test
    void testStar2() {
        Integer answer = Day8.solution2("/Day8Test.txt");

        assertEquals(8, answer);
    }
}
